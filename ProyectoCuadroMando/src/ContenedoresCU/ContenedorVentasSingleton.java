package ContenedoresCU;

import EntidadesCU.Venta;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;

/*
 *
 * @author Ivan Arenas
 *
 */
public class ContenedorVentasSingleton {

    private LinkedList<Venta> coleccionElementos;
    private static ContenedorVentasSingleton _instancia;

    private ContenedorVentasSingleton() {
        coleccionElementos = new LinkedList<Venta>();
    }
    
    public static ContenedorVentasSingleton getInstancia(){ 
        if (_instancia == null) { 
            //Si la instancia no se ha creado crearla 
            _instancia = new ContenedorVentasSingleton(); 
        } 
        return _instancia; 
    }

    public void almacenar(Venta ven) {
        coleccionElementos.add(ven);
    }

    public Venta getVenta(String id) {
        Venta ven_resultado = null;
        int tam = coleccionElementos.size();
        int cont = 0;
        for (int i = 0; i < tam; i++) {
            Venta ven = (Venta) coleccionElementos.get(i);
            if (ven.getId_venta().equals(id)) {
                ven_resultado = ven;
                break;
            }
            cont++;
        }
        return ven_resultado;
    }

    public void borrarElementos() throws SQLException {
        if (null != coleccionElementos) {
            int tam = coleccionElementos.size();

            for (int i = 0; i < tam; i++) {
                Venta elemento = (Venta) coleccionElementos.get(i);
                elemento.borrar();
            }
            coleccionElementos.clear();
        }
    }
    public void grabarElementos() throws SQLException, ParseException {
        int tam = coleccionElementos.size();
        
        for (int i = 0; i < tam; i++) {
            Venta elemento = (Venta) coleccionElementos.get(i);
            elemento.grabar();
        }
   }
}
