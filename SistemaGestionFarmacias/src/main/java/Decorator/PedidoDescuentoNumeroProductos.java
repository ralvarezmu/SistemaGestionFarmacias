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
    
    public PedidoDescuentoNumeroProductos(Pedido pedido) {
        super(pedido);
    }
    
    @Override
    public void aplicarDescuento() {
        super.setImporte(super.getImporte().multiply(new BigDecimal("0.75")));
    }
    
}
