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

//Producto concreto
public class Antiinflamatorio extends Medicamento {
    private String zonaInflamacion; //articular, muscular o general

    public Antiinflamatorio(String id, String nombre, String descripcion, boolean recetaMedica, double precio, int stock, LocalDate fechaCaducidad, String farmacia, String zonaInflamacion) {
        super(id, nombre, descripcion, "antiinflamatorio", recetaMedica, precio, stock, fechaCaducidad, farmacia);
        setZonaInflamacion(zonaInflamacion);
    }

    public String getZonaInflamacion() { 
        return zonaInflamacion; 
    }

    public final void setZonaInflamacion(String zonaInflamacion) {
        if (zonaInflamacion == null) throw new IllegalArgumentException("zonaInflamacion no puede ser null");

        String v = zonaInflamacion.trim().toLowerCase();
        if (!v.equals("articular") && !v.equals("muscular") && !v.equals("general")) {
            throw new IllegalArgumentException("zonaInflamacion inválida (usa: articular, muscular o general)");
        }
        this.zonaInflamacion = v;
    }

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
