/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerMVC;

import ContenedoresCU.ContenedorProductosSingleton;
import ContenedoresCU.ContenedorVentasSingleton;
import EntidadesCU.Venta_ADO;
import InterfazGraficaUsuarioCU.VentanaPrincipalCuadroMando;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import modeloMVC.MapaVectorialProductos;
import vistamvc.PanelGraficoMapa;

public class ControllerMVCVistaMapaProductos implements ActionListener {
    //asociacion con la vista

    VentanaPrincipalCuadroMando vistaMapa;
    //asociacion con el modelo
    MapaVectorialProductos mapa;
    ContenedorProductosSingleton contenedorPro;

    public ControllerMVCVistaMapaProductos(VentanaPrincipalCuadroMando ventana) {
        //incializacion
        this.vistaMapa = ventana;
        mapa = new MapaVectorialProductos();
        contenedorPro = ContenedorProductosSingleton.getInstancia();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //1.-Actualiza el modelo en función del evento de entrada
        if (e.getSource() instanceof JMenuItem) {
            JMenuItem controlInterfaz = (JMenuItem) e.getSource();//conversión del evento producido

            
            if (controlInterfaz.getText().equals("Generar Mapa de zona de producto")) {

                // pintar el mapa

                mapa.generarGrafico(); //Generar el mapa
                //vistaMapa.selector();
                //3.-seleccionar la vista y configurar para mostrar nuevo estado del modelo 
                PanelGraficoMapa panel_graficoMapaProductos = new PanelGraficoMapa(mapa);
                this.vistaMapa.selector(panel_graficoMapaProductos);
            }
        }
        if (e.getSource() instanceof JButton) {
             JButton controlInterfaz = (JButton) e.getSource();
                      
            if (controlInterfaz.getText().equals("Buscar")) {

               int tam = ContenedorVentasSingleton.getInstancia().getVentas().size();
                for (int i = 0; i < tam; i++) {
                   Venta_ADO elemento = (Venta_ADO) ContenedorVentasSingleton.getInstancia().getVentas().get(i);
                   if(elemento.getProducto().getId_Categoria().equals(this.vistaMapa.texto())){
                       mapa.representar(elemento.getTienda()); 
                       
                   }
                } 
               
                // pintar el mapa


                mapa.generarGrafico(); //Generar el mapa
                //vistaMapa.selector();
                //3.-seleccionar la vista y configurar para mostrar nuevo estado del modelo 
                PanelGraficoMapa panel_graficoMapaProductos = new PanelGraficoMapa(mapa);
                this.vistaMapa.selector(panel_graficoMapaProductos);
            }
        }
    }
}
