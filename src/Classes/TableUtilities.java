package Classes;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author PC
 */
public class TableUtilities {
    
    public String [] alfabeto;
    AFD afd;
    public TableUtilities(){
        afd = new AFD();
    }
    
    public String[] splitString(String alfabeto){
        String alfabetoArr[] = alfabeto.split(",");
        this.alfabeto = alfabetoArr;
        return alfabetoArr;
    }
    
    public void generarColumnas(JTable table, String alfabeto[], String estados[]){
        
        DefaultTableModel dataModel = new DefaultTableModel();
        int cantColumnas = alfabeto.length;
        
        dataModel.addColumn("Q");
        for(int i=0; i<cantColumnas; i++){
            dataModel.addColumn(alfabeto[i]);
            //System.out.println("Columna: "+i+"Valor: "+alfabeto[i]);
        }
        
        int cantFilas = estados.length;
        Object row[] = new Object[cantColumnas];
        
        for(int i=0; i<cantFilas; i++){
            for(int j=0; j<cantColumnas; j++){
                row[j] = null;
                //System.out.println("numero Columna: "+j);
            }
            dataModel.addRow(row);
            dataModel.setValueAt(estados[i], i, 0);
            //System.out.println("Numero fila: "+i+"Valor fila: "+estados[i]);
        }
        
        table.setModel(dataModel);
    }
    
    public void addValues(JTable table, int row, int column, String value){
        
        TableModel dataModel = table.getModel();
        dataModel.setValueAt(value, row, column);
    }
    
    public void setComboBoxData(JComboBox combo, String[]datos){
        DefaultComboBoxModel combox = new DefaultComboBoxModel();
        int cont = datos.length;
        
        for(int i = 0; i<cont; i++){
            combox.addElement(datos[i]);
        }
        combo.setModel(combox);
    }
    
    public void setEstadosProperties(JTable table, int row, String value){
        TableModel dataModel = table.getModel();
        dataModel.setValueAt(value, row, 0);
    }
    
    public void generarTabla(JTable table, ArrayList<Estados> estados){
        String states[] = new String[estados.size()];
        for(int i = 0; i<estados.size(); i++){
            states[i] = estados.get(i).stateName;
            System.out.println("El estado agregado al arreglo es: "+states[i]);
            if(estados.get(i).isAceptacion){
                states[i] = estados.get(i).stateName +"*";
            }
        }
        
        this.generarColumnas(table,afd.getAlfabeto() , states);
        for(int i = 0; i<estados.size();i++){
            for(int j = 0; j<estados.get(i).getTransiciones().size(); j++){
                String valor = estados.get(i).getTransiciones().get(j).nextState.stateName;
                this.addValues(table, i, j+1, valor );
            }
        }
    }
    
//    public ArrayList<Estados> generarAutomata(JTable table){
//        ArrayList<Estados> estadosList = new ArrayList();
//        TableModel tableModel = table.getModel();
//        String []alfabetoArr =  new String [tableModel.getColumnCount()-1];
//        Estados estado = new Estados("");
//        Estados nextState = new Estados("");
//        Transiciones transicion = new Transiciones("");
//            
//        
//        for(int i = 0; i<tableModel.getRowCount(); i++){
//            ArrayList<Transiciones> transicionesList = new ArrayList();
//            if(i>0){
//               alfabetoArr[i-1] = tableModel.getColumnName(i);
//               System.out.println("La letra agregada es: "+alfabetoArr[i]);
//               transicion.name = tableModel.getColumnName(i);
//            }   
//            System.out.println("El numero de columna es: "+i);
//            for(int j = 0; j<tableModel.getColumnCount(); j++){
//                if((i==0)){
//                    estado.stateName = tableModel.getValueAt(i, j).toString();
//                    System.out.println("El nombre del estado en la fila "+j+ " es: "+estado.stateName);
//                }
//                if(j>0){
//                    nextState.stateName = tableModel.getValueAt(i, j).toString();
//                    System.out.println("Fila: "+i+" Columna: "+j);
//                    transicion.nextState = nextState;
//                    transicionesList.add(transicion);
//                }
//            }
//            estado.setTransiciones(transicionesList);
//            estadosList.add(estado);
//        }
//        
//        return estadosList;
//    }
//   
    public void setCombo(JTable table, JComboBox combo){
        TableModel tableModel = table.getModel();
        String estados[] = new String [tableModel.getRowCount()];
        
        for(int i = 0; i<tableModel.getRowCount();i++){
            estados[i] = tableModel.getValueAt(i, 0).toString();
            System.out.println("El nombre del estado en la fila "+i+ " es: "+estados[i]);
        }
        
        this.setComboBoxData(combo, estados);
    }
    
    public void generateAutomata(JTable table, String [] estadosAceptacion){
        TableModel tableModel = table.getModel();
        this.alfabeto = new String [tableModel.getColumnCount()-1];
        String estados[] = new String [tableModel.getRowCount()];
        
        for(int i = 0; i<tableModel.getRowCount();i++){
            estados[i] = tableModel.getValueAt(i, 0).toString();
            System.out.println("El nombre del estado en la fila "+i+ " es: "+estados[i]);
        }
        afd.initStates(estados, estadosAceptacion);
        
        for(int i = 0; i<tableModel.getRowCount(); i++){
            String stateName = "";
            String transitionName = ""; 
            String estadoLlegada = ""; 
            for(int j = 0; j<tableModel.getColumnCount(); j++){
                if(j<this.alfabeto.length)
                    this.alfabeto[j] = tableModel.getColumnName(j+1).toLowerCase();
                if(j>0){
                    stateName = estados[i];
                    transitionName = tableModel.getColumnName(j).toLowerCase();
                    estadoLlegada = tableModel.getValueAt(i, j).toString();
                    String estadosLlegada[] = estadoLlegada.split(",");
                    if(!estadoLlegada.equals("0")){
                        for(int k =0; k<estadosLlegada.length; k++)
                            afd.initTransiciones(stateName, transitionName, estadosLlegada[k]);
                    }
                }
            }
        }
        afd.imprimirEstados();
        afd.setAlfabeto(alfabeto);
    }
    
    public void generarNFA(JTable table, String [] estadosAceptacion){
        
    }
}
