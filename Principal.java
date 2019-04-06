
package flujos;


import java.io.*;
import java.util.Scanner;



/**
 *
 * @author Yeray
 */
public class Principal {

    
    public static String[] nombre = {"Yeray Ramos", "Aarón González", "Besay López", "Victor Sarmiento", "Abian Borges"};
    public static String[] nTelefono = {"956564", "456465456", "46512313", "56465456", "5646486468468"};
        
    public static void main(String[] args) throws IOException   {
      
        //Se crea el objeto archivo de la clase CrearArchivo
 
        CrearArchivo archivo = new CrearArchivo();
        
        /*Se crea un objeto de la clase Scanner para pedir el nombre del
          del archivo desde teclado, y se almacena en la variable nombreArchivo
        */ 
       Scanner sc = new Scanner(System.in);
       System.out.println("Nombre del nuevo archivo (con extensión .txt):");
       String nombreArchivo = sc.nextLine();
      
        /*Desde el objeto creado, se llama al metodo de la clase pasando como
          argumento la variable que guarda el nombre del archivo introducido por
          teclado
        */
       archivo.crearArchivo(nombreArchivo);
      
        Telefono uno = new Telefono();
        //con el objeto creado llamamos a los metodos
        uno.escribirDirectorio();
        uno.leerDirectorio();
       
       
    
      
 
      
    }
    
}
