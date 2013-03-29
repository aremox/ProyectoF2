package ControlAuxiliarCU.Tiendas;

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

public class ProveedorInformacionTiendas extends ProveedorInformacion {

        LinkedList<RegistroTiendas> tiendas;

    public ProveedorInformacionTiendas(String absolutePath, String separador, int numero) throws FileNotFoundException {
        super(absolutePath, separador, numero);
    }

    public LinkedList extraer() throws IOException {
        tiendas = new LinkedList<RegistroTiendas>();
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
                RegistroLog log = new RegistroLog("ERROR: Linea sin todos los campos","Tiendas");
                errores++;
            } else {
                while (tokens.hasMoreTokens()) {
                    elementos[pos2] = tokens.nextToken().trim();
                    pos2++;
                }

                RegistroTiendas registro = new RegistroTiendas(elementos[0], elementos[1], elementos[2], elementos[3], elementos[4], elementos[5], elementos[6], elementos[7]);
                tiendas.add(registro);
            }
            pos++;
        }

        return tiendas;
    }
    
    
}
