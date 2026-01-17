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
public class PedidoDescuentoNumeroProductos extends Decorador{
    
    /**
     * Crea un nuevo decorador que aplicará el descuento por número de productos
     * sobre el pedido indicado.
     *
     * @param pedido Pedido original a decorar.
     */
    public PedidoDescuentoNumeroProductos(Pedido pedido) {
        super(pedido);
    }
    
    /**
     * Aplica el descuento configurado al importe del pedido decorado.
     * 
     * El importe se recalcula como el 75 % del importe actual.
     * 
     */
    @Override
    public void aplicarDescuento() {
        super.setImporte(super.getImporte() * 0.75);
    }
    
}
