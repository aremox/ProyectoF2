package ControlServicioCU;

import ContenedoresCU.ContenedorAlmacenesSingleton;
import ContenedoresCU.ContenedorClientesSingleton;
import ContenedoresCU.ContenedorProductosSingleton;
import ContenedoresCU.ContenedorTiendasSingleton;
import ContenedoresCU.ContenedorVentasSingleton;
import java.sql.SQLException;


/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */


public class ControladorServicioEliminarDatosCarga {
    
    public ControladorServicioEliminarDatosCarga(){
    }

    public void DesarrollarServicio() throws SQLException{
        borrarVentas();    
        borrarTienda();
        borrarAlmacen();
        borrarClientes();
        borrarProductos();   
    
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

