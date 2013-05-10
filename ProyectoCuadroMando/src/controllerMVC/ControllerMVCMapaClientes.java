/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerMVC;

import ContenedoresCU.ContenedorClientesSingleton;
import EntidadesCU.Cliente_ADO;
import InterfazGraficaUsuarioCU.VentanaPrincipalCuadroMando;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import modeloMVC.MapaVectorialClientes;
import vistamvc.PanelGraficoMapa;



public class ControllerMVCMapaClientes implements ActionListener {
    //asociacion con la vista
    VentanaPrincipalCuadroMando vistaMapa;
    //asociacion con el modelo
    MapaVectorialClientes mapaclientes;
    ContenedorClientesSingleton contenedorCli;

    public ControllerMVCMapaClientes(VentanaPrincipalCuadroMando ventana) {
        //incializacion
        this.vistaMapa = ventana;
        mapaclientes = new MapaVectorialClientes();
        contenedorCli=ContenedorClientesSingleton.getInstancia();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //1.-Actualiza el modelo en función del evento de entrada
       
        JMenuItem controlInterfaz = (JMenuItem) e.getSource(); //conversión del evento producido
        if (controlInterfaz.getText().equals("Generar Mapa de Clientes")) {
            
            
            //2.-Procesar y confifurar el mapa con la colección de figuras geometricas
           int tam = ContenedorClientesSingleton.getInstancia().getClientes().size();
                for (int i = 0; i < tam; i++) {
                   Cliente_ADO elemento = (Cliente_ADO) ContenedorClientesSingleton.getInstancia().getClientes().get(i);
                       mapaclientes.representar(elemento);     
                } 
        // 
       // pintar el mapa
       
           
            mapaclientes.generarGrafico(); //Generar el mapa
            
            //3.-seleccionar la vista y configurar para mostrar nuevo estado del modelo 
            PanelGraficoMapa panel_graficoMapaClientes = new PanelGraficoMapa(mapaclientes);            
            this.vistaMapa.setPanel(panel_graficoMapaClientes);
          }
    }
}
