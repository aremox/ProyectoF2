/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloMVC;

import EntidadesCU.GeoEntidad;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.LinkedList;

public class MapaSuministro extends MapaVectorialBase implements IMapaRepresentarAsociacion {

   
    public MapaSuministro() {
        geometrias = new LinkedList();
    }

    public void representar(GeoEntidad entidad1, GeoEntidad entidad2) {
        // Crear tipo de geometría  y asignar posición (x,y)  
    }

    @Override
    public void generarGrafico() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
