package Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PC
 */
public class NFAe {
    static ArrayList<Estados> nfaeStates;
    ArrayList<Estados> nfa;
    String alfabeto [];
    AFD afd;

    public NFAe(){
        nfaeStates = new ArrayList();
        nfa = new ArrayList();
        afd = new AFD();
    }
    
    public void setNfaeStates(ArrayList<Estados> estados){
        nfaeStates = estados;
    }
    
    public ArrayList<Estados> getNfaeStates(){
        return nfaeStates;
    }
    
    public void setNfa(ArrayList<Estados> estados){
        nfa = estados;
    }
    
    public ArrayList<Estados> getNfa(){
        return nfa;
    }
    
    public void setAlfabeto (String alfabetoArr []){
        this.alfabeto = alfabetoArr;
    }
    
    public String [] getAlfabeto(){
        return this.alfabeto;
    }
    public void normalizarEstados(){
        for(Estados estado: nfaeStates){
            estado.setTransiciones(unirTransiciones(estado));
        }
    }
    
    public void initStates(String estadosArr[], String estadosAceptacion[]){
        for (String estadosArr1 : estadosArr) {
            Estados s;
            s = new Estados(estadosArr1);
            for (String estadosAceptacion1 : estadosAceptacion) {
                if (estadosArr1.equals(estadosAceptacion1))
                    s.setIsAceptacion(true);
            }
//            if (estadosArr1.equals(estadoInicial1))
//                estadoInicial = s;
            nfaeStates.add(s);
        }
//        estadoActual = estadoInicial;
        //this.imprimirEstados();
    }
    
    public void initTransiciones(String stateName, String transitionName, String estadoLlegada){
        System.out.println("Nombre del estado en init: "+stateName+ " Transicion: "+transitionName+" Estado llegada: "+estadoLlegada);
        Estados initialState = this.obtenerEstados(stateName);
        Estados nextState = this.obtenerEstados(estadoLlegada);
        Transiciones t = new Transiciones(transitionName);
        if(nextState==null){
            Estados estados = new Estados ("0");
            t.nextState = estados;
        }else{
            t.nextState = nextState;
        }
        initialState.transiciones.add(t);
    }
    
