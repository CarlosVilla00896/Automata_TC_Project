package Classes;

import java.util.ArrayList;
/**
 *
 * @author PC
 */
public class AFD {
    
    static ArrayList<Estados> estados;
    Estados estadoActual;
    Estados estadoInicial;
    public String caracterIncorrecto ="";
    static String alfabeto[];
    
    static ArrayList <Estados> nfaStates ;
    public ArrayList <Estados> convertedStates;
    
    
    public AFD(){
        estados  = new ArrayList();
    }
    
    public void initStates(String estadosArr[], String estadoInicial1, String estadosAceptacion[]){
        for (String estadosArr1 : estadosArr) {
            Estados s;
            s = new Estados(estadosArr1);
            for (String estadosAceptacion1 : estadosAceptacion) {
                if (estadosArr1.equals(estadosAceptacion1))
                    s.setIsAceptacion(true);
            }
            if (estadosArr1.equals(estadoInicial1))
                estadoInicial = s;
            estados.add(s);
        }
        estadoActual = estadoInicial;
        //this.imprimirEstados();
    }
    
    public void initTransiciones(String stateName, String transitionName, String estadoLlegada){
        System.out.println("Nombre del estado en init: "+stateName);
        Estados initialState = this.obtenerEstado(stateName,estados);
        Estados nextState = this.obtenerEstado(estadoLlegada,estados);
        Transiciones t = new Transiciones(transitionName);
        t.nextState = nextState;
        initialState.transiciones.add(t);
    }
    
    private Estados obtenerEstado(String nombreEstado, ArrayList<Estados> s){
        for(Estados states: s){
            if(states.stateName.equals(nombreEstado))
                return states;
        }
        System.out.println("Estado no encontrado en obtener");
        return null;
    }
    

    public boolean validarAFD(String cadena){
        estadoActual = estados.get(0);
        if (cadena.isEmpty() && estadoActual.isAceptacion)
            return true;
        Transiciones temp = new Transiciones("");
        caracterIncorrecto ="";
        for (int i = 0; i < cadena.length(); i++) {
            String letra = cadena.substring(i, i + 1);
            if(!verificarAlfabeto(letra)){
                System.out.println("Entro al false este");
                caracterIncorrecto = " caracter "+letra+ " no pertenece al alfabeto";
                return false;
            }    
            System.out.println("Letra extraida: " + letra);
            System.out.println("Estado actual antes de analizar caracter: "+estadoActual.stateName +" Transiciones: "+estadoActual.getTransiciones());
            temp = this.getTransiciones(estadoActual, letra, temp);
            System.out.println("El nombre de la transicion nueva es: " + temp.name);
            if (temp.name.isEmpty()) {
                System.out.println("entro al primer false");
                return false;
            } else {
                estadoActual = temp.nextState;
            }
            System.out.println("Estado actual a final de caracter: " + estadoActual.stateName+" Transicones: "+estadoActual.getTransiciones());
        }
        System.out.println("Estado actual al final de cadena: "+ estadoActual.stateName);
        if(estadoActual.isAceptacion)
            return true;
        
        return false;
    }
       
    private Transiciones getTransiciones(Estados state, String letra, Transiciones temp){
        for(Transiciones t: state.transiciones){
            System.out.println("letra: "+letra);
            System.out.println("Estado: "+state.stateName+" Transiciones: "+t.name);
            if(t.name.equals(letra)){
                System.out.println("Si acepta la letra, es igual");
                temp = t;
                break;
            }
        }
        System.out.println("La transicion dice: "+temp.name);
        return temp;
    }
    
    private boolean verificarAlfabeto(String letra){
        int contCaracter =0;
        for(int i = 0; i<alfabeto.length; i++){
            if(alfabeto[i].equals(letra))
                contCaracter++;
        }
        if(contCaracter == 0)
            return false;
        return true;
    }
        
    public void setAlfabeto (String[] alfabetoArr){
        alfabeto = alfabetoArr;
    }
    
