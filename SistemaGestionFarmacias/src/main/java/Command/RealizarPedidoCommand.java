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

    /**
     * Crea una nueva instancia del comando para un pedido concreto.
     *
     * @param receiver Servicio que realizará las operaciones sobre el pedido.
     * @param pedido   Pedido que se desea realizar o cancelar mediante el comando.
     */
    public RealizarPedidoCommand(PedidoService receiver, Pedido pedido) {
        this.receiver = receiver;
        this.pedido = pedido;
    }

    /**
     * Ejecuta la operación principal del comando: realizar el pedido.
     * 
     * Internamente delega en {@link PedidoService#realizarPedido(Pedido)}.
     * 
     */
    @Override
    public void execute() {
        receiver.realizarPedido(pedido);
    }

    /**
     * Cancela o deshace la operación realizada por {@link #execute()}.
     * 
     * Internamente delega en {@link PedidoService#cancelarPedido(Pedido)}.
     * 
     */
    @Override
    public void cancel() {
        receiver.cancelarPedido(pedido);
    }
    
}
