package ControlAuxiliarCU.Clientes;

import EntidadesCU.Cliente;

/*
 *
 * @author Javier Roncero
 *
 */

public class AceptadorClientes {
    
   
    public AceptadorClientes(){
        
    }
    public boolean aceptar(Cliente cli){
        // Comprobamos que cod_postal es un número
        try
        {
            int cod_postal = Integer.parseInt(cli.getCod_Postal());
            // Si es un numero vemos que este comprendido entre 01000 y 52999.
            if ((cod_postal >= 01000) && (cod_postal <= 52999)){
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
                
    }
    
}
