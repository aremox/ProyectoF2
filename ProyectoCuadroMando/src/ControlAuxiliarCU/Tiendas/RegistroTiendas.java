package ControlAuxiliarCU.Tiendas;

/*
 *
 * @author Javier Roncero
 *
 */

public class RegistroTiendas {

    private String id_tienda;
    private String calle;
    private String numero;
    private String cod_postal;
    private String poblacion;
    private String provincia;         
    private String telefono;

    public RegistroTiendas(String at_id_tienda, String at_calle, String at_numero, String at_cod_postal, String at_poblacion, String at_provincia, String at_telefono) {
        id_tienda = at_id_tienda;
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
    public String getCalle(){
        return calle;
    }
    public String getNumero(){
        return numero;
    }  
    public String getCod_Postal(){
        return cod_postal;
    }      
    public String getPoblacion(){
        return poblacion;
    }  
    public String getProvincia(){
        return provincia;
    }  
    public String getTelefono(){
        return telefono;
    } 
}