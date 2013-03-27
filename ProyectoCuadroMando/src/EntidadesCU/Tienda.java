/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesCU;

import ControlAuxiliarCU.*;

/**
 *
 * @author ivan
 */
public class Tienda {

    private String id_almacenes;
   

    public Tienda(String pid_tienda) {
        id_almacenes = pid_tienda;
        
    }
    public String getId_almacen(){
        return id_almacenes;
    }
}
