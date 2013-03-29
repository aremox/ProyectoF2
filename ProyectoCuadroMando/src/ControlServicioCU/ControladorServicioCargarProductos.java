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
    
    public ControladorServicioCargarProductos(File fichero){
        ruta = fichero.getAbsolutePath();
    }
    public void DesarrollarServicio() throws IOException{
        try {
            //
            ProveedorInformacionProductos lec = new ProveedorInformacionProductos(ruta, "--", 4);
            ContenedorProducto contenedor_producto = new ContenedorProducto();
            RegistroDatosCarga ficheroCarga = new RegistroDatosCarga();
            int aciertos = 0;
            int errores = 0;
            
            LinkedList<RegistroProductos> productos = new LinkedList<RegistroProductos>(lec.extraer());
            errores = lec.getErrores();
            
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
                aciertos++;
                
                cont++;
            }
            
            int total = aciertos + errores;
            ficheroCarga.escribirFichero("PRODUCTOS="+total+":ERROR="+errores);
            ficheroCarga.cerrarFichero();
            JOptionPane.showMessageDialog(null,"PRODUCTOS="+total+":ERRORES="+errores,"RESULTADO DE LA CARGA       ", JOptionPane.INFORMATION_MESSAGE); 
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}