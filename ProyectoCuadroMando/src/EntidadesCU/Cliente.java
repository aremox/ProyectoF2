/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesCU;

/**
 *
 * @author ivan
 */
public class Cliente {
     private String id_cliente;
     
     
     public Cliente(String at1) {
        id_cliente = at1;
       
    }
    
    public String getId_cliente(){
        return id_cliente;
    }
}
