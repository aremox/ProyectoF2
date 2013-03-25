package ControlAuxiliarCU;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ProveedorInformacionAlmacenes extends ProveedorInformacion {

    LinkedList almacenes;
    LinkedList elementos;

    public ProveedorInformacionAlmacenes(String absolutePath, String separador, int numero) throws FileNotFoundException {
        super(absolutePath, separador, numero);

    }

    public LinkedList extraer() {
        almacenes = new LinkedList();
        elementos = new LinkedList();
        StringTokenizer tokens;
        leerLinea();
        int tam = lineas.size();
        int pos = 0; //Mientras haya elementos 
        while (pos <= tam - 1) {
            //obtener 
            String linea = (String) lineas.get(pos);
            tokens = new StringTokenizer(linea, separadorCampos);
            while (tokens.hasMoreTokens()) {
                   elementos.add(tokens.nextToken());    
                        //System.out.println(tokens.nextToken().);
                    }
            almacenes.add(elementos);
            pos++;
        }

        return almacenes;
    }
}
