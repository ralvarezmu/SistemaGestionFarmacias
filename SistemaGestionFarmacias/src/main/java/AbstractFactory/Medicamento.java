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

//Producto abstracto
public abstract class Medicamento {
    private final String id;
    private String nombre;
    private String descripcion;
    private final String tipo;           //analgesico, antiinflamatorio o antibiotico
    private boolean recetaMedica;
    private double precio;
    private int stock;
    private LocalDate fechaCaducidad;
    private final String farmacia;       //Madrid o Barcelona

    protected Medicamento(String id, String nombre, String descripcion, String tipo, boolean recetaMedica, double precio, int stock, LocalDate fechaCaducidad, String farmacia) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.recetaMedica = recetaMedica;
        this.precio = precio;
        this.stock = stock;
        this.fechaCaducidad = fechaCaducidad;
        this.farmacia = farmacia;
    }

    
    public String getId() { 
        return id; 
    }
    
    public String getNombre() { 
        return nombre; 
    }
    
    public String getDescripcion() {
        return descripcion; 
    }
    
    public String getTipo() { 
        return tipo; 
    }
    
    public boolean isRecetaMedica() {
        return recetaMedica; 
    }
    
    public double getPrecio() {
        return precio; 
    }
    
    public int getStock() {
        return stock; 
    }
    
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad; 
    }
    
    public String getFarmacia() {
        return farmacia; 
    }

    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion; 
    }
    
    public void setRecetaMedica(boolean recetaMedica) {
        this.recetaMedica = recetaMedica; 
    }
    
    public void setPrecio(double precio) {
        this.precio = precio; 
    }
    
    public void setStock(int stock) {
        this.stock = stock; 
    }
    
    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad; 
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", recetaMedica=" + recetaMedica +
                ", precio=" + precio +
                ", stock=" + stock +
                ", fechaCaducidad=" + fechaCaducidad +
                ", farmacia='" + farmacia + '\'' +
                '}';
    }
}
