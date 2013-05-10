/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloMVC;

import ContenedoresCU.ContenedorClientesSingleton;
import EntidadesCU.Cliente_ADO;
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
        Rectangle cuadrado1 = new Rectangle(entidad.getX(),entidad.getY(), 5, 5);
        geometrias.add(cuadrado1);
        return true;
    }

    @Override
    public void generarGrafico() {
       //Por cada geometria operación draw en la coordenadas asinadas
        int tam = geometrias.size();
                for (int i = 0; i < tam; i++){
                       grafico2d.draw(geometrias.get(i));  
                } 
              
       
    }
}
