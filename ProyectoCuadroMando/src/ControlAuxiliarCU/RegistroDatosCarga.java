/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAuxiliarCU;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ivan
 */
public class RegistroDatosCarga {

    FileWriter fichero = null;
    PrintWriter pw = null;

    public RegistroDatosCarga(String ruta) throws IOException {
        fichero = new FileWriter(ruta, true);
    }

    public void escribirFichero(String texto) {

        pw = new PrintWriter(fichero);
        pw.println(texto);

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
