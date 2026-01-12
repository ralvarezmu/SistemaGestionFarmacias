/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactor;

/**
 *
 * @author claud
 */
import java.time.LocalDate;

//Fábrica concreta
public class FMMedicamentoFactory implements MedicamentoFactory {
    private static final String FARMACIA = "Madrid";

    @Override
    public Analgesico crearAnalgesico(String id, String nombre, String descripcion, boolean recetaMedica,
                                      double precio, int stock, LocalDate fechaCaducidad,
                                      String nivelDolor) {
        return new Analgesico(id, nombre, descripcion, recetaMedica, precio, stock, fechaCaducidad, FARMACIA, nivelDolor);
    }

    @Override
    public Antiinflamatorio crearAntiinflamatorio(String id, String nombre, String descripcion, boolean recetaMedica,
                                                  double precio, int stock, LocalDate fechaCaducidad,
                                                  String zonaInflamacion) {
        return new Antiinflamatorio(id, nombre, descripcion, recetaMedica, precio, stock, fechaCaducidad, FARMACIA, zonaInflamacion);
    }

    @Override
    public Antibiotico crearAntibiotico(String id, String nombre, String descripcion, boolean recetaMedica,
                                        double precio, int stock, LocalDate fechaCaducidad,
                                        String tipoBacteria) {
        return new Antibiotico(id, nombre, descripcion, recetaMedica, precio, stock, fechaCaducidad, FARMACIA, tipoBacteria);
    }
}
