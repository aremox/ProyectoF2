/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlServicioCU;

import ContenedoresCU.ContenedorVenta;
import ControlAuxiliarCU.RegistroDatosCarga;
import ControlAuxiliarCU.Ventas.AceptadorVentas;
import ControlAuxiliarCU.Ventas.ProveedorInformacionVentas;
import ControlAuxiliarCU.Ventas.RegistroVentas;
import EntidadesCU.Venta;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author ivan
 */
public class ControladorServicioCargaVentas {
    public ControladorServicioCargaVentas(File fichero) throws IOException{
        try {
            //
            ProveedorInformacionVentas lec= new ProveedorInformacionVentas(fichero.getAbsolutePath(), "::", 7);
            AceptadorVentas aceptar = new AceptadorVentas();
            ContenedorVenta contenedor = new ContenedorVenta();
            RegistroDatosCarga ficheroCarga = new RegistroDatosCarga("src//ArchivoDatos//registroCargaVentas.log");
            int aciertos=0;
            int errores=0;
            
            LinkedList<RegistroVentas> ventas = new LinkedList<RegistroVentas>(lec.extraer());
            errores=lec.getErrores();
            int tam = ventas.size();
            int cont = 0;
            for (int i = 0; i < tam; i++) {

            RegistroVentas registros = (RegistroVentas) ventas.get(i);
            Venta ven = new Venta(registros.getId_venta(),registros.getId_clienta(),registros.getId_articulo(),registros.getId_tienda(),registros.getUnidades(), registros.getImporte(), registros.geFecha());
            
            if (aceptar.aceptar(ven)){
                contenedor.anadirVenta(ven);
                Venta ven2 = contenedor.getVenta("AL0000001");
                //System.out.println(alm2.getId_almacen());
                aciertos++;
            }else{
                errores++;
            }
            
                
            

            cont++;
        }
            ficheroCarga.escribirFichero("Venta="+aciertos+" errores="+errores);
            ficheroCarga.cerrarFichero();
            JOptionPane.showMessageDialog(null,"Venta="+aciertos+" errores="+errores); 
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
