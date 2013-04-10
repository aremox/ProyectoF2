package InterfazGraficaUsuarioCU;


import java.io.File;
import javax.swing.JTabbedPane;

/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */

public class PanelGeneralOpciones extends JTabbedPane {
    private File directorioActual = null;

    public PanelGeneralOpciones() {
        //Crear un panel por cada pestaña
        //Pestaña carga de clientes
        PanelCargarClientes tabA = new PanelCargarClientes(this);
        PanelCargarProductos tabB = new PanelCargarProductos(this);
        PanelCargarVentas tabC = new PanelCargarVentas(this);
        PanelCargarTiendas tabD = new PanelCargarTiendas(this);
        PanelCargarAlmacenes tabE = new PanelCargarAlmacenes(this);
        PanelEliminarDatosCarga tabF = new PanelEliminarDatosCarga();
        PanelVerInformeCarga tabG = new PanelVerInformeCarga();
        
        tabA.setSize( 100,100);
        this.addTab( "Carga de clientes" , tabA );
        //pestaña carga de articulos

        tabB.setSize( 100,100 );
         this.addTab( "Carga de articulos" , tabB );

        tabC.setSize( 100,100 );
         this.addTab( "Carga de ventas" , tabC );
         
        tabD.setSize( 100,100 );
         this.addTab( "Carga de tiendas" , tabD );
         
        tabE.setSize( 100,100 );
         this.addTab( "Carga de almacenes" , tabE );         

        tabF.setSize( 100,100 );
         this.addTab( "Eliminar datos de carga" , tabF );         
         
        tabG.setSize( 100,100 );
         this.addTab( "Ver informe de carga" , tabG ); 
         
    }

    public File getCurrentDirectory(){
        return directorioActual;
    }

    public void setCurrentDirectory(File dir){
        directorioActual = dir;
    }
    
}
