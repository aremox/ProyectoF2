package ControlServicioCU;

import ContenedoresCU.ContenedorAlmacenesSingleton;
import ContenedoresCU.ContenedorClientesSingleton;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */


public class ControladorServicioGrabarDatosCarga {
    
    public ControladorServicioGrabarDatosCarga(){
    }

    public void DesarrollarServicio(){
        try {
            grabarAlmacen();
            grabarCliente();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorServicioGrabarDatosCarga.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    
    }
    
    
    private void grabarAlmacen() throws SQLException{
    ContenedorAlmacenesSingleton.getInstancia().grabarElementos();
    }
    
    private void grabarCliente() throws SQLException{
    ContenedorClientesSingleton.getInstancia().grabarElementos();
    }
    
}

