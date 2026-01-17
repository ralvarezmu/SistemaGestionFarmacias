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

//Fábrica abstracta
public interface MedicamentoFactory {

    /**
     * Crea un nuevo medicamento de tipo {@link Analgesico}.
     *
     * @param id             Identificador único del medicamento.
     * @param nombre         Nombre comercial del analgésico.
     * @param descripcion    Breve descripción del medicamento.
     * @param recetaMedica   Indica si requiere receta médica.
     * @param precio         Precio unitario del medicamento.
     * @param stock          Cantidad disponible en inventario.
     * @param fechaCaducidad Fecha de caducidad del medicamento.
     * @param nivelDolor     Nivel de dolor que trata ("leve", "moderado" o "intenso").
     * @return Una nueva instancia de {@link Analgesico}.
     */
    Analgesico crearAnalgesico(String id, String nombre, String descripcion, boolean recetaMedica,
                               double precio, int stock, LocalDate fechaCaducidad,
                               String nivelDolor);

    /**
     * Crea un nuevo medicamento de tipo {@link Antiinflamatorio}.
     *
     * @param id              Identificador único del medicamento.
     * @param nombre          Nombre comercial del antiinflamatorio.
     * @param descripcion     Breve descripción del medicamento.
     * @param recetaMedica    Indica si requiere receta médica.
     * @param precio          Precio unitario del medicamento.
     * @param stock           Cantidad disponible en inventario.
     * @param fechaCaducidad  Fecha de caducidad del medicamento.
     * @param zonaInflamacion Zona donde actúa ("articular", "muscular" o "general").
     * @return Una nueva instancia de {@link Antiinflamatorio}.
     */
    Antiinflamatorio crearAntiinflamatorio(String id, String nombre, String descripcion, boolean recetaMedica,
                                           double precio, int stock, LocalDate fechaCaducidad,
                                           String zonaInflamacion);

    /**
     * Crea un nuevo medicamento de tipo {@link Antibiotico}.
     *
     * @param id             Identificador único del medicamento.
     * @param nombre         Nombre comercial del antibiótico.
     * @param descripcion    Breve descripción del medicamento.
     * @param recetaMedica   Indica si requiere receta médica.
     * @param precio         Precio unitario del medicamento.
     * @param stock          Cantidad disponible en inventario.
     * @param fechaCaducidad Fecha de caducidad del medicamento.
     * @param tipoBacteria   Tipo o grupo de bacterias sobre las que actúa el antibiótico.
     * @return Una nueva instancia de {@link Antibiotico}.
     */
    Antibiotico crearAntibiotico(String id, String nombre, String descripcion, boolean recetaMedica,
                                 double precio, int stock, LocalDate fechaCaducidad,
                                 String tipoBacteria);
    
}
