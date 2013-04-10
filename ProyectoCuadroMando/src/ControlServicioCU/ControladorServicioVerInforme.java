/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlServicioCU;

import ContenedoresCU.ContenedorAlmacenes;
import ControlAuxiliarCU.AuditoriaCarga;
import ControlAuxiliarCU.RegistroAlmacenes;
import java.io.File;

/**
 *
 * @author ivan
 */
public class ControladorServicioVerInforme {
    
    private String ruta;
    private AuditoriaCarga audiCarga;
    
    public void ControladorServicioVerInforme(File fichero){
         ruta = fichero.getAbsolutePath();
    }
    
    public AuditoriaCarga DesarrollarServicio(){
        return audiCarga;
    }
}
