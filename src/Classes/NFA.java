package Classes;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class NFA {
    
    static ArrayList <Estados> nfaStates;
    public ArrayList <Estados> convertedStates;
    
    public NFA(ArrayList<Estados> states){
        nfaStates = states;
    }
    
   private Estados obtenerEstado(String nombreEstado){
        for(Estados states: nfaStates){
            if(states.stateName.equals(nombreEstado))
                return states;
        }
        System.out.println("Estado no encontrado en obtener");
        return null;
    }
}
