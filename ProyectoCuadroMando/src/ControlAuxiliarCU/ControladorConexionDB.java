/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAuxiliarCU;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ivan
 */
public class ControladorConexionDB {
    public ControladorConexionDB(){
        
    }
    public Connection obtenerConexion(){
    try
            {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
 
                    String url = "jdbc:derby://localhost:1527/cuadro_mando";
                    String user = "ivan";
                    String password = "123456";
 
                    Connection con = DriverManager.getConnection(url, user, password);
 
                    return con;
 
            }
            catch(Exception e)
            {
                   System.out.println(e.getMessage());
            }
        return null;
    }
}
