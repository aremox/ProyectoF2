package PruebaMenuInicio;


import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class PanelGeneralOpciones extends JTabbedPane {

    PanelCargarClientes panelClientes;

    public PanelGeneralOpciones() {
        panelClientes= new PanelCargarClientes();
        //Crear un panel por cada pestaña
        //Pestaña carga de clientes


        PanelCargarClientes tabA = new PanelCargarClientes();
        tabA.setSize( 100,100);
        this.addTab( "Cargar Clientes" , tabA );
        //pestaña carga de articulos

        JPanel tabB = new JPanel();
        tabA.setSize( 100,100 );
         this.addTab( "Cargar Articulos" , tabB );

    }

}
