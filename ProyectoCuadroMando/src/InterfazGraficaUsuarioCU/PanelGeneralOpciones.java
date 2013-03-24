package InterfazGraficaUsuarioCU;


import InterfazGraficaUsuarioCU.PanelCargarClientes;
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
         
        JPanel tabE = new JPanel();
        tabE.setSize( 100,100 );
         this.addTab( "Carga de almacenes" , tabE );         
         
         
         
    }

}
