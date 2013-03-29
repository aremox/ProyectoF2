package ControlServicioCU;

import ControlAuxiliarCU.RegistroDatosCarga;
import ControlAuxiliarCU.Ventas.AceptadorVentas;
import ControlAuxiliarCU.Ventas.ProveedorInformacionVentas;
import ControlAuxiliarCU.Ventas.RegistroVentas;
import EntidadesCU.Venta;
import InterfazGraficaUsuarioCU.VentanaPrincipalCuadroMando;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/*
 *
 * @author Ivan Arenas
 *
 */

public class ControladorServicioCargarVentas {

    private String ruta;

    public ControladorServicioCargarVentas(File fichero) {
        ruta = fichero.getAbsolutePath();
    }

    public void DesarrollarServicio() throws IOException {
        try {
            //
            ProveedorInformacionVentas lec = new ProveedorInformacionVentas(ruta, "::", 7);
            AceptadorVentas aceptar = new AceptadorVentas();


            RegistroDatosCarga ficheroCarga = new RegistroDatosCarga();
            int aciertos = 0;
            int errores = 0;

            LinkedList<RegistroVentas> ventas = new LinkedList<RegistroVentas>(lec.extraer());
            errores = lec.getErrores();
            int tam = ventas.size();
            int cont = 0;
            for (int i = 0; i < tam; i++) {

                RegistroVentas registros = (RegistroVentas) ventas.get(i);
                Venta ven = new Venta(registros.getId_venta(), 
                                      VentanaPrincipalCuadroMando.contenedor_cliente.getCliente(registros.getId_cliente()), 
                                      VentanaPrincipalCuadroMando.contenedor_producto.getProducto(registros.getId_producto()), 
                                      VentanaPrincipalCuadroMando.contenedor_tienda.getTienda(registros.getId_tienda()), 
                                      registros.getUnidades(), 
                                      registros.getImporte(), 
                                      registros.geFecha());

                if (aceptar.aceptar(ven)) {
                    VentanaPrincipalCuadroMando.contenedor_venta.anadirVenta(ven);
                    aciertos++;
                } else {
                    errores++;
                }
                cont++;
            }
            int total = aciertos + errores;
            ficheroCarga.escribirFichero("VENTAS="+total+":ERROR="+errores);
            ficheroCarga.cerrarFichero();
            JOptionPane.showMessageDialog(null, "VENTAS="+total+":ERROR="+errores,"RESULTADO DE LA CARGA       ", JOptionPane.INFORMATION_MESSAGE); 

        } catch (FileNotFoundException ex) {
            //  System.out.rintln("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
