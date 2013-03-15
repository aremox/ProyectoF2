package ProyectoCuadroMando;

import java.io.InputStream;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 */
public class PanelCargarClientes extends JPanel implements Action{

    private JButton openButton;
    private JFileChooser selector;
    
    
    public PanelCargarClientes() {
        //Establecer tamaño y otros parámetros
        //Inicializar controles
        JLabel etiqueta1= new JLabel("Archivo de carga");
        selector=new JFileChooser();
        openButton = new JButton("Abrir un File...");
        
        this.add(etiqueta1);
        this.add(openButton);
        openButton.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = selector.showOpenDialog(PanelCargarClientes.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = selector.getSelectedFile();
                System.out.println(file.toString());
                //This is where a real application would open the file.
               // log.append("Opening: " + file.getName() + "." + newline);
            } else {
                //log.append("Open command cancelled by user." + newline);
            }
            //log.setCaretPosition(log.getDocument().getLength()); 
    }}

    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
