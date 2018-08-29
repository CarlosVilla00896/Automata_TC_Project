package Classes;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author PC
 */
public final class Conexion {
    Connection c,conect;
    static String bd = "resiste";
    static String url = "jdbc:derby://localhost:1527/";
    String driver ="org.apache.derby.jdbc.EmbeddedDriver";
    static String user = "carlos_admin";
    static String password = "derby123";
    
    public String auxUser = ""; public String auxPassword = ""; public String auxDB = "";
  
    public Conexion(){
       this.auxUser = user;
       this.auxPassword = password;
       this.auxDB = bd;
    }
  
    
    public Connection conectar(){
        System.out.println(url);
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("db: "+ this.auxDB);
            System.out.println("usuario: "+this.auxUser);
            System.out.println("pass: "+this.auxPassword);
            c= DriverManager.getConnection(url+auxDB,auxUser,auxPassword);
            System.out.println("Se conecto bien");
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
        return c;
    }
    public void desconectar(){
        try {
            c.close();
            System.out.println("Se desconecto bien la base de datos "+this.auxDB);
        } catch (SQLException ex) {
            System.out.println("No se pudo cerrar conexion");
        }
    }
    
     
}
