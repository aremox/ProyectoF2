package ContenedoresCU;

import ControlServicioCU.ControladorServicioCargarProductos;
import EntidadesCU.Producto;
import java.util.LinkedList;

/*
 *
 * @author Javier Roncero
 *
 */

public class ContenedorProductos {

    private static LinkedList<Producto> lista;

    public ContenedorProductos() {
        lista = new LinkedList<Producto>();
    }

    public void almacenar(Producto pro) {
        lista.add(pro);
    }

    public static Producto getProducto(String id) {
        Producto pro_resultado = null;
        int tam = lista.size();
        //int cont = 0;
        for (int i = 0; i < tam; i++) {
            Producto pro = (Producto) lista.get(i);
            if (pro.getId_producto().equals(id)) {
                pro_resultado = pro;
                break;
            }
            //cont++;
        }
        return pro_resultado;
    }


    public static void borrarElementos(){
        lista.clear();
    }

}
