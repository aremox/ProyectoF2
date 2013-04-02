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
    //private ControlServicioCU.ControladorServicioCargarClientes controlador;
    
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
                textoError = "El cliente "+ cli.getId_cliente()+" tiene un código postal erróneo ["+cli.getCod_Postal()+"]";
                resAceptar = false;
            }
        }
        catch(NumberFormatException nfe)
        {
            textoError = "El cliente "+ cli.getId_cliente()+" tiene un código postal no numérico ["+cli.getCod_Postal()+"]";
            resAceptar = false;
        }
        
        return resAceptar;
    }

   
    public String getTextoError(){
        return textoError;
    }
    
}