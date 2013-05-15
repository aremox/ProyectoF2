package InterfazGraficaUsuarioCU;

import controllerMVC.ControllerMVCVistaMapaClientes;
import controllerMVC.ControllerMVCVistaMapaInfuencia;
import controllerMVC.ControllerMVCVistaMapaMayorVentas;
import controllerMVC.ControllerMVCVistaMapaSuministros;
import controllerMVC.ControllerMVCVistaMapaVentas;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import vistamvc.PanelGraficoMapa;


/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */

public class VentanaPrincipalCuadroMando extends JFrame implements Action {

    PanelGeneralOpciones panelOpciones;
    PanelGraficoMapa vista;// variable de estado de representación del mapa
    
    public VentanaPrincipalCuadroMando() {
        //Configurar ventana principal
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.setSize(900, 600);
        this.setTitle("Proyecto Cuadro de Mando");
        this.setResizable(true);
        //Centramos la ventana en la pantalla
        this.setLocationRelativeTo(null);
        //

        JMenuBar barraMenus = new JMenuBar();// control barra de menú superior
        JMenu menuC = creaControlMenuMapas(); // crear control menú elementos
        barraMenus.add(menuC);// asignar control de menú a barra superior 
        this.setJMenuBar(barraMenus);// asignar barra a control JFrame



        //Inicializar controles
        panelOpciones = new PanelGeneralOpciones();
        this.setContentPane(panelOpciones);
        //Mostrar ventana principal
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    }

    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private JMenu creaControlMenuMapas() {

        JMenuItem itemAA = new JMenuItem("Generar Mapa de Clientes");
        JMenuItem itemAB = new JMenuItem("Generar Mapa de Ventas");
        JMenuItem itemAC = new JMenuItem("Generar Mapa de Suministro");
        JMenuItem itemAD = new JMenuItem("Generar Mapa de tienda con mayor numero de ventas");
        JMenuItem itemAE = new JMenuItem("Generar Mapa de influencia");

        JMenu menu = new JMenu("Opciones de Análisis");
        menu.add(itemAA);
        menu.add(itemAB);
        menu.add(itemAC);
        menu.add(itemAD);
        menu.add(itemAE);

        itemAA.addActionListener(new ControllerMVCVistaMapaClientes(this));
        itemAB.addActionListener(new ControllerMVCVistaMapaVentas(this));
        itemAC.addActionListener(new ControllerMVCVistaMapaSuministros(this));
        itemAD.addActionListener(new ControllerMVCVistaMapaMayorVentas(this));
        itemAE.addActionListener(new ControllerMVCVistaMapaInfuencia(this));

        return menu;
    }

    /**
     *
     * Método que permite configurar la vista y actualizarla
     */
    public void setPanel(PanelGraficoMapa vista) {
        this.vista = vista;
        this.setContentPane(vista);
        this.setVisible(true);
    }
}