package ContenedoresCU;

import EntidadesCU.Cliente;
import java.util.LinkedList;

/*
 *
 * @author Javier Roncero
 *
 */

public class ContenedorCliente {

    private LinkedList lista;

    public ContenedorCliente() {
        lista = new LinkedList();
    }

    public void anadirCliente(Cliente cli) {
        lista.add(cli);
    }

    public Cliente getCliente(String id) {
        Cliente cli_resultado = null;
        int tam = lista.size();
        //int cont = 0;
        for (int i = 0; i < tam; i++) {
            Cliente cli = (Cliente) lista.get(i);
            if (cli.getId_cliente().equals(id)) {
                cli_resultado = cli;
            }
            //cont++;
        }
        return cli_resultado;
    }
}
