package ContenedoresCU;

import ControlServicioCU.ControladorServicioCargarVentas;
import EntidadesCU.Venta;
import java.util.LinkedList;

/*
 *
 * @author Ivan Arenas
 *
 */
public class ContenedorVentas {

    private static LinkedList<Venta> lista;

    public ContenedorVentas() {
        lista = new LinkedList<Venta>();
    }

    public void almacenar(Venta ven) {
        lista.add(ven);
    }

    public static Venta getVenta(String id) {
        Venta ven_resultado = null;
        int tam = lista.size();
        int cont = 0;
        for (int i = 0; i < tam; i++) {
            Venta ven = (Venta) lista.get(i);
            if (ven.getId_venta().equals(id)) {
                ven_resultado = ven;
                break;
            }
            cont++;
        }
        return ven_resultado;
    }

    public static void borrarElementos() {
        if (null != lista) {
            lista.clear();
        }
    }
}
