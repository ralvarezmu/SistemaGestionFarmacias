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

public abstract class Analgesico extends Medicamento {

    private final String nivelDolor; // "leve", "moderado", "intenso"

    protected Analgesico(
            String id,
            String nombre,
            String descripcion,
            boolean requiereReceta,
            BigDecimal precio,
            int stock,
            LocalDate fechaCaducidad,
            String farmaciaAsociada,
            String nivelDolor
    ) {
        super(id, nombre, descripcion, "ANALGESICO", requiereReceta, precio, stock, fechaCaducidad, farmaciaAsociada);
        this.nivelDolor = nivelDolor;
    }

    public String getNivelDolor() {
        return nivelDolor;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", nivelDolor='" + nivelDolor + '\'' +
                '}';
    }
}

