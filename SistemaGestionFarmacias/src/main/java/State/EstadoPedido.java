/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package State;

import AbstractFactory.Medicamento;
import Decorator.Pedido;

/**
 *
 * @author Admin
 */
public interface EstadoPedido {
    
    /**
     * Añade un medicamento al pedido según las reglas del estado actual.
     * 
     * Algunos estados pueden permitir añadir medicamentos (Nuevo, Confirmado)
     * mientras que otros lo rechazan (Enviado, Entregado).
     *
     * @param medicamento Medicamento a añadir al pedido.
     * @param pedido      Pedido que está en este estado.
     * @throws UnsupportedOperationException Si el estado actual no permite añadir medicamentos.
     */
    public void anadirMedicamento(Medicamento medicamento, Pedido pedido);
    
    /**
     * Elimina un medicamento del pedido según las reglas del estado actual.
     * 
     * Algunos estados permiten eliminar (Nuevo) mientras que otros no (Preparando).
     *
     * @param medicamento Medicamento a eliminar del pedido.
     * @param pedido      Pedido que está en este estado.
     * @throws UnsupportedOperationException Si el estado actual no permite eliminar medicamentos.
     */
    public void eliminarMedicamento(Medicamento medicamento, Pedido pedido);
    
    /**
     * Selecciona el método de pago según las reglas del estado actual.
     *
     * Solo ciertos estados permiten cambiar el método de pago (Nuevo, Confirmado).
     *
     * @param tipo  Código del método de pago ({@link ElectorMetodoPago#TARJETA}, etc.).
     * @param pedido Pedido que está en este estado.
     * @throws UnsupportedOperationException Si el estado no permite seleccionar método de pago.
     */
    public void seleccionarMetodoPago(int tipo, Pedido pedido);
    
    /**
     * Confirma el pedido y transita al siguiente estado apropiado.
     * 
     * Típicamente pasa de "Nuevo" → "Confirmado".
     *
     * @param pedido Pedido a confirmar.
     * @throws UnsupportedOperationException Si el estado actual no permite confirmación.
     */
    public void confirmarPedido(Pedido pedido);
    
    /**
     * Inicia el proceso de envío del pedido.
     * 
     * Transita a estado "Enviado", notificando cambios.
     *
     * @param pedido Pedido a enviar.
     * @throws UnsupportedOperationException Si el pedido no está listo para envío.
     */
    public void enviarPedido(Pedido pedido);
        
    /**
     * Muestra información del estado actual del pedido al usuario.
     *
     * @param pedido Pedido cuyo estado se mostrará.
     */
    public void verEstadoPedido(Pedido pedido);
    
}
