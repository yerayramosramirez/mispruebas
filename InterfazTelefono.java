package flujos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface InterfazTelefono {

	File escribirDirectorio();

	String leerDirectorio() throws FileNotFoundException, IOException;

	void accesoAleatorio() throws FileNotFoundException, IOException;

}