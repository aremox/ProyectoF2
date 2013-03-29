package ProyectoCuadroMando;

import InterfazGraficaUsuarioCU.VentanaPrincipalCuadroMando;
import javax.swing.UIManager;

/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */
public class ProyectoCuadroMando {

    public static void main(String[] args) {

        try {
            //Muestra el aspecto de las ventanas propio de los sistemas Windows
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            
            //Muestra el aspecto de las ventanas propio del Sistema Operativo donde se ejecute
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
            
        } catch (Exception e) {
        }
        new VentanaPrincipalCuadroMando();
    }
}
