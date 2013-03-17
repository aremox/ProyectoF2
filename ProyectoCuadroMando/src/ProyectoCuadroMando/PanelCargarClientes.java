package ProyectoCuadroMando;

import java.awt.Color;
import java.io.InputStream;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 */
public class PanelCargarClientes extends JPanel implements Action{

    private JButton botonSelector;
    private JButton botonCancelar;
    private JButton botonCargar;
    private JFileChooser selector;
    private JTextField cuadroTextoRuta; 
   
    
    public PanelCargarClientes() {
        //Establecer tamaño y otros parámetros
        //Inicializar controles
        JLabel etiquetaArchivo = new JLabel("Archivo de clientes :");
        selector = new JFileChooser();
        botonSelector = new JButton("Seleccionar archivo");
        botonCancelar = new JButton("Cancelar");
        botonCargar = new JButton("Cargar");
        cuadroTextoRuta = new JTextField(40);
        cuadroTextoRuta.setEditable(false);
        cuadroTextoRuta.setBackground(Color.WHITE); 

            
        this.setLayout(null);
        this.add(etiquetaArchivo);
        etiquetaArchivo.setBounds(75,75,120,30);
        this.add(cuadroTextoRuta);
        cuadroTextoRuta.setBounds(205,75,225,30);

        this.add(botonSelector);
        botonSelector.setBounds(450,75,150,30);
        botonSelector.addActionListener(this);
        this.add(botonCancelar);
        botonCancelar.addActionListener(this);
        botonCancelar.setBounds(350,225,150,30);
        this.add(botonCargar);
        botonCargar.setBounds(510,225,150,30);
        botonCargar.setEnabled(false);
       
    }

    public void actionPerformed(ActionEvent e) {
        //Handle open button action.
        if (e.getSource() == botonSelector) {
            int returnVal = selector.showOpenDialog(PanelCargarClientes.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = selector.getSelectedFile();
                System.out.println(file.toString());
                cuadroTextoRuta.setText(file.toString());
                botonCargar.setEnabled(true);
                
                //This is where a real application would open the file.
               // log.append("Opening: " + file.getName() + "." + newline);
            } else {
                //log.append("Open command cancelled by user." + newline);
            }
            //log.setCaretPosition(log.getDocument().getLength()); 
        } else if (e.getSource() == botonCancelar) {
            
            cuadroTextoRuta.setText("");
            botonCargar.setEnabled(false);
        }
    }

    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
