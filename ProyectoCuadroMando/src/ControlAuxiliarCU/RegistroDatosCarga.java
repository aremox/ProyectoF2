package ControlAuxiliarCU;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */

public class RegistroDatosCarga {

    FileWriter fichero = null;
    PrintWriter pw = null;

    public RegistroDatosCarga() throws IOException {
        String ruta = "src//ArchivoDatos//carga.txt";
        fichero = new FileWriter(ruta, true);
    }

    public void escribirFichero(String texto) {

        pw = new PrintWriter(fichero);
        pw.println(texto);
        pw.println("");

    }

    /**
     *
     * @throws IOException
     */
    public void cerrarFichero() throws IOException {
        if (null != fichero) {
            fichero.close();
        }

    }
}
