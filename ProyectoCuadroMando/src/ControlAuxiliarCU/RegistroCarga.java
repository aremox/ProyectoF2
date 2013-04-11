package ControlAuxiliarCU;

/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
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
    
    public String getTextoInformeCarga(){
        String textoInforme = getCarga() + " : " + getNRegistrosAceptados() + " (error " + getError() + "%)";
        return textoInforme;
    }
}
