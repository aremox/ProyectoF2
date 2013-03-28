package EntidadesCU;

import ControlAuxiliarCU.*;

/*
 *
 * @author Javier Roncero
 *
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
