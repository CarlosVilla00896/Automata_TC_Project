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
        estadoActual = estados.get(0);
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
    
    
}
    
