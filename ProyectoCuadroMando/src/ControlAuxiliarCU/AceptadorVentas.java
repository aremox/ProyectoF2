package ControlAuxiliarCU;

import EntidadesCU.Venta_ADO;

/*
 *
 * @author Ivan Arenas
 *
 */
public class AceptadorVentas {

    private String textoError = "";
    private Boolean resAceptar = true;

    public AceptadorVentas() {
    }

    public boolean validar(Venta_ADO ven) {
        textoError = "";
        resAceptar = true;

        return (aceptarCliente(ven) && aceptarProducto(ven) && aceptarTienda(ven) && aceptarImporte(ven));

    }

    private boolean aceptarCliente(Venta_ADO ven) {
        if (resAceptar) {
            if (ven.getCliente() == null) {

                textoError = "Venta " + ven.getId_venta() + " con incoherencia de datos, no se ha encontrado el CLIENTE asociado la venta";
                resAceptar = false;
            }
        }
        return resAceptar;
    }

    private boolean aceptarProducto(Venta_ADO ven) {
        if (resAceptar) {
            if (ven.getProducto() == null) {
                textoError = "Venta " + ven.getId_venta() + " con incoherencia de datos, no se ha encontrado el PRODUCTO asociado a la venta";
                resAceptar = false;
            }
          
        }
        return resAceptar;
    }

    private boolean aceptarTienda(Venta_ADO ven) {
        if (resAceptar) {
            if (ven.getTienda() == null) {
                textoError = "Venta " + ven.getId_venta() + " con incoherencia de datos, no se ha encontrado la TIENDA asociada a la venta";
                resAceptar = false;
            }
        }
        return resAceptar;
    }

    private boolean aceptarImporte(Venta_ADO ven) {
        if (resAceptar) {
            // Comprobamos si está vacío
            if ("".equals(ven.getImporte())) {
                textoError = "Venta " + ven.getId_venta() + " con incoherencia de datos, el campo IMPORTE está vacío";
                resAceptar = false;
            } else {
                // Importe no está vacío
                // Comprobamos que el importe es un número
                try {
                    float importe = Float.parseFloat(ven.getImporte());
                    // El importe si es numérico 
                } catch (NumberFormatException nfe) {
                    // El importe no es numérico
                    textoError = "Venta " + ven.getId_venta() + " con incoherencia de datos, el importe [" + ven.getImporte() + "] asociado a la venta no es numérico";
                    resAceptar = false;
                }

            }
        }

        return resAceptar;
    }

    public String getTextoError() {
        return textoError;
    }
}
