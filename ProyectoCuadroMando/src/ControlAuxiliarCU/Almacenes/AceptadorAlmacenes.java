package ControlAuxiliarCU.Almacenes;

import EntidadesCU.Almacen;

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
    public boolean aceptar(Almacen alm){
        textoError = "";
        resAceptar = true;
        
        return (aceptarCodPostal(alm));
    }
    
    private boolean aceptarCodPostal(Almacen alm){
        // Comprobamos que cod_postal es un número
        try
        {
            int cod_postal = Integer.parseInt(alm.getCod_postal());
            // Si es un numero vemos que este comprendido entre 01000 y 52999.
            if ((cod_postal >= 01000) && (cod_postal <= 52999)){
                resAceptar = true;
            }
            else
            {
                textoError = "Almacen con código postal erróneo";
                resAceptar = false;
            }
        }
        catch(NumberFormatException nfe)
        {
            textoError = "Almacen con código postal no numérico";
            resAceptar = false;
        }
        
        return resAceptar;
    }

    
    public String getTextoError(){
        return textoError;
    }
}
