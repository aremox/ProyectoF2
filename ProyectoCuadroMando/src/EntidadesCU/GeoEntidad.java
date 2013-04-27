/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesCU;

/**
 *
 * @author ivan
 */
public abstract class GeoEntidad {
    protected int x=0;
    protected int y=0;
    
    public void GeoEntidad(){
        
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int variX){
        x = variX;
    }
    public void setY(int variY){
        y =variY;
    }
}
