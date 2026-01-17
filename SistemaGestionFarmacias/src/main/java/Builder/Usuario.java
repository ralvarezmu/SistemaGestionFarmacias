/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author sete
 */
public class Usuario {
    
    private String nombre;
    private String email;
    private String password;

    /**
     * Crea un nuevo objeto {@code Usuario} con los datos proporcionados.
     *
     * @param nombre   Nombre completo del usuario.
     * @param email    Correo electrónico de contacto o acceso.
     * @param password Contraseña utilizada para la autenticación.
     */
    public Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }
    
    /**
     * Constructor vacío para permitir la creación de usuarios sin inicializar los campos.
     * 
     * Es útil para procesos de deserialización o frameworks que requieren un constructor por defecto.
     * 
     */
    public Usuario(){}

    /**
     * Devuelve el nombre completo del usuario.
     *
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define un nuevo nombre para el usuario.
     *
     * @param nombre Nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el correo electrónico del usuario.
     *
     * @return Correo electrónico asociado.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email Nueva dirección de correo electrónico.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve la contraseña del usuario.
     *
     * @return Contraseña de acceso.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece una nueva contraseña para el usuario.
     *
     * @param password Nueva contraseña de acceso.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Devuelve una representación en cadena del usuario,
     * mostrando su nombre, correo electrónico y contraseña.
     *
     * @return Cadena con los datos básicos del usuario.
     */
    @Override
    public String toString() {
        return "nombre=" + nombre +
               ", email=" + email +
               ", password=" + password;
    }
    
    
    
}
