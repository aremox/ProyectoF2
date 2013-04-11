package ControlAuxiliarCU;

/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */

public class RegistroCarga {
    private String carga;
    private double indiceError;
    private int nRegistroErroneos;
    private int nRegistrosLeidos;
    
    public RegistroCarga(String car, double err, int nre, int nrl){
        carga = car;
        indiceError = err;
        nRegistroErroneos = nre;
        nRegistrosLeidos = nrl;
    }
    
    public String getCarga(){
        return carga;
    }
    
    public double getError(){
        return indiceError;
    }
    
    public int getNRegistroErroneos(){
        return nRegistroErroneos;
    }
    
    public int getNRegistrosLeidos(){
        return nRegistrosLeidos;
    }
    
    public String getTextoInformeCarga(){
        //String textoInforme = getCarga() + " : " + getNRegistrosAceptados() + " (error " + getError() + "%)";
        String textoInforme = getCarga() + ":" + getNRegistrosLeidos() + ":" + getNRegistroErroneos() + ":" + getError();
        return textoInforme;
    }
}
