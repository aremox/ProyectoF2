package ControlAuxiliarCU;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */

public abstract class ProveedorInformacion {

    protected File archivo;
    private FileReader flujoEntrada;
    protected String separadorCampos;
    protected LinkedList<String> lineas;
    
    public ProveedorInformacion(String separador) throws FileNotFoundException {
        //comprobar archivo
        separadorCampos = separador;

    }
    
    protected boolean comprobarFlujo() throws FileNotFoundException {
        boolean resComprobacion = false;
        try {
            flujoEntrada = new FileReader(archivo);
            if (!archivo.exists()) {
                resComprobacion = false;
                throw new IOException();
            } else {
                resComprobacion = true;
            }
        } catch (IOException ex) {
            System.out.println("ERROR: El fichero no existe");
            JOptionPane.showMessageDialog(null,"El fichero no se puede abrir","ERROR AL ABRIR EL ARCHIVO       ", JOptionPane.ERROR_MESSAGE); 

        }
        return resComprobacion;
    }

    private void cerrarFlujo() throws IOException {
         if (flujoEntrada != null){
              flujoEntrada.close();
         }
    }

    protected void leerLineas() {
        String linea;
        lineas=new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(flujoEntrada); 
            while ((linea = br.readLine()) != null) {
                    lineas.add(linea);
            }
            cerrarFlujo();
        } catch (IOException ex) {
            System.out.println("ERROR: En el flujo de lectura");
            JOptionPane.showMessageDialog(null,"Error al intentar leer el archivo","ERROR AL LEER EL ARCHIVO       ", JOptionPane.ERROR_MESSAGE); 
        }
    }
    
    abstract LinkedList extraer(String absolutePath);
    
}
