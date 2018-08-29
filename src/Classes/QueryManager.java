package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class QueryManager {
    
    Conexion c;
    Connection cx;
    ResultSet result;
    public Statement s;
    public String labelArr [];
    
    public QueryManager(){
        c = new Conexion();
    }
   
    public void seTableData(JTable table, String sql){
          try{
              DefaultTableModel dataModel = new DefaultTableModel();
              ResultSet rs = this.executeQuery(sql);
              ResultSetMetaData meta = rs.getMetaData();
              int cantColumn = meta.getColumnCount();
              //this.setComboBoxDataColumn(meta, cantColumn);

              for(int i=1; i<=cantColumn;i++){
                  dataModel.addColumn(meta.getColumnLabel(i));
              }
              Object row[] = new Object[cantColumn];

              while(rs.next()){
                  for(int i=0; i<cantColumn; i++){
                      row[i] = rs.getObject(i+1);
                  }
                  dataModel.addRow(row);

              }
              table.setModel(dataModel);
              rs.close();
              this.s.close();
              this.cx.close();
              this.c.desconectar();
              System.out.println("todo macizo al insertar datos");
          }catch(Throwable e){
              System.out.println("Hubo un problema");
              e.printStackTrace();
          }
      }

      public ResultSet executeQuery(String sql){

        try{
            cx = c.conectar();
            s = cx.createStatement();
            s.execute("SET SCHEMA TEST");
            System.out.println("Query del resultset: "+sql);
            //ddl.setSql(sql);
            result = s.executeQuery(sql);

            System.out.println("Se pudo obtener el resultset!");
        }catch(Throwable e){
            System.out.println("No se obtuvo la tabla");
            return null;
        }
        return result;
      }  
      
    public void setComboBoxDataRows(JComboBox combo,String sql){
        try{
            DefaultComboBoxModel comboModel = new DefaultComboBoxModel(); 
            ResultSet rs = this.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int cantColumn = meta.getColumnCount();
            
            this.labelArr = new String [cantColumn];
            System.out.println("Cant columnas combobox rows: "+cantColumn);
            String row[] = new String[cantColumn];
            while(rs.next()){
                for(int i=0; i<cantColumn; i++){
                    row[i] = rs.getObject(i+1).toString();
                    System.out.println("El elemento agregado al combo: "+ row[i]);
                    comboModel.addElement(row[i]);
                }
                System.out.println("Entro al while");
            }
            
            combo.setModel(comboModel);
            rs.close();
            this.s.close();
            this.cx.close();
            this.c.desconectar();
            System.out.println("Funciona combomodel row");
        }catch(Throwable e){
            e.printStackTrace();
            System.out.println("No funciona combomodel row");
        }
    }
}
