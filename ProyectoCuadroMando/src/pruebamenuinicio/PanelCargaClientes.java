package pruebamenuinicio;


import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 */

public class PanelCargaClientes extends JPanel implements Action{

    public PanelCargaClientes() {
        //Establecer tamaño y otros parámetros
        //Inicializar controles
        JLabel etiqueta1= new JLabel("Archivo de carga");
        this.add(etiqueta1);
    }


    public void actionPerformed(ActionEvent e) {
       //Mostrar FileChooser
        //obtener archivo
        //leer cada registro y almacenarlo en la colección
    }

    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
