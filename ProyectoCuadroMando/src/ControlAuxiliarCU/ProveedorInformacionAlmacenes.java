package ControlAuxiliarCU;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ProveedorInformacionAlmacenes extends ProveedorInformacion {

    LinkedList<RegistroAlmacen> almacenes;

    public ProveedorInformacionAlmacenes(String absolutePath, String separador, int numero) throws FileNotFoundException {
        super(absolutePath, separador, numero);

    }

    public LinkedList extraer() {
        almacenes = new LinkedList<RegistroAlmacen>();
        String[] elementos;
        StringTokenizer tokens;
        leerLinea();
        int tam = lineas.size();
        int pos = 0; //Mientras haya elementos 
        while (pos <= tam - 1) {
            elementos=new String[numeroCampos];
            String linea = (String) lineas.get(pos);
            tokens = new StringTokenizer(linea, separadorCampos);
            int pos2 = 0;
            while (tokens.hasMoreTokens()) {
                        elementos[pos2]=tokens.nextToken().trim();
                   //elementos.add(tokens.nextToken());    
                        //System.out.println(tokens.nextToken().);
                        pos2++;
                    }
             
            System.out.println(elementos[0]);
            RegistroAlmacen registro = new RegistroAlmacen(elementos[0],elementos[1],elementos[2],elementos[3],elementos[4], elementos[5], elementos[6]);
            almacenes.add(registro);
            pos++;
        }

        return almacenes;
    }
}
