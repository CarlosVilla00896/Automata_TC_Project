package Classes;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Estados {
    
    public boolean isAceptacion;
    public String stateName;
    public String actualState;
    public ArrayList<Transiciones> transiciones = new ArrayList();
    
    public Estados(String stateName){
        this.stateName = stateName;
    }

    public void setIsAceptacion(boolean isAceptacion) {
        this.isAceptacion = isAceptacion;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    public void setActualState(String actualState){
        this.actualState = actualState;
    }
    
    public void setTransiciones(ArrayList<Transiciones> transiciones) {
        this.transiciones = transiciones;
    }

    public boolean isIsAceptacion() {
        return isAceptacion;
    }

    public String getStateName() {
        return stateName;
    }

    public String getActualState(){
        return actualState;
    }
    
    public ArrayList<Transiciones> getTransiciones() {
        return transiciones;
    }
    
}
