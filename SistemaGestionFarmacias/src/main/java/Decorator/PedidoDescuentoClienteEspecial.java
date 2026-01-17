/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class PedidoDescuentoClienteEspecial extends Decorador{
    
    /**
     * Crea un nuevo decorador de pedido para cliente especial.
     *
     * @param pedido Pedido original sobre el que se aplicará el descuento.
     */
    public PedidoDescuentoClienteEspecial(Pedido pedido) {
        super(pedido);
    }
    
    /**
     * Aplica el descuento especial al importe del pedido decorado.
     * 
     * El importe se recalcula como el 40 % del importe actual.
     * 
     */
    @Override
    public void aplicarDescuento() {
        super.setImporte(super.getImporte() * 0.40);
    }

    
}
