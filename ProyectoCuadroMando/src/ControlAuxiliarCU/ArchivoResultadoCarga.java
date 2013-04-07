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

public class ArchivoResultadoCarga {

    FileWriter fichero = null;
    PrintWriter pw = null;

    public ArchivoResultadoCarga() throws IOException {
        String ruta = "src//ArchivoDatos//carga.txt";
        fichero = new FileWriter(ruta, true);
    }

    public void registrarDatosCarga(String texto) {

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
