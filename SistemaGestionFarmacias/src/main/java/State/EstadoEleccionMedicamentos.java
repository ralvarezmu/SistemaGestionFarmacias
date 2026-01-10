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
    
    @Override
    public void anadirMedicamento(Medicamento medicamento, Pedido pedido) {
        pedido.getMedicamentos().add(medicamento);
    }
    
    @Override
    public void eliminarMedicamento(Medicamento medicamento, Pedido pedido) {
        pedido.getMedicamentos().remove(medicamento);
    }
    
    @Override
    public void seleccionarMetodoPago(int tipo, Pedido pedido) {
        System.out.println("ERROR: Primero debe elegir medicamentos para su pedido");
    }
    
    @Override
    public void confirmarPedido(Pedido pedido) {
        System.out.println("ERROR: Primero debe elegir medicamentos para su pedido");
        throw new IllegalArgumentException("Primero debe elegir un metodo de pago");
    }
    
    @Override
    public void enviarPedido(Pedido pedido) {
        System.out.println("ERROR: Primero debe elegir medicamentos para su pedido");
    }
    
    @Override
    public void verEstadoPedido(Pedido pedido) {
        System.out.println("ERROR: Primero debe elegir medicamentos para su pedido");
    }
    
}
