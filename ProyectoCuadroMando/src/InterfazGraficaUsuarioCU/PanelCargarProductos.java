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
 * @author Javier Roncero
 *
 */

public class PanelCargarProductos extends JPanel{

    private JButton botonSelector;
    private JButton botonCancelar;
    private JButton botonCargar;
    private JFileChooser selector;
    private JTextField cuadroTextoRuta; 

    public PanelCargarProductos(PanelGeneralOpciones objeto) {
        //Establecer tamaño y otros parámetros
        //Inicializar controles
        JLabel etiquetaArchivo = new JLabel("Archivo de artículos :");
        selector = new JFileChooser();
        botonSelector = new JButton("Seleccionar archivo");
        botonCancelar = new JButton("Cancelar");
        botonCargar = new JButton("Cargar");
        cuadroTextoRuta = new JTextField(40);
        cuadroTextoRuta.setEditable(false);
        cuadroTextoRuta.setBackground(Color.WHITE); 
    
        this.setLayout(null);
        this.add(etiquetaArchivo);
        etiquetaArchivo.setBounds(200,165,120,30);
        this.add(cuadroTextoRuta);
        cuadroTextoRuta.setBounds(330,165,225,30);

        ManejadorEventosCargarProductos evento = new ManejadorEventosCargarProductos(this, objeto);
        
        this.add(botonSelector);
        botonSelector.setBounds(575,165,150,30);
        botonSelector.addActionListener(evento);
        this.add(botonCancelar);
        botonCancelar.addActionListener(evento);
        botonCancelar.setBounds(510,380,150,30);
        this.add(botonCargar);
        botonCargar.addActionListener(evento);
        botonCargar.setBounds(670,380,150,30);
        botonCargar.setEnabled(false);
       
    }

    public void setEnabledBotonCargar(Boolean estado){
        botonCargar.setEnabled(estado);
    }
    
    public void setTextCuadroTextoRuta(String texto){
        cuadroTextoRuta.setText(texto);
    }
    
    public int showOpenDialog(){
        int returnVal = selector.showOpenDialog(selector);
        return returnVal;
    }
    
    public File getSelectedFile(){
        return selector.getSelectedFile();
    }
    
    public File getCurrentDirectory(){
        return selector.getCurrentDirectory();
    }

    public void setCurrentDirectory(File dir){
        selector.setCurrentDirectory(dir);
    }
   
    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
