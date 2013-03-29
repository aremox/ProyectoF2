package ControlServicioCU;

import ContenedoresCU.ContenedorTienda;
import ControlAuxiliarCU.Tiendas.AceptadorTiendas;
import ControlAuxiliarCU.Tiendas.ProveedorInformacionTiendas;
import ControlAuxiliarCU.Tiendas.RegistroTiendas;
import ControlAuxiliarCU.RegistroDatosCarga;
import ControlAuxiliarCU.RegistroLog;
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
    
    public ControladorServicioCargarTiendas(File fichero){
        ruta = fichero.getAbsolutePath();
    }
    public void DesarrollarServicio() throws IOException{
        try {
            //
            ProveedorInformacionTiendas lec = new ProveedorInformacionTiendas(ruta, "::", 7);
            AceptadorTiendas aceptar = new AceptadorTiendas();
            ContenedorTienda contenedor_tienda = new ContenedorTienda();
            RegistroDatosCarga ficheroCarga = new RegistroDatosCarga();
            int aciertos = 0;
            int errores = 0;
            
            LinkedList<RegistroTiendas> tiendas = new LinkedList<RegistroTiendas>(lec.extraer());
            errores = lec.getErrores();
            
            int tam = tiendas.size();
            int cont = 0;
            for (int i = 0; i < tam; i++) {
                RegistroTiendas registros = (RegistroTiendas) tiendas.get(i);
                Tienda tie = new Tienda(registros.getId_tienda(),
                                          registros.getCalle(), 
                                          registros.getNumero(), 
                                          registros.getCod_Postal(), 
                                          registros.getPoblacion(), 
                                          registros.getProvincia(), 
                                          registros.getTelefono(),                        
                                          registros.getId_almacen());

                if (aceptar.aceptar(tie)){
                    contenedor_tienda.anadirTienda(tie);
                    aciertos++;
                }else{
                    errores++;
                    RegistroLog log = new RegistroLog("Tienda con código postal erróneo","Tiendas");
                }
                cont++;
            }
            
            int total = aciertos + errores;
            ficheroCarga.escribirFichero("TIENDAS="+total+":ERROR="+errores);
            ficheroCarga.cerrarFichero();
            JOptionPane.showMessageDialog(null,"TIENDAS="+total+":ERRORES="+errores,"RESULTADO DE LA CARGA       ", JOptionPane.INFORMATION_MESSAGE); 
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}