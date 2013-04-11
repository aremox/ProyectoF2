package InterfazGraficaUsuarioCU;

import ControlServicioCU.ControladorServicioInformeCarga;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;


/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */

public class ManejadorEventosInformeCarga implements Action {

   
    
    public ManejadorEventosInformeCarga(){

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource(); 
        if ("Ver informe de carga".equals(boton.getText())) {
            ControladorServicioInformeCarga controladorInformeCarga = new ControladorServicioInformeCarga();
            try {
                String lineaAlmacen = controladorInformeCarga.DesarrollarServicio().obtenerAuditoriaCargaAlmacen().getTextoInformeCarga();
                String lineaTiendas = controladorInformeCarga.DesarrollarServicio().obtenerAuditoriaCargaTiendas().getTextoInformeCarga();
                String lineaClientes = controladorInformeCarga.DesarrollarServicio().obtenerAuditoriaCargaClientes().getTextoInformeCarga();
                String lineaProductos = controladorInformeCarga.DesarrollarServicio().obtenerAuditoriaCargaProductos().getTextoInformeCarga();
                String lineaVentas = controladorInformeCarga.DesarrollarServicio().obtenerAuditoriaCargaVentas().getTextoInformeCarga();
                
                // Opción normal
                //JOptionPane.showMessageDialog(null,"\n\n"+lineaClientes+"\n"+lineaProductos+"\n"+lineaTiendas+"\n"+lineaAlmacen+"\n"+lineaVentas+"\n\n\n\n","INFORME DE CARGA       ", JOptionPane.PLAIN_MESSAGE);             
                
                // Opción centrado en el MessageDialog con HTML
                String message = "<html><body><div width='400px' height='200px' align='center'><br/><br/><br/><br/><br/>"+lineaClientes+"<br/><br/>"+lineaProductos+"<br/><br/>"+lineaTiendas+"<br/><br/>"+lineaAlmacen+"<br/><br/>"+lineaVentas+"</div></body></html>";
                JLabel messageLabel = new JLabel(message);
                JOptionPane.showMessageDialog(null,messageLabel,"INFORME DE CARGA       ", JOptionPane.PLAIN_MESSAGE);            

            } catch (IOException ex) {
                Logger.getLogger(ManejadorEventosInformeCarga.class.getName()).log(Level.SEVERE, null, ex);
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