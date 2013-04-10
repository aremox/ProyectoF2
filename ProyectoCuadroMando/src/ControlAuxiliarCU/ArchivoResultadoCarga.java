package ControlAuxiliarCU;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */
public class ArchivoResultadoCarga {

    private File archivo;
    private FileReader flujoEntrada;
    private String separadorCampos;
    private String ruta;
    private FileWriter fichero = null;
    private PrintWriter pw = null;
    private AuditoriaCarga audtCarga;

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

    public AuditoriaCarga obtenerAuditoriaCarga() throws FileNotFoundException, IOException {
        flujoEntrada = new FileReader(ruta);
        audtCarga = new AuditoriaCarga();
        String linea, linea2;
        String carga = null;
        StringTokenizer tokens, tokens2;
        

        BufferedReader br = new BufferedReader(flujoEntrada);
        while ((linea = br.readLine()) != null) {
            if ("".equalsIgnoreCase(linea)) {
                tokens = new StringTokenizer(linea, "=");
                while (tokens.hasMoreTokens()) {
                    
                    carga = tokens.nextToken().trim();
                   
                    tokens2 = new StringTokenizer(tokens.nextToken().trim(), ":");
                    int[] elementos = new int[tokens2.countTokens()];
                    int pos = 0;
                    while (tokens2.hasMoreTokens()) {
                        elementos[pos] = Integer.parseInt(tokens.nextToken().trim());
                        pos++;
                    }
                }
                RegistroCarga regCar = new RegistroCarga(carga, elementos[0], elementos[1],elementos[2]);
                    
            }
        }

        cerrarFichero();
        return audtCarga;
    }
}
