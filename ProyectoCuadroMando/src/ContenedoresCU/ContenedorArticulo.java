package ContenedoresCU;

import EntidadesCU.Almacen;
import EntidadesCU.Articulo;
import java.util.LinkedList;

/*
 *
 * @author Ivan Arenas
 *
 */

public class ContenedorArticulo {

    private LinkedList lista;

    public ContenedorArticulo() {
        lista = new LinkedList();
    }

    public void anadirArticulo(Articulo art) {
        lista.add(art);
    }

    public Articulo getArticulo(String id) {
        /*sustituir por lo bueno */
        Articulo art_resultado = new Articulo("ART0001");
                return art_resultado;
    }
}
