package ControlAuxiliarCU;

import EntidadesCU.Cliente_ADO;

/*
 *
 * @author Javier Roncero
 *
 */

public class AceptadorClientes {
    
    private String textoError = "";
    private Boolean resAceptar = true;
    //private ControlServicioCU.ControladorServicioCargarClientes controlador;
    
    public AceptadorClientes(){
      
    }
    public boolean validar(Cliente_ADO cli){
        textoError = "";
        resAceptar = true;
        return (aceptarCalle(cli) && aceptarNumeroCalle(cli) && aceptarCodPostal(cli) && aceptarPoblacion(cli) && aceptarProvincia(cli));
    }
    
    private boolean aceptarCalle (Cliente_ADO cli){
         if (resAceptar) {
            if ("".equals(cli.getCalle())) {
                textoError = "Cliente "+ cli.getId_cliente() +" con incoherencia de datos, el campo CALLE está vacío";
                resAceptar = false;
            }
        }
        return resAceptar;
    }

    private boolean aceptarNumeroCalle (Cliente_ADO cli){
         if (resAceptar) {
            if ("".equals(cli.getNumero())) {
                textoError = "Cliente "+ cli.getId_cliente() +" con incoherencia de datos, el campo NÚMERO DE CALLE está vacío";
                resAceptar = false;
            }
            if(!cli.getNumero().matches("[0-9]*")){
                textoError = "Cliente "+ cli.getId_cliente() +" con incoherencia de datos, el campo NÚMERO CALLE no es un numero";
                   resAceptar = false;
            }
        }
        return resAceptar;
    }    

    private boolean aceptarCodPostal (Cliente_ADO cli){
         if (resAceptar) {
            if ("".equals(cli.getCod_Postal())) {
                textoError = "Cliente "+ cli.getId_cliente() +" con incoherencia de datos, el campo CODIGO POSTAL está vacío";
                resAceptar = false;
            }
        }
        return resAceptar;
    }       

    private boolean aceptarPoblacion (Cliente_ADO cli){
         if (resAceptar) {
            if ("".equals(cli.getPoblacion())) {
                textoError = "Cliente "+ cli.getId_cliente() +" con incoherencia de datos, el campo POBLACIÓN está vacío";
                resAceptar = false;
            }
        }
        return resAceptar;
    }  
    
    private boolean aceptarProvincia (Cliente_ADO cli){
         if (resAceptar) {
            if ("".equals(cli.getProvincia())) {
                textoError = "Cliente "+ cli.getId_cliente() +" con incoherencia de datos, el campo PROVINCIA está vacío";
                resAceptar = false;
            }
        }
        return resAceptar;
    }      
    

    public String getTextoError(){
        return textoError;
    }

    
    /*private boolean aceptarCodPostal(Cliente cli){
     * // Comprobamos que cod_postal es un número
     * try
     * {
     * int cod_postal = Integer.parseInt(cli.getCod_Postal());
     * // Si es un numero vemos que este comprendido entre 01000 y 52999.
     * if ((cod_postal >= 01000) && (cod_postal <= 52999)){
     * resAceptar = true;
     * }
     * else
     * {
     * textoError = "El cliente "+ cli.getId_cliente()+" tiene un código postal erróneo ["+cli.getCod_Postal()+"]";
     * resAceptar = false;
     * }
     * }
     * catch(NumberFormatException nfe)
     * {
     * textoError = "El cliente "+ cli.getId_cliente()+" tiene un código postal no numérico ["+cli.getCod_Postal()+"]";
     * resAceptar = false;
     * }
     * 
     * return resAceptar;
     * }*/    
    
}