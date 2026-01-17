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
public class Antiinflamatorio extends Medicamento {
    
    private String zonaInflamacion; //articular, muscular o general

    /**
     * Crea una nueva instancia de {@code Antiinflamatorio} con los datos especificados.
     *
     * @param id              Identificador único del medicamento.
     * @param nombre          Nombre comercial del antiinflamatorio.
     * @param descripcion     Breve descripción del medicamento.
     * @param recetaMedica    Indica si requiere receta médica.
     * @param precio          Precio unitario del medicamento.
     * @param stock           Cantidad disponible en inventario.
     * @param fechaCaducidad  Fecha de caducidad del medicamento.
     * @param farmacia        Nombre de la farmacia que ofrece el medicamento.
     * @param zonaInflamacion Zona en la que actúa el medicamento
     *                        ("articular", "muscular" o "general").
     *
     */
    public Antiinflamatorio(String id, String nombre, String descripcion, boolean recetaMedica, double precio, int stock, LocalDate fechaCaducidad, String farmacia, String zonaInflamacion) {
        super(id, nombre, descripcion, "antiinflamatorio", recetaMedica, precio, stock, fechaCaducidad, farmacia);
        setZonaInflamacion(zonaInflamacion);
    }

    /**
     * Devuelve la zona del cuerpo donde actúa el antiinflamatorio.
     *
     * @return Zona de inflamación: "articular", "muscular" o "general".
     */
    public String getZonaInflamacion() { 
        return zonaInflamacion; 
    }

    /**
     * Establece la zona del cuerpo en la que actúa el antiinflamatorio.
     * El valor debe ser uno de los siguientes: {@code "articular"}, {@code "muscular"} o {@code "general"}.
     *
     * @param zonaInflamacion Zona del cuerpo tratada por el medicamento.
     * @throws IllegalArgumentException Si {@code zonaInflamacion} es {@code null}
     *                                  o no coincide con los valores permitidos.
     */
    public final void setZonaInflamacion(String zonaInflamacion) {
        if (zonaInflamacion == null) throw new IllegalArgumentException("zonaInflamacion no puede ser null");

        String v = zonaInflamacion.trim().toLowerCase();
        if (!v.equals("articular") && !v.equals("muscular") && !v.equals("general")) {
            throw new IllegalArgumentException("zonaInflamacion inválida (usa: articular, muscular o general)");
        }
        this.zonaInflamacion = v;
    }

    /**
     * Devuelve una representación en cadena del antiinflamatorio.
     *
     * @return Una cadena con los datos principales del medicamento,
     *         incluyendo id, nombre, farmacia y zona de inflamación.
     */
    @Override
    public String toString() {
        return "Antiinflamatorio{" +
                "id='" + getId() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", farmacia='" + getFarmacia() + '\'' +
                ", zonaInflamacion='" + zonaInflamacion + '\'' +
                '}';
    }
}
