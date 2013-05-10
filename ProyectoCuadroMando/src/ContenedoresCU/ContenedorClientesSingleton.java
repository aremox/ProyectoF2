package ContenedoresCU;

import EntidadesCU.Cliente_ADO;
import java.sql.SQLException;
import java.util.LinkedList;

/*
 *
 * @author Javier Roncero
 *
 */

public class ContenedorClientesSingleton {

    private LinkedList<Cliente_ADO> coleccionElementos;
    private static ContenedorClientesSingleton _instancia;

    private ContenedorClientesSingleton() {
        coleccionElementos = new LinkedList<>();
    }
    
    public static ContenedorClientesSingleton getInstancia(){ 
        if (_instancia == null) { 
            //Si la instancia no se ha creado crearla 
            _instancia = new ContenedorClientesSingleton(); 
        } 
        return _instancia; 
    }

    public void almacenar(Cliente_ADO cli) {
        coleccionElementos.add(cli);
    }

    public Cliente_ADO getCliente(String id) {
        Cliente_ADO cli_resultado = null;
        int tam = coleccionElementos.size();
        //int cont = 0;
        for (int i = 0; i < tam; i++) {
            Cliente_ADO cli = (Cliente_ADO) coleccionElementos.get(i);
            if (cli.getId_cliente().equals(id)) {
                cli_resultado = cli;
                break;
            }
            //cont++;
        }
        return cli_resultado;
    }
    
   
    public void borrarElementos() throws SQLException{
        if (null != coleccionElementos) {
            int tam = coleccionElementos.size();
        for (int i = 0; i < tam; i++) {
            Cliente_ADO elemento = (Cliente_ADO) coleccionElementos.get(i);
            elemento.borrar();
        }
            coleccionElementos.clear();
        }
    }
    public void grabarElementos() throws SQLException {
        int tam = coleccionElementos.size();
        
        for (int i = 0; i < tam; i++) {
            Cliente_ADO elemento = (Cliente_ADO) coleccionElementos.get(i);
            elemento.grabar();
        }
   }
    public LinkedList getClientes(){
        return coleccionElementos;
         
     }
    
}
