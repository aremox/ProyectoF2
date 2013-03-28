package ControlAuxiliarCU;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public abstract class ProveedorInformacion {

    private File archivo;
    private FileReader flujoEntrada;
    protected String separadorCampos;
    protected int numeroCampos;
    protected LinkedList<String> lineas;
    protected int errores=0;

    public ProveedorInformacion(String ruta, String separador, int numero) throws FileNotFoundException {
        //comprobar archivo
        archivo = new File(ruta);
        separadorCampos = separador;
        numeroCampos = numero;
        try {
            flujoEntrada = new FileReader(archivo);
            if (!archivo.exists()) {
                throw new IOException();
            }
        } catch (IOException ex) {
            System.out.println("ERROR: El fichero no existe");

        }
    }

    public void cerrarFlujo() throws IOException {
         if (null != flujoEntrada)
              flujoEntrada.close();
    }

    public void leerLinea() {
        String linea = "";
        lineas=new LinkedList<String>();
        try {
            BufferedReader br = new BufferedReader(flujoEntrada); 
            while ((linea = br.readLine()) != null) {
                    lineas.add(linea);
            }
        } catch (IOException ex) {
            System.out.println("ERROR: En el flujo de lectura");
        }
    }
    
    public int getErrores(){
        return errores;
    }

}
