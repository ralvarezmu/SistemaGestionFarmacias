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

public abstract class Antibiotico extends Medicamento {

    private final String tipoBacteria;

    protected Antibiotico(
            String id,
            String nombre,
            String descripcion,
            boolean requiereReceta,
            BigDecimal precio,
            int stock,
            LocalDate fechaCaducidad,
            String farmaciaAsociada,
            String tipoBacteria
    ) {
        super(id, nombre, descripcion, "ANTIBIOTICO", requiereReceta, precio, stock, fechaCaducidad, farmaciaAsociada);
        this.tipoBacteria = tipoBacteria;
    }

    public String getTipoBacteria() {
        return tipoBacteria;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", tipoBacteria='" + tipoBacteria + '\'' +
                '}';
    }
}

