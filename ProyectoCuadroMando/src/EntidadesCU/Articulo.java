package EntidadesCU;

import ControlAuxiliarCU.*;

/*
 *
 * @author Javier Roncero
 *
 */

public class Articulo {

    private String id_articulo;
   

    public Articulo(String pid_almacenes) {
        id_articulo = pid_almacenes;
       
    }
    public String getId_articulo(){
        return id_articulo;
    }
}
