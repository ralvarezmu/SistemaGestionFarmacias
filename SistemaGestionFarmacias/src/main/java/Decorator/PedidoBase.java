/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

import AbstractFactory.Medicamento;
import FactoryMethod.MetodoPago;
import Observer.Notificador;
import State.EstadoEntregado;
import State.EstadoEnvio;
import State.EstadoPedido;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Admin
 */
public class PedidoBase implements Pedido{
    
    private String id;
    private String usuario;
    private LocalDate fecha;
    private ArrayList<Medicamento> medicamentos = new ArrayList<>();
    private double importe;
    private MetodoPago metodoPago;
    private EstadoPedido estado;
    private Notificador notificador;
    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    
    /**
     * Crea una nueva instancia de {@code PedidoBase} con los datos proporcionados.
     * 
     * El importe se calcula automáticamente en función de la lista de medicamentos.
     *
     * @param id           Identificador único del pedido.
     * @param usuario      Usuario que realiza el pedido.
     * @param fecha        Fecha de creación del pedido.
     * @param medicamentos Lista inicial de medicamentos del pedido.
     */
    public PedidoBase(String id, String usuario, LocalDate fecha, ArrayList<Medicamento> medicamentos) {
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
        this.medicamentos = medicamentos;
        this.importe = calcularImporte();
    }
    
    /** {@inheritDoc} */
    @Override
    public String getUsuario() {
        return usuario;
    }
    
    /** {@inheritDoc} */
    @Override
    public String getId() {
        return id;
    }
    
    /** {@inheritDoc} */
    @Override
    public LocalDate getFecha() {
        return fecha;
    }
    
    /** {@inheritDoc} */
    @Override
    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }
    
    /** {@inheritDoc} */
    @Override
    public double getImporte() {
        return importe;
    }
    
    /** {@inheritDoc} */
    @Override
    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    /**
     * Calcula el importe total del pedido sumando el precio de todos los medicamentos.
     *
     * @return Importe total calculado.
     */
    @Override
    public double calcularImporte() {
        double importeTotal = 0.0;
        for (Medicamento m : medicamentos) {
            importeTotal += m.getPrecio();
        }
        this.importe = importeTotal;
        return importeTotal;
    }

    /** {@inheritDoc} */
    @Override
    public EstadoPedido getEstado() {
        return estado;
    }
    
    /** {@inheritDoc} */
    @Override
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
    
    /** {@inheritDoc} */
    @Override
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }
    
    /** {@inheritDoc} */
    @Override
    public void setMetodoPago(MetodoPago metodo) {
        this.metodoPago = metodo;
    }
    
    /**
     * Marca el pedido como listo y notifica a los observadores mediante el notificador.
     * 
     * La lógica de cambio de estado puede estar gestionada externamente por {@link EstadoPedido}.
     * 
     */
    @Override
    public void marcarComoListo() {
        //setEstado("Listo");
        notificador.actualizar();
    }
    
    /** {@inheritDoc} */
    @Override
    public Notificador getNotificador() {
        return notificador;
    }
    
    /** {@inheritDoc} */
    @Override
    public void setNotificador(Notificador notificador) {
        this.notificador = notificador;
    }
    
    /**
     * Añade un medicamento delegando la operación en el estado actual del pedido.
     *
     * @param medicamento Medicamento a añadir al pedido.
     */
    @Override
    public void anadirMedicamento(Medicamento medicamento) {
        estado.anadirMedicamento(medicamento, this);
    }
    
    /**
     * Elimina un medicamento delegando la operación en el estado actual del pedido.
     *
     * @param medicamento Medicamento a eliminar del pedido.
     */
    @Override
    public void eliminarMedicamento(Medicamento medicamento) {
        estado.eliminarMedicamento(medicamento, this);
    }
    
    /**
     * Selecciona el método de pago delegando en el estado actual del pedido.
     *
     * @param tipo Código o tipo de método de pago.
     */
    @Override
    public void seleccionarMetodoPago(int tipo) {
        estado.seleccionarMetodoPago(tipo, this);
    }
    
    /**
     * Confirma el pedido delegando la lógica en el estado actual.
     */
    @Override
    public void confirmarPedido() {
        estado.confirmarPedido(this);
    }
    
    /**
     * Muestra o registra el estado actual del pedido delegando en {@link EstadoPedido}.
     */
    @Override
    public void verEstadoPedido() {
        estado.verEstadoPedido(this);
    }
    
    /**
     * Inicia el proceso de preparación del pedido.
     * 
     * Programa una tarea diferida que, pasado un minuto, cambia el estado a
     * {@link EstadoEnvio}, marca el pedido como listo y delega la llamada a
     * {@link EstadoPedido#enviarPedido(Pedido)}.
     * 
     */
    @Override
    public void prepararPedido() {
        EstadoPedido envio = new EstadoEnvio();
        scheduler.schedule(() -> {
            this.setEstado(envio);
            this.marcarComoListo();
            estado.enviarPedido(this);
        }, 1, TimeUnit.MINUTES);
    }
    
    /**
     * Simula el envío del pedido al cliente.
     * 
     * Programa una tarea diferida que, pasado un minuto, cambia el estado a
     * {@link EstadoEntregado}, muestra el estado y detiene el scheduler.
     * 
     */
    @Override
    public void enviarPedido() {
        EstadoPedido entregado = new EstadoEntregado();
        scheduler.schedule(() -> {
            this.setEstado(entregado);
            this.verEstadoPedido();
            scheduler.shutdown();
        }, 1, TimeUnit.MINUTES);
    }

    /**
     * Devuelve una representación textual del pedido, incluyendo sus campos principales.
     *
     * @return Cadena con la información del pedido.
     */
    @Override
    public String toString() {
        return "PedidoBase{" + "id=" + id + ", usuario=" + usuario + ", fecha=" + fecha + ", medicamentos=" + medicamentos + ", importe=" + importe + ", metodoPago=" + metodoPago + ", estado=" + estado + ", notificador=" + notificador + ", scheduler=" + scheduler + '}';
    }
    
}
