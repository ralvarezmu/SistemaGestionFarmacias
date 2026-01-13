/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package State;

import AbstractFactory.FBMedicamentoFactory;
import AbstractFactory.FMMedicamentoFactory;
import AbstractFactory.Medicamento;
import AbstractFactory.MedicamentoFactory;
import Decorator.Pedido;
import Decorator.PedidoBase;
import Observer.Notificador;
import Observer.NotificadorCliente;
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
        
        MedicamentoFactory factoriaMadrid = new FMMedicamentoFactory();
        MedicamentoFactory factoriaBarcelona = new FBMedicamentoFactory();

        Medicamento paracetamol = factoriaBarcelona.crearAnalgesico(
            "A101", "Paracetamol 1g", "Analgésico común", false,
            3.10, 100, LocalDate.of(2027, 6, 15),
            "leve"
        );

        Medicamento amoxicilina = factoriaBarcelona.crearAntibiotico(
            "AB101", "Amoxicilina 500mg", "Antibiótico antibacteriano", true,
            8.75, 30, LocalDate.of(2026, 9, 20),
            "E. coli"
        );

        Medicamento ibuprofeno = factoriaBarcelona.crearAntiinflamatorio(
            "AI101", "Ibuprofeno 600mg", "Inflamación muscular", false,
            5.40, 60, LocalDate.of(2026, 12, 10),
            "muscular"
        );

        Medicamento gelocatil = factoriaMadrid.crearAnalgesico(
            "A201", "Gelocatil 1g", "Dolor intenso", false,
            4.90, 80, LocalDate.of(2027, 3, 5),
            "intenso"
        );

        Medicamento azitromicina = factoriaMadrid.crearAntibiotico(
            "AB201", "Azitromicina 500mg", "Antibiótico respiratorio", true,
            11.60, 20, LocalDate.of(2026, 7, 30),
            "S. pneumoniae"
        );

        Medicamento naproxeno = factoriaMadrid.crearAntiinflamatorio(
            "AI201", "Naproxeno 550mg", "Dolor articular", false,
            6.80, 40, LocalDate.of(2026, 11, 25),
            "articular"
        );
        
        ArrayList<Medicamento> medicamentosPedido = new ArrayList<>();
        
        // Crear el pedido
        Pedido pedido = new PedidoBase("1", "Juan Pérez", LocalDate.now(), medicamentosPedido);
        
        Notificador N1 = new NotificadorCliente("Juan Pérez", pedido);        
        pedido.setNotificador(N1);
        
        EstadoPedido estado1 = new EstadoEleccionMedicamentos();
        pedido.setEstado(estado1);
        pedido.anadirMedicamento(paracetamol);
        pedido.anadirMedicamento(naproxeno);
        pedido.eliminarMedicamento(paracetamol);
        pedido.seleccionarMetodoPago(0);
        
        EstadoPedido estado2 = new EstadoEleccionMetodoPago();
        pedido.setEstado(estado2);
        pedido.anadirMedicamento(paracetamol);
        pedido.anadirMedicamento(naproxeno);
        pedido.eliminarMedicamento(paracetamol);
        pedido.seleccionarMetodoPago(1);
        
        EstadoPedido estado3 = new EstadoFinalizarPedido();
        pedido.setEstado(estado3);
        pedido.anadirMedicamento(paracetamol);
        pedido.anadirMedicamento(naproxeno);
        pedido.eliminarMedicamento(paracetamol);
        pedido.seleccionarMetodoPago(0);
        pedido.confirmarPedido();
        pedido.verEstadoPedido();
        
    }
    
}
