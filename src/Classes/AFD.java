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
        Estados initialState = this.obtenerEstado(stateName);
        Estados nexState = this.obtenerEstado(estadoLlegada);
        Transiciones t = new Transiciones(transitionName);
        t.nextState = nexState;
        initialState.transiciones.add(t);
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
        Transiciones temp = new Transiciones("");
        for (int i = 0; i < cadena.length(); i++) {
            String letra = cadena.substring(i, i + 1);
//            temp = this.getTransiciones(estadoActual, letra, temp);
            System.out.println("Letra extraida: " + letra);
            System.out.println("Estado actual antes de analizar caracter: "+estadoActual.stateName +" Transiciones: "+estadoActual.getTransiciones());
            for (Transiciones t : estadoActual.getTransiciones()) {
                System.out.println("Entro al for de transiciones");
//                System.out.println("letra: " + letra);
//                System.out.println("Estado actual: " + estadoActual.stateName + " Transicion: " + t.name);
                if (t.name.equals(letra)) {
                    System.out.println("Letra se encuentra en las trasiciones, se almacena en temp");
                    temp = t;//El problema es este return, no para la ejecucion aca.
                    break;
                }
            }
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
//       
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
    private Transiciones getTransiciones(Estados state, String letra, Transiciones temp){
        for(Transiciones t: state.transiciones){
            System.out.println("letra: "+letra);
            System.out.println("Estado: "+state.stateName+" Transiciones: "+t.name);
            if(t.name.equals(letra)){
                System.out.println("Si acepta la letra, es igual");
                temp = t;//El problema es este return, no para la ejecucion aca.
            }
            System.out.println("");
        }
        System.out.println("La transicion dice: "+temp.name);
        return temp;
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
    
