/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAuxiliarCU;

/**
 *
 * @author ivan
 */
public class RegistroAlmacenes {

    private String id_almacenes;
    private String calle;
    private int numero;
    private int cod_postal;
    private int telefono;
    private String municipio;
    private String provincia;

    public RegistroAlmacenes(String pid_almacenes, String pcalle, int pnumero, int pcod_postal, int ptelefono, String pmunicipio, String pprovincia) {
        id_almacenes = pid_almacenes;
        calle = pcalle;
        numero = pnumero;
        cod_postal = pcod_postal;
        telefono = ptelefono;
        municipio = pmunicipio;
        provincia = pprovincia;

    }
}
