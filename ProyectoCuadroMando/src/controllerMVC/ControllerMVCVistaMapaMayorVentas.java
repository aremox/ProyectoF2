/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerMVC;

import ContenedoresCU.ContenedorVentasSingleton;
import EntidadesCU.Tienda_ADO;
import EntidadesCU.Venta_ADO;
import InterfazGraficaUsuarioCU.VentanaPrincipalCuadroMando;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import modeloMVC.MapaVectorialMayorVentas;
import vistamvc.PanelGraficoMapa;



public class ControllerMVCVistaMapaMayorVentas implements ActionListener {
    //asociacion con la vista
    VentanaPrincipalCuadroMando vistaMapa;
    //asociacion con el modelo
    MapaVectorialMayorVentas mapa;
    ContenedorVentasSingleton contenedorVen;

    public ControllerMVCVistaMapaMayorVentas(VentanaPrincipalCuadroMando ventana) {
        //incializacion
        this.vistaMapa = ventana;
        mapa = new MapaVectorialMayorVentas();
        contenedorVen=ContenedorVentasSingleton.getInstancia();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //1.-Actualiza el modelo en función del evento de entrada
       
        JMenuItem controlInterfaz = (JMenuItem) e.getSource(); //conversión del evento producido
        if (controlInterfaz.getText().equals("Generar Mapa de tienda con mayor numero de ventas")) {
            
            
            //2.-Procesar y confifurar el mapa con la colección de figuras geometricas
           int tam = ContenedorVentasSingleton.getInstancia().getVentas().size();
           Tienda_ADO tienda= ContenedorVentasSingleton.getInstancia().getMayor_Venta();
                for (int i = 0; i < tam; i++) {
                    Venta_ADO elemento = (Venta_ADO) ContenedorVentasSingleton.getInstancia().getVentas().get(i);
                    if (elemento.getTienda().equals(tienda) )
                    {
                       mapa.representar(elemento.getCliente(), elemento.getTienda()); 
                       //mapa.representar(elemento.getCliente());
                       mapa.asociar(elemento.getTienda(), elemento.getCliente());
                    }
                } 
                
        // 
       // pintar el mapa
       
           
            mapa.generarGrafico(); //Generar el mapa
            
            //3.-seleccionar la vista y configurar para mostrar nuevo estado del modelo 
            PanelGraficoMapa panel_graficoMapaMayorVentas = new PanelGraficoMapa(mapa);            
            this.vistaMapa.setPanel(panel_graficoMapaMayorVentas);
          }
    }
}
