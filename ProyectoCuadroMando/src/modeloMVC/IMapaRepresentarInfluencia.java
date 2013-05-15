/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeloMVC;

import EntidadesCU.GeoEntidad;


public interface IMapaRepresentarInfluencia {
    public boolean influencia ( GeoEntidad entidad1, GeoEntidad entidad2, float diametro);
}
