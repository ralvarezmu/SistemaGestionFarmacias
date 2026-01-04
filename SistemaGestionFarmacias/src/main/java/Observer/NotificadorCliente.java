/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import Decorator.Pedido;

/**
 *
 * @author Admin
 */
public class NotificadorCliente implements Notificador{
    
    private String cliente;
    private Pedido pedido;
    
    public NotificadorCliente(String nombreCliente, Pedido pedido) {
        this.cliente = nombreCliente;
        this.pedido = pedido;
    }
    
    @Override
    public void actualizar() {
        //if(pedido.getEstado().equals("Listo")) {
            System.out.println(cliente + ", tu pedido esta listo");
        //} 
    }
    
}
