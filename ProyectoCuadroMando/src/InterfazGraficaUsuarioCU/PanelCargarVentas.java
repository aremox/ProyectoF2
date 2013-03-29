package InterfazGraficaUsuarioCU;

import java.awt.Color;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 *
 * @author Ivan Arenas
 *
 */

public class PanelCargarVentas extends JPanel {

   private JButton botonSelector;
   private JButton botonCancelar;
   private JButton botonCargar;
   private JFileChooser selector;
   private JTextField cuadroTextoRuta; 
   
    
    public PanelCargarVentas() {
        //Establecer tamaño y otros parámetros
        //Inicializar controles
        JLabel etiquetaArchivo = new JLabel("Archivo de ventas:");
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

        ManejadorEventosCargarVentas evento = new ManejadorEventosCargarVentas(this);
        
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
    
     public void setEnabledBotonCargar(Boolean estado){
        botonCargar.setEnabled(estado);
    }
    
    public void setTextCuadroTextoRuta(String texto){
        cuadroTextoRuta.setText(texto);
    }
    
    public int abrirSelectorFichero(){
        int returnVal = selector.showOpenDialog(selector);
        return returnVal;
    }
    
    public File getSelectedFile(){
        return selector.getSelectedFile();
    }
   

    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
