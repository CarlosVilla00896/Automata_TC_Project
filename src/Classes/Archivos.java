package Classes;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Archivos {
    
    final File carpeta = new File("C:\\Users\\PC\\Documents\\GitHub\\Automata_TC_Project\\Tests");
    File file;
    FileReader fr;
    Scanner scanner;
    //String filename = "Tests/TestNFA.txt";
    AFD afd;
    public String cadenasAceptas ="", cadenasNoAceptadas ="";
    public static ArrayList<String> testFiles;
    
    public Archivos (){
        afd = new AFD();
        testFiles = new ArrayList();
        listarFicheros(carpeta);
    }

    public String getCadenasAceptas() {
        return cadenasAceptas;
    }

    public String getCadenasNoAceptadas() {
        return cadenasNoAceptadas;
    }
    private void listarFicheros(File carpeta){
       for( final File fichero: carpeta.listFiles()){
           if(fichero.isFile()){
               String fileName = fichero.getName();
               testFiles.add(fileName);
           }
       }
    }
    
    public ArrayList<String> getTestFiles(){
        return testFiles;
    }
    
    public void abrirArchivo(String filename){
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
