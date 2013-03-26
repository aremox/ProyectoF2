/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlServicioCU;

import ControlAuxiliarCU.ProveedorInformacion;
import ControlAuxiliarCU.ProveedorInformacionAlmacenes;
import ControlAuxiliarCU.RegistroAlmacen;
import EntidadesCU.Almacen;
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
            int tam = almacenes.size();
            int cont = 0;
            for (int i = 0; i < tam; i++) {

            RegistroAlmacen registros = (RegistroAlmacen) almacenes.get(i);
            Almacen alm = new Almacen(registros.getId_almacen(),registros.getCalle(),registros.getNumero(),registros.getCod_postal(),registros.getTelefono(), registros.getMunicipio(), registros.getProvincia());

            

            cont++;
        }
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
