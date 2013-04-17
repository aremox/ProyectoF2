package InterfazGraficaUsuarioCU;

import ControlServicioCU.ControladorServicioEliminarDatosCarga;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */

public class ManejadorEventosGrabarDatosCarga implements Action {

    
    public ManejadorEventosGrabarDatosCarga(){

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource(); 

        if ("Grabar datos de carga".equals(boton.getText())) {
 
            //ControladorServicioGrabarDatosCarga controladorGrabarDatos = new ControladorServicioGrabarDatosCarga();
            //controladorGrabarDatos.DesarrollarServicio();
            JOptionPane.showMessageDialog(null,"Datos grabados correctamente                            ","GRABAR DATOS DE CARGA", JOptionPane.INFORMATION_MESSAGE);             

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