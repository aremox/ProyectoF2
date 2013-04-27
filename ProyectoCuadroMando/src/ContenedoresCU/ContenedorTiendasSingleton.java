package ContenedoresCU;

import EntidadesCU.Tienda;
import java.sql.SQLException;
import java.util.LinkedList;

/*
 *
 * @author Javier Roncero
 *
 */
public class ContenedorTiendasSingleton {

    private LinkedList<Tienda> coleccionElementos;
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

    public void almacenar(Tienda tie) {
        coleccionElementos.add(tie);
    }

    public Tienda getTienda(String id) {
        Tienda tie_resultado = null;
        int tam = coleccionElementos.size();
        //int cont = 0;
        for (int i = 0; i < tam; i++) {
            Tienda tie = (Tienda) coleccionElementos.get(i);
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
                Tienda elemento = (Tienda) coleccionElementos.get(i);
                elemento.borrar();
            }
            coleccionElementos.clear();
        }
    }

    public void grabarElementos() throws SQLException {
        int tam = coleccionElementos.size();

        for (int i = 0; i < tam; i++) {
            Tienda elemento = (Tienda) coleccionElementos.get(i);
            elemento.grabar();
        }
    }
    public LinkedList getTiendas(){
        return coleccionElementos;
         
     }
}
