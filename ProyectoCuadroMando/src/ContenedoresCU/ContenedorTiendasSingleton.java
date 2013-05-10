package ContenedoresCU;

import EntidadesCU.Tienda_ADO;
import java.sql.SQLException;
import java.util.LinkedList;

/*
 *
 * @author Javier Roncero
 *
 */
public class ContenedorTiendasSingleton {

    private LinkedList<Tienda_ADO> coleccionElementos;
    private static ContenedorTiendasSingleton _instancia;

    private ContenedorTiendasSingleton() {
        coleccionElementos = new LinkedList<>();
    }

    public static ContenedorTiendasSingleton getInstancia() {
        if (_instancia == null) {
            //Si la instancia no se ha creado crearla 
            _instancia = new ContenedorTiendasSingleton();
        }
        return _instancia;
    }

    public void almacenar(Tienda_ADO tie) {
        coleccionElementos.add(tie);
    }

    public Tienda_ADO getTienda(String id) {
        Tienda_ADO tie_resultado = null;
        int tam = coleccionElementos.size();
        //int cont = 0;
        for (int i = 0; i < tam; i++) {
            Tienda_ADO tie = (Tienda_ADO) coleccionElementos.get(i);
            if (tie.getId_tienda().equals(id)) {
                tie_resultado = tie;
                break;
            }
            //cont++;
        }
        return tie_resultado;
    }

    public void borrarElementos() throws SQLException {
        if (null != coleccionElementos) {
            int tam = coleccionElementos.size();

            for (int i = 0; i < tam; i++) {
                Tienda_ADO elemento = (Tienda_ADO) coleccionElementos.get(i);
                elemento.borrar();
            }
            coleccionElementos.clear();
        }
    }

    public void grabarElementos() throws SQLException {
        int tam = coleccionElementos.size();

        for (int i = 0; i < tam; i++) {
            Tienda_ADO elemento = (Tienda_ADO) coleccionElementos.get(i);
            elemento.grabar();
        }
    }
    public LinkedList getTiendas(){
        return coleccionElementos;
         
     }
}
