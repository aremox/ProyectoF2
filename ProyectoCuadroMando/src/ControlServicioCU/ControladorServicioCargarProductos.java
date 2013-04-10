package ControlServicioCU;

import ContenedoresCU.ContenedorProductos;
import ControlAuxiliarCU.ProveedorInformacionProductos;
import ControlAuxiliarCU.RegistroProductos;
import ControlAuxiliarCU.ArchivoResultadoCarga;
import ControlAuxiliarCU.TratamientoDatosCarga;
import EntidadesCU.Producto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;


/*
 *
 * @author Javier Roncero
 *
 */

public class ControladorServicioCargarProductos {
    private String ruta;
    public static ContenedorProductos contenedor_producto = new ContenedorProductos();
    
    public ControladorServicioCargarProductos(File fichero){
        ruta = fichero.getAbsolutePath();
    }
    public void DesarrollarServicio() throws IOException{
        try {
            //
            ProveedorInformacionProductos lec = new ProveedorInformacionProductos("--");
            
            ArchivoResultadoCarga ficheroCarga = new ArchivoResultadoCarga();
            int totalLecturas;
            int errores = 0;
            
            LinkedList<RegistroProductos> productos = new LinkedList<>(lec.extraer(ruta));
            
            
            int tam = productos.size();
            totalLecturas = tam;
            int cont = 0;
            for (int i = 0; i < tam; i++) {
                RegistroProductos registros = (RegistroProductos) productos.get(i);
                Producto pro = new Producto(registros.getId_producto(),
                                            registros.getCategoria(),
                                            registros.getPrecio(),
                                            registros.getFicha_tecnica());

                // Los productos no necesitan validación
                contenedor_producto.almacenar(pro);

            }
            
            TratamientoDatosCarga resultados = new TratamientoDatosCarga(errores, totalLecturas);
            
            ficheroCarga.registrarDatosCarga("PRODUCTOS="+resultados.getTotalLecturas()+":"+resultados.getErrores()+":"+resultados.getPorcentaje());
            ficheroCarga.cerrarFichero();
           
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}