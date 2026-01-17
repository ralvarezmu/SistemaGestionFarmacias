/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

/**
 *
 * @author claud
 */
import java.time.LocalDate;

//Fábrica concreta
public class FBMedicamentoFactory implements MedicamentoFactory {
    
    private static final String FARMACIA = "Barcelona";

    /**
     * Crea un nuevo objeto {@link Analgesico} asociado a la farmacia de Barcelona.
     *
     * @param id             Identificador único del medicamento.
     * @param nombre         Nombre comercial del analgésico.
     * @param descripcion    Descripción breve del medicamento.
     * @param recetaMedica   Indica si requiere receta médica.
     * @param precio         Precio unitario del medicamento.
     * @param stock          Cantidad disponible en inventario.
     * @param fechaCaducidad Fecha de caducidad del medicamento.
     * @param nivelDolor     Nivel de dolor que trata ("leve", "moderado" o "intenso").
     * @return Una nueva instancia de {@link Analgesico} con los datos especificados.
     */
    @Override
    public Analgesico crearAnalgesico(String id, String nombre, String descripcion, boolean recetaMedica,
                                      double precio, int stock, LocalDate fechaCaducidad,
                                      String nivelDolor) {
        return new Analgesico(id, nombre, descripcion, recetaMedica, precio, stock, fechaCaducidad, FARMACIA, nivelDolor);
    }

    /**
     * Crea un nuevo objeto {@link Antiinflamatorio} asociado a la farmacia de Barcelona.
     *
     * @param id              Identificador único del medicamento.
     * @param nombre          Nombre comercial del antiinflamatorio.
     * @param descripcion     Descripción breve del medicamento.
     * @param recetaMedica    Indica si requiere receta médica.
     * @param precio          Precio unitario del medicamento.
     * @param stock           Cantidad disponible en inventario.
     * @param fechaCaducidad  Fecha de caducidad del medicamento.
     * @param zonaInflamacion Zona en la que actúa ("articular", "muscular" o "general").
     * @return Una nueva instancia de {@link Antiinflamatorio} con los datos especificados.
     */
    @Override
    public Antiinflamatorio crearAntiinflamatorio(String id, String nombre, String descripcion, boolean recetaMedica,
                                                  double precio, int stock, LocalDate fechaCaducidad,
                                                  String zonaInflamacion) {
        return new Antiinflamatorio(id, nombre, descripcion, recetaMedica, precio, stock, fechaCaducidad, FARMACIA, zonaInflamacion);
    }

    /**
     * Crea un nuevo objeto {@link Antibiotico} asociado a la farmacia de Barcelona.
     *
     * @param id             Identificador único del medicamento.
     * @param nombre         Nombre comercial del antibiótico.
     * @param descripcion    Descripción breve del medicamento.
     * @param recetaMedica   Indica si requiere receta médica.
     * @param precio         Precio unitario del medicamento.
     * @param stock          Cantidad disponible en inventario.
     * @param fechaCaducidad Fecha de caducidad del medicamento.
     * @param tipoBacteria   Tipo o grupo de bacterias sobre las que actúa el medicamento.
     * @return Una nueva instancia de {@link Antibiotico} con los datos especificados.
     */
    @Override
    public Antibiotico crearAntibiotico(String id, String nombre, String descripcion, boolean recetaMedica,
                                        double precio, int stock, LocalDate fechaCaducidad,
                                        String tipoBacteria) {
        return new Antibiotico(id, nombre, descripcion, recetaMedica, precio, stock, fechaCaducidad, FARMACIA, tipoBacteria);
    }
}
