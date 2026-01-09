/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionfarmacias;

import AbstractFactory.Medicamento;
import Decorator.Pedido;
import Decorator.PedidoBase;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ServicioPedido {
    
    private Pedido pedido;
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public Pedido getPedido() {
        return pedido;
    }
    
    public void crearPedido(String cliente) {
        ArrayList<Medicamento> medicamentosPedido = new ArrayList<>();
        
        // Crear el pedido
        this.pedido = new PedidoBase("1", cliente, LocalDate.now(), medicamentosPedido);
    }
    
}
