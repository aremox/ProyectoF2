/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlServicioCU;

import ContenedoresCU.ContenedorAlmacen;
import ControlAuxiliarCU.AceptadorAlmacenes;
import ControlAuxiliarCU.ProveedorInformacionAlmacenes;
import ControlAuxiliarCU.RegistroAlmacen;
import ControlAuxiliarCU.RegistroDatosCarga;
import EntidadesCU.Almacen;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author ivan
 */
public class ControladorServicioCargaAlmacenes {
    public ControladorServicioCargaAlmacenes(File fichero) throws IOException{
        try {
            //
            ProveedorInformacionAlmacenes lec= new ProveedorInformacionAlmacenes(fichero.getAbsolutePath(), "::", 7);
            AceptadorAlmacenes aceptar = new AceptadorAlmacenes();
            ContenedorAlmacen contenedor = new ContenedorAlmacen();
            RegistroDatosCarga ficheroCarga = new RegistroDatosCarga("src//ArchivoDatos//registroCargaAlmacen.log");
            int aciertos=0;
            int errores=0;
            
            LinkedList<RegistroAlmacen> almacenes = new LinkedList<RegistroAlmacen>(lec.extraer());
            int tam = almacenes.size();
            int cont = 0;
            for (int i = 0; i < tam; i++) {

            RegistroAlmacen registros = (RegistroAlmacen) almacenes.get(i);
            Almacen alm = new Almacen(registros.getId_almacen(),registros.getCalle(),registros.getNumero(),registros.getCod_postal(),registros.getTelefono(), registros.getMunicipio(), registros.getProvincia());
            
            if (aceptar.aceptar(alm)){
                contenedor.anadirAlmacen(alm);
                Almacen alm2 = contenedor.getAlmacen("AL0000001");
                //System.out.println(alm2.getId_almacen());
                aciertos++;
            }else{
                errores++;
            }
            
                
            

            cont++;
        }
            ficheroCarga.escribirFichero("Almacen="+aciertos+" errores="+errores);
            ficheroCarga.cerrarFichero();
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
