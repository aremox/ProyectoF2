/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerMVC;

import ContenedoresCU.ContenedorAlmacenesSingleton;
import ContenedoresCU.ContenedorClientesSingleton;
import ContenedoresCU.ContenedorTiendasSingleton;
import ContenedoresCU.ContenedorVentasSingleton;
import EntidadesCU.Cliente_ADO;
import EntidadesCU.Tienda_ADO;
import EntidadesCU.Venta_ADO;
import InterfazGraficaUsuarioCU.VentanaPrincipalCuadroMando;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import modeloMVC.MapaVectorialSuministros;
import vistamvc.PanelGraficoMapa;



public class ControllerMVCVistaMapaSuministros implements ActionListener {
    //asociacion con la vista
    VentanaPrincipalCuadroMando vistaMapa;
    //asociacion con el modelo
    MapaVectorialSuministros mapa;
    ContenedorTiendasSingleton contenedorTien;
    

    public ControllerMVCVistaMapaSuministros(VentanaPrincipalCuadroMando ventana) {
        //incializacion
        this.vistaMapa = ventana;
        mapa = new MapaVectorialSuministros();
        contenedorTien=ContenedorTiendasSingleton.getInstancia();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //1.-Actualiza el modelo en función del evento de entrada
       
        JMenuItem controlInterfaz = (JMenuItem) e.getSource(); //conversión del evento producido
        if (controlInterfaz.getText().equals("Generar Mapa de Suministro")) {
            
            
            //2.-Procesar y confifurar el mapa con la colección de figuras geometricas
           int tam = ContenedorTiendasSingleton.getInstancia().getTiendas().size();
                for (int i = 0; i < tam; i++) {
                   Tienda_ADO elemento = (Tienda_ADO) ContenedorTiendasSingleton.getInstancia().getTiendas().get(i);
                       mapa.representar(elemento); 
                       mapa.representar(elemento.getAlmacen());
                       mapa.asociar(elemento, elemento.getAlmacen());
                } 
        // 
       // pintar el mapa
       
           
            mapa.generarGrafico(); //Generar el mapa
            
            //3.-seleccionar la vista y configurar para mostrar nuevo estado del modelo 
            PanelGraficoMapa panel_graficoMapaVentas = new PanelGraficoMapa(mapa);            
            this.vistaMapa.setPanel(panel_graficoMapaVentas);
          }
    }
}
