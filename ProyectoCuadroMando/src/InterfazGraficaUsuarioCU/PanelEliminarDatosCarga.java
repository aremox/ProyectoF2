package InterfazGraficaUsuarioCU;


import javax.swing.JButton;
import javax.swing.JPanel;


/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */

public class PanelEliminarDatosCarga extends JPanel{

    private JButton botonVerInforme;


    public PanelEliminarDatosCarga(){
        //Establecer tamaño y otros parámetros
        //Inicializar controles

        botonVerInforme = new JButton("Eliminar datos de carga");
    
        ManejadorEventosEliminarDatosCarga evento = new ManejadorEventosEliminarDatosCarga();
        
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
