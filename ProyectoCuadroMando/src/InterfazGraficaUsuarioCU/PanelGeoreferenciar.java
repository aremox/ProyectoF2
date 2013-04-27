package InterfazGraficaUsuarioCU;


import javax.swing.JButton;
import javax.swing.JPanel;


/*
 *
 * @author Ivan Arenas
 * @author Javier Roncero
 *
 */

public class PanelGeoreferenciar extends JPanel{

    private JButton botonGeoreferenciar;


    public PanelGeoreferenciar(){
        //Establecer tamaño y otros parámetros
        //Inicializar controles

        botonGeoreferenciar = new JButton("Georeferenciar datos de carga");
    
        ManejadorEventosGeoreferenciar evento = new ManejadorEventosGeoreferenciar();
        
        this.setLayout(null);
        this.add(botonGeoreferenciar);
        botonGeoreferenciar.setBounds(290,165,320,30);
        botonGeoreferenciar.addActionListener(evento);
       
    }

    
    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
