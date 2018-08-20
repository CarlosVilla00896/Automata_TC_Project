package Classes;

import java.util.ArrayList;

public class Transiciones {
    
    public String name;
    public Estados nextState;
    public ArrayList<Estados> nextStates = new ArrayList();
    
    public Transiciones(String name){
      this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNextState(Estados nextState) {
        this.nextState = nextState;
    }

    public void setNextStates(ArrayList<Estados> nextStates) {
        this.nextStates = nextStates;
    }
    
    public String getName() {
        return name;
    }

    public Estados getNextState() {
        return nextState;
    }

    public ArrayList<Estados> getNextStates() {
        return nextStates;
    }

}
