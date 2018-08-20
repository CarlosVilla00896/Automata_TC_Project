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
    AFD afd;
    
    public Archivos (){
        afd = new AFD();
    }
    
    public void abrirArchivo(){
        try{
            file = new File(filename);
            fr = new FileReader(file);
            scanner = new Scanner(fr);
            scanner.nextLine();
            
            while(scanner.hasNextLine()){
                String dato = scanner.nextLine();
                afd.validarAFD_aux(dato);
                
//                System.out.println(dato);
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
