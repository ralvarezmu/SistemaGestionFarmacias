/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

/**
 *
 * @author claud
 */
import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Medicamento {

    private final String id;
    private final String nombre;
    private final String descripcion;
    private final String tipo; // "ANALGESICO", "ANTIINFLAMATORIO", "ANTIBIOTICO"
    private final boolean requiereReceta;
    private BigDecimal precio;
    private int stock;
    private final LocalDate fechaCaducidad;
    private final String farmaciaAsociada;

    protected Medicamento(
            String id,
            String nombre,
            String descripcion,
            String tipo,
            boolean requiereReceta,
            BigDecimal precio,
            int stock,
            LocalDate fechaCaducidad,
            String farmaciaAsociada
    ) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.requiereReceta = requiereReceta;
        this.precio = precio;
        this.stock = stock;
        this.fechaCaducidad = fechaCaducidad;
        this.farmaciaAsociada = farmaciaAsociada;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getTipo() { return tipo; }
    public boolean isRequiereReceta() { return requiereReceta; }
    public BigDecimal getPrecio() { return precio; }
    public int getStock() { return stock; }
    public LocalDate getFechaCaducidad() { return fechaCaducidad; }
    public String getFarmaciaAsociada() { return farmaciaAsociada; }

    public void setPrecio(BigDecimal precio) {
        if (precio == null || precio.signum() < 0) throw new IllegalArgumentException("Precio inválido");
        this.precio = precio;
    }

    public void setStock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("Stock inválido");
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", requiereReceta=" + requiereReceta +
                ", precio=" + precio +
                ", stock=" + stock +
                ", caducidad=" + fechaCaducidad +
                ", farmacia='" + farmaciaAsociada + '\'' +
                '}';
    }
}

