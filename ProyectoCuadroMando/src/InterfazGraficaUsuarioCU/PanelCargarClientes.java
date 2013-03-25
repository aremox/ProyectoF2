package InterfazGraficaUsuarioCU;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 */
public class PanelCargarClientes extends JPanel{

    private JButton botonSelector;
    private JButton botonCancelar;
    public JButton botonCargar;
    public JFileChooser selector;
    public JTextField cuadroTextoRuta; 
   
    
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

        ManejadorEventosCargaCliente evento = new ManejadorEventosCargaCliente(this);
        
        this.add(botonSelector);
        botonSelector.setBounds(450,75,150,30);
        botonSelector.addActionListener(evento);
        this.add(botonCancelar);
        botonCancelar.addActionListener(evento);
        botonCancelar.setBounds(350,225,150,30);
        this.add(botonCargar);
        botonCargar.addActionListener(evento);
        botonCargar.setBounds(510,225,150,30);
        botonCargar.setEnabled(false);
       
    }

    
    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
