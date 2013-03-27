/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAuxiliarCU.Almacen;

/**
 *
 * @author ivan
 */
public class RegistroAlmacen {

    private String id_almacen;
    private String calle;
    private String numero;
    private String cod_postal;
    private String telefono;
    private String municipio;
    private String provincia;

    public RegistroAlmacen(String pid_almacenes, String pcalle, String pnumero, String pcod_postal, String ptelefono, String pmunicipio, String pprovincia) {
        id_almacen = pid_almacenes;
        calle = pcalle;
        numero = pnumero;
        cod_postal = pcod_postal;
        telefono = ptelefono;
        municipio = pmunicipio;
        provincia = pprovincia;

    }
    
    public String getId_almacen(){
        return id_almacen;
    }
    public String getCalle(){
        return calle;
    }
    public String getNumero(){
        return numero;
    }
    public String getCod_postal(){
        return cod_postal;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getMunicipio(){
        return municipio;
    }
    public String getProvincia(){
        return provincia;
    }
}