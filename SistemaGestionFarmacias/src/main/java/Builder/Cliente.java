/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author sete
 */
public class Cliente extends Usuario{
    
    private String direccion;

    /**
     * Crea una nueva instancia de {@link Cliente} con la información especificada.
     *
     * @param direccion Dirección física del cliente.
     * @param nombre    Nombre completo del cliente.
     * @param email     Correo electrónico del cliente.
     * @param password  Contraseña de acceso del cliente.
     */
    public Cliente(String direccion, String nombre, String email, String password) {
        super(nombre, email, password);
        this.direccion = direccion;
    }
    
    /**
     * Constructor vacío para permitir la creación de objetos sin inicializar los campos.
     * 
     * Es útil en contextos como la deserialización o frameworks que requieren un
     * constructor sin parámetros.
     * 
     */
    public Cliente(){}

    /**
     * Devuelve la dirección física registrada del cliente.
     *
     * @return Dirección del cliente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece una nueva dirección para el cliente.
     *
     * @param direccion Nueva dirección del cliente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve una representación en cadena del cliente, incluyendo su información básica
     * y su dirección.
     *
     * @return Cadena con los datos del cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" +
               super.toString() +
               ", direccion=" + direccion +
               "}";
    }
    
}
