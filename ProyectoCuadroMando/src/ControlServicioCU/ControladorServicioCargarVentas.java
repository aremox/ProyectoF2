package ControlServicioCU;

import ContenedoresCU.ContenedorClientesSingleton;
import ContenedoresCU.ContenedorProductosSingleton;
import ContenedoresCU.ContenedorTiendasSingleton;
import ContenedoresCU.ContenedorVentasSingleton;
import ControlAuxiliarCU.AceptadorVentas;
import ControlAuxiliarCU.ArchivoLog;
import ControlAuxiliarCU.ArchivoResultadoCarga;
import ControlAuxiliarCU.ProveedorInformacionVentas;
import ControlAuxiliarCU.RegistroVentas;
import ControlAuxiliarCU.TratamientoDatosCarga;
import EntidadesCU.Venta_ADO;
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
    private ContenedorVentasSingleton contenedor_venta = ContenedorVentasSingleton.getInstancia();
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
                Venta_ADO ven = new Venta_ADO(registros.getId_venta(), 
                                      ContenedorClientesSingleton.getInstancia().getCliente(registros.getId_cliente()),
                                      ContenedorProductosSingleton.getInstancia().getProducto(registros.getId_producto()), 
                                      ContenedorTiendasSingleton.getInstancia().getTienda(registros.getId_tienda()), 
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
