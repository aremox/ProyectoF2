package ControlAuxiliarCU.Tiendas;

import EntidadesCU.Tienda;

/*
 *
 * @author Javier Roncero
 *
 */

public class AceptadorTiendas {
    
    private String textoError = "";
    private Boolean resAceptar = true;
    
    public AceptadorTiendas(){
        
    }
    public boolean aceptar(Tienda tie){

        return (aceptarCodPostal(tie) && comprobarAlmacen(tie));
    }
    
    private boolean aceptarCodPostal(Tienda tie){
        // Comprobamos que cod_postal es un número
        try
        {
            int cod_postal = Integer.parseInt(tie.getCod_Postal());
            // Si es un numero vemos que este comprendido entre 01000 y 52999.
            if ((cod_postal >= 01000) && (cod_postal <= 52999)){
                resAceptar = true;
            }
            else
            {
                textoError = "Tienda con código postal erróneo";
                resAceptar = false;
            }
        }
        catch(NumberFormatException nfe)
        {
            textoError = "Tienda con código postal no numérico";
            resAceptar = false;
        }
        
        return resAceptar;
    }

    private boolean comprobarAlmacen(Tienda tie){
        if (resAceptar){
            if (tie.getAlmacen() == null){
                textoError = "No existe un almacén en el mismo codigo postal de la tienda";
                resAceptar = false;
            }
        }
        return resAceptar;
    }
    
    public String getTextoError(){
        return textoError;
    }
    
}
