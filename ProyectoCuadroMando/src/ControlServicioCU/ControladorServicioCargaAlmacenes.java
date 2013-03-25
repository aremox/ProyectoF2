/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlServicioCU;

import ControlAuxiliarCU.ProveedorInformacion;
import ControlAuxiliarCU.ProveedorInformacionAlmacenes;
import ProyectoCuadroMando.ProyectoCuadroMando;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivan
 */
public class ControladorServicioCargaAlmacenes {
    public ControladorServicioCargaAlmacenes(File fichero){
        try {
            //
            ProveedorInformacionAlmacenes lec= new ProveedorInformacionAlmacenes(fichero.getAbsolutePath(), "::", 7);
            //lec.leerLinea();
            LinkedList almacenes = new LinkedList (lec.extraer());
            
             int tam = almacenes.size();
        int pos = 0; //Mientras haya elementos 
        while (pos <= tam - 1) {
            //obtener 
            String linea = (String) almacenes.get(pos);
            System.out.println(linea);
            pos++;
        }
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
