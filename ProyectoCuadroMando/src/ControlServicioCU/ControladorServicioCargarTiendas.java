package ControlServicioCU;

import ContenedoresCU.ContenedorTienda;
import ControlAuxiliarCU.RegistroDatosCarga;
import ControlAuxiliarCU.RegistroLog;
import ControlAuxiliarCU.Tiendas.AceptadorTiendas;
import ControlAuxiliarCU.Tiendas.ProveedorInformacionTiendas;
import ControlAuxiliarCU.Tiendas.RegistroTiendas;
import EntidadesCU.Tienda;
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

public class ControladorServicioCargarTiendas {
    private String ruta;
    public static ContenedorTienda contenedor_tienda = new ContenedorTienda();
    private RegistroTiendas registros;
    
    public ControladorServicioCargarTiendas(File fichero){
        ruta = fichero.getAbsolutePath();
    }
    public void DesarrollarServicio() throws IOException{
        try {
            //
            ProveedorInformacionTiendas lec = new ProveedorInformacionTiendas(ruta, "::");
            AceptadorTiendas aceptar = new AceptadorTiendas();
            
            RegistroDatosCarga ficheroCarga = new RegistroDatosCarga();
            int totalLecturas;
            int errores = 0;
            
            LinkedList<RegistroTiendas> tiendas = new LinkedList<RegistroTiendas>(lec.extraer());
            totalLecturas = lec.getTotalLecturas();
            
            int tam = tiendas.size();
            int cont = 0;
            for (int i = 0; i < tam; i++) {
                registros = (RegistroTiendas) tiendas.get(i);
                Tienda tie = new Tienda(registros.getId_tienda(),
                                          ControladorServicioCargarAlmacenes.contenedor_almacen.getAlmacen(registros.getId_almacen()),                  
                                          registros.getCalle(), 
                                          registros.getNumero(), 
                                          registros.getCod_Postal(), 
                                          registros.getPoblacion(), 
                                          registros.getProvincia(), 
                                          registros.getTelefono());

                if (aceptar.aceptar(tie)){
                    contenedor_tienda.anadirTienda(tie);
                }else{
                    errores++;
                    RegistroLog log = new RegistroLog(aceptar.getTextoError(),"Tiendas");
                    //System.out.println("ERROR: " + aceptar.getTextoError());
                }
                cont++;
            }
            
            // convertimos errores y totalLecturas a double para obener
            // decimales en la división, al obtener porcentaje
            double erroresDouble = errores;
            double totalLecturasDouble = totalLecturas;
            double porcentaje = (erroresDouble / totalLecturasDouble);
            
            // redondeamos a 3 decimales el valor de porcentaje (según ejemplo del proyecto)
            porcentaje = Math.rint(porcentaje*1000)/1000;
            
            ficheroCarga.escribirFichero("TIENDAS="+totalLecturas+":"+errores+":"+porcentaje);
            ficheroCarga.cerrarFichero();
            JOptionPane.showMessageDialog(null,"Archivo de TIENDAS cargado correctamente                 \n\nResultado de la carga: RC="+totalLecturas+" RE="+errores+" IE="+porcentaje+"\n\n ","RESULTADO DE LA CARGA       ", JOptionPane.INFORMATION_MESSAGE); 
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public RegistroTiendas getRegistroTiendas(){
        return registros;
    }   
}