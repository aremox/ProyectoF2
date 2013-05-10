/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeloMVC;
import ContenedoresCU.ContenedorClientesSingleton;

public class ControladorServicioCUGenerarMapaClientes {
   
    public boolean desarrollarServicio( MapaVectorialClientes mapa){
       //Acceder a cvontendores
        ContenedorClientesSingleton contenedor= ContenedorClientesSingleton.getInstancia();
        // 
       // pintar el mapa
        mapa.representar(null);
    return true;
    }
}
