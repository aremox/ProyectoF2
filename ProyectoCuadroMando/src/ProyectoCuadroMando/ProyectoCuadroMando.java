package ProyectoCuadroMando;

import InterfazGraficaUsuarioCU.VentanaPrincipalCuadroMando;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */


public class ProyectoCuadroMando {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        try {
            //Muestra el aspecto de las ventanas propio de los sistemas Windows
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            
            //Muestra el aspecto de las ventanas propio del Sistema Operativo donde se ejecute
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        Inicializar inicializar = new Inicializar();
        VentanaPrincipalCuadroMando ventanaPrincipalCuadroMando = new VentanaPrincipalCuadroMando();
    }
}
