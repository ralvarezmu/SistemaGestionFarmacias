/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Observer;

import AbstractFactory.FBAnalgesico;
import AbstractFactory.Medicamento;
import Decorator.Pedido;
import Decorator.PedidoBase;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PruebaPatron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Medicamento paracetamol = new FBAnalgesico(
            "A001", "Paracetamol", "Analgésico común", false,
            new BigDecimal("2.95"), 120, LocalDate.of(2027, 5, 10),
            "Farmacia Barcelona", "leve"
        );

        Medicamento ibuprofeno = new FBAnalgesico(
            "A002", "Ibuprofeno 400mg", "Dolor moderado", false,
            new BigDecimal("4.50"), 80, LocalDate.of(2026, 11, 2),
            "Farmacia Barcelona", "moderado"
        );

        Medicamento aspirina = new FBAnalgesico(
            "A003", "Aspirina 500mg", "Dolor y fiebre", false,
            new BigDecimal("1.80"), 200, LocalDate.of(2026, 8, 15),
            "Farmacia Barcelona", "leve"
        );
        
        Medicamento gelocatil = new FBAnalgesico(
            "A004", "Gelocatil 1g", "Dolor intenso", false,
            new BigDecimal("5.20"), 50, LocalDate.of(2027, 3, 20),
            "Farmacia Barcelona", "intenso"
        );

        Medicamento naproxeno = new FBAnalgesico(
            "A005", "Naproxeno 550mg", "Dolor muscular", false,
            new BigDecimal("6.75"), 40, LocalDate.of(2026, 12, 1),
            "Farmacia Barcelona", "muscular"
        );

        Medicamento metamizol = new FBAnalgesico(
            "A006", "Nolotil 575mg", "Dolor severo", true,
            new BigDecimal("3.90"), 30, LocalDate.of(2027, 1, 15),
            "Farmacia Barcelona", "severo"
        );
        
        ArrayList<Medicamento> medicamentosPedido = new ArrayList<>();
        medicamentosPedido.add(paracetamol);
        medicamentosPedido.add(ibuprofeno);
        medicamentosPedido.add(aspirina);
        medicamentosPedido.add(gelocatil);
        medicamentosPedido.add(naproxeno);
        medicamentosPedido.add(metamizol);
        
        // Crear el pedido
        Pedido pedido = new PedidoBase("1", "Juan Pérez", LocalDate.now(), medicamentosPedido);
        
        Notificador N1 = new NotificadorCliente("Juan Pérez", pedido);
        
        pedido.setNotificador(N1);
        pedido.marcarComoListo();
        
    }
    
}
