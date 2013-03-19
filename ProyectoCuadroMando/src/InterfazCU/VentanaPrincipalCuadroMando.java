package InterfazCU;


import InterfazCU.PanelGeneralOpciones;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class VentanaPrincipalCuadroMando extends JFrame implements Action{

PanelGeneralOpciones panelOpciones;
    public VentanaPrincipalCuadroMando() {
        //Configurar ventana principal
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.getContentPane().setLayout( new BorderLayout() );
        this.setSize( 700, 350 );
        this.setTitle( "Proyecto Cuadro de Mando" );
        this.setResizable(false);
        //Centramos la ventana en la pantalla
        this.setLocationRelativeTo(null); 
       
        
        
       //Inicializar controles
        panelOpciones=new PanelGeneralOpciones();
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
