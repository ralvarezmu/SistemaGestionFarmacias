/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

import AbstractFactory.Medicamento;
import Decorator.Pedido;
import FactoryMethod.ElectorMetodoPago;

/**
 *
 * @author Admin
 */
public class EstadoEleccionMetodoPago implements EstadoPedido{
    
    private ElectorMetodoPago elector;
    
    /**
     * Constructor que inicializa el elector de métodos de pago mediante Singleton.
     */
    public EstadoEleccionMetodoPago() {
        this.elector = ElectorMetodoPago.getInstancia();
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: No se pueden añadir medicamentos una vez seleccionado el pago.
     * 
     */
    @Override
    public void anadirMedicamento(Medicamento medicamento, Pedido pedido) {
        System.out.println("ERROR: Pedido pendiente de pago, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: No se pueden eliminar medicamentos una vez seleccionado el pago.
     * 
     */
    @Override
    public void eliminarMedicamento(Medicamento medicamento, Pedido pedido) {
        System.out.println("ERROR: Pedido pendiente de pago, imposible modficar");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Permitido: Selecciona el método de pago mediante el {@link ElectorMetodoPago}
     * y lo asigna al pedido.
     *
     * @param tipo Código del método de pago (0=Tarjeta, 1=PayPal, 2=Bizum).
     */
    @Override
    public void seleccionarMetodoPago(int tipo, Pedido pedido) {
        pedido.setMetodoPago(elector.elegirMetodoPago(tipo));
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: No se puede confirmar hasta seleccionar método de pago.
     * 
     */
    @Override
    public void confirmarPedido(Pedido pedido) {
        System.out.println("ERROR: Primero debe elegir un metodo de pago");
        throw new IllegalArgumentException("Primero debe elegir un metodo de pago");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: No se puede enviar sin método de pago seleccionado.
     * 
     */
    @Override
    public void enviarPedido(Pedido pedido) {
        System.out.println("ERROR: Primero debe elegir un metodo de pago");
    }
    
    /**
     * {@inheritDoc}
     * 
     * Bloqueado: Estado intermedio no tiene información completa para mostrar.
     * 
     */
    @Override
    public void verEstadoPedido(Pedido pedido) {
        System.out.println("ERROR: Primero debe elegir un metodo de pago");
    }
    
}
