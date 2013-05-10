package ControlAuxiliarCU;

import EntidadesCU.Almacen_ADO;

/*
 *
 * @author Ivan Arenas
 *
 */

public class AceptadorAlmacenes {
    
    private String textoError = "";
    private Boolean resAceptar = true;
    
    public AceptadorAlmacenes(){
    }
    public boolean validar(Almacen_ADO alm){
        textoError = "";
        resAceptar = true;
        
        return (aceptarCalle(alm) && aceptarNumeroCalle(alm) && aceptarCodPostal(alm) && aceptarMunicipio(alm) && aceptarProvincia(alm));
    }

    
    private boolean aceptarCalle (Almacen_ADO alm){
         if (resAceptar) {
            if ("".equals(alm.getCalle())) {
                textoError = "Almacén "+ alm.getId_almacen() +" con incoherencia de datos, el campo CALLE está vacío";
                resAceptar = false;
            }
        }
        return resAceptar;
    }

    private boolean aceptarNumeroCalle (Almacen_ADO alm){
         if (resAceptar) {
            if ("".equals(alm.getNumero())) {
                textoError = "Almacén "+ alm.getId_almacen() +" con incoherencia de datos, el campo NÚMERO DE CALLE está vacío";
                resAceptar = false;
            }
        }
        return resAceptar;
    }    

    private boolean aceptarCodPostal (Almacen_ADO alm){
         if (resAceptar) {
            if ("".equals(alm.getCod_postal())) {
                textoError = "Almacén "+ alm.getId_almacen() +" con incoherencia de datos, el campo CODIGO POSTAL está vacío";
                resAceptar = false;
            }
        }
        return resAceptar;
    }       

    private boolean aceptarMunicipio (Almacen_ADO alm){
         if (resAceptar) {
            if ("".equals(alm.getMunicipio())) {
                textoError = "Almacén "+ alm.getId_almacen() +" con incoherencia de datos, el campo MUNICIPIO está vacío";
                resAceptar = false;
            }
        }
        return resAceptar;
    }  
    
    private boolean aceptarProvincia (Almacen_ADO alm){
         if (resAceptar) {
            if ("".equals(alm.getProvincia())) {
                textoError = "Almacén "+ alm.getId_almacen() +" con incoherencia de datos, el campo PROVINCIA está vacío";
                resAceptar = false;
            }
        }
        return resAceptar;
    }     
    
    
    public String getTextoError(){
        return textoError;
    }
    
    
    /*private boolean aceptarCodPostal(Almacen alm){
     * // Comprobamos que cod_postal es un número
     * try
     * {
     * int cod_postal = Integer.parseInt(alm.getCod_postal());
     * // Si es un numero vemos que este comprendido entre 01000 y 52999.
     * if ((cod_postal >= 01000) && (cod_postal <= 52999)){
     * resAceptar = true;
     * }
     * else
     * {
     * textoError = "El almacén "+ alm.getId_almacen()+" tiene un código postal erróneo ["+alm.getCod_postal()+"]";
     * resAceptar = false;
     * }
     * }
     * catch(NumberFormatException nfe)
     * {
     * textoError = "Almacen con código postal no numérico";textoError = "El almacén "+ alm.getId_almacen()+" tiene un código postal no numérico ["+alm.getCod_postal()+"]";
     * resAceptar = false;
     * }
     * 
     * return resAceptar;
     * }*/

}
