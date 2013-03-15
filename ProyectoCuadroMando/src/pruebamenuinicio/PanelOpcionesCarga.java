package pruebamenuinicio;


import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class PanelOpcionesCarga extends JTabbedPane {

    PanelCargaClientes panelClientes;

    public PanelOpcionesCarga() {
        panelClientes= new PanelCargaClientes();
        //Crear un panel por cada pestaña
        //Pestaña carga de clientes


          PanelCargaClientes tabA = new PanelCargaClientes();
        tabA.setSize( 100,100);
        this.addTab( "Cargar Clientes" , tabA );
        //pestaña carga de articulos

        JPanel tabB = new JPanel();
        tabA.setSize( 100,100 );
         this.addTab( "Cargar Articulos" , tabB );

    }

}
