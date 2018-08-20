package Classes;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class AFD {
    
    ArrayList<Estados> estados  = new ArrayList();
    Estados estadoActual;
    Estados estadoInicial;
    
    public void initStates(String estadosArr[], String estadoInicial, String estadosAceptacion[]){
        for (String estadosArr1 : estadosArr) {
            Estados s;
            s = new Estados(estadosArr1);
            for (String estadosAceptacion1 : estadosAceptacion) {
                if (estadosArr1.equals(estadosAceptacion1))
                    s.setIsAceptacion(true);
            }
            if (estadosArr1.equals(estadoInicial))
                this.estadoInicial = s;
            estados.add(s);
        }
        //this.imprimirEstados();
    }
    
    public void initTransiciones(String stateName, String transitionName, String estadoLlegada){
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
        return null;
    }
    
    public void imprimirEstados(){
        int cont = 1;
        System.out.println("Mi estado inicial es: "+this.estadoInicial.getStateName());
        System.out.println("Sus transiciones son: ");
        for(Transiciones t: this.estadoInicial.getTransiciones())
            System.out.println(t.name+ ": "+t.nextState.getStateName());
        for(Estados states: this.estados){
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
    
