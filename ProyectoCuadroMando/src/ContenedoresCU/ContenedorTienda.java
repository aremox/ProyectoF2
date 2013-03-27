/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ContenedoresCU;

import EntidadesCU.Almacen;
import EntidadesCU.Tienda;
import java.util.LinkedList;

/**
 *
 * @author ivan
 */
public class ContenedorTienda {

    private LinkedList lista;

    public ContenedorTienda() {
        lista = new LinkedList();
    }

    public void anadirAlmacen(Almacen alm) {
        lista.add(alm);
    }

    public Tienda getAlmacen(String id) {
       /*sustituir por lo bueno */
        Tienda tie_resultado = new Tienda("TIE0001");
                return tie_resultado;
    }
}
