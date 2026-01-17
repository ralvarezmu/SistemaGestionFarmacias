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

    /**
     * Constructor protegido para inicializar un medicamento.
     * Este constructor es utilizado por las subclases dentro del patrón Factory Method.
     *
     * @param id              Identificador único del medicamento.
     * @param nombre          Nombre comercial del medicamento.
     * @param descripcion     Breve descripción del medicamento.
     * @param tipo            Tipo de medicamento (analgésico, antiinflamatorio o antibiótico).
     * @param recetaMedica    Indica si requiere receta médica.
     * @param precio          Precio unitario del medicamento.
     * @param stock           Cantidad disponible en inventario.
     * @param fechaCaducidad  Fecha de caducidad del medicamento.
     * @param farmacia        Farmacia que distribuye el medicamento ("Madrid" o "Barcelona").
     */
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

    /**
     * Devuelve el identificador único del medicamento.
     *
     * @return Identificador del medicamento.
     */
    public String getId() { 
        return id; 
    }
    
    /**
     * Devuelve el nombre comercial del medicamento.
     *
     * @return Nombre del medicamento.
     */
    public String getNombre() { 
        return nombre; 
    }
    
    /**
     * Devuelve la descripción del medicamento.
     *
     * @return Descripción del medicamento.
     */
    public String getDescripcion() {
        return descripcion; 
    }
    
    /**
     * Devuelve el tipo del medicamento.
     *
     * @return Tipo de medicamento (analgésico, antiinflamatorio o antibiótico).
     */
    public String getTipo() { 
        return tipo; 
    }
    
    /**
     * Indica si el medicamento requiere receta médica.
     *
     * @return {@code true} si requiere receta médica; {@code false} en caso contrario.
     */
    public boolean isRecetaMedica() {
        return recetaMedica; 
    }
    
     /**
     * Devuelve el precio unitario del medicamento.
     *
     * @return Precio del medicamento.
     */
    public double getPrecio() {
        return precio; 
    }
    
    /**
     * Devuelve la cantidad disponible en stock.
     *
     * @return Stock actual del medicamento.
     */
    public int getStock() {
        return stock; 
    }
    
    /**
     * Devuelve la fecha de caducidad del medicamento.
     *
     * @return Fecha de caducidad.
     */
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad; 
    }
    
    /**
     * Devuelve el nombre de la farmacia que distribuye este medicamento.
     *
     * @return Nombre de la farmacia (por ejemplo, "Madrid" o "Barcelona").
     */
    public String getFarmacia() {
        return farmacia; 
    }

    /**
     * Establece un nuevo nombre comercial para el medicamento.
     *
     * @param nombre Nuevo nombre del medicamento.
     */
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    
    /**
     * Establece una nueva descripción para el medicamento.
     *
     * @param descripcion Nueva descripción del medicamento.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion; 
    }
    
    /**
     * Define si el medicamento requiere receta médica.
     *
     * @param recetaMedica {@code true} si requiere receta médica; {@code false} en caso contrario.
     */
    public void setRecetaMedica(boolean recetaMedica) {
        this.recetaMedica = recetaMedica; 
    }
    
    /**
     * Establece el precio unitario del medicamento.
     *
     * @param precio Nuevo precio del medicamento.
     */
    public void setPrecio(double precio) {
        this.precio = precio; 
    }
    
    /**
     * Actualiza la cantidad disponible del medicamento.
     *
     * @param stock Nuevo valor de stock.
     */
    public void setStock(int stock) {
        this.stock = stock; 
    }
    
    /**
     * Establece la fecha de caducidad del medicamento.
     *
     * @param fechaCaducidad Nueva fecha de caducidad.
     */
    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad; 
    }

    /**
     * Devuelve una representación en cadena del medicamento,
     * incluyendo su información principal.
     *
     * @return Cadena descriptiva del medicamento.
     */
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
