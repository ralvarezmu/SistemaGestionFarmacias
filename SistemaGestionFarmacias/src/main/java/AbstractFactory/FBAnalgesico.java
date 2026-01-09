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

public class FBAnalgesico extends Analgesico {

    public FBAnalgesico(String id, String nombre, String descripcion, boolean requiereReceta,
                        BigDecimal precio, int stock, LocalDate fechaCaducidad,
                        String farmaciaAsociada, String nivelDolor) {
        super(id, nombre, descripcion, requiereReceta, precio, stock, fechaCaducidad, farmaciaAsociada, nivelDolor);
    }
    
    @Override
    public String toString() {
        return super.getNombre();
    }
    
}

