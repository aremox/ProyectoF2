/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlServicioCU;

import ContenedoresCU.ContenedorCliente;
import ControlAuxiliarCU.Clientes.AceptadorClientes;
import ControlAuxiliarCU.Clientes.ProveedorInformacionClientes;
import ControlAuxiliarCU.Clientes.RegistroClientes;
import ControlAuxiliarCU.RegistroDatosCarga;
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
    public ControladorServicioCargaClientes(File fichero) throws IOException{
        try {
            //
            ProveedorInformacionClientes lec = new ProveedorInformacionClientes(fichero.getAbsolutePath(), ":", 10);
            AceptadorClientes aceptar = new AceptadorClientes();
            ContenedorCliente contenedor = new ContenedorCliente();
            RegistroDatosCarga ficheroCarga = new RegistroDatosCarga("src//ArchivoDatos//registroCargaClientes.log");
            int aciertos=0;
            int errores=0;
            
            LinkedList<RegistroClientes> clientes = new LinkedList<RegistroClientes>(lec.extraer());
            errores=lec.getErrores();
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
                    //Almacen alm2 = contenedor.getAlmacen("AL0000001");
                    //System.out.println(alm2.getId_almacen());
                    aciertos++;
                }else{
                    errores++;
                }
                cont++;
            }
            ficheroCarga.escribirFichero("CLIENTES="+aciertos+":ERROR="+errores);
            ficheroCarga.cerrarFichero();
            JOptionPane.showMessageDialog(null,"CLIENTES="+aciertos+":ERRORES="+errores); 
            
        } catch (FileNotFoundException ex) {
          //  System.out.println("Error en la lectura");
            //Logger.getLogger(ControladorServicioCargaAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}