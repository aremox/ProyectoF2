/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeloMVC;
import ContenedoresCU.ContenedorClientesSingleton;
import EntidadesCU.Cliente_ADO;

public class ControladorServicioCUGenerarMapaClientes {
   
    public boolean desarrollarServicio( MapaVectorialClientes mapa){
       //Acceder a cvontendores
        ContenedorClientesSingleton contenedor= ContenedorClientesSingleton.getInstancia();
        // 
       // pintar el mapa
       int tam = ContenedorClientesSingleton.getInstancia().getClientes().size();
                for (int i = 0; i < tam; i++) {
                   Cliente_ADO elemento = (Cliente_ADO) ContenedorClientesSingleton.getInstancia().getClientes().get(i);
                       mapa.representar(elemento);     
                }
             
       
    return true;
    }
}
