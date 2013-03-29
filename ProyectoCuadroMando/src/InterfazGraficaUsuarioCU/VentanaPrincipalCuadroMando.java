package InterfazGraficaUsuarioCU;

import ContenedoresCU.ContenedorAlmacen;
import ContenedoresCU.ContenedorCliente;
import ContenedoresCU.ContenedorProducto;
import ContenedoresCU.ContenedorTienda;
import ContenedoresCU.ContenedorVenta;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JFrame;

/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */

public class VentanaPrincipalCuadroMando extends JFrame implements Action {

    PanelGeneralOpciones panelOpciones;
    public static ContenedorAlmacen contenedor_almacen;
    public static ContenedorCliente contenedor_cliente;
    public static ContenedorProducto contenedor_producto;
    public static ContenedorTienda contenedor_tienda;
    public static ContenedorVenta contenedor_venta;
    
    

    public VentanaPrincipalCuadroMando() {
        //Creamos los contenedores
        contenedor_almacen = new ContenedorAlmacen();
        contenedor_cliente = new ContenedorCliente();
        contenedor_producto = new ContenedorProducto();
        contenedor_tienda = new ContenedorTienda();
        contenedor_venta = new ContenedorVenta();
        
        
        //Configurar ventana principal
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.setSize(700, 350);
        this.setTitle("Proyecto Cuadro de Mando");
        this.setResizable(false);
        //Centramos la ventana en la pantalla
        this.setLocationRelativeTo(null);



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
}