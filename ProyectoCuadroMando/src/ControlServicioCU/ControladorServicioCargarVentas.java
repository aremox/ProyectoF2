package ControlServicioCU;

import ContenedoresCU.ContenedorVenta;
import ControlAuxiliarCU.ArchivoResultadoCarga;
import ControlAuxiliarCU.ArchivoLog;
import ControlAuxiliarCU.TratamientoDatosCarga;
import ControlAuxiliarCU.AceptadorVentas;
import ControlAuxiliarCU.ProveedorInformacionVentas;
import ControlAuxiliarCU.RegistroVentas;
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
            ProveedorInformacionVentas lec = new ProveedorInformacionVentas("::");
            AceptadorVentas aceptar = new AceptadorVentas();


            ArchivoResultadoCarga ficheroCarga = new ArchivoResultadoCarga();
            int totalLecturas;
            int errores = 0;

            LinkedList<RegistroVentas> ventas = new LinkedList<>(lec.extraer(ruta));
           
            int tam = ventas.size();
            totalLecturas = tam;
            for (int i = 0; i < tam; i++) {

                registros = (RegistroVentas) ventas.get(i);
                Venta ven = new Venta(registros.getId_venta(), 
                                      ControladorServicioCargarClientes.contenedor_cliente.getCliente(registros.getId_cliente()), 
                                      ControladorServicioCargarProductos.contenedor_producto.getProducto(registros.getId_producto()), 
                                      ControladorServicioCargarTiendas.contenedor_tienda.getTienda(registros.getId_tienda()), 
                                      registros.getUnidades(), 
                                      registros.getImporte(), 
                                      registros.geFecha());

                if (aceptar.validar(ven)) {
                    contenedor_venta.anadirVenta(ven);

                } else {
                    errores++;
                    ArchivoLog log = new ArchivoLog(aceptar.getTextoError(),"Ventas");
                    //System.out.println("ERROR: " + validar.getTextoError());
                }
                
            }
            
            TratamientoDatosCarga resultados = new TratamientoDatosCarga(errores, totalLecturas);
            
            ficheroCarga.registrarDatosCarga("VENTAS="+resultados.getTotalLecturas()+":"+resultados.getErrores()+":"+resultados.getPorcentaje());
            ficheroCarga.cerrarFichero();
            JOptionPane.showMessageDialog(null,"Archivo de VENTAS cargado correctamente                 \n\nResultado de la carga: RC="+resultados.getTotalLecturas()+" RE="+resultados.getErrores()+" IE="+resultados.getPorcentaje()+"\n\n ","RESULTADO DE LA CARGA       ", JOptionPane.INFORMATION_MESSAGE);             
           
        } catch (FileNotFoundException ex) {
            //  System.out.rintln("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
}
