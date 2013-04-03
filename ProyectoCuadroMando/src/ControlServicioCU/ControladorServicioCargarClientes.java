package ControlServicioCU;

import ContenedoresCU.ContenedorCliente;
import ControlAuxiliarCU.Clientes.AceptadorClientes;
import ControlAuxiliarCU.Clientes.ProveedorInformacionClientes;
import ControlAuxiliarCU.Clientes.RegistroClientes;
import ControlAuxiliarCU.RegistroDatosCarga;
import ControlAuxiliarCU.RegistroLog;
import EntidadesCU.Cliente;
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

public class ControladorServicioCargarClientes {
    private String ruta;
    public static ContenedorCliente contenedor_cliente = new ContenedorCliente();
    private RegistroClientes registros;
    
    public ControladorServicioCargarClientes(File fichero){
        ruta = fichero.getAbsolutePath();
    }
    public void DesarrollarServicio() throws IOException{
        try {
            //
            ProveedorInformacionClientes lec = new ProveedorInformacionClientes(ruta, ":");
            AceptadorClientes aceptar = new AceptadorClientes();
            
            RegistroDatosCarga ficheroCarga = new RegistroDatosCarga();
            int totalLecturas;
            int errores = 0;
            
            LinkedList<RegistroClientes> clientes = new LinkedList<RegistroClientes>(lec.extraer());
            totalLecturas = lec.getTotalLecturas();
            
            int tam = clientes.size();
            int cont = 0;
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

                if (aceptar.aceptar(cli)){
                    contenedor_cliente.anadirCliente(cli);

                }else{
                    errores++;
                    RegistroLog log = new RegistroLog(aceptar.getTextoError(),"Clientes");
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
            
            ficheroCarga.escribirFichero("CLIENTES="+totalLecturas+":"+errores+":"+porcentaje);
            ficheroCarga.cerrarFichero();
            JOptionPane.showMessageDialog(null,"Archivo de CLIENTES cargado correctamente                 \n\nResultado de la carga: RC="+totalLecturas+" RE="+errores+" IE="+porcentaje+"\n\n ","RESULTADO DE LA CARGA       ", JOptionPane.INFORMATION_MESSAGE);    
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public RegistroClientes getRegistroClientes(){
        return registros;
    }    
    
}