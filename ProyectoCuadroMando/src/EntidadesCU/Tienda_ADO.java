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

public class Tienda_ADO extends GeoEntidad {
    private String id_tienda;
    private Almacen_ADO id_almacen;
    private String calle;
    private String numero;
    private String cod_postal;
    private String poblacion;
    private String provincia;         
    private String telefono;
    private static final String INSERT 
            = "INSERT INTO TIENDAS " 
            + "(id_almacen, calle, numero, cod_postal, poblacion, provincia, telefono, x, y," 
            + "id_tienda) VALUES(?, ?, ?, ?, ?, ?, ?, ?,?,?)"; 
    private static final String UPDATE 
            = "UPDATE TIENDAS SET id_almacen = ?, calle = ?, numero = ?, cod_postal = ?, poblacion = ?, provincia = ?, telefono = ?,x=?,y=?" 
            + " WHERE id_tienda = ?";
    private static final String borrar = "delete from tiendas where id_tienda = ?"; 
           
    private boolean saved = false;


    public Tienda_ADO(String at_id_tienda, String at_calle, String at_numero, String at_cod_postal, String at_telefono, String at_poblacion, String at_provincia, Almacen_ADO at_id_almacen) {
        super();
        id_tienda = at_id_tienda;
        calle = at_calle;
        numero = at_numero;
        cod_postal = at_cod_postal;
        poblacion = at_poblacion;
        provincia = at_provincia;
        telefono = at_telefono;
        id_almacen = at_id_almacen;
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
    
    public Almacen_ADO getAlmacen(){
        return id_almacen;
    }
    public void borrar() throws SQLException { 
        ControladorConexionDB controlDB = new ControladorConexionDB();
        try (Connection connection = controlDB.obtenerConexion()) {
            try (PreparedStatement statement = connection.prepareStatement(borrar)) {
                statement.setString(1, id_tienda);
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
                    statement.setString(1, id_almacen.getId_almacen()); 
                    statement.setString(2, calle); 
                    statement.setInt(3, Integer.parseInt(numero)); 
                    statement.setInt(4, Integer.parseInt(cod_postal)); 
                    statement.setString(5, poblacion); 
                    statement.setString(6, provincia); 
                    statement.setLong(7, Long.parseLong(telefono));
                    statement.setInt(8, x);
                    statement.setInt(9, y);
                    statement.setString(10, id_tienda);
                    statement.executeUpdate();
                } 
            } 
             
            else { 
                try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
                    statement.setString(1, id_almacen.getId_almacen()); 
                    statement.setString(2, calle); 
                    statement.setInt(3, Integer.parseInt(numero)); 
                    statement.setInt(4, Integer.parseInt(cod_postal)); 
                    statement.setString(5, poblacion); 
                    statement.setString(6, provincia); 
                    statement.setLong(7, Long.parseLong(telefono));
                    statement.setInt(8, x);
                    statement.setInt(9, y);
                    statement.setString(10, id_tienda);
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
