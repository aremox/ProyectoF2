package PruebaMenuInicio;


import Controladores.LectorArchivo;
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
            LectorArchivo lec= new LectorArchivo("l://prueba.txt");
            System.out.println(lec.leerLinea());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

}
}
