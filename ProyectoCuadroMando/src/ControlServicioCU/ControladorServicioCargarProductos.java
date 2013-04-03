package ControlServicioCU;

import ContenedoresCU.ContenedorProducto;
import ControlAuxiliarCU.Productos.ProveedorInformacionProductos;
import ControlAuxiliarCU.Productos.RegistroProductos;
import ControlAuxiliarCU.RegistroDatosCarga;
import EntidadesCU.Producto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/*
 *
 * @author Javier Roncero
 *
 */

public class ControladorServicioCargarProductos {
    private String ruta;
    public static ContenedorProducto contenedor_producto = new ContenedorProducto();
    
    public ControladorServicioCargarProductos(File fichero){
        ruta = fichero.getAbsolutePath();
    }
    public void DesarrollarServicio() throws IOException{
        try {
            //
            ProveedorInformacionProductos lec = new ProveedorInformacionProductos(ruta, "--");
            
            RegistroDatosCarga ficheroCarga = new RegistroDatosCarga();
            int totalLecturas;
            int errores = 0;
            
            LinkedList<RegistroProductos> productos = new LinkedList<RegistroProductos>(lec.extraer());
            totalLecturas = lec.getTotalLecturas();
            
            int tam = productos.size();
            int cont = 0;
            for (int i = 0; i < tam; i++) {
                RegistroProductos registros = (RegistroProductos) productos.get(i);
                Producto pro = new Producto(registros.getId_producto(),
                                            registros.getCategoria(),
                                            registros.getPrecio(),
                                            registros.getFicha_tecnica());

                // Los productos no necesitan validación
                contenedor_producto.anadirProducto(pro);

                
                cont++;
            }
            
            // convertimos errores y totalLecturas a double para obener
            // decimales en la división, al obtener porcentaje
            double erroresDouble = errores;
            double totalLecturasDouble = totalLecturas;
            double porcentaje = (erroresDouble / totalLecturasDouble);
            
            // redondeamos a 3 decimales el valor de porcentaje (según ejemplo del proyecto)
            porcentaje = Math.rint(porcentaje*1000)/1000;
            
            ficheroCarga.escribirFichero("PRODUCTOS="+totalLecturas+":"+errores+":"+porcentaje);
            ficheroCarga.cerrarFichero();
            JOptionPane.showMessageDialog(null,"PRODUCTOS="+totalLecturas+":"+errores+":"+porcentaje,"RESULTADO DE LA CARGA       ", JOptionPane.INFORMATION_MESSAGE); 
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}