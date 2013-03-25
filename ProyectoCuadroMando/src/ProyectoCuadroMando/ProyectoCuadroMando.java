package ProyectoCuadroMando;


import InterfazGraficaUsuarioCU.VentanaPrincipalCuadroMando;
import ControlAuxiliarCU.ProveedorInformacion;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gustavo.millan
 */

public class ProyectoCuadroMando {
public static void main(String[] args){

 new VentanaPrincipalCuadroMando();
 //testLector();
}
/*
public static void testLector(){
        try {
            ProveedorInformacion lec= new ProveedorInformacion("src//ArchivoDatos//prueba.txt");
            lec.leerLinea();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error en la lectura");
            Logger.getLogger(ProyectoCuadroMando.class.getName()).log(Level.SEVERE, null, ex);
        }

} */
}
