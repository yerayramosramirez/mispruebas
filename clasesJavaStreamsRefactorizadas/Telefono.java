
package flujos;


import static flujos.Ejecucion.getNombre;
import static flujos.Ejecucion.nTelefono;

import java.io.*;



/**
 *
 * @author Yeray
 */
public class Telefono implements InterfazTelefono {
    
   
    
    //metodo que crea y escribe en el directorio creado

    /* (non-Javadoc)
	 * @see flujos.InterfazTelefono#escribirDirectorio()
	 */
    @Override
	public File escribirDirectorio(){
       // instanciacion del objeto de la clase File para crear un nuevo fichero
       File directorio = new File("directorio.txt"); 
        
        try{
           //Se crear el archivo si no esta creado
            crearArchivo(directorio);
      //Excepciones de objeto file no encontrado y de entrada o salida 
        }catch(FileNotFoundException fnfe){
            System.out.println("Error" +fnfe);
        }catch(IOException ioe){
            System.out.println("Error" + ioe);
        }

          return directorio; 
        }

	private void crearArchivo(File directorio) throws IOException {
		if(!directorio.exists()){
		    directorio.createNewFile();
		    System.out.println("Archivo creado");
		   //se abre el flujo de escritura en el archivo creado
		    BufferedWriter bw = new BufferedWriter(new FileWriter(directorio));
		   //bucle para introducir los datos que se reciben desde el main
		    for (int i = 0; i< getNombre().length; i++){
		        bw.write("* " +getNombre()[i]+ "  " + nTelefono[i] );  
		    }

		   //Se cierra el flujo
		bw.close();
		} else{
		     System.out.println("El archivo ya existe");
		}
	} 
    
    //metodo que lee el contenido de un fichero ya creado

    /* (non-Javadoc)
	 * @see flujos.InterfazTelefono#leerDirectorio()
	 */
    @Override
	public String leerDirectorio() throws FileNotFoundException, IOException{
        //se abre el flujo de lectura del archivo 
        BufferedReader br = new BufferedReader(new FileReader("directorio.txt"));
        String leer;// variable que guarda el contenido leido en el fichero
        /*mientras la lectura del fichero no sea nula es decir que hayan lineas
          que leer, con el for recorremos el fichero devolvdiendo los datos en 
          el formato de salida con system.out 
        */
        while((leer = br.readLine()) != null){
                for (int i = 0; i<getNombre().length; i++){
                    System.out.println("Nombre: " +getNombre()[i]+ " Teléfono: " + nTelefono[i] );
                  }
             System.out.println("Hay un total de " + getNombre().length + " de personas en el directorio");  
            }
       
         
        //se cierra el flujo
        br.close();
       
        return leer;
   
    }
    
    /* (non-Javadoc)
	 * @see flujos.InterfazTelefono#accesoAleatorio()
	 */
    @Override
	public void accesoAleatorio() throws FileNotFoundException, IOException{
        
        RandomAccessFile raf = new RandomAccessFile("directorio.txt", "rw");
        //System.out.println(raf.length());
        String nombre = "pepe perez";
        
         System.out.println(raf.read());
        
        
    }
    
   
    
}
    

