package InterfazGraficaUsuarioCU;

import ControlServicioCU.ControladorServicioCargarVentas;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/*
 *
 * @author Ivan Arenas
 *
 */

public class ManejadorEventosCargarVentas implements Action{
    
    private PanelCargarVentas panel;
    private PanelGeneralOpciones panelGeneral;
    private File file;
    
  public ManejadorEventosCargarVentas(PanelCargarVentas objeto, PanelGeneralOpciones objeto2){
        panel = objeto;
        panelGeneral = objeto2;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource(); 

        if ("Seleccionar archivo".equals(boton.getText())) {
            
            if (panelGeneral.getCurrentDirectory() != null) {
                panel.setCurrentDirectory(panelGeneral.getCurrentDirectory());
            }

            
            int returnVal = panel.abrirSelectorFichero();

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = panel.getSelectedFile();
                panel.setTextCuadroTextoRuta(file.toString());
                panel.setEnabledBotonCargar(Boolean.TRUE);
                panelGeneral.setCurrentDirectory(panel.getCurrentDirectory());
            }
            
        } else if ("Cancelar".equals(boton.getText())) {
            panel.setTextCuadroTextoRuta("");
            panel.setEnabledBotonCargar(Boolean.FALSE);
            
        } else if ("Cargar".equals(boton.getText())) {
            try {
                ControladorServicioCargarVentas controladorVentas = new ControladorServicioCargarVentas(file);
                controladorVentas.DesarrollarServicio();
                JOptionPane.showMessageDialog(null,"Archivo de VENTAS cargado correctamente                  ","RESULTADO DE LA CARGA       ", JOptionPane.INFORMATION_MESSAGE);
                panel.setTextCuadroTextoRuta("");
                panel.setEnabledBotonCargar(Boolean.FALSE);
            } catch (IOException ex) {
                Logger.getLogger(ManejadorEventosCargarVentas.class.getName()).log(Level.SEVERE, null, ex);
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
