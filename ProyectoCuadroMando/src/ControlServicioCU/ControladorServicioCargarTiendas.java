package ControlServicioCU;

import ContenedoresCU.ContenedorAlmacenesSingleton;
import ContenedoresCU.ContenedorTiendasSingleton;
import ControlAuxiliarCU.AceptadorTiendas;
import ControlAuxiliarCU.ArchivoLog;
import ControlAuxiliarCU.ArchivoResultadoCarga;
import ControlAuxiliarCU.ProveedorInformacionTiendas;
import ControlAuxiliarCU.RegistroTiendas;
import ControlAuxiliarCU.TratamientoDatosCarga;
import EntidadesCU.Tienda_ADO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;


/*
 *
 * @author Javier Roncero
 *
 */

public class ControladorServicioCargarTiendas {
    private String ruta;
    private ContenedorTiendasSingleton contenedor_tienda = ContenedorTiendasSingleton.getInstancia();
    private RegistroTiendas registros;
    
    public ControladorServicioCargarTiendas(File fichero){
        ruta = fichero.getAbsolutePath();
    }
    public void DesarrollarServicio() throws IOException{
        try {
            //
            ProveedorInformacionTiendas lec = new ProveedorInformacionTiendas("::");
            AceptadorTiendas aceptar = new AceptadorTiendas();
            
            ArchivoResultadoCarga ficheroCarga = new ArchivoResultadoCarga();
            int totalLecturas;
            int errores = 0;
            
            LinkedList<RegistroTiendas> tiendas = new LinkedList<>(lec.extraer(ruta));
         
            
            int tam = tiendas.size();
            totalLecturas = tam;
            for (int i = 0; i < tam; i++) {
                registros = (RegistroTiendas) tiendas.get(i);
                Tienda_ADO tie = new Tienda_ADO(registros.getId_tienda(),
                                          //ControladorServicioCargarAlmacenes.contenedor_almacen.getAlmacen(registros.getId_almacen()),                  
                                          registros.getCalle(), 
                                          registros.getNumero(), 
                                          registros.getCod_Postal(), 
                                          registros.getTelefono(),
                                          registros.getPoblacion(), 
                                          registros.getProvincia(),
                                          ContenedorAlmacenesSingleton.getInstancia().getAlmacen(registros.getId_almacen()));

                if (aceptar.validar(tie)){
                    contenedor_tienda.almacenar(tie);
                }else{
                    errores++;
                    ArchivoLog log = new ArchivoLog(aceptar.getTextoError(),"Tiendas");
                    //System.out.println("ERROR: " + validar.getTextoError());
                }
                
            }
            
            TratamientoDatosCarga resultados = new TratamientoDatosCarga(errores, totalLecturas);
            
            ficheroCarga.registrarDatosCarga("TIENDAS="+resultados.getTotalLecturas()+":"+resultados.getErrores()+":"+resultados.getPorcentaje());
            ficheroCarga.cerrarFichero();
           
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
}