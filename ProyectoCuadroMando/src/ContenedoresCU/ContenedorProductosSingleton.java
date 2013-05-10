package ContenedoresCU;

import EntidadesCU.Producto_ADO;
import java.sql.SQLException;
import java.util.LinkedList;

/*
 *
 * @author Javier Roncero
 *
 */

public class ContenedorProductosSingleton {

    private LinkedList<Producto_ADO> coleccionElementos;
    private static ContenedorProductosSingleton _instancia;

    private ContenedorProductosSingleton() {
        coleccionElementos = new LinkedList<Producto_ADO>();
    }
    
    public static ContenedorProductosSingleton getInstancia(){ 
        if (_instancia == null) { 
            //Si la instancia no se ha creado crearla 
            _instancia = new ContenedorProductosSingleton(); 
        } 
        return _instancia; 
    }

    public void almacenar(Producto_ADO pro) {
        coleccionElementos.add(pro);
    }

    public Producto_ADO getProducto(String id) {
        Producto_ADO pro_resultado = null;
        int tam = coleccionElementos.size();
        //int cont = 0;
        for (int i = 0; i < tam; i++) {
            Producto_ADO pro = (Producto_ADO) coleccionElementos.get(i);
            if (pro.getId_producto().equals(id)) {
                pro_resultado = pro;
                break;
            }
            //cont++;
        }
        return pro_resultado;
    }


    public void borrarElementos() throws SQLException{
        if (null != coleccionElementos) {
            int tam = coleccionElementos.size();
        
        for (int i = 0; i < tam; i++) {
            Producto_ADO elemento = (Producto_ADO) coleccionElementos.get(i);
            elemento.borrar();
        }
            coleccionElementos.clear();
        }
    }
    public void grabarElementos() throws SQLException {
        int tam = coleccionElementos.size();
        
        for (int i = 0; i < tam; i++) {
            Producto_ADO elemento = (Producto_ADO) coleccionElementos.get(i);
            elemento.grabar();
        }
   }

}
