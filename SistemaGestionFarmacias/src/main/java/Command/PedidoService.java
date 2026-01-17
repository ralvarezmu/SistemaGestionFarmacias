/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Decorator.Pedido;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sete
 */
public class PedidoService {
    
    private final Map<String, Pedido> pedidosRealizados = new HashMap<>();

    /**
     * Registra un nuevo pedido como realizado.
     *
     * @param pedido Pedido que se desea registrar.
     */
    public void realizarPedido(Pedido pedido) {
        pedidosRealizados.put(pedido.getId(), pedido);
        System.out.println("✅ Pedido realizado -> ID: " + pedido.getId()
                + " | Importe: " + pedido.getImporte());
    }

    /**
     * Cancela un pedido previamente realizado, si está registrado.
     *
     * @param pedido Pedido que se desea cancelar o deshacer.
     */
    public void cancelarPedido(Pedido pedido) {
        Pedido eliminado = pedidosRealizados.remove(pedido.getId());
        if (eliminado != null) {
            System.out.println("↩️ Pedido deshecho/cancelado -> ID: " + pedido.getId());
        } else {
            System.out.println("⚠️ No se pudo deshacer: el pedido no estaba registrado -> ID: " + pedido.getId());
        }
    }

    /**
     * Comprueba si existe un pedido registrado con el identificador proporcionado.
     *
     * @param idPedido Identificador del pedido que se desea verificar.
     * @return {@code true} si el pedido está registrado, {@code false} en caso contrario.
     */
    public boolean existePedido(String idPedido) {
        return pedidosRealizados.containsKey(idPedido);
    }
    
}
