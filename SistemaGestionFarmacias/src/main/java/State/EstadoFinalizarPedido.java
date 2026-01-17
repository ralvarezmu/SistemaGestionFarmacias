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
public class EstadoFinalizarPedido implements EstadoPedido {
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Pedido listo para confirmar no admite cambios de contenido.
     * 
     */
    @Override
    public void anadirMedicamento(Medicamento medicamento, Pedido pedido) {
        System.out.println("ERROR: Pedido pendiente de confirmacion, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Pedido listo para confirmar no admite cambios de contenido.
     * 
     */
    @Override
    public void eliminarMedicamento(Medicamento medicamento, Pedido pedido) {
        System.out.println("ERROR: Pedido pendiente de confirmacion, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Método de pago ya seleccionado, no modificable.
     * 
     */
    @Override
    public void seleccionarMetodoPago(int tipo, Pedido pedido) {
        System.out.println("ERROR: Pedido pendiente de confirmacion, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     *
     * Permitido (ÚNICA OPERACIÓN): Confirma el pedido y realiza transición automática:
     * 
     *   Cambia estado a {@link EstadoPreparacion}
     *   Inicia proceso de preparación ({@link Pedido#prepararPedido()})
     * 
     * 
     */
    @Override
    public void confirmarPedido(Pedido pedido) {
        System.out.println("Pedido confirmado");
        EstadoPedido preparacion = new EstadoPreparacion();
        pedido.setEstado(preparacion);
        pedido.prepararPedido();
    }
    
    /**
     * {@inheritDoc}
     *
     * Bloqueado: No se puede enviar sin confirmar primero.
     * 
     */
    @Override
    public void enviarPedido(Pedido pedido) {
        System.out.println("ERROR: Pedido pendiente de confirmacion, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Requiere confirmación previa para mostrar estado completo.
     * 
     */
    @Override
    public void verEstadoPedido(Pedido pedido) {
        System.out.println("ERROR: Primero debe confirmar el pedido");
    }
    
}
