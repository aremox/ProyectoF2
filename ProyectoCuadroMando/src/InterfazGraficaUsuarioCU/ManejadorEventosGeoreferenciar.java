/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGraficaUsuarioCU;

import ControlServicioCU.ControladorServicioGeoreferenciar;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author ivan
 */
public class ManejadorEventosGeoreferenciar implements Action {
    public ManejadorEventosGeoreferenciar(){

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource(); 

        if ("Georeferenciar datos de carga".equals(boton.getText())) {
 
            ControladorServicioGeoreferenciar controladorGeoreferenciar = new ControladorServicioGeoreferenciar();
            controladorGeoreferenciar.DesarrollarServicio();
            JOptionPane.showMessageDialog(null,"Datos Georeferenciados y grabados correctamente                            ","GEOREFERENCIAR DATOS DE CARGA", JOptionPane.INFORMATION_MESSAGE);             

        }


    }

    @Override
    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setEnabled(boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
