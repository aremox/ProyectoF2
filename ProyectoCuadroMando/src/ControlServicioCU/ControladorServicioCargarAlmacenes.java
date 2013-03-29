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
            ProveedorInformacionAlmacenes lec= new ProveedorInformacionAlmacenes(ruta, "::", 7);
            AceptadorAlmacenes aceptar = new AceptadorAlmacenes(this);
            
            RegistroDatosCarga ficheroCarga = new RegistroDatosCarga();
            int aciertos=0;
            int errores=0;
            
            LinkedList<RegistroAlmacenes> almacenes = new LinkedList<RegistroAlmacenes>(lec.extraer());
            
            errores=lec.getErrores();
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
                    aciertos++;
                }else{
                    errores++;
                    RegistroLog log = new RegistroLog(aceptar.getTextoError(),"Almacenes");
                    System.out.println("ERROR: " + aceptar.getTextoError());
                }
                cont++;
            }
            int total = aciertos + errores;
            ficheroCarga.escribirFichero("ALMACEN="+total+":ERROR="+errores);
            ficheroCarga.cerrarFichero();
            JOptionPane.showMessageDialog(null,"ALMACEN="+total+":ERROR="+errores,"RESULTADO DE LA CARGA       ", JOptionPane.INFORMATION_MESSAGE); 
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public RegistroAlmacenes getRegistroAlmacenes(){
        return registros;
    }
    
}
