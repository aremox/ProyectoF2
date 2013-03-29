package ControlAuxiliarCU.Ventas;

import EntidadesCU.Venta;

/*
 *
 * @author Ivan Arenas
 *
 */
public class AceptadorVentas {

    private String textoError = "";
    private Boolean resAceptar = true;
    private ControlServicioCU.ControladorServicioCargarVentas controlador;

    public AceptadorVentas(ControlServicioCU.ControladorServicioCargarVentas objeto) {
        controlador = objeto;
    }

    public boolean aceptar(Venta ven) {
        textoError = "";
        resAceptar = true;
        
        return (aceptarCliente(ven) && aceptarProducto(ven) && aceptarTienda(ven) && aceptarImporte(ven));
        
    }

    private boolean aceptarCliente(Venta ven) {
        if (resAceptar) {
            if (ven.getCliente() == null) {
                textoError = "Venta "+ controlador.getRegistroVentas().getId_venta() +" con incoherencia de datos, no se ha encontrado el cliente "+controlador.getRegistroVentas().getId_cliente()+" asociado a la venta";
                resAceptar = false;
            }
        }
        return resAceptar;
    }

    private boolean aceptarProducto(Venta ven) {
        if (resAceptar) {
            if (ven.getProducto() == null) {
                textoError = "Venta "+ controlador.getRegistroVentas().getId_venta() +" con incoherencia de datos, no se ha encontrado el producto "+controlador.getRegistroVentas().getId_producto()+" asociado a la venta";
                resAceptar = false;
            }
        }
        return resAceptar;
    }

    private boolean aceptarTienda(Venta ven) {
        if (resAceptar) {
            if (ven.getTienda() == null) {
                textoError = "Venta "+ controlador.getRegistroVentas().getId_venta() +" con incoherencia de datos, no se ha encontrado la tienda "+controlador.getRegistroVentas().getId_tienda()+" asociada a la venta";            
                resAceptar = false;
            }
        }
        return resAceptar;
    }

    private boolean aceptarImporte(Venta ven) {
        if (resAceptar) {
            // Comprobamos que el importe es un número
            try {
                float importe = Float.parseFloat(ven.getImporte());
                // El importe si es nuérico 
            } catch (NumberFormatException nfe) {
                // El importe no es nuérico
                textoError = "Venta "+ controlador.getRegistroVentas().getId_venta() +" con incoherencia de datos, el importe ["+ controlador.getRegistroVentas().getImporte()+"] asociado a la venta no es numérico";
                resAceptar = false;
            }
        }
        return resAceptar;
    }

    public String getTextoError() {
        return textoError;
    }
}
