/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistamvc;

import java.awt.Graphics;
import javax.swing.JPanel;
import modeloMVC.MapaVectorialBase;
import modeloMVC.MapaVectorialClientes;
import modeloMVC.MapaVectorialInfluencia;
import modeloMVC.MapaVectorialMayorVentas;
import modeloMVC.MapaVectorialSuministros;
import modeloMVC.MapaVectorialVentas;


public class PanelGraficoMapa extends JPanel{
    
    //asociación de sólo lectura con el modelo 
    MapaVectorialBase mapa;    
    
    public PanelGraficoMapa(MapaVectorialClientes mapa){
        
        this.mapa=mapa;   
    }
    
    public PanelGraficoMapa(MapaVectorialVentas mapa){
        
        this.mapa=mapa;   
    }
    public PanelGraficoMapa(MapaVectorialSuministros mapa){
        
        this.mapa=mapa;   
    }
    public PanelGraficoMapa(MapaVectorialMayorVentas mapa){
        
        this.mapa=mapa;   
    }
    public PanelGraficoMapa(MapaVectorialInfluencia mapa){
        
        this.mapa=mapa;   
    }
    
    @Override
    public void paint(Graphics g) {
         //actualizacion de la vista y acceso al modelo     
        g.drawImage(mapa.getImagen(), 0, 0, this);
    }

}
