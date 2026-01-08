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
    
    public EstadoEleccionMetodoPago() {
        this.elector = ElectorMetodoPago.getInstancia();
    }
        
    @Override
    public void anadirMedicamento(Medicamento medicamento, Pedido pedido) {
        System.out.println("ERROR: Pedido pendiente de pago, imposible modficar");
    }
    
    @Override
    public void eliminarMedicamento(Medicamento medicamento, Pedido pedido) {
        System.out.println("ERROR: Pedido pendiente de pago, imposible modficar");
    }
    
    @Override
    public void seleccionarMetodoPago(int tipo, Pedido pedido) {
        pedido.setMetodoPago(elector.elegirMetodoPago(tipo));
    }
    
    @Override
    public void confirmarPedido(Pedido pedido) {
        System.out.println("ERROR: Primero debe elegir un metodo de pago");
    }
    
    @Override
    public void enviarPedido(Pedido pedido) {
        System.out.println("ERROR: Primero debe elegir un metodo de pago");
    }
    
    @Override
    public void verEstadoPedido(Pedido pedido) {
        System.out.println("ERROR: Primero debe elegir un metodo de pago");
    }
    
}
