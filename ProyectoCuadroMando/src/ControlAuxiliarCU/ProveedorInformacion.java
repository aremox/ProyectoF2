package ControlAuxiliarCU;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public abstract class ProveedorInformacion {

    private File archivo;
    private FileReader flujoLectura;
    protected String separadorCampos;
    private int numeroCampos;
    protected LinkedList lineas;

    public ProveedorInformacion(String ruta, String separador, int numero) throws FileNotFoundException {
//comprobar archivo
        archivo = new File(ruta);
        separadorCampos = separador;
        numeroCampos = numero;
        try {
            flujoLectura = new FileReader(archivo);
            if (!archivo.exists()) {
                throw new IOException();
            }
        } catch (IOException ex) {
            System.out.println("ERROR: El fichero no existe");

        }
    }

    public void cerrarFlujo() {
    }

    public void leerLinea() {
          
        //StringBuilder linea = new StringBuilder();

        //String linea2 = "elemento1::elemento2::elemento3";
        //StringTokenizer tokens = new StringTokenizer(linea2, "::");

        //while(tokens.hasMoreTokens()){

        //System.out.println(tokens.nextToken());

        //}

        String linea = "";
        StringTokenizer tokens;
        lineas=new LinkedList();
        try {
         
            //int caracter;
            BufferedReader br = new BufferedReader(flujoLectura); 
           

            while ((linea = br.readLine()) != null) {

                tokens = new StringTokenizer(linea, separadorCampos);
                if (tokens.countTokens() != numeroCampos) {
                    System.out.println("ERROR: Linea sin todos los campos");
                } else {
                    //System.out.print("Separo la linea: ");
                    //System.out.println(linea);
                    lineas.add(linea);/*
                    while (tokens.hasMoreTokens()) {
                        
                        //System.out.println(tokens.nextToken().trim());
                    }
*/
                }
            }
            //while ((caracter = flujoLectura.read()) != -1) {
            //  linea = linea.append((char)caracter);
            // 
            //}
        } catch (IOException ex) {
            System.out.println("ERROR: En el flujo de lectura");
           // Logger.getLogger(ProveedorInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }


       // return lineas;
    }
}
