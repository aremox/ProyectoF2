package ControlServicioCU;

import ContenedoresCU.ContenedorAlmacenes;
import ContenedoresCU.ContenedorClientes;
import ContenedoresCU.ContenedorProductos;
import ContenedoresCU.ContenedorTiendas;
import ContenedoresCU.ContenedorVentas;


/*
 *
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
    ContenedorTiendas.borrarElementos();
    }
    
     private void borrarAlmacen(){
    ContenedorAlmacenes.borrarElementos();
    }
     private void borrarVentas(){
    ContenedorVentas.borrarElementos();
    }
     private void borrarClientes(){
    ContenedorClientes.borrarElementos();
    }
     private void borrarProductos(){
    ContenedorProductos.borrarElementos();
    }
}

