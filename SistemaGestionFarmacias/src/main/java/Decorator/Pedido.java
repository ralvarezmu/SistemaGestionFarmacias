/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Decorator;

import java.time.LocalDate;
import AbstractFactory.Medicamento;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface Pedido {
    
    public String getUsuario();
    
    public LocalDate getFecha();
    
    public ArrayList<Medicamento> getMedicamentos();
    
    public BigDecimal getImporte();
    
    public void setImporte(BigDecimal importe);
}
