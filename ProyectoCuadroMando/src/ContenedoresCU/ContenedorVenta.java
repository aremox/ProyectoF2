/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ContenedoresCU;

import EntidadesCU.Venta;
import java.util.LinkedList;

/**
 *
 * @author ivan
 */
public class ContenedorVenta {

    private LinkedList lista;

    public ContenedorVenta() {
        lista = new LinkedList();
    }

    public void anadirVenta(Venta ven) {
        lista.add(ven);
    }

    public Venta getVenta(String id) {
        Venta ven_resultado=null;
        int tam = lista.size();
            int cont = 0;
            for (int i = 0; i < tam; i++) {
                Venta ven = (Venta) lista.get(i);
                 if ( ven.getId_venta().equals( id ) ){
                 ven_resultado = ven;
                 }
        cont++;
        }
                return ven_resultado;
    }
}