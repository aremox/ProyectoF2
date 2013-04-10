package ContenedoresCU;

import ControlServicioCU.ControladorServicioCargarTiendas;
import EntidadesCU.Tienda;
import java.util.LinkedList;

/*
 *
 * @author Javier Roncero
 *
 */

public class ContenedorTiendas {

    private LinkedList<Tienda> lista;

    public ContenedorTiendas() {
        lista = new LinkedList<Tienda>();
    }

    public void almacenar(Tienda tie) {
        lista.add(tie);
    }

    public Tienda getTienda(String id) {
        Tienda tie_resultado = null;
        int tam = lista.size();
        //int cont = 0;
        for (int i = 0; i < tam; i++) {
            Tienda tie = (Tienda) lista.get(i);
            if (tie.getId_tienda().equals(id)) {
                tie_resultado = tie;
                break;
            }
            //cont++;
        }
        return tie_resultado;
    }

        
   public void borrarElementos() {
        ControladorServicioCargarTiendas.contenedor_tienda.clear();
    }
   
    public void clear(){
        lista.clear();
    }

}
