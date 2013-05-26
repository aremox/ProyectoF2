/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloMVC;

import EntidadesCU.GeoEntidad;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


public class MapaVectorialProductos extends MapaVectorialBase implements IMapaRepresentarEntidad {

    public MapaVectorialProductos() {
        super();
        //incializar contexto de dibujo
       grafico2d.setPaint(Color.BLUE);//color de la línea rojo
    }
    public void inicializar() {
        geometrias.clear();
    }
    
    @Override
    public boolean representar(GeoEntidad entidad) {
        // Crear tipo de geometría  y asignar posición (x,y)        
        Rectangle cuadrado1 = new Rectangle(entidad.getX()-3,entidad.getY()-3, 6, 6);
        
        geometrias.add(cuadrado1);
       
       
        return true;
    }

    @Override
    public void generarGrafico() {
       //Por cada geometria operación draw en la coordenadas asinadas
        int tam = geometrias.size();
                for (int i = 0; i < tam; i++){
                    
                    grafico2d.setPaint(Color.orange);  
                     
                    
                        grafico2d.fill(geometrias.get(i));
                       grafico2d.draw(geometrias.get(i));  
                } 
              
       
    }
    
}
