package ControlServicioCU;

import ContenedoresCU.ContenedorAlmacen;
import ControlAuxiliarCU.Almacenes.AceptadorAlmacenes;
import ControlAuxiliarCU.Almacenes.ProveedorInformacionAlmacenes;
import ControlAuxiliarCU.Almacenes.RegistroAlmacenes;
import ControlAuxiliarCU.RegistroDatosCarga;
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

public class ControladorServicioCargaAlmacenes {
    private String ruta;
    
    public ControladorServicioCargaAlmacenes(File fichero){
        ruta = fichero.getAbsolutePath();
    }
    
    public void DesarrollarServicio() throws IOException{
        try {
            //
            ProveedorInformacionAlmacenes lec= new ProveedorInformacionAlmacenes(ruta, "::", 7);
            AceptadorAlmacenes aceptar = new AceptadorAlmacenes();
            ContenedorAlmacen contenedor = new ContenedorAlmacen();
            RegistroDatosCarga ficheroCarga = new RegistroDatosCarga("src//ArchivoDatos//registroCargaAlmacen.log");
            int aciertos=0;
            int errores=0;
            
            LinkedList<RegistroAlmacenes> almacenes = new LinkedList<RegistroAlmacenes>(lec.extraer());
            errores=lec.getErrores();
            int tam = almacenes.size();
            int cont = 0;
            for (int i = 0; i < tam; i++) {
                RegistroAlmacenes registros = (RegistroAlmacenes) almacenes.get(i);
                Almacen alm = new Almacen(registros.getId_almacen(),registros.getCalle(),registros.getNumero(),registros.getCod_postal(),registros.getTelefono(), registros.getMunicipio(), registros.getProvincia());

                if (aceptar.aceptar(alm)){
                    contenedor.anadirAlmacen(alm);
                    //Almacen alm2 = contenedor.getAlmacen("AL0000001");
                    //System.out.println(alm2.getId_almacen());
                    aciertos++;
                }else{
                    errores++;
                }
                cont++;
            }
            ficheroCarga.escribirFichero("Almacen="+aciertos+" errores="+errores);
            ficheroCarga.cerrarFichero();
            JOptionPane.showMessageDialog(null,"Almacen="+aciertos+" errores="+errores); 
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
