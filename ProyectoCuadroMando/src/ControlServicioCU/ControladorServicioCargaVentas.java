package ControlServicioCU;

import ContenedoresCU.ContenedorArticulo;
import ContenedoresCU.ContenedorCliente;
import ContenedoresCU.ContenedorTienda;
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

/*
 *
 * @author Ivan Arenas
 *
 */

public class ControladorServicioCargaVentas {
    private String ruta;
    
    public ControladorServicioCargaVentas(File fichero){
        ruta = fichero.getAbsolutePath();
    }
    
    public void DesarrollarServicio() throws IOException{
        try {
            //
            ProveedorInformacionVentas lec= new ProveedorInformacionVentas(ruta, "::", 7);
            AceptadorVentas aceptar = new AceptadorVentas();
            ContenedorVenta contenedor_venta = new ContenedorVenta();
            ContenedorCliente contenedor_cliente = new ContenedorCliente();
            ContenedorTienda contenedor_tienda = new ContenedorTienda();
            ContenedorArticulo contenedor_articulo = new ContenedorArticulo();
            
            
            RegistroDatosCarga ficheroCarga = new RegistroDatosCarga("src//ArchivoDatos//registroCargaVentas.log");
            int aciertos=0;
            int errores=0;
            
            LinkedList<RegistroVentas> ventas = new LinkedList<RegistroVentas>(lec.extraer());
            errores=lec.getErrores();
            int tam = ventas.size();
            int cont = 0;
            for (int i = 0; i < tam; i++) {

            RegistroVentas registros = (RegistroVentas) ventas.get(i);
            Venta ven = new Venta(registros.getId_venta(),contenedor_cliente.getCliente(registros.getId_clienta()),contenedor_articulo.getArticulo(registros.getId_articulo()),contenedor_tienda.getTienda(registros.getId_tienda()),registros.getUnidades(), registros.getImporte(), registros.geFecha());
            
            if (aceptar.aceptar(ven)){
                contenedor_venta.anadirVenta(ven);
                //Venta ven2 = contenedor_venta.getVenta("AL0000001");
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
