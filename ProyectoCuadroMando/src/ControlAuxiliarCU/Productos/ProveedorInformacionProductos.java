package ControlAuxiliarCU.Productos;

/*
 *
 * @author Javier Roncero
 *
 */

import ControlAuxiliarCU.ProveedorInformacion;
import ControlAuxiliarCU.RegistroLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ProveedorInformacionProductos extends ProveedorInformacion {

        LinkedList<RegistroProductos> productos;

    public ProveedorInformacionProductos(String absolutePath, String separador, int numero) throws FileNotFoundException {
        super(absolutePath, separador, numero);
    }

    public LinkedList extraer() throws IOException {
        productos = new LinkedList<RegistroProductos>();
        String[] elementos;
        StringTokenizer tokens;
        leerLineas();
        int tam = lineas.size();
        int pos = 0; //Mientras haya elementos 
        
        while (pos <= tam - 1) {
            elementos = new String[numeroCampos];
            String linea = (String) lineas.get(pos);
            tokens = new StringTokenizer(linea, separadorCampos);
            int pos2 = 0;
            if (tokens.countTokens() != numeroCampos) {
                System.out.println("ERROR: Linea sin todos los campos");
                RegistroLog log = new RegistroLog("ERROR: Linea sin todos los campos","Productos");
                errores++;
            } else {
                while (tokens.hasMoreTokens()) {
                    elementos[pos2] = tokens.nextToken().trim();
                    pos2++;
                }

                RegistroProductos registro = new RegistroProductos(elementos[0], elementos[1], elementos[2], elementos[3]);
                productos.add(registro);
            }
            pos++;
        }

        return productos;
    }
    
    
}
