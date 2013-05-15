package ContenedoresCU;

import EntidadesCU.Cliente_ADO;
import EntidadesCU.Tienda_ADO;
import EntidadesCU.Venta_ADO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;

/*
 *
 * @author Ivan Arenas
 *
 */
public class ContenedorVentasSingleton {

    private LinkedList<Venta_ADO> coleccionElementos;
    private static ContenedorVentasSingleton _instancia;

    private ContenedorVentasSingleton() {
        coleccionElementos = new LinkedList<Venta_ADO>();
    }

    public static ContenedorVentasSingleton getInstancia() {
        if (_instancia == null) {
            //Si la instancia no se ha creado crearla 
            _instancia = new ContenedorVentasSingleton();
        }
        return _instancia;
    }

    public void almacenar(Venta_ADO ven) {
        coleccionElementos.add(ven);
    }

    public Venta_ADO getVenta(String id) {
        Venta_ADO ven_resultado = null;
        int tam = coleccionElementos.size();
        int cont = 0;
        for (int i = 0; i < tam; i++) {
            Venta_ADO ven = (Venta_ADO) coleccionElementos.get(i);
            if (ven.getId_venta().equals(id)) {
                ven_resultado = ven;
                break;
            }
            cont++;
        }
        return ven_resultado;
    }

    public void borrarElementos() throws SQLException {
        if (null != coleccionElementos) {
            int tam = coleccionElementos.size();

            for (int i = 0; i < tam; i++) {
                Venta_ADO elemento = (Venta_ADO) coleccionElementos.get(i);
                elemento.borrar();
            }
            coleccionElementos.clear();
        }
    }

    public void grabarElementos() throws SQLException, ParseException {
        int tam = coleccionElementos.size();

        for (int i = 0; i < tam; i++) {
            Venta_ADO elemento = (Venta_ADO) coleccionElementos.get(i);
            elemento.grabar();
        }
    }

    public LinkedList getVentas() {
        return coleccionElementos;
    }

    public Tienda_ADO getMayor_Venta() {
        int tam = coleccionElementos.size();
        for (int i = 0; i < tam; i++) {
            Venta_ADO elemento = (Venta_ADO) coleccionElementos.get(i);
            elemento.getTienda().setN_ventas();
        }
        Tienda_ADO tienda = coleccionElementos.get(0).getTienda();
        for (int i = 0; i < tam; i++) {
            Tienda_ADO elemento = (Tienda_ADO) coleccionElementos.get(i).getTienda();

            if (tienda.getN_ventas() < elemento.getN_ventas()) {
                tienda = elemento;
            }
        }
        return tienda;
    }

    public Cliente_ADO getInfuenciaTienda(Tienda_ADO tienda) {
        double diametro = 0, ca1 = 0, ca2 = 0, hi = 0;
        Cliente_ADO cliente = null;
        int tam = coleccionElementos.size();

        for (int i = 0; i < tam; i++) {
            Venta_ADO elemento = (Venta_ADO) coleccionElementos.get(i);
            if (elemento.getTienda().equals(tienda)) {
                ca1 = Math.abs(elemento.getTienda().getX() - elemento.getCliente().getX());
                ca2 = Math.abs(elemento.getTienda().getY() - elemento.getCliente().getY());
                hi = Math.hypot(ca1, ca2);
                if (hi > diametro) {
                    diametro = hi;
                    cliente = elemento.getCliente();
                }
            }
        }
        return cliente;
    }

    public float getDiametroInfuencia(Tienda_ADO tienda, Cliente_ADO cliente) {
       
        float ca1 = 0, ca2 = 0, hi = 0;
        ca1 = Math.abs(tienda.getX() - cliente.getX());
        ca2 = Math.abs(tienda.getY() - cliente.getY());
        hi = (float) Math.hypot(ca1, ca2);



        return hi;

    }
}
