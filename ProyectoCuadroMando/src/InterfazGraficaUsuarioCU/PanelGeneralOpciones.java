package InterfazGraficaUsuarioCU;


import InterfazGraficaUsuarioCU.PanelCargarClientes;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class PanelGeneralOpciones extends JTabbedPane {

    PanelCargarClientes panelClientes;
    PanelCargarAlmacenes panelAlmacenes;

    public PanelGeneralOpciones() {
        panelClientes= new PanelCargarClientes();
        panelAlmacenes= new PanelCargarAlmacenes();
        //Crear un panel por cada pestaña
        //Pestaña carga de clientes


        PanelCargarClientes tabA = new PanelCargarClientes();
        PanelCargarAlmacenes tabE = new PanelCargarAlmacenes();
        
        tabA.setSize( 100,100);
        this.addTab( "Carga de clientes" , tabA );
        //pestaña carga de articulos

        JPanel tabB = new JPanel();
        tabB.setSize( 100,100 );
         this.addTab( "Carga de articulos" , tabB );

        JPanel tabC = new JPanel();
        tabC.setSize( 100,100 );
         this.addTab( "Carga de ventas" , tabC );
         
        JPanel tabD = new JPanel();
        tabD.setSize( 100,100 );
         this.addTab( "Carga de tiendas" , tabD );
         
        tabE.setSize( 100,100 );
         this.addTab( "Carga de almacenes" , tabE );         
         
         
         
    }

}
