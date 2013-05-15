/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloMVC;

import EntidadesCU.GeoEntidad;
import java.awt.Color;
import java.awt.Rectangle;


public class MapaVectorialClientes extends MapaVectorialBase implements IMapaRepresentarEntidad {

    public MapaVectorialClientes() {
        super();
        //incializar contexto de dibujo
       grafico2d.setPaint(Color.red);//color de la línea rojo
    }

    @Override
    public boolean representar(GeoEntidad entidad) {
        // Crear tipo de geometría  y asignar posición (x,y)        
        Rectangle cuadrado1 = new Rectangle(entidad.getX()-1,entidad.getY()-1, 2, 2);
        geometrias.add(cuadrado1);
        return true;
    }

    @Override
    public void generarGrafico() {
       //Por cada geometria operación draw en la coordenadas asinadas
        int tam = geometrias.size();
                for (int i = 0; i < tam; i++){
                   
                    int x = geometrias.get(i).getBounds().width;
                    
                    switch(x) {
                        case 2:
                           grafico2d.setPaint(Color.blue);
                            break;
                        case 5:
                           grafico2d.setPaint(Color.green);
                            break;
                        case 10:
                            grafico2d.setPaint(Color.ORANGE);
                            break;
                        default:
                         grafico2d.setPaint(Color.RED);   
                    }
                    grafico2d.fill(geometrias.get(i));
                       grafico2d.draw(geometrias.get(i));  
                } 
              
       
    }
}
