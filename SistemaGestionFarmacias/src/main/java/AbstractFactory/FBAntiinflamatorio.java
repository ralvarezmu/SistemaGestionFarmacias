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

public class FBAntiinflamatorio extends Antiinflamatorio {

    public FBAntiinflamatorio(String id, String nombre, String descripcion, boolean requiereReceta,
                              BigDecimal precio, int stock, LocalDate fechaCaducidad,
                              String farmaciaAsociada, String zonaInflamacion) {
        super(id, nombre, descripcion, requiereReceta, precio, stock, fechaCaducidad, farmaciaAsociada, zonaInflamacion);
    }
}

