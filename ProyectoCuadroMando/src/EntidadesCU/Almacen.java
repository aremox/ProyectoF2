package EntidadesCU;

import ControlAuxiliarCU.*;

/*
 *
 * @author Ivan Arenas
 *
 */

public class Almacen {

    private String id_almacenes;
    private String calle;
    private String numero;
    private String cod_postal;
    private String telefono;
    private String municipio;
    private String provincia;

    public Almacen(String pid_almacenes, String pcalle, String pnumero, String pcod_postal, String ptelefono, String pmunicipio, String pprovincia) {
        id_almacenes = pid_almacenes;
        calle = pcalle;
        numero = pnumero;
        cod_postal = pcod_postal;
        telefono = ptelefono;
        municipio = pmunicipio;
        provincia = pprovincia;
    }
    public String getId_almacen(){
        return id_almacenes;
    }
}