    public void generarNFAe(){
        normalizarEstados();
        imprimirEstadosNFAe(nfaeStates);
//        nfaeStates = afd.getEstados();
        this.alfabeto = afd.getAlfabeto();
        for(Estados estadoActual:nfaeStates )
            estadoActual.getTransiciones().add(generarCerradura(estadoActual));
        
         
        for(Estados estadoActual:nfaeStates ){
            String letraAnterior = this.alfabeto[0];
            Estados s = new Estados("");
            s.setStateName(estadoActual.stateName);
            if(estadoActual.isAceptacion)
                s.setIsAceptacion(true);
                            
            Transiciones transicionCerradura = new Transiciones ("");
            for(int i = 0; i<this.alfabeto.length; i++){
               for(int j = 0; j<estadoActual.getTransiciones().size(); j++){
                    if(i>0)
                        letraAnterior = this.alfabeto[i-1];
                    int size = estadoActual.getTransiciones().size();
                    if(j == size-1 ){
                        Transiciones transicionActual = estadoActual.getTransiciones().get(j);
                        if(transicionActual.name.equals("ce(q)")){
                            estadoActual.getTransiciones().add(generarUnion(estadoActual,transicionActual,this.alfabeto[i],"ce",this.alfabeto[i]));
                            transicionCerradura = transicionActual;
                        }else if(transicionActual.name.equals("d[ce(q)"+this.alfabeto[i]+"]")){
                            System.out.println("Evaluo la transicion: "+transicionActual.name+ " comparada con: "+"d[ce(q)"+this.alfabeto[i]+"]");
                            Transiciones temp1 = generarUnion(estadoActual,transicionActual,"ce(q)","dce",this.alfabeto[i]);
                            if(!buscarTransicion(estadoActual.getTransiciones(), temp1)){
                                estadoActual.getTransiciones().add(temp1);
                                System.out.println("Agregado cedceq con exito");
                                s.getTransiciones().add(temp1);
                            }
                        }else if(transicionActual.name.equals("ce{d[ce(q)"+letraAnterior+"]}")){
                            System.out.println("entro a la cerradura de la transicion epsilon");
                            Transiciones temp = new Transiciones("");
                            temp = obtenerTransicion (estadoActual,"ce{d[ce(q)"+this.alfabeto[i]+"]}" ,temp);
                            if(temp.name.isEmpty()){
                                System.out.println("estado actual: "+estadoActual.stateName);
                                System.out.println("Transicion cerradura: "+transicionCerradura.name);
                                System.out.println("letra del alfabeto: "+this.alfabeto[i]);
                                System.out.println("cumple la condicion de la transicion cerradura epsilon");
                                Transiciones temp1 = generarUnion(estadoActual,transicionCerradura,this.alfabeto[i],"ce",this.alfabeto[i] );
                                if(!buscarTransicion(estadoActual.getTransiciones(), temp1)){
                                    estadoActual.getTransiciones().add(temp1);
                                    System.out.println("Agregado con exito");
                                }
                            }
                        }
                    }
                }
            }
            nfa.add(s);
        }
        
    }
    /*
    funcion para generar la cerradura del estado, se concatena el statetName del estado con el nextstate de la transicion e
    este string se devuelve para ser el nuevo nextstate de la nueva transicion "ce(q)" que se agregara a el arraylist de 
    transiciones del estado actual. ¿Devuelvo el string del nextstate o la transicion completa? 
    */
    public Transiciones generarCerradura(Estados e){
        Transiciones transicion = new Transiciones ("ce(q)");
        Estados nextState = new Estados("");
        String nextStateName = e.stateName;
        System.out.println("nextstate antes de condicion en funcion cerradura: "+nextStateName);
        
        for(Transiciones t: e.getTransiciones()){
            if(t.name.equals("e")){
                if(!(t.nextState.stateName == null) && !(t.nextState.stateName.equals("0")))
                     nextStateName +=","+t.nextState.stateName;
            }
        }
        
        nextState.stateName = nextStateName;
        transicion.nextState = nextState;
        System.out.println("La trasicion en la funcion generar cerradura es: "+transicion.name+" nextState: "+transicion.nextState.stateName);
        return transicion;
    }
    /*
    Esta funcion me genera el string del nextstate para la nueva transicion d[ce(q)a] que se agrega al arraylist de cada uno
    de los estados en nfaeStates, obviamente el nextstate cambiara segun su estado. Recibo el estado sobre el que estoy
    trabajando, y su transicion ce(q).Al stateName del nextState de la transicion ce(q) en el estado en curso le aplico split 
    para obtener el nombre
    de los estados por separado, los cuales los uso para obtener dicho estado del nfaeStates con la funcion de obtenrEstado
    uso esos 3 estados temp para obtener de cada uno el nextState segun la transicion indicada en el parametro. 
    Para eso lo que haré es, el nextstate deel primer estado lo agregaré al string union (el que retornaré) y luego para los
    nextState de los otros estados los daré split(",") y almacenaré en un arreglo de strings. Para ir agregando los demás 
    estados a la union, con un ciclo for recorreré dicho arreglo y compararé cada string que salga con el string de union
    para usaré union.contain(arr[i)), si es falso concatenaré el string del arreglo al string de union: union += union +","+arr[i] 
    Luego devuelvo el string. Esta funcion me sirve para todas las transiciones siguietes.
    */
    //Cambio a lo de arriba, me genera la transicion.
    //validar cuando el nexstate de la transicion de parametro sea 0
    public Transiciones generarUnion(Estados estadoActual,Transiciones transicionActual, String transicionName, String tipoTransicion, String decoracion){
        Transiciones transicion = new Transiciones ("");
        Estados nextState = new Estados("");
        String nexStateName = "";
        String tName = "";
        
        ArrayList <Transiciones> transiciones = new ArrayList();    
        
        switch(tipoTransicion){
            case "ce":
                tName = "d[ce(q)"+decoracion+"]";
                transicion.setName(tName);
                break;
            case "dce":
                tName = "ce{d[ce(q)"+decoracion+"]}";
                transicion.setName(tName);
                break;
            default:
                tName = "default";
                transicion.setName(tName);
        }
        System.out.println("El nombre de la transicion actual es: "+transicionActual.name+" transicionName: "+transicionName);
        transiciones = obtenerArrayListTransiciones(transicionActual,transicionName);
        System.out.println("Tamano de arraylist en funcion generarUnion: "+transiciones.size());
        
        for(int i = 0; i<transiciones.size();i++){
            if((i ==0)){
                if(!transiciones.get(i).nextState.stateName.equals("0"))
                    nexStateName = transiciones.get(i).nextState.stateName;
            }
            if (i>0){
                String arr [] = transiciones.get(i).nextState.stateName.split(",");
                for(int j =0; j<arr.length; j++){
                    if(nexStateName.isEmpty() && !(transiciones.get(i).nextState.stateName.equals("0")))
                        nexStateName = transiciones.get(i).nextState.stateName;
                    if(!nexStateName.contains(arr[j])&& !(transiciones.get(i).nextState.stateName.equals("0")))
                        nexStateName += ","+arr[j];
                }
            }
        }
        String [] sort = nexStateName.split(",");
        ArrayList<String> sortedStates = new ArrayList();
        for(int i = 0; i<sort.length; i++)
            sortedStates.add(sort[i]);
        Collections.sort(sortedStates);
        
        for(int i = 0; i<sort.length; i++){
            if(i==0)
                nexStateName = sortedStates.get(i);
            if(i>0)
                nexStateName += ","+sortedStates.get(i);
        }
        
        nextState.setStateName(nexStateName);
        transicion.nextState = nextState;
        System.out.println("Transicion generada :"+transicion.name+" nextState: "+transicion.nextState.stateName);
        return transicion;
    }
    
