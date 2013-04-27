package EntidadesCU;

import ControlAuxiliarCU.ControladorConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *
 * @author Ivan Arenas
 *
 */

public class Venta {

    private String id_venta;
    private Cliente cliente;
    private Producto producto;
    private Tienda tienda;
    private String unidades;
    private String importe;
    private String fecha;
    private static final String INSERT 
            = "INSERT INTO ventas " 
            + "(cliente, producto, tienda, unidades, importe, fecha, " 
            + "id_venta) VALUES(?, ?, ?, ?, ?, ?, ?)"; 
    private static final String UPDATE 
            = "UPDATE ventas SET ventas = ?, producto = ?, tienda = ?, unidades = ?, importe = ?, fecha = ?" 
            + " WHERE id_venta = ?";
    private static final String borrar = "delete from ventas where id_venta = ?";
    private boolean saved = false;

    public Venta(String at1, Cliente at2, Producto at3, Tienda at4, String at5, String at6, String at7) {
        id_venta = at1;
        cliente = at2;
        producto = at3;
        tienda = at4;
        unidades = at5;
        importe = at6;
        fecha = at7;

    }
    
    public String getId_venta(){
        return id_venta;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public Producto getProducto(){
        return producto;
    }
    
    public Tienda getTienda(){
        return tienda;
    }
    
    public String getImporte(){
        return importe;
    }
    
    public void borrar() throws SQLException { 
        ControladorConexionDB controlDB = new ControladorConexionDB();
        try (Connection connection = controlDB.obtenerConexion()) {
            try (PreparedStatement statement = connection.prepareStatement(borrar)) {
                statement.setString(1, id_venta);
                statement.executeUpdate();
            }
            connection.close();
        }
    }
    
    public void grabar() throws SQLException, ParseException { 
    ControladorConexionDB controlDB = new ControladorConexionDB();
       try (Connection connection = controlDB.obtenerConexion()) {
            if (saved) { 
                try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
                    statement.setString(1, cliente.getId_cliente()); 
                    statement.setString(2, producto.getId_producto()); 
                    statement.setString(3, tienda.getId_tienda());  
                    statement.setInt(4, Integer.parseInt(unidades)); 
                    statement.setDouble(5, Double.parseDouble(importe)); 
                    statement.setString(6,fecha); 
                    statement.setString(7, id_venta);
                    statement.executeUpdate();
                } 
            } 
             
            else { 
                try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
                     statement.setString(1, cliente.getId_cliente()); 
                    statement.setString(2, producto.getId_producto()); 
                    statement.setString(3, tienda.getId_tienda());  
                    statement.setInt(4, Integer.parseInt(unidades)); 
                    statement.setDouble(5, Double.parseDouble(importe)); 
                    statement.setString(6,fecha); 
                    statement.setString(7, id_venta);
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
