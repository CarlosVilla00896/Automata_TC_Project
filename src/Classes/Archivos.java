package Classes;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Archivos {
    File file;
    FileReader fr;
    Scanner scanner;
    String filename = "Test.txt";
    
    public Archivos (){
        
    }
    
    public void abrirArchivo(){
        try{
            file = new File(filename);
            fr = new FileReader(file);
            scanner = new Scanner(fr);
            scanner.nextLine();
            
            while(scanner.hasNextLine()){
                //hacer funcion del automata que recibe como parametro la cadena que se acaba de leer del fichero
                String dato = scanner.nextLine();
                System.out.println(dato);
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(null != fr){
                    fr.close();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
