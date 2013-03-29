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

public class RegistroLog {

    FileWriter fichero = null;
    PrintWriter pw = null;

    public RegistroLog(String texto, String categoria) throws IOException {
    
            fichero = new FileWriter("src//ArchivoDatos//auditoriacarga.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(":::::::::::"+categoria+"::::::::::");
            pw.println("");
            pw.println(texto);
            pw.println("");
                if (null != fichero) {
                    fichero.close();
             }
    }

    RegistroLog() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

