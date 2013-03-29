package ControlAuxiliarCU.Clientes;

import EntidadesCU.Cliente;

/*
 *
 * @author Javier Roncero
 *
 */

public class AceptadorClientes {
    
    private String textoError = "";
    private Boolean resAceptar = true;
    
    public AceptadorClientes(){
        
    }
    public boolean aceptar(Cliente cli){
        textoError = "";
        resAceptar = true;
        
        return (aceptarCodPostal(cli));
    }
    
    private boolean aceptarCodPostal(Cliente cli){
        // Comprobamos que cod_postal es un número
        try
        {
            int cod_postal = Integer.parseInt(cli.getCod_Postal());
            // Si es un numero vemos que este comprendido entre 01000 y 52999.
            if ((cod_postal >= 01000) && (cod_postal <= 52999)){
                resAceptar = true;
            }
            else
            {
                textoError = "Cliente con código postal erróneo";
                resAceptar = false;
            }
        }
        catch(NumberFormatException nfe)
        {
            textoError = "Cliente con código postal no numérico";
            resAceptar = false;
        }
        
        return resAceptar;
    }

   
    public String getTextoError(){
        return textoError;
    }
    
}