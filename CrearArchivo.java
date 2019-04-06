/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flujos;

import java.io.*;


/**
 *
 * @author Yeray
 */
public class CrearArchivo {
        
  
    
    /*metodo que crea un objeto del tipo File con el parametro recibido 
    * de la clase principal nombreArchivo de tipo String
    */
    
    public File crearArchivo(String nombreArchivo){
        // instanciacion del objeto de la clase File
        File archivo = new File(nombreArchivo);
      
        try{
            // Si el archivo no existe se crea
            if (!archivo.exists()){
                archivo.createNewFile();
                System.out.println("Archivo creado");
                //Una vez creado se abre el flujo de escritura
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                //Bucle que escribe números del 1 al 10 dentro del archivo
                    for (int i=1; i <= 10; i++){
                        bw.write("Numero -> " + i + "\n");
                    }
                //Cierre del flujo de escritura
                    bw.close();
           
            }else if (archivo.exists()){
                 /*Si el archivo ya existe, muestra mensaje y avisa de que solo
                   se puede leer el contenido del archivo 
                */ 
                System.out.println("El archivo " + archivo + " ya existe");
                System.out.println(".....Leyendo Archivo " + archivo + ".....");
                System.out.println("Solo puede leer el archivo");
                // Se abre el flujo de lectura
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String leer;
                //Bucle que lee el archivo mientras haya líneas que leer
                while ((leer = br.readLine()) != null){
                    System.out.println(leer);
                }
                //Cierre del flujo de lectura
                br.close();    
            }
        }catch(FileNotFoundException fnfe){
            System.out.println("Error" +fnfe);
        }catch(IOException ioe){
            System.out.println("Error " + ioe);  
        }
         return archivo;
    }   
}
    
