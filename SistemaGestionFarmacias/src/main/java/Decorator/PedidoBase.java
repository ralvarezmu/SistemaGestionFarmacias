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
public class PedidoBase implements Pedido{
    
    private String usuario;
    private LocalDate fecha;
    private ArrayList<Medicamento> medicamentos = new ArrayList<>();
    private BigDecimal importe;
    
    public PedidoBase(String usuario, LocalDate fecha, ArrayList<Medicamento> medicamentos) {
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
    
    public BigDecimal calcularImporte() {
        BigDecimal importeTotal = BigDecimal.ZERO;
        for (Medicamento m : medicamentos) {
            importeTotal = importeTotal.add(m.getPrecio());
        }
        
        return importeTotal;
    }
    
}
