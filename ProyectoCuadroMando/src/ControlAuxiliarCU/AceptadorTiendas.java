package ControlAuxiliarCU;

import EntidadesCU.Tienda;

/*
 *
 * @author Javier Roncero
 *
 */

public class AceptadorTiendas {
    
    private String textoError = "";
    private Boolean resAceptar = true;
    //private ControlServicioCU.ControladorServicioCargarTiendas controlador;
    
    public AceptadorTiendas(){
        //controlador = objeto;
    }
    public boolean aceptar(Tienda tie){
        textoError = "";
        resAceptar = true;
        
        return (aceptarCalle(tie) && aceptarNumeroCalle(tie) && aceptarCodPostal(tie) && aceptarPoblacion(tie) && aceptarProvincia(tie) && comprobarAlmacen(tie));
    }

    private boolean aceptarCalle (Tienda tie){
         if (resAceptar) {
            if ("".equals(tie.getCalle())) {
                textoError = "Tienda "+ tie.getId_tienda()+" con incoherencia de datos, el campo CALLE está vacío";
                resAceptar = false;
            }
        }
        return resAceptar;
    }

    private boolean aceptarNumeroCalle (Tienda tie){
         if (resAceptar) {
            if ("".equals(tie.getNumero())) {
                textoError = "Tienda "+ tie.getId_tienda() +" con incoherencia de datos, el campo NÚMERO DE CALLE está vacío";
                resAceptar = false;
            }
        }
        return resAceptar;
    }    

    private boolean aceptarCodPostal (Tienda tie){
         if (resAceptar) {
            if ("".equals(tie.getCod_Postal())) {
                textoError = "Tienda "+ tie.getId_tienda() +" con incoherencia de datos, el campo CODIGO POSTAL está vacío";
                resAceptar = false;
            }
        }
        return resAceptar;
    }       

    private boolean aceptarPoblacion (Tienda tie){
         if (resAceptar) {
            if ("".equals(tie.getPoblacion())) {
                textoError = "Tienda "+ tie.getId_tienda() +" con incoherencia de datos, el campo POBLACIÓN está vacío";
                resAceptar = false;
            }
        }
        return resAceptar;
    }  
    
    private boolean aceptarProvincia (Tienda tie){
         if (resAceptar) {
            if ("".equals(tie.getProvincia())) {
                textoError = "Tienda "+ tie.getId_tienda() +" con incoherencia de datos, el campo PROVINCIA está vacío";
                resAceptar = false;
            }
        }
        return resAceptar;
    }     
    
    
    private boolean comprobarAlmacen(Tienda tie){
        if (resAceptar){
            if (tie.getAlmacen() == null){
                textoError = "Tienda "+ tie.getId_tienda() +" con incoherencia de datos, no existe el ALMACÉN asociado";
                resAceptar = false;
            }
        }
        return resAceptar;
    }
    
    public String getTextoError(){
        return textoError;
    }

    /*private boolean aceptarCodPostal(Tienda tie){
     * // Comprobamos que cod_postal es un número
     * try
     * {
     * int cod_postal = Integer.parseInt(tie.getCod_Postal());
     * // Si es un numero vemos que este comprendido entre 01000 y 52999.
     * if ((cod_postal >= 01000) && (cod_postal <= 52999)){
     * resAceptar = true;
     * }
     * else
     * {
     * textoError = "La tienda "+ tie.getId_tienda()+" tiene un código postal erróneo ["+tie.getCod_Postal()+"]";
     * resAceptar = false;
     * }
     * }
     * catch(NumberFormatException nfe)
     * {
     * textoError = "La tienda "+ tie.getId_tienda()+" tiene un código postal no numérico ["+tie.getCod_Postal()+"]";
     * resAceptar = false;
     * }
     * 
     * return resAceptar;
     * }*/    
    
}
