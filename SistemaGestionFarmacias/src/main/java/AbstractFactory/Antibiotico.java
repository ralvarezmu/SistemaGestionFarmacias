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

    public Antibiotico(String id, String nombre, String descripcion, boolean recetaMedica, double precio, int stock, LocalDate fechaCaducidad, String farmacia, String tipoBacteria) {
        super(id, nombre, descripcion, "antibiotico", recetaMedica, precio, stock, fechaCaducidad, farmacia);
        setTipoBacteria(tipoBacteria);
    }

    public String getTipoBacteria() { 
        return tipoBacteria; 
    }

    public final void setTipoBacteria(String tipoBacteria) {
        if (tipoBacteria == null || tipoBacteria.trim().isEmpty()) {
            throw new IllegalArgumentException("tipoBacteria no puede estar vacío");
        }
        this.tipoBacteria = tipoBacteria.trim();
    }

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