    public ArrayList<Transiciones> obtenerArrayListTransiciones(Transiciones transicionActual, String transicionName){
        String arregloEstados [] = transicionActual.nextState.stateName.split(",");
        if(transicionName.equals("b")){
            System.out.println("Tamano de arreglo: "+arregloEstados.length);
            System.out.println("Contenido arreglo: "+arregloEstados.toString());
        }
            
        ArrayList <Transiciones> transiciones = new ArrayList();
        ArrayList<Estados> estados = new ArrayList();
        
        for(int i =0 ; i<arregloEstados.length; i++){
            Estados estado = obtenerEstados(arregloEstados[i]);
            if(!(estado == null)){
                estados.add(estado);
            }else{
                System.out.println("No se encontro el estado");
            }
        }
        for(Estados state: estados){
            Transiciones temp =  new Transiciones("");
            temp = obtenerTransicion(state, transicionName, temp);
            if(!(temp.name.isEmpty())){
                if(!(temp.nextState.stateName.equals("0"))){
                    System.out.println("Entro a la comparacion de != 0, el nextstate es: "+temp.nextState.stateName);
                    transiciones.add(temp);
                }
                System.out.println("Estado "+state.stateName+" tiene la transicion "+temp.name);
            }else{
                System.out.println("No se encontro la transicion "+transicionName+" en el estado "+state.stateName);
            }
        }
        return transiciones;
    }
    
    public Transiciones obtenerTransicion (Estados estado, String transicionName,Transiciones temp){
        for(Transiciones t: estado.transiciones){
            if(t.name.equals(transicionName)){
                temp = t;
                break;
            }
        }
        return temp;
    }
    
    public Estados obtenerEstados(String nombreEstado){
        for(Estados state: nfaeStates){
            if(state.stateName.equals(nombreEstado))
                return state;
        }
        System.out.println("Estado no encontrado en obtener nfae");
        return null;
    }
    
    public ArrayList <Transiciones> unirTransiciones(Estados e){
        ArrayList <Transiciones> transiciones = new ArrayList();
        Transiciones temp = new Transiciones("");
        for(int i= 0; i<e.getTransiciones().size();i++){
            if(i!=0){
                Transiciones tempActual = e.getTransiciones().get(i);
                Transiciones tempAnterior = e.getTransiciones().get(i-1);
                if(tempActual.name.equals(tempAnterior.name)){
                    temp.setName(tempActual.name);
                    Estados s = new Estados (tempAnterior.nextState.getStateName()+ ","+tempActual.nextState.getStateName());
                    temp.nextState = s;
                    transiciones.add(temp);
                }else if(i == (e.getTransiciones().size()-1)){
                    if(!buscarTransicion(transiciones, tempAnterior))
                        transiciones.add(tempAnterior);
                    if(!buscarTransicion(transiciones, tempActual))
                        transiciones.add(tempActual);
                }else{
                    if(!buscarTransicion(transiciones, tempAnterior))
                        transiciones.add(tempAnterior);
                }
            }
        }
        return transiciones;
    }
    
     public boolean buscarTransicion(ArrayList <Transiciones> transiciones, Transiciones tra){
        if(transiciones == null)
            return false;
        for(Transiciones t: transiciones){
            if(t.name.equals(tra.name))
                return true;
        }
        return false;
    }
    
     public void imprimirEstadosNFAe(ArrayList<Estados> estados){
        int cont = 1;
        System.out.println("Mi NFAe: ");
        for(Estados states: estados){
            //System.out.println("Numero de estado: "+cont);
            System.out.println("nombre estado: "+states.getStateName());
            System.out.println("Es estado final?: "+states.isAceptacion);
            System.out.println("Sus transiciones son: ");
            for(Transiciones t: states.getTransiciones())
                System.out.println(t.name+ ": "+t.nextState.getStateName());
            cont++;
        }
    }
     
}
