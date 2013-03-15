package Controladores;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LectorArchivo {
    File archivo;
    FileReader flujoLectura;
public LectorArchivo(String ruta) throws FileNotFoundException{
//comprobar archivo
    archivo=new File(ruta);

    try{
        flujoLectura= new FileReader (archivo);
    if (!archivo.exists()) throw new IOException();
    }catch (IOException ex){
    System.out.println("No existe el fichero, melon");
    }
}

public void cerrarFlujo(){}

public String leerLinea(){
StringBuilder linea= new StringBuilder();
 try {
            int caracter;
            while ((caracter = flujoLectura.read()) != -1) {
              linea= linea.append((char)caracter);
            }
        } catch (IOException ex) {
            Logger.getLogger(LectorArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }

 return linea.toString();
}

}
