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

public class Producto {
    private String id_producto;
    private String categoria;
    private String precio;         
    private String ficha_tecnica;
    private static final String INSERT 
            = "INSERT INTO PRODUCTOS " 
            + "(categoria, precio, ficha_tecnica, " 
            + "id_producto) VALUES(?, ?, ?, ?)"; 
    private static final String UPDATE 
            = "UPDATE PRODUCTOS SET categoria = ?, precio = ?, " 
            + "ficha_tecnica = ?" 
            + " WHERE id_producto = ?";
     private static final String borrar = "delete from PRODUCTOS where id_producto = ?"; 
    private boolean saved = false;


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
    
     public void borrar() throws SQLException { 
        ControladorConexionDB controlDB = new ControladorConexionDB();
        try (Connection connection = controlDB.obtenerConexion()) {
            try (PreparedStatement statement = connection.prepareStatement(borrar)) {
                statement.setString(1, id_producto);
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
                    statement.setString(1, categoria); 
                    statement.setDouble(2, Double.parseDouble(precio)); 
                    statement.setString(3, ficha_tecnica); 
                    statement.setString(4, id_producto);
                    statement.executeUpdate();
                } 
            } 
             
            else { 
                try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
                    statement.setString(1, categoria); 
                    statement.setDouble(2, Double.parseDouble(precio));  
                    statement.setString(3, ficha_tecnica); 
                    statement.setString(4, id_producto);
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
