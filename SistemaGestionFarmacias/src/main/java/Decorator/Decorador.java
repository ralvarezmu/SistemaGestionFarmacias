/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

import AbstractFactory.Medicamento;
import FactoryMethod.MetodoPago;
import Observer.Notificador;
import State.EstadoPedido;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public abstract class Decorador implements Pedido{
    
    private Pedido pedido;
    
    /**
     * Crea un nuevo decorador envolviendo el pedido indicado.
     *
     * @param pedido Pedido que se va a decorar.
     */
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
    public double getImporte() {
        return pedido.getImporte();
    }
    
    @Override
    public void setImporte(double importe) {
        this.pedido.setImporte(importe);
    }
    
    @Override
    public double calcularImporte() {
        return pedido.calcularImporte();
    }
    
    @Override
    public String getId() {
        return pedido.getId();
    }
    
    @Override
    public EstadoPedido getEstado() {
        return pedido.getEstado();
    }
    
    @Override
    public void setEstado(EstadoPedido estado) {
        this.pedido.setEstado(estado);
    }
    
    @Override
    public MetodoPago getMetodoPago() {
        return pedido.getMetodoPago();
    }
    
    @Override
    public void setMetodoPago(MetodoPago metodo) {
        this.pedido.setMetodoPago(metodo);
    }
    
    /**
     * Marca el pedido como listo y notifica a los observadores mediante el notificador.
     */
    @Override
    public void marcarComoListo() {
        //setEstado("Listo");
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
    
    /**
     * Añade un medicamento al pedido respetando las reglas del estado actual.
     */
    @Override
    public void anadirMedicamento(Medicamento medicamento) {
        this.pedido.getEstado().anadirMedicamento(medicamento, this);
    }
    
    /**
     * Elimina un medicamento del pedido respetando las reglas del estado actual.
     */
    @Override
    public void eliminarMedicamento(Medicamento medicamento) {
        this.pedido.getEstado().eliminarMedicamento(medicamento, this);
    }
    
    /**
     * Selecciona método de pago delegando en la lógica del estado actual.
     */
    @Override
    public void seleccionarMetodoPago(int tipo) {
        this.pedido.getEstado().seleccionarMetodoPago(tipo, this);
    }
    
    /**
     * Confirma el pedido según las reglas del estado actual.
     */
    @Override
    public void confirmarPedido() {
        this.pedido.getEstado().confirmarPedido(this);
    }
    
    /**
     * Muestra información del estado actual del pedido.
     */
    @Override
    public void verEstadoPedido() {
        this.pedido.getEstado().verEstadoPedido(this);
    }
    
    
    @Override
    public void prepararPedido() {
        this.pedido.prepararPedido();
    }
    
    @Override
    public void enviarPedido() {
        this.pedido.enviarPedido();
    }
    
    /**
     * Aplica la decoración específica de la subclase (descuento, impuesto, etc.).
     * 
     * Método abstracto que debe ser implementado por cada decorador concreto.
     * 
     */
    public abstract void aplicarDescuento();
    
}
