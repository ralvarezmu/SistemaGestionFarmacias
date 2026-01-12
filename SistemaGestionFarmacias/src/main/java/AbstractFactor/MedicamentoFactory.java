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

//Fábrica abstracta
public interface MedicamentoFactory {

    Analgesico crearAnalgesico(String id, String nombre, String descripcion, boolean recetaMedica,
                               double precio, int stock, LocalDate fechaCaducidad,
                               String nivelDolor);

    Antiinflamatorio crearAntiinflamatorio(String id, String nombre, String descripcion, boolean recetaMedica,
                                           double precio, int stock, LocalDate fechaCaducidad,
                                           String zonaInflamacion);

    Antibiotico crearAntibiotico(String id, String nombre, String descripcion, boolean recetaMedica,
                                 double precio, int stock, LocalDate fechaCaducidad,
                                 String tipoBacteria);
}
