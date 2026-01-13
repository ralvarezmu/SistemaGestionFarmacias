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

    public Analgesico(String id, String nombre, String descripcion, boolean recetaMedica, double precio, int stock, LocalDate fechaCaducidad, String farmacia, String nivelDolor) {
        super(id, nombre, descripcion, "analgesico", recetaMedica, precio, stock, fechaCaducidad, farmacia);
        setNivelDolor(nivelDolor);
    }

    public String getNivelDolor() { 
        return nivelDolor; 
    }

    public final void setNivelDolor(String nivelDolor) {
        if (nivelDolor == null) throw new IllegalArgumentException("nivelDolor no puede ser null");

        String v = nivelDolor.trim().toLowerCase();
        if (!v.equals("leve") && !v.equals("moderado") && !v.equals("intenso")) {
            throw new IllegalArgumentException("nivelDolor inválido (usa: leve, moderado o intenso)");
        }
        this.nivelDolor = v;
    }

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
