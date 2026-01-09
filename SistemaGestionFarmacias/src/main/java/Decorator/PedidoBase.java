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
import java.math.BigDecimal;
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
    private BigDecimal importe;
    private MetodoPago metodoPago;
    private EstadoPedido estado;
    private Notificador notificador;
    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    
    public PedidoBase(String id, String usuario, LocalDate fecha, ArrayList<Medicamento> medicamentos) {
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
        this.medicamentos = medicamentos;
        this.importe = calcularImporte();
    }
    
    @Override
    public String getUsuario() {
        return usuario;
    }
    
    @Override
    public String getId() {
        return id;
    }
    
    @Override
    public LocalDate getFecha() {
        return fecha;
    }
    
    @Override
    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }
    
    @Override
    public BigDecimal getImporte() {
        return importe;
    }
    
    @Override
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }
    
    @Override
    public BigDecimal calcularImporte() {
        BigDecimal importeTotal = BigDecimal.ZERO;
        for (Medicamento m : medicamentos) {
            importeTotal = importeTotal.add(m.getPrecio());
        }
        
        this.importe = importeTotal;
        return importeTotal;
    }
    
    @Override
    public EstadoPedido getEstado() {
        return estado;
    }
    
    @Override
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
    
    @Override
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }
    
    @Override
    public void setMetodoPago(MetodoPago metodo) {
        this.metodoPago = metodo;
    }
    
    @Override
    public void marcarComoListo() {
        //setEstado("Listo");
        notificador.actualizar();
    }
    
    @Override
    public Notificador getNotificador() {
        return notificador;
    }
    
    @Override
    public void setNotificador(Notificador notificador) {
        this.notificador = notificador;
    }
    
    @Override
    public void anadirMedicamento(Medicamento medicamento) {
        estado.anadirMedicamento(medicamento, this);
    }
    
    @Override
    public void eliminarMedicamento(Medicamento medicamento) {
        estado.eliminarMedicamento(medicamento, this);
    }
    
    @Override
    public void seleccionarMetodoPago(int tipo) {
        estado.seleccionarMetodoPago(tipo, this);
    }
    
    @Override
    public void confirmarPedido() {
        estado.confirmarPedido(this);
    }
    
    @Override
    public void verEstadoPedido() {
        estado.verEstadoPedido(this);
    }
    
    @Override
    public void prepararPedido() {
        EstadoPedido envio = new EstadoEnvio();
        scheduler.schedule(() -> {
            this.setEstado(envio);
            this.marcarComoListo();
            estado.enviarPedido(this);
        }, 1, TimeUnit.MINUTES);
    }
    
    @Override
    public void enviarPedido() {
        EstadoPedido entregado = new EstadoEntregado();
        scheduler.schedule(() -> {
            this.setEstado(entregado);
            this.verEstadoPedido();
            scheduler.shutdown();
        }, 1, TimeUnit.MINUTES);
    }
    
}
