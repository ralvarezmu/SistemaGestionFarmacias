/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author sete
 */
public interface UsuarioBuilder {
    
    /**
     * Reinicia el proceso de construcción del objeto, creando una nueva instancia.
     * 
     * Este método es útil para reutilizar el builder y evitar conservar
     * el estado de una construcción anterior.
     * 
     */
    void reset();
    
    /**
     * Asigna el nombre al usuario en construcción.
     *
     * @param nombre Nombre del usuario.
     * @return Esta misma instancia de {@code UsuarioBuilder}
     *         para permitir llamadas encadenadas.
     */
    UsuarioBuilder setNombre(String nombre);
    
    /**
     * Asigna el correo electrónico al usuario en construcción.
     *
     * @param email Correo electrónico del usuario.
     * @return Esta misma instancia de {@code UsuarioBuilder}
     *         para permitir llamadas encadenadas.
     */
    UsuarioBuilder setEmail(String email);
    
    /**
     * Asigna la contraseña del usuario en construcción.
     *
     * @param password Contraseña del usuario.
     * @return Esta misma instancia de {@code UsuarioBuilder}
     *         para permitir llamadas encadenadas.
     */
    UsuarioBuilder setPassword(String password);
    
    /**
     * Finaliza el proceso de construcción y devuelve el objeto {@link Usuario} creado.
     * 
     * Las implementaciones deben incluir validaciones para asegurar que todos los
     * atributos obligatorios fueron proporcionados antes de devolver el resultado.
     *
     * @return El objeto {@link Usuario} completamente configurado.
     * @throws IllegalStateException Si falta información obligatoria.
     */
    Usuario build();  
}
