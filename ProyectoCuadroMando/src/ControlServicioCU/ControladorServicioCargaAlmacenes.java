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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
            
             List lista2 = new ArrayList(almacenes);
                    Iterator it = lista2.iterator();
                    while (it.hasNext()) {
                        System.out.println(it.next() + "");
                    }
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
