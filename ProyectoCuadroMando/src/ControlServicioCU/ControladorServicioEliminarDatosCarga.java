package ControlServicioCU;

import ContenedoresCU.ContenedorAlmacenesSingleton;
import ContenedoresCU.ContenedorClientesSingleton;
import ContenedoresCU.ContenedorProductosSingleton;
import ContenedoresCU.ContenedorTiendasSingleton;
import ContenedoresCU.ContenedorVentasSingleton;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */


public class ControladorServicioEliminarDatosCarga {
    
    public ControladorServicioEliminarDatosCarga(){
    }

    public void DesarrollarServicio() {
        try {
            borrarVentas();    
            borrarTienda();
            borrarAlmacen();
            borrarClientes();   
            borrarProductos();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorServicioEliminarDatosCarga.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    private void borrarTienda() throws SQLException{
    ContenedorTiendasSingleton.getInstancia().borrarElementos();
    }
    
     private void borrarAlmacen() throws SQLException{
    ContenedorAlmacenesSingleton.getInstancia().borrarElementos();
    }
     private void borrarVentas() throws SQLException{
    ContenedorVentasSingleton.getInstancia().borrarElementos();
    }
     private void borrarClientes() throws SQLException{
    ContenedorClientesSingleton.getInstancia().borrarElementos();
    }
     private void borrarProductos() throws SQLException{
    ContenedorProductosSingleton.getInstancia().borrarElementos();
    }
}

