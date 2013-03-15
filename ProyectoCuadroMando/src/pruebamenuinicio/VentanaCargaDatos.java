package pruebamenuinicio;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class VentanaCargaDatos extends JFrame implements Action{

PanelOpcionesCarga panelOpciones;
    public VentanaCargaDatos() {
        //Configurar ventana principal
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.getContentPane().setLayout( new BorderLayout() );
        this.setSize( 400, 300 );
        this.setTitle( "Test" );

       //Inicializar controles
        panelOpciones=new PanelOpcionesCarga();
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
