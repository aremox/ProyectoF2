/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloMVC;

import EntidadesCU.GeoEntidad;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author ivan
 */
public class MapaVectorialInfluencia extends MapaVectorialBase implements IMapaRepresentarEntidades, IMapaRepresentarInfluencia {

    public MapaVectorialInfluencia() {
        super();
        //incializar contexto de dibujo
        grafico2d.setPaint(Color.DARK_GRAY);//color de la línea gris
    }

    @Override
    public boolean representar(GeoEntidad entidad, GeoEntidad entidad2) {
        // Crear tipo de geometría  y asignar posición (x,y)        
        Rectangle cuadrado1 = new Rectangle(entidad.getX()-1, entidad.getY()-1, 2, 2);
        Rectangle cuadrado2 = new Rectangle(entidad2.getX()-3, entidad2.getY()-3, 6, 6);
        
        geometrias.add(cuadrado1);
        geometrias.add(cuadrado2);
        
        return true;
    }

    @Override
    public void generarGrafico() {
        //Por cada geometria operación draw en la coordenadas asinadas
        int tam = geometrias.size();
        for (int i = 0; i < tam; i++) {
            int x = geometrias.get(i).getBounds().width;
            grafico2d.setPaint(Color.RED);
            switch (x) {
                case 2:
                    grafico2d.setPaint(Color.BLUE);
                    grafico2d.fill(geometrias.get(i));
                    break;
                case 6:
                    grafico2d.setPaint(Color.green);
                    grafico2d.fill(geometrias.get(i));
                    break;
                case 20:
                    grafico2d.setPaint(Color.ORANGE);
                    grafico2d.fill(geometrias.get(i));
                    break;
                default:
                    grafico2d.setPaint(Color.RED);
            }
            //grafico2d.fill(geometrias.get(i));
            grafico2d.draw(geometrias.get(i));
        }


    }

    @Override
    public boolean influencia(GeoEntidad entidad1, GeoEntidad entidad2, float diametro) {
       
        float p1 = ((entidad1.getX()-entidad2.getX())/2)+entidad2.getX()-diametro/2;
        float p2 = ((entidad1.getY()-entidad2.getY())/2)+entidad2.getY()-diametro/2;
        
        Ellipse2D cuadrado3 = new Ellipse2D.Float(p1, p2, diametro, diametro);
        geometrias.add(cuadrado3);
        return true;
        
    }
}
