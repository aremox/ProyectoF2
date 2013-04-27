package EntidadesCU;

import ControlAuxiliarCU.ControladorConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 *
 * @author Javier Roncero
 *
 */

public class Cliente extends GeoEntidad{
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
    private static final String INSERT 
            = "INSERT INTO CLIENTES " 
            + "(dni, nombre, apellidos, calle, " 
            + "numero, cod_postal, poblacion, provincia, telefono,x,y, id_cliente) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)"; 
    private static final String UPDATE 
            = "UPDATE CLIENTES SET dni = ?, " 
            + "nombre = ?, apellidos = ?, calle = ?, numero = ?, " 
            + "cod_postal = ?, poblacion = ?, provincia = ?, telefono = ?,x=?,y=?, id_cliente = ?  WHERE id_cliente = ?";
     private static final String borrar = "delete from CLIENTES where id_cliente = ?"; 
    private boolean saved = false;


    public Cliente(String at_id_cliente, String at_dni, String at_nombre, String at_apellidos, String at_calle, String at_numero, String at_cod_postal, String at_poblacion, String at_provincia, String at_telefono) {
        super();
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
    
     public void borrar() throws SQLException { 
        ControladorConexionDB controlDB = new ControladorConexionDB();
        try (Connection connection = controlDB.obtenerConexion()) {
            try (PreparedStatement statement = connection.prepareStatement(borrar)) {
                statement.setString(1, id_cliente);
                statement.executeUpdate();
            }
            connection.close();
        }
    }
     
    public void grabar() throws SQLException { 
    ControladorConexionDB controlDB = new ControladorConexionDB();
        try (Connection connection = controlDB.obtenerConexion()) {
            if (saved) { 
                try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
                    statement.setString(1, dni); 
                    statement.setString(2, nombre); 
                    statement.setString(3, apellidos); 
                    statement.setString(4, calle); 
                    statement.setInt(5, Integer.parseInt(numero)); 
                    statement.setInt(6, Integer.parseInt(cod_postal)); 
                    statement.setString(7, poblacion);
                    statement.setString(8, provincia);
                    statement.setLong(9, Long.parseLong(telefono));
                    statement.setInt(10, x);
                    statement.setInt(11, y);
                    statement.setString(12, id_cliente);
                    statement.executeUpdate();
                } 
            } 
             
            else { 
                try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
                    statement.setString(1, dni); 
                    statement.setString(2, nombre); 
                    statement.setString(3, apellidos); 
                    statement.setString(4, calle); 
                    statement.setInt(5, Integer.parseInt(numero)); 
                    statement.setInt(6, Integer.parseInt(cod_postal)); 
                    statement.setString(7, poblacion);
                    statement.setString(8, provincia);
                    statement.setLong(9, Long.parseLong(telefono));
                    statement.setInt(10, x);
                    statement.setInt(11, y);
                    statement.setString(12, id_cliente);
                    statement.executeUpdate();
                } 
                // Indicate that the information now exists 
                // in the database. 
                saved = true; 
            }
            connection.close();
        } 
    }

}
