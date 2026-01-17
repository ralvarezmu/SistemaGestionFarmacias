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
public class EstadoEntregado implements EstadoPedido{
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Pedido entregado no admite modificaciones.
     * 
     */
    @Override
    public void anadirMedicamento(Medicamento medicamento, Pedido pedido) {
        System.out.println("ERROR: Pedido confirmado, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Pedido entregado no admite modificaciones.
     * 
     */
    @Override
    public void eliminarMedicamento(Medicamento medicamento, Pedido pedido) {
        System.out.println("ERROR: Pedido confirmado, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Pedido entregado no admite cambios de pago.
     * 
     */
    @Override
    public void seleccionarMetodoPago(int tipo, Pedido pedido) {
        System.out.println("ERROR: Pedido confirmado, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     *
     * Información: El pedido ya está confirmado y entregado.
     * 
     */
    @Override
    public void confirmarPedido(Pedido pedido) {
        System.out.println("Pedido confirmado");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Pedido ya entregado, no se puede reenviar.
     * 
     */
    @Override
    public void enviarPedido(Pedido pedido) {
        System.out.println("ERROR: Pedido confirmado, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Permitido: Muestra el estado final del pedido.
     * 
     */
    @Override
    public void verEstadoPedido(Pedido pedido) {
        System.out.println("Pedido entregado");
    }
    
}
