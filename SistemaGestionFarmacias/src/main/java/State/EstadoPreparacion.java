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
    
    @Override
    public void anadirMedicamento(Medicamento medicamento, Pedido pedido) {
        System.out.println("ERROR: Pedido confirmado, imposible modficar");
    }
    
    @Override
    public void eliminarMedicamento(Medicamento medicamento, Pedido pedido) {
        System.out.println("ERROR: Pedido confirmado, imposible modficar");
    }
    
    @Override
    public void seleccionarMetodoPago(String metodo, Pedido pedido) {
        System.out.println("ERROR: Pedido confirmado, imposible modficar");
    }
    
    @Override
    public void confirmarPedido(Pedido pedido) {
        System.out.println("Pedido confirmado");
        pedido.prepararPedido();
    }
    
    @Override
    public void enviarPedido(Pedido pedido) {
        System.out.println("ERROR: Pedido pendiente de confirmacion, imposible modficar");
    }

    @Override
    public void verEstadoPedido(Pedido pedido) {
        System.out.println("Pedido en preparacion");
    }
    
}
