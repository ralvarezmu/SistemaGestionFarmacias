/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Decorator.Pedido;

/**
 *
 * @author sete
 */
public class RealizarPedidoCommand implements Command{
    
    private final PedidoService receiver;
    private final Pedido pedido;

    public RealizarPedidoCommand(PedidoService receiver, Pedido pedido) {
        this.receiver = receiver;
        this.pedido = pedido;
    }

    @Override
    public void execute() {
        receiver.realizarPedido(pedido);
    }

    @Override
    public void cancel() {
        receiver.cancelarPedido(pedido);
    }
    
}
