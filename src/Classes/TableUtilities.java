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
    NFAe nfaE;
    public TableUtilities(){
        afd = new AFD();
        nfaE = new NFAe();
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
    

    public void setCombo(JTable table, JComboBox combo){
        TableModel tableModel = table.getModel();
        String estados[] = new String [tableModel.getRowCount()];
        
        for(int i = 0; i<tableModel.getRowCount();i++){
            estados[i] = tableModel.getValueAt(i, 0).toString();
            System.out.println("El nombre del estado en la fila "+i+ " es: "+estados[i]);
        }
        
        this.setComboBoxData(combo, estados);
    }
    
    public void generateAutomata(JTable table, String [] estadosAceptacion, int numAlfabeto){
        TableModel tableModel = table.getModel();
        this.alfabeto = new String [tableModel.getColumnCount()-numAlfabeto];
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
                    this.alfabeto[j] = tableModel.getColumnName(j+numAlfabeto).toLowerCase();
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
        nfaE.setNfaeStates(afd.getEstados());
        System.out.println("Alfabeto: ");
        for(int i = 0; i<alfabeto.length;i++){
            System.out.println(alfabeto[i]);
        }
        nfaE.setAlfabeto(alfabeto);
        afd.setAlfabeto(alfabeto);
    }
    
    public void generateAutomata2(JTable table, String [] estadosAceptacion, int numAlfabeto){
        TableModel tableModel = table.getModel();
        this.alfabeto = new String [tableModel.getColumnCount()-numAlfabeto];
        String estados[] = new String [tableModel.getRowCount()];
        
        for(int i = 0; i<tableModel.getRowCount();i++){
            estados[i] = tableModel.getValueAt(i, 0).toString();
            System.out.println("El nombre del estado en la fila "+i+ " es: "+estados[i]);
        }
        nfaE.initStates(estados, estadosAceptacion);
        
        for(int i = 0; i<tableModel.getRowCount(); i++){
            String stateName = "";
            String transitionName = ""; 
            String estadoLlegada = ""; 
            for(int j = 0; j<tableModel.getColumnCount(); j++){
                if(j<this.alfabeto.length)
                    this.alfabeto[j] = tableModel.getColumnName(j+numAlfabeto).toLowerCase();
                if(j>0){
                    stateName = estados[i];
                    transitionName = tableModel.getColumnName(j).toLowerCase();
                    estadoLlegada = tableModel.getValueAt(i, j).toString();
                    String estadosLlegada[] = estadoLlegada.split(",");
                    for(int k =0; k<estadosLlegada.length; k++)
                            nfaE.initTransiciones(stateName, transitionName, estadosLlegada[k]);
                }
            }
        }
        nfaE.imprimirEstadosNFAe(nfaE.getNfaeStates());
        System.out.println("Alfabeto: ");
        for(int i = 0; i<alfabeto.length;i++){
            System.out.println(alfabeto[i]);
        }
        nfaE.setAlfabeto(alfabeto);
        afd.setAlfabeto(alfabeto);
    }
    
}
