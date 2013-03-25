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

    private PanelCargarClientes panel;
    private File file;
    
    public ManejadorEventosCargaCliente(PanelCargarClientes objeto){
        panel = objeto;
    }
    
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource(); 

        if ("Seleccionar archivo".equals(boton.getText())) {
            int returnVal = panel.showOpenDialog();

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = panel.getSelectedFile();
                panel.setTextCuadroTextoRuta(file.toString());
                panel.setEnabledBotonCargar(Boolean.TRUE);
;
            }
            
        } else if ("Cancelar".equals(boton.getText())) {
            panel.setTextCuadroTextoRuta("");
            panel.setEnabledBotonCargar(Boolean.FALSE);
            
        } else if ("Cargar".equals(boton.getText())) {

            //System.out.println("Boton cargar");
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