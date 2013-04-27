/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlServicioCU;

import ContenedoresCU.ContenedorAlmacenesSingleton;
import ContenedoresCU.ContenedorClientesSingleton;
import ContenedoresCU.ContenedorTiendasSingleton;
import EntidadesCU.Almacen;
import EntidadesCU.Cliente;
import EntidadesCU.Tienda;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.geo.GeoReferenciadorFactory;
import org.geo.IGeoReferenciador;



/**
 *
 * @author ivan
 */
public class ControladorServicioGeoreferenciar {
    public ControladorServicioGeoreferenciar(){
    }

    public void DesarrollarServicio() {
        
            referenciarAlmacenes();
            referenciarTiendas();
            referenciarClientes();  
    }
    
    
    private void referenciarAlmacenes(){
        try {
            int tam = ContenedorAlmacenesSingleton.getInstancia().getAlmacenes().size();
                for (int i = 0; i < tam; i++) {
                   Almacen elemento = (Almacen) ContenedorAlmacenesSingleton.getInstancia().getAlmacenes().get(i);
                   IGeoReferenciador geo = GeoReferenciadorFactory.crear();
                   int[] ref = geo.georeferenciar(elemento.getCod_postal(), elemento.getCalle(), elemento.getProvincia());
                   elemento.setX(ref[0]);          
                   elemento.setY(ref[1]);          
                }
            ContenedorAlmacenesSingleton.getInstancia().grabarElementos();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorServicioGeoreferenciar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void referenciarTiendas(){
        try {
            int tam = ContenedorTiendasSingleton.getInstancia().getTiendas().size();
               
               for (int i = 0; i < tam; i++) {
                   Tienda elemento = (Tienda) ContenedorTiendasSingleton.getInstancia().getTiendas().get(i);
                  IGeoReferenciador geo = GeoReferenciadorFactory.crear();
                  int[] ref = geo.georeferenciar(elemento.getCod_Postal(), elemento.getCalle(), elemento.getProvincia());
                  elemento.setX(ref[0]);
                  elemento.setY(ref[1]);          
               }
            ContenedorTiendasSingleton.getInstancia().grabarElementos();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorServicioGeoreferenciar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void referenciarClientes(){
        try {
            int tam = ContenedorClientesSingleton.getInstancia().getClientes().size();
                for (int i = 0; i < tam; i++) {
                    Cliente elemento = (Cliente) ContenedorClientesSingleton.getInstancia().getClientes().get(i);
                   IGeoReferenciador geo = GeoReferenciadorFactory.crear();
                   int[] ref = geo.georeferenciar(elemento.getCod_Postal(), elemento.getCalle(), elemento.getProvincia());
                   elemento.setX(ref[0]);
                   elemento.setY(ref[0]);          
                }
             ContenedorClientesSingleton.getInstancia().grabarElementos();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorServicioGeoreferenciar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


