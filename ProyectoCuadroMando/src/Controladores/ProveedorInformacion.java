package Controladores;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.FileReader;
import java.io.BufferedReader;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.StringTokenizer;

public class ProveedorInformacion {
    File archivo;
    FileReader flujoLectura;
public ProveedorInformacion(String ruta) throws FileNotFoundException{
//comprobar archivo
    archivo=new File(ruta);

    try{
        flujoLectura = new FileReader (archivo);
    if (!archivo.exists()) throw new IOException();
    }catch (IOException ex){}
}

public void cerrarFlujo(){}

public String leerLinea(){
//StringBuilder linea = new StringBuilder();

//String linea2 = "elemento1::elemento2::elemento3";
//StringTokenizer tokens = new StringTokenizer(linea2, "::");

//while(tokens.hasMoreTokens()){

//System.out.println(tokens.nextToken());

//}

String linea = "";
StringTokenizer tokens;

try {
            //int caracter;
            BufferedReader br = new BufferedReader(flujoLectura);
            
            while ((linea = br.readLine()) != null)
            {

                tokens = new StringTokenizer(linea, ":");
                if (tokens.countTokens() != 10) {
                    System.out.println("ERROR: Linea sin todos los campos");
                }
                else
                {
                    while(tokens.hasMoreTokens()){

                        System.out.println(tokens.nextToken().trim());
                    }
                    System.out.println(linea);
                }
            }
            //while ((caracter = flujoLectura.read()) != -1) {
            //  linea = linea.append((char)caracter);
            // 
            //}
        } catch (IOException ex) {
            Logger.getLogger(ProveedorInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }


  return linea;
}

}
