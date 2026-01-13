/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AbstractFactory;

/**
 *
 * @author claud
 */
import java.time.LocalDate;

public class PruebaPatron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MedicamentoFactory factoriaMadrid = new FMMedicamentoFactory();
        MedicamentoFactory factoriaBarcelona = new FBMedicamentoFactory();

        Medicamento m1 = factoriaMadrid.crearAnalgesico(
                "A-001", "Paracetamol", "Dolor leve/moderado", false,
                3.50, 50, LocalDate.of(2027, 5, 10),
                "moderado"
        );

        Medicamento m2 = factoriaBarcelona.crearAntiinflamatorio(
                "AI-010", "Ibuprofeno", "Para inflamación muscular", false,
                4.90, 40, LocalDate.of(2026, 12, 1),
                "muscular"
        );

        Medicamento m3 = factoriaMadrid.crearAntibiotico(
                "AB-100", "Amoxicilina", "Antibiótico de amplio espectro", true,
                9.99, 15, LocalDate.of(2026, 8, 20),
                "E. coli"
        );

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }
}
