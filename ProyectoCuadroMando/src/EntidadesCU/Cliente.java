package EntidadesCU;

/*
 *
 * @author Javier Roncero
 *
 */

public class Cliente {
    private String id_cliente;
    private String dni;
    private String nombre;
    private String apellidos;
    private String calle;
    private String numero;
    private String cod_postal;
    private String poblacion;
    private String provincia;         
    private String telefono;


    public Cliente(String at_id_cliente, String at_dni, String at_nombre, String at_apellidos, String at_calle, String at_numero, String at_cod_postal, String at_poblacion, String at_provincia, String at_telefono) {
        id_cliente = at_id_cliente;
        dni = at_dni;
        nombre = at_nombre;
        apellidos = at_apellidos;
        calle = at_calle;
        numero = at_numero;
        cod_postal = at_cod_postal;
        poblacion = at_poblacion;
        provincia = at_provincia;
        telefono = at_telefono;
    }
    
    public String getId_cliente(){
        return id_cliente;
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
    public void grabar(){
        
    }

}
