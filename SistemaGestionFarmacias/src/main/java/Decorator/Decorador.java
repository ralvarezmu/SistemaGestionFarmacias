/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

import AbstractFactory.Medicamento;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public abstract class Decorador implements Pedido{
    
    private Pedido pedido;
    
    public Decorador(Pedido pedido) {
        this.pedido = pedido;
    }
    
    @Override
    public String getUsuario() {
        return pedido.getUsuario();
    }
    
    @Override
    public LocalDate getFecha() {
        return pedido.getFecha();
    }
    
    @Override
    public ArrayList<Medicamento> getMedicamentos() {
        return pedido.getMedicamentos();
    }
    
    @Override
    public BigDecimal getImporte() {
        return pedido.getImporte();
    }
    
    @Override
    public void setImporte(BigDecimal importe) {
        this.pedido.setImporte(importe);
    }
    
    public abstract void aplicarDescuento();
    
}
