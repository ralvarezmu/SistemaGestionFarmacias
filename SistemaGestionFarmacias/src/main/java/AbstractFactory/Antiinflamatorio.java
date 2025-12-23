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

public abstract class Antiinflamatorio extends Medicamento {

    private final String zonaInflamacion; // "articular", "muscular", "general"

    protected Antiinflamatorio(
            String id,
            String nombre,
            String descripcion,
            boolean requiereReceta,
            BigDecimal precio,
            int stock,
            LocalDate fechaCaducidad,
            String farmaciaAsociada,
            String zonaInflamacion
    ) {
        super(id, nombre, descripcion, "ANTIINFLAMATORIO", requiereReceta, precio, stock, fechaCaducidad, farmaciaAsociada);
        this.zonaInflamacion = zonaInflamacion;
    }

    public String getZonaInflamacion() {
        return zonaInflamacion;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", zonaInflamacion='" + zonaInflamacion + '\'' +
                '}';
    }
}

