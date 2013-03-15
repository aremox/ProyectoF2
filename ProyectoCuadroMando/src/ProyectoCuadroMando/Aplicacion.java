package ProyectoCuadroMando;


import Controladores.ProveedorInformacion;
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

public class Aplicacion {
public static void main(String[] args){

 new VentanaPrincipalCuadroMando();
 testLector();
}

public static void testLector(){
        try {
            ProveedorInformacion lec= new ProveedorInformacion("l://prueba.txt");
            System.out.println(lec.leerLinea());
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error en la lectura");
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

}
}
