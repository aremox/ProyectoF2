package ContenedoresCU;

import ControlServicioCU.ControladorServicioCargarAlmacenes;
import EntidadesCU.Almacen;
import java.util.LinkedList;

/*
 *
 * @author Ivan Arenas
 *
 */

public class ContenedorAlmacenes {

    private LinkedList<Almacen> lista;

    public  ContenedorAlmacenes() {
        lista = new LinkedList<Almacen>();
    }

    public void almacenar(Almacen alm) {
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
                break;
            }
            cont++;
        }
        return alm_resultado;
    }
    
    public void borrarElementos() {
        ControladorServicioCargarAlmacenes.contenedor_almacen.clear();
    }
   
    public void clear(){
        lista.clear();
    }
}

