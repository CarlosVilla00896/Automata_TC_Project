package Classes;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author PC
 */
public class Automata {
    
    public Automata(){
        
    }
    
    public String[] splitString(String alfabeto){
        String alfabetoArr[] = alfabeto.split(",");
        return alfabetoArr;
    }
    
    public void generarColumnas(JTable table, String alfabeto[], String estados[]){
        
        DefaultTableModel dataModel = new DefaultTableModel();
        int cantColumnas = alfabeto.length;
        
        dataModel.addColumn("Q");
        for(int i=0; i<cantColumnas; i++){
            dataModel.addColumn(alfabeto[i]);
            System.out.println("Columna: "+i+"Valor: "+alfabeto[i]);
        }
        
        int cantFilas = estados.length;
        Object row[] = new Object[cantColumnas];
        
        for(int i=0; i<cantFilas; i++){
            for(int j=0; j<cantColumnas; j++){
                row[j] = null;
                System.out.println("numero Columna: "+j);
            }
            dataModel.addRow(row);
            dataModel.setValueAt(estados[i], i, 0);
            System.out.println("Numero fila: "+i+"Valor fila: "+estados[i]);
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
    
}
