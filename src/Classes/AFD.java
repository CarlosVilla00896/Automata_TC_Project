package Classes;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class AFD {
    
    static ArrayList<Estados> estados;
    static Estados estadoActual;
    static Estados estadoInicial;
//    Archivos archivo;
    String palabrasAceptadas ="", palabrasNoAceptadas = "";
    
    public AFD(){
        estados  = new ArrayList();
//        archivo = new Archivos();
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
        Estados s = this.obtenerEstado(stateName);
        Transiciones t = new Transiciones(transitionName);
        t.nextState = new Estados(estadoLlegada);
        s.transiciones.add(t);
    }
    
    private Estados obtenerEstado(String nombreEstado){
        for(Estados states: estados){
            if(states.stateName.equals(nombreEstado))
                return states;
        }
        System.out.println("Estado no encontrado en obtener");
        return null;
    }
    
    public boolean validarAFD(String cadena){
        for(int i=0; i<cadena.length();i++){
            String letra = cadena.substring(i, i+1);
            Transiciones t = this.getTransiciones(estadoActual, letra);
            if(t==null){
                System.out.println("entro al primer false");
                return false;
//                this.palabrasNoAceptadas +=cadena+" cadena no aceptada"+"\n";
            }else{
                estadoActual = t.nextState;
            }
        }
        
        if(estadoActual.isAceptacion){
            return true;
//            this.palabrasAceptadas += cadena+" cadena aceptada"+"\n";
        }else{
            System.out.println("Entro al segundo false");
            return false;
//            this.palabrasNoAceptadas +=cadena+" cadena no aceptada"+"\n";
        }
    }
    
    public void validarAFD_aux(String cadena){
        estadoActual = estados.get(0);
        
        if(validarAFD(cadena)){
            this.palabrasAceptadas += cadena+" cadena aceptada"+"\n";
        }else{
            this.palabrasNoAceptadas +=cadena+" cadena no aceptada"+"\n";
        }
        
        System.out.println(this.palabrasAceptadas);
        System.out.println(this.palabrasNoAceptadas);
    }
    private Transiciones getTransiciones(Estados state, String letra){
        for(Transiciones t: state.transiciones){
            System.out.println("letra: "+letra);
            System.out.println("Estado: "+state.stateName+" Transiciones: "+t.name);
            if(t.name.equals(letra)){
                System.out.println("Si acepta la letra, es igual");
                return t;//El problema es este return, no para la ejecucion aca.
            }
            System.out.println("");
        }
        System.out.println("Nunca encontro la transicion con la letra");
        return null;
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
    
    
}
    
