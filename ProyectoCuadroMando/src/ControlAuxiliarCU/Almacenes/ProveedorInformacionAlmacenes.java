package ControlAuxiliarCU.Almacenes;

import ControlAuxiliarCU.ProveedorInformacion;
import ControlAuxiliarCU.RegistroLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 *
 * @author Ivan Arenas
 *
 */

public class ProveedorInformacionAlmacenes extends ProveedorInformacion {

    LinkedList<RegistroAlmacenes> almacenes;

    public ProveedorInformacionAlmacenes(String absolutePath, String separador) throws FileNotFoundException {
        super(absolutePath, separador);

    }

    public LinkedList extraer() throws IOException {
        almacenes = new LinkedList<RegistroAlmacenes>();
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
                elementos[pos2] = tokens.nextToken().trim();
                pos2++;
            }

            RegistroAlmacenes registro = new RegistroAlmacenes(elementos[0], elementos[1], elementos[2], elementos[3], elementos[4], elementos[5], elementos[6]);
            almacenes.add(registro);
            pos++;
        }
        totalLecturas = almacenes.size();
        return almacenes;        
        
        
        
        
        
        
    }
}
