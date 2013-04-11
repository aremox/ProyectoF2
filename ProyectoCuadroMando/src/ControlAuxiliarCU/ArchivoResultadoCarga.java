package ControlAuxiliarCU;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */

public class ArchivoResultadoCarga {

    private FileReader archivo;
    private String ruta;
    private FileWriter fichero = null;
    private PrintWriter pw = null;
    private AuditoriaCarga audtCarga;

    public ArchivoResultadoCarga() throws IOException {
        ruta = "src//ArchivoDatos//carga.txt";
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
        
        if (null != archivo) {
            archivo.close();
        }

    }

    public AuditoriaCarga obtenerAuditoriaCarga() throws IOException {
        archivo = new FileReader(ruta);
        audtCarga = new AuditoriaCarga();
        String linea;
        String carga = null;
        StringTokenizer tokens, tokens2;
        String[] elementos = null;

        BufferedReader br = new BufferedReader(archivo);
        while (((linea = br.readLine()) != null)) {
            if (!("".equals(linea))) {
                //if ("".equalsIgnoreCase(linea)) {
                    tokens = new StringTokenizer(linea, "=");
                    while (tokens.hasMoreTokens()) {

                        carga = tokens.nextToken().trim();

                        tokens2 = new StringTokenizer(tokens.nextToken().trim(), ":");
                        elementos = new String[tokens2.countTokens()];
                        int pos = 0;
                        while (tokens2.hasMoreTokens()) {
                            elementos[pos] = (tokens2.nextToken().trim());
                            pos++;
                        }
                    }
                    int TotalLeidos = Integer.parseInt(elementos[0]);
                    int TotalErrores = Integer.parseInt(elementos[1]);
                    double PorcentajeFallos = Double.parseDouble(elementos[2]);
                    int CargadosConExito = TotalLeidos - TotalErrores;
                    double CargadosConExitoDouble = CargadosConExito;
                    double TotalLeidosDouble = TotalLeidos;
                    int Errores = 100 - (int)((CargadosConExitoDouble / TotalLeidosDouble) * 100);
                    
                    RegistroCarga regCar = new RegistroCarga(carga, Errores, CargadosConExito, TotalLeidos);
                    audtCarga.asociarRegistroCarga(regCar);
                //}
            }

        }
        cerrarFichero();
        //System.out.println(audtCarga.obtenerAuditoriaCargaAlmacen().getTextoInformeCarga());
        return audtCarga;
    }
}
