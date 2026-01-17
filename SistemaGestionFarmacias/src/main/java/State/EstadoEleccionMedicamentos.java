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
public class EstadoEleccionMedicamentos implements EstadoPedido{
    
    /**
     * {@inheritDoc}
     * 
     * Permitido: Añade el medicamento directamente a la lista del pedido.
     * 
     */
    @Override
    public void anadirMedicamento(Medicamento medicamento, Pedido pedido) {
        pedido.getMedicamentos().add(medicamento);
    }
    
    /**
     * {@inheritDoc}
     * 
     * Permitido: Elimina el medicamento de la lista del pedido.
     * 
     */
    @Override
    public void eliminarMedicamento(Medicamento medicamento, Pedido pedido) {
        pedido.getMedicamentos().remove(medicamento);
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: No se puede seleccionar método de pago sin medicamentos.
     * 
     */
    @Override
    public void seleccionarMetodoPago(int tipo, Pedido pedido) {
        System.out.println("ERROR: Primero debe elegir medicamentos para su pedido");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: No se puede confirmar pedido sin medicamentos seleccionados.
     * 
     */
    @Override
    public void confirmarPedido(Pedido pedido) {
        System.out.println("ERROR: Primero debe elegir medicamentos para su pedido");
        throw new IllegalArgumentException("Primero debe elegir un metodo de pago");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: No se puede enviar pedido sin medicamentos.
     * 
     */
    @Override
    public void enviarPedido(Pedido pedido) {
        System.out.println("ERROR: Primero debe elegir medicamentos para su pedido");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Estado inicial no tiene información relevante para mostrar.
     * 
     */
    @Override
    public void verEstadoPedido(Pedido pedido) {
        System.out.println("ERROR: Primero debe elegir medicamentos para su pedido");
    }
    
}
