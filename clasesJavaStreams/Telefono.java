
package flujos;


import static flujos.Principal.nTelefono;
import static flujos.Principal.nombre;
import java.io.*;



/**
 *
 * @author Yeray
 */
public class Telefono {
    
   
    
    //metodo que crea y escribe en el directorio creado

    public File escribirDirectorio(){
       // instanciacion del objeto de la clase File para crear un nuevo fichero
       File directorio = new File("directorio.txt"); 
        
        try{
           //Se crear el archivo si no esta creado
            if(!directorio.exists()){
                directorio.createNewFile();
                System.out.println("Archivo creado");
               //se abre el flujo de escritura en el archivo creado
                BufferedWriter bw = new BufferedWriter(new FileWriter(directorio));
               //bucle para introducir los datos que se reciben desde el main
                for (int i = 0; i< nombre.length; i++){
                    bw.write("* " +nombre[i]+ "  " + nTelefono[i] );  
                }

               //Se cierra el flujo
            bw.close();
            } else{
                 System.out.println("El archivo ya existe");
            }
      //Excepciones de objeto file no encontrado y de entrada o salida 
        }catch(FileNotFoundException fnfe){
            System.out.println("Error" +fnfe);
        }catch(IOException ioe){
            System.out.println("Error" + ioe);
        }

          return directorio; 
        } 
    
    //metodo que lee el contenido de un fichero ya creado

    public String leerDirectorio() throws FileNotFoundException, IOException{
        //se abre el flujo de lectura del archivo 
        BufferedReader br = new BufferedReader(new FileReader("directorio.txt"));
        String leer;// variable que guarda el contenido leido en el fichero
        /*mientras la lectura del fichero no sea nula es decir que hayan lineas
          que leer, con el for recorremos el fichero devolvdiendo los datos en 
          el formato de salida con system.out 
        */
        while((leer = br.readLine()) != null){
                for (int i = 0; i<nombre.length; i++){
                    System.out.println("Nombre: " +nombre[i]+ " Teléfono: " + nTelefono[i] );
                  }
             System.out.println("Hay un total de " + nombre.length + " de personas en el directorio");  
            }
       
         
        //se cierra el flujo
        br.close();
       
        return leer;
   
    }
    
    public void accesoAleatorio() throws FileNotFoundException, IOException{
        
        RandomAccessFile raf = new RandomAccessFile("directorio.txt", "rw");
        //System.out.println(raf.length());
        String nombre = "pepe perez";
        
         System.out.println(raf.read());
        
        
    }
    
   
    
}
    

