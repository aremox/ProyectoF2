package ControlAuxiliarCU;

import ControlAuxiliarCU.ProveedorInformacion;
import ControlAuxiliarCU.ArchivoLog;
import java.io.File;
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

    public ProveedorInformacionProductos(String separador) throws FileNotFoundException {
        super(separador);
    }

    @Override
    public LinkedList extraer(String ruta) {
        archivo = new File(ruta);
        productos = new LinkedList<RegistroProductos>();


        try {
            if (comprobarFlujo()) {
                String[] elementos;
                StringTokenizer tokens;
                leerLineaRegistro();
                int tam = lineas.size();
                int pos = 0; //Mientras haya elementos 

                while (pos <= tam - 1) {
                    String linea = (String) lineas.get(pos);
                    //tokens = new StringTokenizer(linea, separadorCampos);
                    //elementos = new String[tokens.countTokens()];
                    elementos = linea.split("\\--");
                
                    RegistroProductos registro = new RegistroProductos(elementos[0], elementos[1], elementos[2], elementos[3]);
                    productos.add(registro);
                    pos++;
                }
            }
        } catch (IOException ex) {
        }

        return productos;
    }
}
