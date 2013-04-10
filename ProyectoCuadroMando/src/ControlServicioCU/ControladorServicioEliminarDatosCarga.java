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

        ContenedorTiendas tiendas = new ContenedorTiendas();
        tiendas.borrarElementos();
                
        ContenedorAlmacenes almacenes = new ContenedorAlmacenes();
        almacenes.borrarElementos();
        
        ContenedorClientes clientes = new ContenedorClientes();
        clientes.borrarElementos();
        
        ContenedorProductos productos = new ContenedorProductos();
        productos.borrarElementos();
        
        ContenedorVentas ventas = new ContenedorVentas();
        ventas.borrarElementos();
        
    }
}

