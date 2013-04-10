package InterfazGraficaUsuarioCU;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/*
 *
 * @author Javier Roncero
 *
 */

public class ManejadorEventosEliminarDatosCarga implements Action {

    private File file;
    
    
    public ManejadorEventosEliminarDatosCarga(){

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource(); 

        if ("Eliminar datos de carga".equals(boton.getText())) {
 
            //try {
                //ControladorServicioCargarClientes controladorClientes = new ControladorServicioCargarClientes(file);
                //controladorClientes.DesarrollarServicio();
                JOptionPane.showMessageDialog(null,"Eliminar datos de Carga                                    ","ELIMINAR DATOS DE CARGA", JOptionPane.INFORMATION_MESSAGE);             

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