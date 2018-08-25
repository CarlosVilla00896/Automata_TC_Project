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
    String filename = "TestNFA.txt";
    AFD afd;
    public String cadenasAceptas ="", cadenasNoAceptadas ="";
    
    public Archivos (){
        afd = new AFD();
    }

    public String getCadenasAceptas() {
        return cadenasAceptas;
    }

    public String getCadenasNoAceptadas() {
        return cadenasNoAceptadas;
    }
    
    public void abrirArchivo(){
        try{
            file = new File(filename);
            fr = new FileReader(file);
            scanner = new Scanner(fr);
            scanner.nextLine();
            
            while(scanner.hasNextLine()){
                String dato = scanner.nextLine();
                if(afd.validarAFD(dato)){
                    this.cadenasAceptas+= dato+" cadena aceptada"+"\n";
                }else{
                    this.cadenasNoAceptadas += dato+" cadena no aceptada "+afd.caracterIncorrecto+"\n";
                }
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
