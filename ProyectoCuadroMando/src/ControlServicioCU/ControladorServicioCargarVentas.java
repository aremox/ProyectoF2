package ControlServicioCU;

import ContenedoresCU.ContenedorVenta;
import ControlAuxiliarCU.RegistroDatosCarga;
import ControlAuxiliarCU.RegistroLog;
import ControlAuxiliarCU.Ventas.AceptadorVentas;
import ControlAuxiliarCU.Ventas.ProveedorInformacionVentas;
import ControlAuxiliarCU.Ventas.RegistroVentas;
import EntidadesCU.Venta;
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
    public static ContenedorVenta contenedor_venta = new ContenedorVenta();
    private RegistroVentas registros;
    
    public ControladorServicioCargarVentas(File fichero) {
        ruta = fichero.getAbsolutePath();
    }

    public void DesarrollarServicio() throws IOException {
        try {
            //
            ProveedorInformacionVentas lec = new ProveedorInformacionVentas(ruta, "::");
            AceptadorVentas aceptar = new AceptadorVentas();


            RegistroDatosCarga ficheroCarga = new RegistroDatosCarga();
            int totalLecturas;
            int errores = 0;

            LinkedList<RegistroVentas> ventas = new LinkedList<RegistroVentas>(lec.extraer());
            totalLecturas = lec.getTotalLecturas();
            int tam = ventas.size();
            int cont = 0;
            for (int i = 0; i < tam; i++) {

                registros = (RegistroVentas) ventas.get(i);
                Venta ven = new Venta(registros.getId_venta(), 
                                      ControladorServicioCargarClientes.contenedor_cliente.getCliente(registros.getId_cliente()), 
                                      ControladorServicioCargarProductos.contenedor_producto.getProducto(registros.getId_producto()), 
                                      ControladorServicioCargarTiendas.contenedor_tienda.getTienda(registros.getId_tienda()), 
                                      registros.getUnidades(), 
                                      registros.getImporte(), 
                                      registros.geFecha());

                if (aceptar.aceptar(ven)) {
                    contenedor_venta.anadirVenta(ven);

                } else {
                    errores++;
                    RegistroLog log = new RegistroLog(aceptar.getTextoError(),"Ventas");
                    //System.out.println("ERROR: " + aceptar.getTextoError());
                }
                cont++;
            }
            
            float porcentaje = (errores / totalLecturas);
            ficheroCarga.escribirFichero("VENTAS="+totalLecturas+":"+errores+":"+porcentaje);
            ficheroCarga.cerrarFichero();
            JOptionPane.showMessageDialog(null,"VENTAS="+totalLecturas+":"+errores+":"+porcentaje,"RESULTADO DE LA CARGA       ", JOptionPane.INFORMATION_MESSAGE);             
            

        } catch (FileNotFoundException ex) {
            //  System.out.rintln("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public RegistroVentas getRegistroVentas(){
        return registros;
    }  
}
