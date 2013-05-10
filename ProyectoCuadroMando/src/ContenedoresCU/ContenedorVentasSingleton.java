package ContenedoresCU;

import EntidadesCU.Venta_ADO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;

/*
 *
 * @author Ivan Arenas
 *
 */
public class ContenedorVentasSingleton {

    private LinkedList<Venta_ADO> coleccionElementos;
    private static ContenedorVentasSingleton _instancia;

    private ContenedorVentasSingleton() {
        coleccionElementos = new LinkedList<Venta_ADO>();
    }
    
    public static ContenedorVentasSingleton getInstancia(){ 
        if (_instancia == null) { 
            //Si la instancia no se ha creado crearla 
            _instancia = new ContenedorVentasSingleton(); 
        } 
        return _instancia; 
    }

    public void almacenar(Venta_ADO ven) {
        coleccionElementos.add(ven);
    }

    public Venta_ADO getVenta(String id) {
        Venta_ADO ven_resultado = null;
        int tam = coleccionElementos.size();
        int cont = 0;
        for (int i = 0; i < tam; i++) {
            Venta_ADO ven = (Venta_ADO) coleccionElementos.get(i);
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
                Venta_ADO elemento = (Venta_ADO) coleccionElementos.get(i);
                elemento.borrar();
            }
            coleccionElementos.clear();
        }
    }
    public void grabarElementos() throws SQLException, ParseException {
        int tam = coleccionElementos.size();
        
        for (int i = 0; i < tam; i++) {
            Venta_ADO elemento = (Venta_ADO) coleccionElementos.get(i);
            elemento.grabar();
        }
   }
}
