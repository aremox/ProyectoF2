package ControlAuxiliarCU;

import java.util.LinkedList;

/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */


public class AuditoriaCarga {
    private RegistroCarga regAlm;
    private RegistroCarga regVent;
    private RegistroCarga regClie;
    private RegistroCarga regTien;
    private RegistroCarga regProd;
    private LinkedList<RegistroCarga> registros = new LinkedList<RegistroCarga>();

   
    public void auditoriaCarga(){
        //LinkedList<RegistroCarga> registros = new LinkedList<RegistroCarga>();
    }
    
    public void asociarRegistroCarga(RegistroCarga reg){
        registros.add(reg);
    }
    
    private RegistroCarga buscarRegistroCarga(String nombre){
        int tam = registros.size();
        int cont;
        
        RegistroCarga regResultado = null;
        for (cont = 0; cont < tam; cont++){
            RegistroCarga registro = (RegistroCarga) registros.get(cont);
            if (registro.getCarga().equals(nombre)){
                regResultado = registro;
                break;
            }
        }
        return regResultado;
    }
        
    public RegistroCarga obtenerAuditoriaCargaAlmacen(){
        regAlm = buscarRegistroCarga("ALMACENES");
        return regAlm;
    }
    
    public RegistroCarga obtenerAuditoriaCargaVentas(){
        regVent = buscarRegistroCarga("VENTAS");
        return regVent;
    }
    
    public RegistroCarga obtenerAuditoriaCargaClientes(){
        regClie = buscarRegistroCarga("CLIENTES");
        return regClie;
    }
    
    public RegistroCarga obtenerAuditoriaCargaTiendas(){
        regTien = buscarRegistroCarga("TIENDAS");
        return regTien;
    }
    
    public RegistroCarga obtenerAuditoriaCargaProductos(){
        regProd = buscarRegistroCarga("PRODUCTOS");
        return regProd;
    }
    
}
