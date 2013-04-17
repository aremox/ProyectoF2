package ContenedoresCU;

import EntidadesCU.Cliente;
import java.util.LinkedList;

/*
 *
 * @author Javier Roncero
 *
 */

public class ContenedorClientesSingleton {

    private LinkedList<Cliente> coleccionElementos;
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

    public void almacenar(Cliente cli) {
        coleccionElementos.add(cli);
    }

    public Cliente getCliente(String id) {
        Cliente cli_resultado = null;
        int tam = coleccionElementos.size();
        //int cont = 0;
        for (int i = 0; i < tam; i++) {
            Cliente cli = (Cliente) coleccionElementos.get(i);
            if (cli.getId_cliente().equals(id)) {
                cli_resultado = cli;
                break;
            }
            //cont++;
        }
        return cli_resultado;
    }
    
   
    public void borrarElementos(){
        if (null != coleccionElementos) {
            coleccionElementos.clear();
        }
    }
    public void grabarElementos() {
        int tam = coleccionElementos.size();
        
        for (int i = 0; i < tam; i++) {
            Cliente elemento = (Cliente) coleccionElementos.get(i);
            elemento.grabar();
        }
   }
    
}
