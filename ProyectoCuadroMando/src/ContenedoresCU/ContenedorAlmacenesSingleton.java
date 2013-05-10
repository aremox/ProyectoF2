package ContenedoresCU;

import EntidadesCU.Almacen_ADO;
import java.sql.SQLException;
import java.util.LinkedList;

/*
 *
 * @author Ivan Arenas
 *
 */

public class ContenedorAlmacenesSingleton {

    private LinkedList<Almacen_ADO> coleccionElementos;
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

    public void almacenar(Almacen_ADO alm) {
        coleccionElementos.add(alm);
    }

    public Almacen_ADO getAlmacen(String id) {
        Almacen_ADO alm_resultado = null;
        int tam = coleccionElementos.size();
        
        for (int i = 0; i < tam; i++) {
            Almacen_ADO alm = (Almacen_ADO) coleccionElementos.get(i);
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
                Almacen_ADO elemento = (Almacen_ADO) coleccionElementos.get(i);
                elemento.borrar();
            }
            coleccionElementos.clear();
        }
    }
    
     public void grabarElementos() throws SQLException {
  
        int tam = coleccionElementos.size();
        int contador;
        
        for (int i = 0; i < tam; i++) {
            Almacen_ADO alm = (Almacen_ADO) coleccionElementos.get(i);
            alm.grabar();
            contador = i;
            
        }
       
    }
     
     public LinkedList getAlmacenes(){
        return coleccionElementos;
         
     }
}

