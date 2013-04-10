package ControlServicioCU;

import ContenedoresCU.ContenedorAlmacenes;
import ControlAuxiliarCU.AceptadorAlmacenes;
import ControlAuxiliarCU.ProveedorInformacionAlmacenes;
import ControlAuxiliarCU.RegistroAlmacenes;
import ControlAuxiliarCU.ArchivoLog;
import ControlAuxiliarCU.ArchivoResultadoCarga;
import ControlAuxiliarCU.TratamientoDatosCarga;
import EntidadesCU.Almacen;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

/*
 *
 * @author Ivan Arenas
 *
 */

public class ControladorServicioCargarAlmacenes {
    private String ruta;
    private ContenedorAlmacenes contenedor_almacen = new ContenedorAlmacenes();
    private RegistroAlmacenes registros;
    
    public ControladorServicioCargarAlmacenes(File fichero){
        ruta = fichero.getAbsolutePath();
    }
    
    public void DesarrollarServicio() throws IOException{
        try {
            //
            ProveedorInformacionAlmacenes lec= new ProveedorInformacionAlmacenes("::");
            AceptadorAlmacenes aceptar = new AceptadorAlmacenes();
            
            ArchivoResultadoCarga ficheroCarga = new ArchivoResultadoCarga();
            int totalLecturas;
            int errores=0;
            
            LinkedList<RegistroAlmacenes> almacenes = new LinkedList<>(lec.extraer(ruta));
            
            
            int tam = almacenes.size();
            totalLecturas = tam;

            for (int i = 0; i < tam; i++) {
                registros = (RegistroAlmacenes) almacenes.get(i);
                Almacen alm = new Almacen(registros.getId_almacen(),
                                          registros.getCalle(),
                                          registros.getNumero(),
                                          registros.getCod_postal(),
                                          registros.getTelefono(), 
                                          registros.getMunicipio(), 
                                          registros.getProvincia());

                if (aceptar.validar(alm)){
                    contenedor_almacen.almacenar(alm);

                }else{
                    errores++;
                    ArchivoLog log = new ArchivoLog(aceptar.getTextoError(),"Almacenes");
                    //System.out.println("ERROR: " + validar.getTextoError());
                }
                
            }
            
            TratamientoDatosCarga resultados = new TratamientoDatosCarga(errores, totalLecturas);
            
            ficheroCarga.registrarDatosCarga("ALMACEN="+resultados.getTotalLecturas()+":"+resultados.getErrores()+":"+resultados.getPorcentaje());
            ficheroCarga.cerrarFichero();
            
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
