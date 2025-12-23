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

public class FBMedicamentoFactory implements MedicamentoFactory {

    private static final String FARMACIA = "Farmacia Barcelona";

    @Override
    public Analgesico crearAnalgesico(String id, String nombre, String descripcion, boolean requiereReceta,
                                     BigDecimal precio, int stock, LocalDate fechaCaducidad, String nivelDolor) {
        return new FBAnalgesico(id, nombre, descripcion, requiereReceta, precio, stock, fechaCaducidad, FARMACIA, nivelDolor);
    }

    @Override
    public Antiinflamatorio crearAntiinflamatorio(String id, String nombre, String descripcion, boolean requiereReceta,
                                                 BigDecimal precio, int stock, LocalDate fechaCaducidad, String zonaInflamacion) {
        return new FBAntiinflamatorio(id, nombre, descripcion, requiereReceta, precio, stock, fechaCaducidad, FARMACIA, zonaInflamacion);
    }

    @Override
    public Antibiotico crearAntibiotico(String id, String nombre, String descripcion, boolean requiereReceta,
                                        BigDecimal precio, int stock, LocalDate fechaCaducidad, String tipoBacteria) {
        return new FBAntibiotico(id, nombre, descripcion, requiereReceta, precio, stock, fechaCaducidad, FARMACIA, tipoBacteria);
    }
}

