/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesCU;

/**
 *
 * @author ivan
 */
public class Venta {

    private String id_venta;
    private Cliente cliente;
    private Articulo articulo;
    private Tienda tienda;
    private String unidades;
    private String importe;
    private String fecha;

    public Venta(String at1, Cliente at2, Articulo at3, Tienda at4, String at5, String at6, String at7) {
        id_venta = at1;
        cliente = at2;
        articulo = at3;
        tienda = at4;
        unidades = at5;
        importe = at6;
        fecha = at7;

    }
    
    public String getId_venta(){
        return id_venta;
    }
}
