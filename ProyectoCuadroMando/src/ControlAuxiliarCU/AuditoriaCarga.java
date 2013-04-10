/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAuxiliarCU;

/**
 *
 * @author ivan
 */
public class AuditoriaCarga {
    private RegistroCarga regAlm;
    private RegistroCarga regVent;
    private RegistroCarga regClie;
    private RegistroCarga regTien;
    private RegistroCarga regProd;
    
    public void auditoriaCarga(){
        
    }
    
    public void asociarRegistroCarga(RegistroCarga reg){
        
    }
    public RegistroCarga obtenerAuditoriaCargaAlmacen(){
        return regAlm;
    }
    
    public RegistroCarga obtenerAuditoriaCargaVentas(){
        return regVent;
    }
    
    public RegistroCarga obtenerAuditoriaCargaClientes(){
        return regClie;
    }
    
    public RegistroCarga obtenerAuditoriaCargaTiendas(){
        return regTien;
    }
    
    public RegistroCarga obtenerAuditoriaCargaProductos(){
        return regProd;
    }
    
}
