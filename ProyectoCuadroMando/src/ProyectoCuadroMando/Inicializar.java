/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoCuadroMando;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ivan
 */
public class Inicializar {
    public Inicializar() throws IOException, SQLException, ClassNotFoundException{
        borrarFicheroCarga();
        borrarFicheroLog();
        borrarTablas();
    }
    
    private void borrarFicheroCarga() throws IOException{
       String ruta = "src//ArchivoDatos//carga.txt";
       FileWriter fichero = new FileWriter(ruta);
       PrintWriter pw = new PrintWriter(fichero);
        pw.println("");
        if (null != fichero) {
            fichero.close();
        }
        
    }
    private void borrarFicheroLog() throws IOException{
       String ruta = "src//ArchivoDatos//auditoriacarga.txt";
       FileWriter fichero = new FileWriter(ruta);
       PrintWriter pw = new PrintWriter(fichero);
        pw.println("");
        if (null != fichero) {
            fichero.close();
        }
        
    }
    private void borrarTablas() throws SQLException, ClassNotFoundException{
         Class.forName("org.apache.derby.jdbc.ClientDriver");
 
                    String url = "jdbc:derby://localhost:1527/cuadromando";
                    String user = "ivan";
                    String password = "123456";
                    
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement();
            try{
                      
                        String query = "delete from ventas";
                        stmt.executeUpdate(query);
                        System.out.println("Table borrada ...");                            
                   } catch(SQLException s){
                                System.out.println("Table not deleted ");               
                         }
        
        try{
                        String query = "delete from tiendas";
                        stmt.executeUpdate(query);
                        System.out.println("Table borrada ...");                            
                   } catch(SQLException s){
                                System.out.println("Table not deleted ");               
                         }
     try{
                        String query = "delete from almacenes";
                        stmt.executeUpdate(query);
                        System.out.println("Table borrada ...");                            
                   } catch(SQLException s){
                                System.out.println("Table not deleted ");               
                         }
      try{
                        String query = "delete from productos";
                        stmt.executeUpdate(query);
                        System.out.println("Table borrada ...");                            
                   } catch(SQLException s){
                                System.out.println("Table not deleted ");               
                         }
       try{
                        String query = "delete from clientes";
                        stmt.executeUpdate(query);
                        System.out.println("Table borrada ...");                            
                   } catch(SQLException s){
                                System.out.println("Table not deleted ");               
                         }
    con.close();
                        
    }
}
                    
                   
    

