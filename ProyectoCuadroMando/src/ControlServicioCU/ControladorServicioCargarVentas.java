package ControlServicioCU;

import ContenedoresCU.ContenedorClientes;
import ContenedoresCU.ContenedorProductos;
import ContenedoresCU.ContenedorTiendas;
import ContenedoresCU.ContenedorVentas;
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


/*
 *
 * @author Ivan Arenas
 *
 */

public class ControladorServicioCargarVentas {

    private String ruta;
    private ContenedorVentas contenedor_venta = new ContenedorVentas();
    private RegistroVentas registros;
    
    public ControladorServicioCargarVentas(File fichero) {
        ruta = fichero.getAbsolutePath();
    }

    public void DesarrollarServicio() throws IOException {
        try {
            //
            ProveedorInformacionVentas lec = new ProveedorInformacionVentas(":");
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
                                      ContenedorClientes.getCliente(registros.getId_cliente()),
                                      ContenedorProductos.getProducto(registros.getId_producto()), 
                                      ContenedorTiendas.getTienda(registros.getId_tienda()), 
                                      registros.getUnidades(), 
                                      registros.getImporte(), 
                                      registros.geFecha());

                if (aceptar.validar(ven)) {
                    contenedor_venta.almacenar(ven);

                } else {
                    errores++;
                    ArchivoLog log = new ArchivoLog(aceptar.getTextoError(),"Ventas");
                    //System.out.println("ERROR: " + validar.getTextoError());
                }
                
            }
            
            TratamientoDatosCarga resultados = new TratamientoDatosCarga(errores, totalLecturas);
            
            ficheroCarga.registrarDatosCarga("VENTAS="+resultados.getTotalLecturas()+":"+resultados.getErrores()+":"+resultados.getPorcentaje());
            ficheroCarga.cerrarFichero();
           
        } catch (FileNotFoundException ex) {
            //  System.out.rintln("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
}
