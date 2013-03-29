package InterfazGraficaUsuarioCU;

import ControlServicioCU.ControladorServicioCargarAlmacenes;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;

/*
 *
 * @author Ivan Arenas
 *
 */

public class ManejadorEventosCargarAlmacenes implements Action{
    
    private PanelCargarAlmacenes panel;
    private File file;
    
  public ManejadorEventosCargarAlmacenes(PanelCargarAlmacenes objeto){
        panel = objeto;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource(); 

        if ("Seleccionar archivo".equals(boton.getText())) {
            int returnVal = panel.abrirSelectorFichero();

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = panel.getSelectedFile();
                panel.setTextCuadroTextoRuta(file.toString());
                panel.setEnabledBotonCargar(Boolean.TRUE);
            }
            
        } else if ("Cancelar".equals(boton.getText())) {
            panel.setTextCuadroTextoRuta("");
            panel.setEnabledBotonCargar(Boolean.FALSE);
            
        } else if ("Cargar".equals(boton.getText())) {
            try {
                ControladorServicioCargarAlmacenes controladorAlmacenes = new ControladorServicioCargarAlmacenes(file);
                controladorAlmacenes.DesarrollarServicio();
                panel.setTextCuadroTextoRuta("");
                panel.setEnabledBotonCargar(Boolean.FALSE);
            } catch (IOException ex) {
                Logger.getLogger(ManejadorEventosCargarAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
            }
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
