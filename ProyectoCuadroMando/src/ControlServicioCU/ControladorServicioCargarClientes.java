package ControlServicioCU;

import ContenedoresCU.ContenedorClientes;
import ControlAuxiliarCU.AceptadorClientes;
import ControlAuxiliarCU.ProveedorInformacionClientes;
import ControlAuxiliarCU.RegistroClientes;
import ControlAuxiliarCU.ArchivoResultadoCarga;
import ControlAuxiliarCU.ArchivoLog;
import ControlAuxiliarCU.TratamientoDatosCarga;
import EntidadesCU.Cliente;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;


/*
 *
 * @author Javier Roncero
 *
 */

public class ControladorServicioCargarClientes {
    private String ruta;
    public static ContenedorClientes contenedor_cliente = new ContenedorClientes();
    private RegistroClientes registros;
    
    public ControladorServicioCargarClientes(File fichero){
        ruta = fichero.getAbsolutePath();
    }
    public void DesarrollarServicio() throws IOException{
        try {
            //
            ProveedorInformacionClientes lec = new ProveedorInformacionClientes(":");
            AceptadorClientes aceptar = new AceptadorClientes();
            
            ArchivoResultadoCarga ficheroCarga = new ArchivoResultadoCarga();
            int totalLecturas;
            int errores = 0;
            
            LinkedList<RegistroClientes> clientes = new LinkedList<>(lec.extraer(ruta));
            
            int tam = clientes.size();
            totalLecturas = tam;
           
            for (int i = 0; i < tam; i++) {
                registros = (RegistroClientes) clientes.get(i);
                Cliente cli = new Cliente(registros.getId_cliente(),
                                          registros.getDni(),
                                          registros.getNombre(),
                                          registros.getApellidos(),
                                          registros.getCalle(), 
                                          registros.getNumero(), 
                                          registros.getCod_Postal(), 
                                          registros.getPoblacion(), 
                                          registros.getProvincia(), 
                                          registros.getTelefono());

                if (aceptar.validar(cli)){
                    contenedor_cliente.almacenar(cli);

                }else{
                    errores++;
                    ArchivoLog log = new ArchivoLog(aceptar.getTextoError(),"Clientes");
                    //System.out.println("ERROR: " + validar.getTextoError());
                }
                
            }
            
            TratamientoDatosCarga resultados = new TratamientoDatosCarga(errores, totalLecturas);
            
            ficheroCarga.registrarDatosCarga("CLIENTES="+resultados.getTotalLecturas()+":"+resultados.getErrores()+":"+resultados.getPorcentaje());
            ficheroCarga.cerrarFichero();
           
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}