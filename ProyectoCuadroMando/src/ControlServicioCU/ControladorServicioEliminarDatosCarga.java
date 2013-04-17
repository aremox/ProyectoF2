package ControlServicioCU;

import ContenedoresCU.ContenedorAlmacenesSingleton;
import ContenedoresCU.ContenedorClientesSingleton;
import ContenedoresCU.ContenedorProductosSingleton;
import ContenedoresCU.ContenedorTiendasSingleton;
import ContenedoresCU.ContenedorVentasSingleton;


/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */


public class ControladorServicioEliminarDatosCarga {
    
    public ControladorServicioEliminarDatosCarga(){
    }

    public void DesarrollarServicio(){
        borrarVentas();    
        borrarTienda();
        borrarAlmacen();
        borrarClientes();
        borrarProductos();   
    
    }
    
    
    private void borrarTienda(){
    ContenedorTiendasSingleton.getInstancia().borrarElementos();
    }
    
     private void borrarAlmacen(){
    ContenedorAlmacenesSingleton.getInstancia().borrarElementos();
    }
     private void borrarVentas(){
    ContenedorVentasSingleton.getInstancia().borrarElementos();
    }
     private void borrarClientes(){
    ContenedorClientesSingleton.getInstancia().borrarElementos();
    }
     private void borrarProductos(){
    ContenedorProductosSingleton.getInstancia().borrarElementos();
    }
}

