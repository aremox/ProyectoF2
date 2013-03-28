package ControlAuxiliarCU.Almacenes;

/*
 *
 * @author Ivan Arenas
 *
 */

import ControlAuxiliarCU.ProveedorInformacion;
import ControlAuxiliarCU.RegistroLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ProveedorInformacionAlmacenes extends ProveedorInformacion {

    LinkedList<RegistroAlmacenes> almacenes;

    public ProveedorInformacionAlmacenes(String absolutePath, String separador, int numero) throws FileNotFoundException {
        super(absolutePath, separador, numero);

    }

    public LinkedList extraer() throws IOException {
        almacenes = new LinkedList<RegistroAlmacenes>();
        String[] elementos;
        StringTokenizer tokens;
        leerLinea();
        int tam = lineas.size();
        int pos = 0; //Mientras haya elementos 
        while (pos <= tam - 1) {
            elementos = new String[numeroCampos];
            String linea = (String) lineas.get(pos);
            tokens = new StringTokenizer(linea, separadorCampos);
            int pos2 = 0;
            if (tokens.countTokens() != numeroCampos) {
                System.out.println("ERROR: Linea sin todos los campos");
                RegistroLog log = new RegistroLog("ERROR: Linea sin todos los campos","Almacenes");
                errores++;
            } else {
                while (tokens.hasMoreTokens()) {
                    elementos[pos2] = tokens.nextToken().trim();
                    pos2++;
                }

                RegistroAlmacenes registro = new RegistroAlmacenes(elementos[0], elementos[1], elementos[2], elementos[3], elementos[4], elementos[5], elementos[6]);
                almacenes.add(registro);
            }
            pos++;
        }

        return almacenes;
    }
}
