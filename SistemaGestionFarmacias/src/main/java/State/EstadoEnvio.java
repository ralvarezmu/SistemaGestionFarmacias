/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

import AbstractFactory.Medicamento;
import Decorator.Pedido;

/**
 *
 * @author Admin
 */
public class EstadoEnvio implements EstadoPedido{
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Pedido en tránsito no admite modificaciones de contenido.
     * 
     */
    @Override
    public void anadirMedicamento(Medicamento medicamento, Pedido pedido) {
        System.out.println("ERROR: Pedido confirmado, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Pedido en tránsito no admite modificaciones de contenido.
     * 
     */
    @Override
    public void eliminarMedicamento(Medicamento medicamento, Pedido pedido) {
        System.out.println("ERROR: Pedido confirmado, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Método de pago ya seleccionado, no modificable en tránsito.
     * 
     */
    @Override
    public void seleccionarMetodoPago(int tipo, Pedido pedido) {
        System.out.println("ERROR: Pedido confirmado, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Información: Pedido ya confirmado, actualmente en fase de envío.
     * 
     */
    @Override
    public void confirmarPedido(Pedido pedido) {
        System.out.println("Pedido confirmado");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Permitido: Completa el proceso de envío delegando al pedido.
     * Transición hacia estado final de entrega.
     * 
     */
    @Override
    public void enviarPedido(Pedido pedido) {
        pedido.enviarPedido();
    }
    
    /**
     * {@inheritDoc}
     * 
     * Permitido: Muestra el estado actual "Pedido en envío".
     * 
     */
    @Override
    public void verEstadoPedido(Pedido pedido) {
        System.out.println("Pedido en envio");
    }
    
}
