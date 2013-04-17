package EntidadesCU;

/*
 *
 * @author Javier Roncero
 *
 */

public class Producto {
    private String id_producto;
    private String categoria;
    private String precio;         
    private String ficha_tecnica;


    public Producto(String at_id_producto, String at_categoria, String at_precio, String at_ficha_tecnica) {
        id_producto = at_id_producto;
        categoria = at_categoria;
        precio = at_precio;
        ficha_tecnica = at_ficha_tecnica;
    }
    
    public String getId_producto(){
        return id_producto;
    }
    public String getId_Categoria(){
        return categoria;
    }
    public void grabar(){
        
    }

}
