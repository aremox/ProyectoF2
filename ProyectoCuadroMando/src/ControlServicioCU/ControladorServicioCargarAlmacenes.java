package ControlServicioCU;

import ContenedoresCU.ContenedorAlmacen;
import ControlAuxiliarCU.Almacenes.AceptadorAlmacenes;
import ControlAuxiliarCU.Almacenes.ProveedorInformacionAlmacenes;
import ControlAuxiliarCU.Almacenes.RegistroAlmacenes;
import ControlAuxiliarCU.RegistroDatosCarga;
import ControlAuxiliarCU.RegistroLog;
import EntidadesCU.Almacen;
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

public class ControladorServicioCargarAlmacenes {
    private String ruta;
    public static ContenedorAlmacen contenedor_almacen = new ContenedorAlmacen();
    private RegistroAlmacenes registros;
    
    public ControladorServicioCargarAlmacenes(File fichero){
        ruta = fichero.getAbsolutePath();
    }
    
    public void DesarrollarServicio() throws IOException{
        try {
            //
            ProveedorInformacionAlmacenes lec= new ProveedorInformacionAlmacenes(ruta, "::");
            AceptadorAlmacenes aceptar = new AceptadorAlmacenes();
            
            RegistroDatosCarga ficheroCarga = new RegistroDatosCarga();
            int totalLecturas;
            int errores=0;
            
            LinkedList<RegistroAlmacenes> almacenes = new LinkedList<RegistroAlmacenes>(lec.extraer());
            
            totalLecturas = lec.getTotalLecturas();
            int tam = almacenes.size();
            int cont = 0;
            for (int i = 0; i < tam; i++) {
                registros = (RegistroAlmacenes) almacenes.get(i);
                Almacen alm = new Almacen(registros.getId_almacen(),
                                          registros.getCalle(),
                                          registros.getNumero(),
                                          registros.getCod_postal(),
                                          registros.getTelefono(), 
                                          registros.getMunicipio(), 
                                          registros.getProvincia());

                if (aceptar.aceptar(alm)){
                    contenedor_almacen.anadirAlmacen(alm);

                }else{
                    errores++;
                    RegistroLog log = new RegistroLog(aceptar.getTextoError(),"Almacenes");
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
            
            ficheroCarga.escribirFichero("ALMACEN="+totalLecturas+":"+errores+":"+porcentaje);
            ficheroCarga.cerrarFichero();
            JOptionPane.showMessageDialog(null,"Archivo de ALMACENES cargado correctamente                 \n\nResultado de la carga: RC="+totalLecturas+" RE="+errores+" IE="+porcentaje+"\n\n ","RESULTADO DE LA CARGA       ", JOptionPane.INFORMATION_MESSAGE);             
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public RegistroAlmacenes getRegistroAlmacenes(){
        return registros;
    }
    
}
