package ContenedoresCU;

import EntidadesCU.Almacen;
import java.sql.SQLException;
import java.util.LinkedList;

/*
 *
 * @author Ivan Arenas
 *
 */

public class ContenedorAlmacenesSingleton {

    private LinkedList<Almacen> coleccionElementos;
    //private LinkedList<Cliente> coleccionElementos;
    private static ContenedorAlmacenesSingleton _instancia;

    private  ContenedorAlmacenesSingleton() {
        coleccionElementos = new LinkedList<>();
    }
    
    public static ContenedorAlmacenesSingleton getInstancia(){ 
        if (_instancia == null) { 
            //Si la instancia no se ha creado crearla 
            _instancia = new ContenedorAlmacenesSingleton(); 
        } 
        return _instancia; 
    }

    public void almacenar(Almacen alm) {
        coleccionElementos.add(alm);
    }

    public Almacen getAlmacen(String id) {
        Almacen alm_resultado = null;
        int tam = coleccionElementos.size();
        
        for (int i = 0; i < tam; i++) {
            Almacen alm = (Almacen) coleccionElementos.get(i);
            if (alm.getId_almacen().equals(id)) {
                alm_resultado = alm;
                break;
            }
            
        }
        return alm_resultado;
    }
   
    public void borrarElementos() throws SQLException{
        if (null != coleccionElementos) {
            int tam = coleccionElementos.size();

            for (int i = 0; i < tam; i++) {
                Almacen elemento = (Almacen) coleccionElementos.get(i);
                elemento.borrar();
            }
            coleccionElementos.clear();
        }
    }
    
     public void grabarElementos() throws SQLException {
  
        int tam = coleccionElementos.size();
        
        
        for (int i = 0; i < tam; i++) {
            Almacen alm = (Almacen) coleccionElementos.get(i);
            alm.grabar();
            
        }
       
    }
}

