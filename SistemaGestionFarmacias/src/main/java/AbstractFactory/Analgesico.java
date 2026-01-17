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

//Producto concreto
public class Analgesico extends Medicamento {
    
    private String nivelDolor; // leve, moderado o intenso

    /**
     * Crea una nueva instancia de {@code Analgesico} con los datos especificados.
     *
     * @param id             Identificador único del medicamento.
     * @param nombre         Nombre comercial del analgésico.
     * @param descripcion    Breve descripción del medicamento.
     * @param recetaMedica   Indica si requiere receta médica.
     * @param precio         Precio unitario del medicamento.
     * @param stock          Cantidad disponible en inventario.
     * @param fechaCaducidad Fecha de caducidad del medicamento.
     * @param farmacia       Nombre de la farmacia que ofrece el medicamento.
     * @param nivelDolor     Nivel de dolor que trata ("leve", "moderado" o "intenso").
     *
     */
    public Analgesico(String id, String nombre, String descripcion, boolean recetaMedica, double precio, int stock, LocalDate fechaCaducidad, String farmacia, String nivelDolor) {
        super(id, nombre, descripcion, "analgesico", recetaMedica, precio, stock, fechaCaducidad, farmacia);
        setNivelDolor(nivelDolor);
    }

    /**
     * Devuelve el nivel de dolor que el analgésico puede tratar.
     *
     * @return Nivel de dolor ("leve", "moderado" o "intenso").
     */
    public String getNivelDolor() { 
        return nivelDolor; 
    }

    /**
     * Establece el nivel de dolor que el analgésico puede tratar.
     * 
     * El valor debe ser uno de los siguientes: "leve", "moderado" o "intenso".
     * 
     *
     * @param nivelDolor Nivel de dolor que el medicamento trata.
     */
    public final void setNivelDolor(String nivelDolor) {
        if (nivelDolor == null) throw new IllegalArgumentException("nivelDolor no puede ser null");

        String v = nivelDolor.trim().toLowerCase();
        if (!v.equals("leve") && !v.equals("moderado") && !v.equals("intenso")) {
            throw new IllegalArgumentException("nivelDolor inválido (usa: leve, moderado o intenso)");
        }
        this.nivelDolor = v;
    }

    /**
     * Devuelve una representación en cadena del objeto Analgésico.
     *
     * @return Una cadena con los datos principales del analgésico.
     */
    @Override
    public String toString() {
        return "Analgesico{" +
                "id='" + getId() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", farmacia='" + getFarmacia() + '\'' +
                ", nivelDolor='" + nivelDolor + '\'' +
                '}';
    }
}
