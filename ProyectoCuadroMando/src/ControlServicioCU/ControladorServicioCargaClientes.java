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

public class ControladorServicioCargaClientes {
    private String ruta;
    
    public ControladorServicioCargaClientes(File fichero){
        ruta = fichero.getAbsolutePath();
    }
    public void DesarrollarServicio() throws IOException{
        try {
            //
            ProveedorInformacionClientes lec = new ProveedorInformacionClientes(ruta, ":", 10);
            AceptadorClientes aceptar = new AceptadorClientes();
            ContenedorCliente contenedor = new ContenedorCliente();
            RegistroDatosCarga ficheroCarga = new RegistroDatosCarga();
            int aciertos = 0;
            int errores = 0;
            
            LinkedList<RegistroClientes> clientes = new LinkedList<RegistroClientes>(lec.extraer());
            errores = lec.getErrores();
            
            int tam = clientes.size();
            int cont = 0;
            for (int i = 0; i < tam; i++) {
                RegistroClientes registros = (RegistroClientes) clientes.get(i);
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
                    contenedor.anadirCliente(cli);
                    aciertos++;
                }else{
                    errores++;
                    RegistroLog log = new RegistroLog("Cliente con código postal erróneo","Clientes");
                }
                cont++;
            }
            
            int total = aciertos + errores;
            ficheroCarga.escribirFichero("CLIENTES="+total+":ERROR="+errores);
            ficheroCarga.cerrarFichero();
            JOptionPane.showMessageDialog(null,"CLIENTES="+total+":ERRORES="+errores); 
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}