/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Strategy;

/**
 *
 * @author claud
 */
import AbstractFactory.Medicamento;
import Bridge.AlmacenMedicamentos;
import java.util.List;

public class PruebaPatron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlmacenMedicamentos almacen = AlmacenMedicamentos.getInstancia();
        List<Medicamento> todos = almacen.getTodosLosMedicamentos();

        ConsultorMedicamentos consultor = new ConsultorMedicamentos(new ConsultaPorNombre());

        // Buscar por nombre
        List<Medicamento> r1 = consultor.consultar(todos, "paracetamol");
        System.out.println("Resultados por nombre 'paracetamol':");
        for (Medicamento medicamento : r1) {
            System.out.println(medicamento);
        }

        // Buscar por tipo
        consultor.setEstrategia(new ConsultaPorTipo());
        List<Medicamento> r2 = consultor.consultar(todos, "analgesico");
        System.out.println("\nResultados por tipo 'analgesico':");
        for (Medicamento medicamento : r2) {
            System.out.println(medicamento);
        }

        // Buscar por farmacia
        consultor.setEstrategia(new ConsultaPorFarmacia());
        List<Medicamento> r3 = consultor.consultar(todos, "madrid");
        System.out.println("\nResultados por farmacia 'madrid':");
        for (Medicamento medicamento : r3) {
            System.out.println(medicamento);
        }
    }
}
