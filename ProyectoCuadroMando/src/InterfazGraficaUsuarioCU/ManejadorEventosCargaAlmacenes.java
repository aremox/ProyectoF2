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

        if (e.getSource() == PanelCargarClientes.botonSelector) {
            int returnVal = PanelCargarClientes.selector.showOpenDialog(PanelCargarClientes.selector);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = PanelCargarClientes.selector.getSelectedFile();
                System.out.println(file.toString());
                PanelCargarClientes.cuadroTextoRuta.setText(file.toString());
                PanelCargarClientes.botonCargar.setEnabled(true);
            }
            
        } else if (e.getSource() == PanelCargarClientes.botonCancelar) {

            PanelCargarClientes.cuadroTextoRuta.setText("");
            PanelCargarClientes.botonCargar.setEnabled(false);
            
        } else if (e.getSource() == PanelCargarClientes.botonCargar) {

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
