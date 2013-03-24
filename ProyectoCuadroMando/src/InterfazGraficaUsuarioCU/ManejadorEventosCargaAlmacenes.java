/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGraficaUsuarioCU;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author ivan
 */
public class ManejadorEventosCargaAlmacenes implements Action{
  public void actionPerformed(ActionEvent e) {

        if (e.getSource() == PanelCargarAlmacenes.botonSelector) {
            int returnVal = PanelCargarAlmacenes.selector.showOpenDialog(PanelCargarAlmacenes.selector);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = PanelCargarAlmacenes.selector.getSelectedFile();
                System.out.println(file.toString());
                PanelCargarAlmacenes.cuadroTextoRuta.setText(file.toString());
                PanelCargarAlmacenes.botonCargar.setEnabled(true);
            }
            
        } else if (e.getSource() == PanelCargarAlmacenes.botonCancelar) {

            PanelCargarAlmacenes.cuadroTextoRuta.setText("");
            PanelCargarAlmacenes.botonCargar.setEnabled(false);
            
        } else if (e.getSource() == PanelCargarAlmacenes.botonCargar) {

            System.out.println("Boton cargar");
        }


    }

    @Override
    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEnabled(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
