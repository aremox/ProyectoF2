/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ContenedoresCU;

import EntidadesCU.Almacen;
import java.util.LinkedList;

/**
 *
 * @author ivan
 */
public class ContenedorAlmacen {

    private LinkedList lista;

    public ContenedorAlmacen() {
        lista = new LinkedList();
    }

    public void anadirAlmacen(Almacen alm) {
        lista.add(alm);
    }

    public Almacen getAlmacen(String id) {
        Almacen alm_resultado = null;
        int tam = lista.size();
        int cont = 0;
        for (int i = 0; i < tam; i++) {
            Almacen alm = (Almacen) lista.get(i);
            if (alm.getId_almacen().equals(id)) {
                alm_resultado = alm;
            }
            cont++;
        }
        return alm_resultado;
    }
}
