/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Decorator;

import java.time.LocalDate;
import AbstractFactory.Medicamento;
import Observer.Notificador;
import State.EstadoPedido;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface Pedido {
    
    public String getId();
    
    public String getUsuario();
    
    public LocalDate getFecha();
    
    public ArrayList<Medicamento> getMedicamentos();
    
    public BigDecimal getImporte();
    
    public void setImporte(BigDecimal importe);
    
    public EstadoPedido getEstado();
    
    public void setEstado(EstadoPedido estado);
    
    public String getMetodoPago();
    
    public void setMetodoPago(String metodo);
    
    public Notificador getNotificador();
    
    public void setNotificador(Notificador notificador);
    
    public void marcarComoListo();
    
    public void anadirMedicamento(Medicamento medicamento);
    
    public void eliminarMedicamento(Medicamento medicamento);
    
    public void seleccionarMetodoPago(String metodo);
    
    public void confirmarPedido();
    
    public void verEstadoPedido();
    
    public void prepararPedido();
    
    public void enviarPedido();
}
