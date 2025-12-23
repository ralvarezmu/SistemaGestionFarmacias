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

public class FMMedicamentoFactory implements MedicamentoFactory {

    private static final String FARMACIA = "Farmacia Madrid";

    @Override
    public Analgesico crearAnalgesico(String id, String nombre, String descripcion, boolean requiereReceta,
                                     BigDecimal precio, int stock, LocalDate fechaCaducidad, String nivelDolor) {
        return new FMAnalgesico(id, nombre, descripcion, requiereReceta, precio, stock, fechaCaducidad, FARMACIA, nivelDolor);
    }

    @Override
    public Antiinflamatorio crearAntiinflamatorio(String id, String nombre, String descripcion, boolean requiereReceta,
                                                 BigDecimal precio, int stock, LocalDate fechaCaducidad, String zonaInflamacion) {
        return new FMAntiinflamatorio(id, nombre, descripcion, requiereReceta, precio, stock, fechaCaducidad, FARMACIA, zonaInflamacion);
    }

    @Override
    public Antibiotico crearAntibiotico(String id, String nombre, String descripcion, boolean requiereReceta,
                                        BigDecimal precio, int stock, LocalDate fechaCaducidad, String tipoBacteria) {
        return new FMAntibiotico(id, nombre, descripcion, requiereReceta, precio, stock, fechaCaducidad, FARMACIA, tipoBacteria);
    }
}

