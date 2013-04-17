package ContenedoresCU;

import EntidadesCU.Venta;
import java.util.LinkedList;

/*
 *
 * @author Ivan Arenas
 *
 */
public class ContenedorVentasSingleton {

    private LinkedList<Venta> lista;
    private static ContenedorVentasSingleton _instancia;

    private ContenedorVentasSingleton() {
        lista = new LinkedList<Venta>();
    }
    
    public static ContenedorVentasSingleton getInstancia(){ 
        if (_instancia == null) { 
            //Si la instancia no se ha creado crearla 
            _instancia = new ContenedorVentasSingleton(); 
        } 
        return _instancia; 
    }

    public void almacenar(Venta ven) {
        lista.add(ven);
    }

    public Venta getVenta(String id) {
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

    public void borrarElementos() {
        if (null != lista) {
            lista.clear();
        }
    }
}
