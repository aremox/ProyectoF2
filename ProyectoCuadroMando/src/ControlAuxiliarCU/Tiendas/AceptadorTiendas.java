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
    private ControlServicioCU.ControladorServicioCargarTiendas controlador;
    
    public AceptadorTiendas(ControlServicioCU.ControladorServicioCargarTiendas objeto){
        controlador = objeto;
    }
    public boolean aceptar(Tienda tie){
        textoError = "";
        resAceptar = true;
        
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
                textoError = "La tienda "+ controlador.getRegistroTiendas().getId_tienda()+" tiene un código postal erróneo ["+controlador.getRegistroTiendas().getCod_Postal()+"]";
                resAceptar = false;
            }
        }
        catch(NumberFormatException nfe)
        {
            textoError = "La tienda "+ controlador.getRegistroTiendas().getId_tienda()+" tiene un código postal no numérico ["+controlador.getRegistroTiendas().getCod_Postal()+"]";
            resAceptar = false;
        }
        
        return resAceptar;
    }

    private boolean comprobarAlmacen(Tienda tie){
        if (resAceptar){
            if (tie.getAlmacen() == null){
                textoError = "La tienda "+ controlador.getRegistroTiendas().getId_tienda()+" no dispone de ningún Almacén en el mismo código postal ["+controlador.getRegistroTiendas().getCod_Postal()+"]";
                resAceptar = false;
            }
        }
        return resAceptar;
    }
    
    public String getTextoError(){
        return textoError;
    }
    
}
