/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

import AbstractFactory.Medicamento;
import Observer.Notificador;
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
    
    @Override
    public String getId() {
        return pedido.getId();
    }
    
    @Override
    public String getEstado() {
        return pedido.getEstado();
    }
    
    @Override
    public void setEstado(String estado) {
        this.pedido.setEstado(estado);
    }
    
    @Override
    public void marcarComoListo() {
        setEstado("Listo");
        pedido.getNotificador().actualizar();
    }
    
    @Override
    public Notificador getNotificador() {
        return pedido.getNotificador();
    }
    
    @Override
    public void setNotificador(Notificador notificador) {
        this.pedido.setNotificador(notificador);
    }
    
    public abstract void aplicarDescuento();
    
}
