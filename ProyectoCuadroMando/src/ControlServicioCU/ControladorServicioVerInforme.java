/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlServicioCU;

import ContenedoresCU.ContenedorAlmacenes;
import ControlAuxiliarCU.RegistroAlmacenes;
import java.io.File;

/**
 *
 * @author ivan
 */
public class ControladorServicioVerInforme {
    
    private String ruta;
    
    public void ControladorServicioVerInforme(File fichero){
         ruta = fichero.getAbsolutePath();
    }
    
    public void DesarrollarServicio(){
        
    }
}
