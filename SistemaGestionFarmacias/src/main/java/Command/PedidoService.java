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

    public void realizarPedido(Pedido pedido) {
        pedidosRealizados.put(pedido.getId(), pedido);
        System.out.println("✅ Pedido realizado -> ID: " + pedido.getId()
                + " | Importe: " + pedido.getImporte());
    }

    public void cancelarPedido(Pedido pedido) {
        Pedido eliminado = pedidosRealizados.remove(pedido.getId());
        if (eliminado != null) {
            System.out.println("↩️ Pedido deshecho/cancelado -> ID: " + pedido.getId());
        } else {
            System.out.println("⚠️ No se pudo deshacer: el pedido no estaba registrado -> ID: " + pedido.getId());
        }
    }

    public boolean existePedido(String idPedido) {
        return pedidosRealizados.containsKey(idPedido);
    }
    
}
