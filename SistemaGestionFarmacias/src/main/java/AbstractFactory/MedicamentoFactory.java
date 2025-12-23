/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

/**
 *
 * @author claud
 */

import java.math.BigDecimal;
import java.time.LocalDate;

public interface MedicamentoFactory {

    Analgesico crearAnalgesico(
            String id, String nombre, String descripcion,
            boolean requiereReceta, BigDecimal precio, int stock,
            LocalDate fechaCaducidad,
            String nivelDolor
    );

    Antiinflamatorio crearAntiinflamatorio(
            String id, String nombre, String descripcion,
            boolean requiereReceta, BigDecimal precio, int stock,
            LocalDate fechaCaducidad,
            String zonaInflamacion
    );

    Antibiotico crearAntibiotico(
            String id, String nombre, String descripcion,
            boolean requiereReceta, BigDecimal precio, int stock,
            LocalDate fechaCaducidad,
            String tipoBacteria
    );
}

