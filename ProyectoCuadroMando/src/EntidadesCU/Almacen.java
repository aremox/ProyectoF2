package EntidadesCU;

import ControlAuxiliarCU.ControladorConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 *
 * @author Ivan Arenas
 *
 */

public class Almacen extends GeoEntidad{

    private String id_almacen;
    private String calle;
    private int numero;
    private int cod_postal;
    private long telefono;
    private String municipio;
    private String provincia;
    private static final String INSERT 
            = "INSERT INTO ALMACENES " 
            + "(calle, numero, cod_postal, telefono, municipio,provincia,x,y, " 
            + " id_almacen) VALUES(?, ?, ?, ?, ?, ?, ?,?,?)"; 
    private static final String UPDATE 
            = "UPDATE ALMACENES SET calle = ?, " 
            + "numero = ?, cod_postal = ?, telefono = ?, municipio = ?, " 
            + "provincia = ?,x=?,y=? WHERE id_almacen = ?";
    private static final String borrar = "delete from ALMACENES where id_almacen = ?"; 
    private boolean saved = false;
    

    public Almacen(String pid_almacenes, String pcalle, String pnumero, String pcod_postal, String ptelefono, String pmunicipio, String pprovincia) {
        super();
        id_almacen = pid_almacenes;
        calle = pcalle;
        numero = Integer.parseInt(pnumero);
        cod_postal = Integer.parseInt(pcod_postal);
        telefono = Long.parseLong(ptelefono);
        municipio = pmunicipio;
        provincia = pprovincia;
    }
    public String getId_almacen(){
        return id_almacen;
    }
    public String getCalle(){
        return calle;
    }
    public String getNumero(){
        return Integer.toString(numero);
    }
    public String getCod_postal(){
        return Integer.toString(cod_postal);
    }
    public String getTelefono(){
        return Long.toString(telefono);
    }
    public String getMunicipio(){
        return municipio;
    }
    public String getProvincia(){
        return provincia;
    }
   public void borrar() throws SQLException { 
        ControladorConexionDB controlDB = new ControladorConexionDB();
        try (Connection connection = controlDB.obtenerConexion()) {
            try (PreparedStatement statement = connection.prepareStatement(borrar)) {
                statement.setString(1, id_almacen);
                statement.executeUpdate();
            }
            connection.close();
        }
    }
    
    public void grabar() throws SQLException { 
    ControladorConexionDB controlDB = new ControladorConexionDB();
    
           Connection connection = controlDB.obtenerConexion();
                if (saved) { 
            try (PreparedStatement statement2 = connection.prepareStatement(UPDATE)) {
                statement2.setString(1, calle); 
                statement2.setInt(2, numero); 
                statement2.setInt(3, cod_postal); 
                statement2.setDouble(4, telefono); 
                statement2.setString(5, municipio); 
                statement2.setString(6, provincia); 
                statement2.setInt(7, x); 
                statement2.setInt(8, y); 
                statement2.setString(9, id_almacen); 
                statement2.executeUpdate();
            }
                    } 
                else { 
            try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
                statement.setString(1, calle); 
                statement.setInt(2, numero); 
                statement.setInt(3, cod_postal); 
                statement.setDouble(4, telefono); 
                statement.setString(5, municipio); 
                statement.setString(6, provincia);
                statement.setInt(7, x); 
                statement.setInt(8, y); 
                statement.setString(9, id_almacen); 
                statement.executeUpdate();
            }
                    // Indicate that the information now exists 
                    // in the database. 
                    saved = true; 
                }
            }
        
       
               
}
    
