package InterfazGraficaUsuarioCU;

import ControlServicioCU.ControladorServicioCargarClientes;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/*
 *
 * @author Javier Roncero
 *
 */

public class ManejadorEventosVerInformeCarga implements Action {

    private File file;
    
    
    public ManejadorEventosVerInformeCarga(){

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource(); 

        if ("Ver informe de carga".equals(boton.getText())) {
 
            //try {
                //ControladorServicioCargarClientes controladorClientes = new ControladorServicioCargarClientes(file);
                //controladorClientes.DesarrollarServicio();
                JOptionPane.showMessageDialog(null,"Informe de Carga                  ","INFORME DE CARGA       ", JOptionPane.INFORMATION_MESSAGE);             

            //} catch (IOException ex) {
            //    Logger.getLogger(ManejadorEventosCargarAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
            //}
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