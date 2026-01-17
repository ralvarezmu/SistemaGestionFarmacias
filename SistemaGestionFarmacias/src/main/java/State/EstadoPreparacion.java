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
public class EstadoPreparacion implements EstadoPedido{
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Pedido confirmado no admite modificaciones de contenido.
     * 
     */
    @Override
    public void anadirMedicamento(Medicamento medicamento, Pedido pedido) {
        System.out.println("ERROR: Pedido confirmado, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Pedido confirmado no admite modificaciones de contenido.
     * 
     */
    @Override
    public void eliminarMedicamento(Medicamento medicamento, Pedido pedido) {
        System.out.println("ERROR: Pedido confirmado, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Método de pago ya seleccionado e inmutable.
     * 
     */
    @Override
    public void seleccionarMetodoPago(int tipo, Pedido pedido) {
        System.out.println("ERROR: Pedido confirmado, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Información: Pedido ya confirmado, actualmente en fase de preparación.
     * Reinvoca {@link Pedido#prepararPedido()} para mantener el flujo.
     * 
     */
    @Override
    public void confirmarPedido(Pedido pedido) {
        System.out.println("Pedido confirmado");
        pedido.prepararPedido();
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Preparación debe completarse antes del envío.
     * 
     */
    @Override
    public void enviarPedido(Pedido pedido) {
        System.out.println("ERROR: Pedido pendiente de confirmacion, imposible modficar");
    }

    /**
     * {@inheritDoc}
     *
     * Permitido: Muestra el estado actual de preparación.
     * 
     */
    @Override
    public void verEstadoPedido(Pedido pedido) {
        System.out.println("Pedido en preparacion");
    }
    
}
