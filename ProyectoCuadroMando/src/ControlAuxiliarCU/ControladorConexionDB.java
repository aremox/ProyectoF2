/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAuxiliarCU;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ivan
 */
public class ControladorConexionDB {
    Connection con;
    public ControladorConexionDB(){
        
    }
    public Connection obtenerConexion(){
    try
            {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
 
                    String url = "jdbc:derby://localhost:1527/cuadromando";
                    String user = "ivan";
                    String password = "123456";
 
                    con = DriverManager.getConnection(url, user, password);
 
                    return con;
 
            }
            catch(ClassNotFoundException | SQLException e)
            {
                   System.out.println(e.getMessage());
            }
        return null;
    }
    
    public void cerrar() throws SQLException{
        con.close();
    }
}
