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
    private ControlServicioCU.ControladorServicioCargarAlmacenes controlador;
    
    public AceptadorAlmacenes(ControlServicioCU.ControladorServicioCargarAlmacenes objeto){
        controlador = objeto;
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
                textoError = "El almacén "+ controlador.getRegistroAlmacenes().getId_almacen()+" tiene un código postal erróneo ["+controlador.getRegistroAlmacenes().getCod_postal()+"]";
                resAceptar = false;
            }
        }
        catch(NumberFormatException nfe)
        {
            textoError = "Almacen con código postal no numérico";textoError = "El almacén "+ controlador.getRegistroAlmacenes().getId_almacen()+" tiene un código postal no numérico ["+controlador.getRegistroAlmacenes().getCod_postal()+"]";
            resAceptar = false;
        }
        
        return resAceptar;
    }

    
    public String getTextoError(){
        return textoError;
    }
}
