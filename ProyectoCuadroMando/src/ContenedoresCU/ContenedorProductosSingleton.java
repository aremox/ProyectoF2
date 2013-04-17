package ContenedoresCU;

import EntidadesCU.Producto;
import java.util.LinkedList;

/*
 *
 * @author Javier Roncero
 *
 */

public class ContenedorProductosSingleton {

    private LinkedList<Producto> coleccionElementos;
    private static ContenedorProductosSingleton _instancia;

    private ContenedorProductosSingleton() {
        coleccionElementos = new LinkedList<Producto>();
    }
    
    public static ContenedorProductosSingleton getInstancia(){ 
        if (_instancia == null) { 
            //Si la instancia no se ha creado crearla 
            _instancia = new ContenedorProductosSingleton(); 
        } 
        return _instancia; 
    }

    public void almacenar(Producto pro) {
        coleccionElementos.add(pro);
    }

    public Producto getProducto(String id) {
        Producto pro_resultado = null;
        int tam = coleccionElementos.size();
        //int cont = 0;
        for (int i = 0; i < tam; i++) {
            Producto pro = (Producto) coleccionElementos.get(i);
            if (pro.getId_producto().equals(id)) {
                pro_resultado = pro;
                break;
            }
            //cont++;
        }
        return pro_resultado;
    }


    public void borrarElementos(){
        if (null != coleccionElementos) {
            coleccionElementos.clear();
        }
    }
    public void grabarElementos() {
        int tam = coleccionElementos.size();
        
        for (int i = 0; i < tam; i++) {
            Producto elemento = (Producto) coleccionElementos.get(i);
            elemento.grabar();
        }
   }

}
