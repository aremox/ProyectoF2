package ControlAuxiliarCU.Tiendas;

import ControlAuxiliarCU.ProveedorInformacion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 *
 * @author Javier Roncero
 *
 */

public class ProveedorInformacionTiendas extends ProveedorInformacion {

        LinkedList<RegistroTiendas> tiendas;

    public ProveedorInformacionTiendas(String absolutePath, String separador) throws FileNotFoundException {
        super(absolutePath, separador);
    }

    public LinkedList extraer() throws IOException {
        tiendas = new LinkedList<RegistroTiendas>();
        String[] elementos;
        StringTokenizer tokens;
        leerLineas();
        int tam = lineas.size();
        int pos = 0; //Mientras haya elementos 
        
        while (pos <= tam - 1) {
            String linea = (String) lineas.get(pos);
            tokens = new StringTokenizer(linea, separadorCampos);
            elementos = new String[tokens.countTokens()];
            int pos2 = 0;

            while (tokens.hasMoreTokens()) {
                elementos[pos2] = tokens.nextToken();
                pos2++;
            }

            RegistroTiendas registro = new RegistroTiendas(elementos[0], elementos[1], elementos[2], elementos[3], elementos[4], elementos[5], elementos[6], elementos[7]);
            tiendas.add(registro);
            pos++;
        }
        totalLecturas = tiendas.size();
        return tiendas;
    }
    
    
}
