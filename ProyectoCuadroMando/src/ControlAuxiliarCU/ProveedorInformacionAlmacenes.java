package ControlAuxiliarCU;

import java.io.File;
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

    public ProveedorInformacionAlmacenes(String separador) throws FileNotFoundException {
        super(separador);

    }

    @Override
     public LinkedList extraer(String ruta) {
        archivo = new File(ruta);
        almacenes = new LinkedList<RegistroAlmacenes>();

        try {
            if (comprobarFlujo()) {
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
            }
        } catch (IOException ex) {
        }

        return almacenes;
    }
}
