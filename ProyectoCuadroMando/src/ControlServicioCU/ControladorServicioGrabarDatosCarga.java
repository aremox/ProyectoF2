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


public class ControladorServicioGrabarDatosCarga {
    
    public ControladorServicioGrabarDatosCarga(){
    }

    public void DesarrollarServicio(){
        grabarAlmacen();
          
    
    }
    
    
     private void grabarAlmacen(){
    ContenedorAlmacenesSingleton.getInstancia().grabarElementos();
    }
    
}

