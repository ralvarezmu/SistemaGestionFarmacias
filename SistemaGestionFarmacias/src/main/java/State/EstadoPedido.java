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
    
    public void anadirMedicamento(Medicamento medicamento, Pedido pedido);
    
    public void eliminarMedicamento(Medicamento medicamento, Pedido pedido);
    
    public void seleccionarMetodoPago(String metodo, Pedido pedido);
    
    public void confirmarPedido(Pedido pedido);
    
    public void enviarPedido(Pedido pedido);
        
    public void verEstadoPedido(Pedido pedido);
    
}
