package InterfazGraficaUsuarioCU;


import javax.swing.JButton;
import javax.swing.JPanel;


/*
 *
 * @author Javier Roncero
 *
 */

public class PanelVerInformeCarga extends JPanel{

    private JButton botonVerInforme;


    public PanelVerInformeCarga(){
        //Establecer tamaño y otros parámetros
        //Inicializar controles

        botonVerInforme = new JButton("Ver informe de carga");
    
        ManejadorEventosVerInformeCarga evento = new ManejadorEventosVerInformeCarga();
        
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
