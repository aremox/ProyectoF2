package ControlAuxiliarCU;

/*
 *
 * @author Ivan Arenas
 *
 */

public class RegistroVentas {

    private String id_venta;
    private String id_cliente;
    private String id_producto;
    private String id_tienda;
    private String unidades;
    private String importe;
    private String fecha;

    public RegistroVentas(String at1, String at2, String at3, String at4, String at5, String at6, String at7) {
        id_venta = at1;
        id_cliente = at2;
        id_producto = at3;
        id_tienda = at4;
        unidades = at5;
        importe = at6;
        fecha = at7;

    }
    
    public String getId_venta(){
        return id_venta;
    }
    public String getId_cliente(){
        return id_cliente;
    }
    public String getId_producto(){
        return id_producto;
    }
    public String getId_tienda(){
        return id_tienda;
    }
    public String getUnidades(){
        return unidades;
    }
    public String getImporte(){
        return importe;
    }
    public String geFecha(){
        return fecha;
    }
}
