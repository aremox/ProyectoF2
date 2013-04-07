package ControlAuxiliarCU;

/*
 *
 * @author Javier Roncero
 *
 */

public class RegistroProductos {
    private String id_producto;
    private String categoria;
    private String precio;         
    private String ficha_tecnica;


    public RegistroProductos(String at_id_producto, String at_categoria, String at_precio, String at_ficha_tecnica) {
        id_producto = at_id_producto;
        categoria = at_categoria;
        precio = at_precio;
        ficha_tecnica = at_ficha_tecnica;
    }
    
    public String getId_producto(){
        return id_producto;
    }
    public String getCategoria(){
        return categoria;
    }
    public String getPrecio(){
        return precio;
    }
    public String getFicha_tecnica(){
        return ficha_tecnica;
    }

}
