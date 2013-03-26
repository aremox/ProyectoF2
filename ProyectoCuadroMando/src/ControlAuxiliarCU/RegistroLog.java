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
public class RegistroLog {

    FileWriter fichero = null;
    PrintWriter pw = null;

    public RegistroLog(String texto, String categoria) throws IOException {
    
            fichero = new FileWriter("src//ArchivoDatos//error.log", true);
            pw = new PrintWriter(fichero);
            pw.println(":::::::::::"+categoria+"::::::::::");
            pw.println("");
            pw.println(texto);
        
                if (null != fichero) {
                    fichero.close();
             }
    }

    RegistroLog() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

