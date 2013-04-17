package InterfazGraficaUsuarioCU;


import javax.swing.JButton;
import javax.swing.JPanel;


/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */

public class PanelGrabarDatosCarga extends JPanel{

    private JButton botonVerInforme;


    public PanelGrabarDatosCarga(){
        //Establecer tamaño y otros parámetros
        //Inicializar controles

        botonVerInforme = new JButton("Grabar datos de carga");
    
        ManejadorEventosGrabarDatosCarga evento = new ManejadorEventosGrabarDatosCarga();
        
        this.setLayout(null);
        this.add(botonVerInforme);
        botonVerInforme.setBounds(290,165,320,30);
        botonVerInforme.addActionListener(evento);
       
    }

    
    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
