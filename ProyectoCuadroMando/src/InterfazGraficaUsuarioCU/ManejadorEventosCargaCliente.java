/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGraficaUsuarioCU;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JButton;

/**
 *
 * @author ivan
 */
public class ManejadorEventosCargaCliente implements Action {

    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        System.out.println(boton.getText());
        if ("Seleccionar archivo".equals(boton.getText())) {
            int returnVal = PanelCargarClientes.selector.showOpenDialog(PanelCargarClientes.selector);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = PanelCargarClientes.selector.getSelectedFile();
                System.out.println(file.toString());
                PanelCargarClientes.cuadroTextoRuta.setText(file.toString());
                //PanelCargarClientes.botonCargar.setEnabled(true);
            }
            
        } else if ("Cancelar".equals(boton.getText())) {

            PanelCargarClientes.cuadroTextoRuta.setText("");
            //PanelCargarClientes.botonCargar.setEnabled(false);
            
        } else if ("Cargar".equals(boton.getText())) {

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