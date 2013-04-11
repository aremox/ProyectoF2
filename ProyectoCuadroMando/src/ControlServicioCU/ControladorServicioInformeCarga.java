package ControlServicioCU;

import ControlAuxiliarCU.ArchivoResultadoCarga;
import ControlAuxiliarCU.AuditoriaCarga;
import java.io.IOException;


/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */


public class ControladorServicioInformeCarga {

    private AuditoriaCarga audiCarga = null;

    public void ControladorServicioVerInforme() {
    }

    public AuditoriaCarga DesarrollarServicio() throws IOException {
        try {
            ArchivoResultadoCarga archivoResultadoCarga = new ArchivoResultadoCarga();
            audiCarga = archivoResultadoCarga.obtenerAuditoriaCarga();

        } catch (IOException ex) {
            //    Logger.getLogger(ManejadorEventosCargarAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return audiCarga;
    }
}
