/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Decorator.Pedido;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    
        /**
     * Obtiene un pedido registrado a partir de su identificador.
     *
     * @param idPedido Identificador del pedido que se desea obtener.
     * @return {@link Pedido} correspondiente al ID indicado, o {@code null} si no existe.
     */
    public Pedido getPedido(String idPedido) {
        return pedidosRealizados.get(idPedido);
    }

    /**
     * Cancela un pedido registrado utilizando su identificador.
     *
     * Este método es útil para operaciones desde la interfaz gráfica,
     * donde solo se dispone del ID del pedido seleccionado.
     *
     * @param idPedido Identificador del pedido que se desea cancelar.
     * @throws RuntimeException Si el ID es nulo, está vacío o el pedido no existe.
     */
    public void cancelarPedidoPorId(String idPedido) {
        if (idPedido == null || idPedido.trim().isEmpty()) {
            throw new RuntimeException("ID de pedido vacío.");
        }

        Pedido pedido = pedidosRealizados.get(idPedido);
        if (pedido == null) {
            throw new RuntimeException("El pedido no existe.");
        }

        cancelarPedido(pedido);
    }

    /**
     * Devuelve una lista con todos los pedidos registrados en el sistema.
     *
     * Este método es útil para pantallas de administración o depuración.
     *
     * @return Lista de todos los pedidos realizados.
     */
    public List<Pedido> getTodosLosPedidos() {
        return new ArrayList<>(pedidosRealizados.values());
    }

    /**
     * Devuelve todos los pedidos realizados por un cliente concreto.
     *
     * @param nombreCliente Nombre del cliente cuyos pedidos se desean consultar.
     * @return Lista de pedidos asociados al cliente indicado.
     */
    public List<Pedido> getPedidosDeCliente(String nombreCliente) {
        List<Pedido> resultado = new ArrayList<>();

        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            return resultado;
        }

        for (Pedido pedido : pedidosRealizados.values()) {
            if (pedido.getUsuario().equalsIgnoreCase(nombreCliente)) {
                resultado.add(pedido);
            }
        }

        return resultado;
    }
}
