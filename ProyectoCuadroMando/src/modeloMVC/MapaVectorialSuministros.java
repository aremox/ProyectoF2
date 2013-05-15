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


public class MapaVectorialSuministros extends MapaVectorialBase implements IMapaRepresentarEntidades, IMapaRepresentarAsociacion {

    public MapaVectorialSuministros() {
        super();
        //incializar contexto de dibujo
       grafico2d.setPaint(Color.BLUE);//color de la línea rojo
    }

    @Override
    public boolean representar(GeoEntidad entidad, GeoEntidad entidad2) {
        // Crear tipo de geometría  y asignar posición (x,y)        
        Rectangle cuadrado1 = new Rectangle(entidad.getX()-3,entidad.getY()-3, 6, 6);
        Rectangle cuadrado2 = new Rectangle(entidad2.getX()-10,entidad2.getY()-3, 20, 6);
        //Ellipse2D cuadrado2 = new Ellipse2D.Float(entidad2.getX(),entidad2.getY(), 7, 7);
        
        geometrias.add(cuadrado1);
       
        geometrias.add(cuadrado2);
        return true;
    }

    @Override
    public void generarGrafico() {
       //Por cada geometria operación draw en la coordenadas asinadas
        int tam = geometrias.size();
                for (int i = 0; i < tam; i++){
                    int x = geometrias.get(i).getBounds().width;
                    grafico2d.setPaint(Color.RED);  
                    switch(x) {
                        case 1:
                           grafico2d.setPaint(Color.BLUE);
                           
                            break;
                        case 6:
                           grafico2d.setPaint(Color.green);
                            break;
                        case 20:
                            grafico2d.setPaint(Color.ORANGE);
                            break;
                        default:
                         grafico2d.setPaint(Color.RED);   
                    }
                        grafico2d.fill(geometrias.get(i));
                       grafico2d.draw(geometrias.get(i));  
                } 
              
       
    }
    @Override
     public boolean asociar ( GeoEntidad entidad1, GeoEntidad entidad2) {
        // Crear tipo de geometría  y asignar posición (x,y) 
        Point2D p1 = new Point2D.Float(entidad1.getX(), entidad1.getY());
        Point2D p2 = new Point2D.Float(entidad2.getX(), entidad2.getY());
        Line2D linea1 = new Line2D.Float(p1, p2);
        geometrias.add(linea1);
        return true;
    }
}
