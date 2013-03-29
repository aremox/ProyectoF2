package ControlAuxiliarCU.Clientes;

import ControlAuxiliarCU.ProveedorInformacion;
import ControlAuxiliarCU.RegistroLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 *
 * @author Javier Roncero
 *
 */

public class ProveedorInformacionClientes extends ProveedorInformacion {

        LinkedList<RegistroClientes> clientes;

    public ProveedorInformacionClientes(String absolutePath, String separador, int numero) throws FileNotFoundException {
        super(absolutePath, separador, numero);
    }

    public LinkedList extraer() throws IOException {
        clientes = new LinkedList<RegistroClientes>();
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
                System.out.println("ERROR: Linea sin todos los campos  -  "+linea);
                RegistroLog log = new RegistroLog("ERROR: Linea sin todos los campos","Clientes");
                errores++;
            } else {
                while (tokens.hasMoreTokens()) {
                    elementos[pos2] = tokens.nextToken().trim();
                    pos2++;
                }

                RegistroClientes registro = new RegistroClientes(elementos[0], elementos[1], elementos[2], elementos[3], elementos[4], elementos[5], elementos[6], elementos[7], elementos[8], elementos[9]);
                clientes.add(registro);
            }
            pos++;
        }

        return clientes;
    }
    
    
}
