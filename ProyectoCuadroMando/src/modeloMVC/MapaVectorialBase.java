/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloMVC;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author gustavo.millan
 */
public abstract class MapaVectorialBase {

    protected LinkedList<Shape> geometrias; //colección de figuras geométericas
    protected BufferedImage imagenCartograficabase; //supesto mapa base
    protected Graphics2D grafico2d; //objeto de tratamiento grafico

    public MapaVectorialBase() {

        grafico2d = null; //grafico no generado
        geometrias = new LinkedList();
        int a = 800, l = 600; //Tamaño del mapa
        imagenCartograficabase = new BufferedImage(a, l, BufferedImage.TRANSLUCENT);
        Image im = null;
        Graphics2D graficoComposicion = this.imagenCartograficabase.createGraphics();
        //establecer contexto del grafico
        graficoComposicion.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        String mapa = "src//imagenbase//mapa.jpg";
        //obtener la imagen de fondo
        File fichero = new File(mapa);
        try {
            im = ImageIO.read(fichero);
        } catch (IOException ex) {
            Logger.getLogger(MapaVectorialBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        //dibujar la cartografía como imagen de fondo en posición 20,20 (arriba-izqu)
        graficoComposicion.drawImage(im, 20, 20, null);
        //guardar estado como estado
        grafico2d = graficoComposicion;

    }

    public BufferedImage getImagen() {

        return imagenCartograficabase;
    }

    public abstract void generarGrafico(); //metodo abstracto para todos los tipos de mapas
}
