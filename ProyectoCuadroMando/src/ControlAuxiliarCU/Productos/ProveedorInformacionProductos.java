package ControlAuxiliarCU.Productos;

import ControlAuxiliarCU.ProveedorInformacion;
import ControlAuxiliarCU.ArchivoLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 *
 * @author Javier Roncero
 *
 */

public class ProveedorInformacionProductos extends ProveedorInformacion {

        LinkedList<RegistroProductos> productos;

    public ProveedorInformacionProductos(String absolutePath, String separador) throws FileNotFoundException {
        super(absolutePath, separador);
    }

    public LinkedList extraer() throws IOException {
        productos = new LinkedList<RegistroProductos>();
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

            RegistroProductos registro = new RegistroProductos(elementos[0], elementos[1], elementos[2], elementos[3]);
            productos.add(registro);
            pos++;
        }
        
        return productos;
    }
    
}
