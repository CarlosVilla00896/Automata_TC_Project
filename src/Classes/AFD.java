package Classes;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class AFD {
    
    ArrayList<Estados> estados  = new ArrayList();
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
    
    private void imprimirEstados(){
        int cont = 1;
        System.out.println("Mi estado inicial es: "+this.estadoInicial.getStateName());
        for(Estados states: this.estados){
            System.out.println("Numero de estado: "+cont);
            System.out.println("nombre estado: "+states.getStateName());
            System.out.println("Es estado final?: "+states.isAceptacion);
            cont++;
        }
    }
    
    
}
    
