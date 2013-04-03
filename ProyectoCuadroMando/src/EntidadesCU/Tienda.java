package EntidadesCU;

/*
 *
 * @author Javier Roncero
 *
 */

public class Tienda {
    private String id_tienda;
    private Almacen id_almacen;
    private String calle;
    private String numero;
    private String cod_postal;
    private String poblacion;
    private String provincia;         
    private String telefono;



    public Tienda(String at_id_tienda, Almacen at_id_almacen, String at_calle, String at_numero, String at_cod_postal, String at_poblacion, String at_provincia, String at_telefono) {
        id_tienda = at_id_tienda;
        id_almacen = at_id_almacen;
        calle = at_calle;
        numero = at_numero;
        cod_postal = at_cod_postal;
        poblacion = at_poblacion;
        provincia = at_provincia;
        telefono = at_telefono;
    }
    
    public String getId_tienda(){
        return id_tienda;
    }
 
    public String getCod_Postal(){
        return cod_postal;
    }      
    
    public Almacen getAlmacen(){
        return id_almacen;
    }
    
    
}