    public void imprimirEstados(){
        int cont = 1;
        System.out.println("Mi estado inicial es: "+estadoInicial.getStateName());
        System.out.println("Sus transiciones son: ");
        for(Transiciones t: estadoInicial.getTransiciones())
            System.out.println(t.name+ ": "+t.nextState.getStateName());
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
    
    public void initNFAStates(){
        nfaStates = new ArrayList();
        Estados es = estados.get(0);
        if (es.getTransiciones().size()>1)//verificamos que el estado tenga mas de dos transiciones para poder aplicar a la union de transicines
                es.setTransiciones(unirTransiciones(es));
        nfaStates.add(es);
        for(int i = 0; i<nfaStates.size();i++){
            for(Transiciones t: nfaStates.get(i).getTransiciones()){
                if(!buscarEstadoNFA(t.nextState)){
                    Estados nuevo = nuevoEstado(t.nextState);
                    if (nuevo.getTransiciones().size()>1)
                        nuevo.setTransiciones(unirTransiciones(nuevo));
                    nfaStates.add(nuevo);
                }
            }
        }
        imprimirEstadosNFA();
        conversionNFA();
    }
    
    public boolean buscarEstadoNFA(Estados state){
        for(Estados estado: nfaStates){
            if(estado.stateName.equals(state.stateName))
                return true;
        }
        return false;
    }
    //Nota: Despues de evaluar el primer estado para sacar sus transiciones y nextstates y agregarlo a la lista, luego
    //tengo que evaluar sus nextstates tal como al primer estado y agregarlos a la lista, repetir el mismo proceso mientras
    //los nextstates no se encuentran en la lista.
    public void conversionNFA(){
       //convertedStates = nfaStates;
       //imprimirEstadosNFA(convertedStates);
       for(Estados states: nfaStates){
           for(Transiciones t: states.getTransiciones()){
               init_nfaTransitions(states.stateName,t.name,t.nextState.stateName);//el error es porque estoy modificando las transiciones mientras las itero, usar Iterator
           }
       }
      estados = convertedStates;
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
//                transiciones.add(temp);
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
    
    //de esta funcion tiene que salir cabal, con su nombre, su arraylist de transiciones(no unidas) y si es de aceptacion
    public Estados nuevoEstado(Estados state){
         String split [] = state.stateName.split(",");
         ArrayList<Transiciones> transiciones = new ArrayList();
         ArrayList <Estados> estadosExtraidos = new ArrayList();
         Estados nuevoEstado = new Estados (state.stateName);
         for(String s: split){
             estadosExtraidos.add(obtenerEstado(s,estados));
         }
         
         for(Estados s: estadosExtraidos){
             if(s.getIsAceptacion())
                 nuevoEstado.setIsAceptacion(true);
             for(String letra: alfabeto){
                Transiciones temp = new Transiciones("");
                temp = getTransiciones(s, letra, temp);
                if(!temp.name.isEmpty())
                    transiciones.add(temp);
             }
         }
         nuevoEstado.transiciones = transiciones;
         System.out.println("El nuevo Estado es: "+nuevoEstado.stateName);
         System.out.println("Sus transiciones son: ");
            for(Transiciones t: nuevoEstado.getTransiciones())
                System.out.println(t.name+ ": "+t.nextState.getStateName());
         return nuevoEstado;
    }
    
    public void init_nfaTransitions(String estadoSalida, String transitionName, String estadoLlegada){
        System.out.println("Nombre del estado en init: "+estadoSalida);
//        Estados initialState = this.obtenerEstado(estadoSalida,nfaStates);
//        Estados nextState = this.obtenerEstado(estadoLlegada,nfaStates);
//        
        Estados initialState2 = this.obtenerEstado(estadoSalida,convertedStates);
        Estados nextState2 = this.obtenerEstado(estadoLlegada,convertedStates);
        
        Transiciones t = new Transiciones(transitionName);
        t.nextState = nextState2;
        initialState2.getTransiciones().add(t);
    }

    public void imprimirEstadosNFA(){
        int cont = 1;
        System.out.println("Mi NFA: ");
//        for(Transiciones t: estadoInicial.getTransiciones())
//            System.out.println(t.name+ ": "+t.nextState.getStateName());
        for(Estados states: nfaStates){
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
    
