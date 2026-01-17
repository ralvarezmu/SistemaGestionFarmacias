/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Decorator;

import java.time.LocalDate;
import AbstractFactory.Medicamento;
import FactoryMethod.MetodoPago;
import Observer.Notificador;
import State.EstadoPedido;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface Pedido {
    
    /**
     * Devuelve el identificador único del pedido.
     * @return ID único del pedido.
     */
    public String getId();
    
    /**
     * Devuelve el usuario que realizó el pedido.
     * @return Nombre o ID del usuario.
     */
    public String getUsuario();
    
    /**
     * Devuelve la fecha de creación del pedido.
     * @return Fecha del pedido.
     */
    public LocalDate getFecha();
    
    /**
     * Devuelve la lista de medicamentos incluidos en el pedido.
     * @return Lista de medicamentos.
     */
    public ArrayList<Medicamento> getMedicamentos();
    
    /**
     * Devuelve el importe total actual del pedido.
     * @return Importe total.
     */
    public double getImporte();
    
    /**
     * Establece un nuevo importe total para el pedido.
     * @param importe Nuevo importe total.
     */
    public void setImporte(double importe);
    
    /**
     * Calcula dinámicamente el importe total del pedido según los medicamentos.
     * @return Importe calculado.
     */
    public double calcularImporte();
    
    /**
     * Devuelve el estado actual del pedido.
     * @return Estado actual ({@link EstadoPedido}).
     */
    public EstadoPedido getEstado();
    
    /**
     * Cambia el estado del pedido.
     * @param estado Nuevo estado del pedido.
     */
    public void setEstado(EstadoPedido estado);
    
    /**
     * Devuelve el método de pago seleccionado.
     * @return Método de pago actual ({@link MetodoPago}).
     */
    public MetodoPago getMetodoPago();
    
    /**
     * Establece el método de pago del pedido.
     * @param metodo Nuevo método de pago.
     */
    public void setMetodoPago(MetodoPago metodo);
    
    /**
     * Devuelve el notificador asociado al pedido.
     * @return Objeto {@link Notificador}.
     */
    public Notificador getNotificador();
    
    /**
     * Asigna un nuevo notificador al pedido.
     * @param notificador Nuevo notificador.
     */
    public void setNotificador(Notificador notificador);
    
    /**
     * Marca el pedido como listo para recogida/entrega y notifica cambios.
     */
    public void marcarComoListo();
    
    /**
     * Añade un medicamento respetando las reglas del estado actual del pedido.
     * @param medicamento Medicamento a añadir.
     */
    public void anadirMedicamento(Medicamento medicamento);
    
    /**
     * Elimina un medicamento respetando las reglas del estado actual.
     * @param medicamento Medicamento a eliminar.
     */
    public void eliminarMedicamento(Medicamento medicamento);
    
    /**
     * Selecciona método de pago según el estado actual del pedido.
     * @param tipo Código numérico del método de pago.
     */
    public void seleccionarMetodoPago(int tipo);
    
    /**
     * Confirma el pedido según las reglas del estado actual.
     */
    public void confirmarPedido();
    
    /**
     * Muestra información del estado actual del pedido.
     */
    public void verEstadoPedido();
    
    /**
     * Inicia la preparación del pedido (fase logística).
     */
    public void prepararPedido();
    
    /**
     * Marca el pedido como enviado al cliente.
     */
    public void enviarPedido();
}
