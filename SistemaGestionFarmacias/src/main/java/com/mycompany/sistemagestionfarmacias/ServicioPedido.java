/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionfarmacias;

import AbstractFactory.Medicamento;
import Decorator.Pedido;
import Decorator.PedidoBase;
import State.EstadoEleccionMedicamentos;
import State.EstadoEleccionMetodoPago;
import State.EstadoFinalizarPedido;
import State.EstadoPedido;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ServicioPedido {
    
    private Pedido pedido;
    private EstadoPedido estado1 = new EstadoEleccionMedicamentos();
    private EstadoPedido estado2 = new EstadoEleccionMetodoPago();
    private EstadoPedido estado3 = new EstadoFinalizarPedido();
    
    public void setPedido(Pedido ped) {
        this.pedido = ped;
    }
    
    public Pedido getPedido() {
        return pedido;
    }
    
    public void crearPedido(String cliente) {
        ArrayList<Medicamento> medicamentosPedido = new ArrayList<>();
        
        // Crear el pedido
        this.pedido = new PedidoBase("1", cliente, LocalDate.now(), medicamentosPedido);
        pedido.setEstado(estado1);
    }
    
    public Boolean pasarPago() {
        if (!pedido.getMedicamentos().isEmpty()) {
            pedido.setEstado(estado2);
            return true;
        }
        return false;
    }
    
    public void actualizarImpoerte() {
        pedido.calcularImporte();
    }
    
}
