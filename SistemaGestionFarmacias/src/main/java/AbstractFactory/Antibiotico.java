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
public class Antibiotico extends Medicamento {
    
    private String tipoBacteria; // "libre" (estreptococo, staphylococcus, E. coli…)

    /**
     * Crea una nueva instancia de {@code Antibiotico} con los datos especificados.
     *
     * @param id             Identificador único del medicamento.
     * @param nombre         Nombre comercial del antibiótico.
     * @param descripcion    Breve descripción del medicamento.
     * @param recetaMedica   Indica si requiere receta médica.
     * @param precio         Precio unitario del medicamento.
     * @param stock          Cantidad disponible en inventario.
     * @param fechaCaducidad Fecha de caducidad del medicamento.
     * @param farmacia       Nombre de la farmacia que ofrece el medicamento.
     * @param tipoBacteria   Tipo o grupo de bacterias para el que está indicado el antibiótico.
     *
     */
    public Antibiotico(String id, String nombre, String descripcion, boolean recetaMedica, double precio, int stock, LocalDate fechaCaducidad, String farmacia, String tipoBacteria) {
        super(id, nombre, descripcion, "antibiotico", recetaMedica, precio, stock, fechaCaducidad, farmacia);
        setTipoBacteria(tipoBacteria);
    }

    /**
     * Devuelve el tipo o grupo de bacterias sobre las que actúa el antibiótico.
     *
     * @return Tipo de bacteria (por ejemplo, {@code "E. coli"} o {@code "estreptococo"}).
     */
    public String getTipoBacteria() { 
        return tipoBacteria; 
    }

    /**
     * Establece el tipo o grupo de bacterias sobre las que actúa el antibiótico.
     *
     * @param tipoBacteria Tipo de bacteria o grupo bacteriano.
     * @throws IllegalArgumentException Si {@code tipoBacteria} es {@code null}
     *                                  o está vacío después de recortar espacios.
     */
    public final void setTipoBacteria(String tipoBacteria) {
        if (tipoBacteria == null || tipoBacteria.trim().isEmpty()) {
            throw new IllegalArgumentException("tipoBacteria no puede estar vacío");
        }
        this.tipoBacteria = tipoBacteria.trim();
    }

    /**
     * Devuelve una representación en cadena del antibiótico.
     *
     * @return Una cadena con los datos principales del antibiótico,
     *         incluyendo su identificador, nombre, farmacia y tipo de bacteria.
     */
    @Override
    public String toString() {
        return "Antibiotico{" +
                "id='" + getId() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", farmacia='" + getFarmacia() + '\'' +
                ", tipoBacteria='" + tipoBacteria + '\'' +
                '}';
    }
}
