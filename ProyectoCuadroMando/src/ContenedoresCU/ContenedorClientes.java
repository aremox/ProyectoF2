package ContenedoresCU;

import ControlServicioCU.ControladorServicioCargarClientes;
import EntidadesCU.Cliente;
import java.util.LinkedList;

/*
 *
 * @author Javier Roncero
 *
 */

public class ContenedorClientes {

    private static LinkedList<Cliente> lista;

    public ContenedorClientes() {
        lista = new LinkedList<Cliente>();
    }

    public void almacenar(Cliente cli) {
        lista.add(cli);
    }

    public static Cliente getCliente(String id) {
        Cliente cli_resultado = null;
        int tam = lista.size();
        //int cont = 0;
        for (int i = 0; i < tam; i++) {
            Cliente cli = (Cliente) lista.get(i);
            if (cli.getId_cliente().equals(id)) {
                cli_resultado = cli;
                break;
            }
            //cont++;
        }
        return cli_resultado;
    }
    
   
    public static void borrarElementos(){
        lista.clear();
    }
    
}
