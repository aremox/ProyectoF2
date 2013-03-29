package ControlAuxiliarCU.Tiendas;

import EntidadesCU.Tienda;

/*
 *
 * @author Javier Roncero
 *
 */

public class AceptadorTiendas {
    
   
    public AceptadorTiendas(){
        
    }
    public boolean aceptar(Tienda tie){
        // Comprobamos que cod_postal es un número
        try
        {
            int cod_postal = Integer.parseInt(tie.getCod_Postal());
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
