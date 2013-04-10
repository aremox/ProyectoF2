/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAuxiliarCU;

/**
 *
 * @author ivan
 */
public class RegistroCarga {
    private String carga;
    private int Error;
    private int NRegistrosAceptados;
    private int NRegistrosLeidos;
    
    public RegistroCarga(String car, int err, int nra, int nrl){
        carga = car;
        Error = err;
        NRegistrosAceptados = nra;
        NRegistrosLeidos = nrl;
    }
    
    public String getCarga(){
        return carga;
    }
    
    public int getError(){
        return Error;
    }
    
    public int getNRegistrosAceptados(){
        return NRegistrosAceptados;
    }
    
    public int getNRegistrosLeidos(){
        return NRegistrosLeidos;
    }
}
