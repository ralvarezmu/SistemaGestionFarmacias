/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AbstractFactory;

/**
 *
 * @author claud
 */

import java.math.BigDecimal;
import java.time.LocalDate;

public class PruebaPatron {

    public static void main(String[] args) {

        MedicamentoFactory factoryMadrid = new FMMedicamentoFactory();
        MedicamentoFactory factoryBarcelona = new FBMedicamentoFactory();

        Analgesico a1 = factoryMadrid.crearAnalgesico(
                "A-001",
                "Paracetamol",
                "Analgésico común para dolor y fiebre",
                false,
                new BigDecimal("2.95"),
                120,
                LocalDate.of(2027, 5, 10),
                "leve"
        );

        Antiinflamatorio ai1 = factoryBarcelona.crearAntiinflamatorio(
                "AI-010",
                "Ibuprofeno",
                "Antiinflamatorio para molestias musculares",
                false,
                new BigDecimal("4.50"),
                60,
                LocalDate.of(2026, 11, 2),
                "muscular"
        );

        Antibiotico ab1 = factoryMadrid.crearAntibiotico(
                "AB-100",
                "Amoxicilina",
                "Antibiótico de amplio espectro",
                true,
                new BigDecimal("9.90"),
                25,
                LocalDate.of(2026, 1, 15),
                "Streptococcus"
        );

        System.out.println(a1);
        System.out.println(ai1);
        System.out.println(ab1);
    }
}

