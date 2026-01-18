/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

/**
 *
 * @author claud
 */

import java.time.LocalDateTime;

public class Sesion {
    private final String idUsuario;
    private final String nombre;
    private final String rol;
    private final LocalDateTime inicio;

    /**
     * Crea una nueva sesión de usuario con timestamp automático.
     *
     * @param idUsuario Identificador único del usuario (ej: "C-001", "F-002").
     * @param nombre    Nombre completo del usuario.
     * @param rol       Rol asignado: "CLIENTE", "FARMACEUTICO" o "ADMIN".
     */
    public Sesion(String idUsuario, String nombre, String rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.rol = rol;
        this.inicio = LocalDateTime.now();
    }

    /**
     * Devuelve el identificador único del usuario autenticado.
     *
     * @return ID del usuario (ej: "C-001", "F-002", "AD-001").
     */
    public String getIdUsuario() { 
        return idUsuario; 
    }
    
    /**
     * Devuelve el nombre completo del usuario autenticado.
     *
     * @return Nombre mostrado del usuario.
     */
    public String getNombre() {
        return nombre; 
    }
    
    /**
     * Devuelve el rol de seguridad del usuario autenticado.
     *
     * @return Rol: "CLIENTE", "FARMACEUTICO" o "ADMIN".
     */
    public String getRol() {
        return rol; 
    }
    
    /**
     * Devuelve la fecha y hora de inicio de la sesión.
     *
     * @return Timestamp de creación de la sesión.
     */
    public LocalDateTime getInicio() {
        return inicio; 
    }

    /**
     * Devuelve una representación legible de la sesión activa.
     *
     * @return Cadena con todos los datos de la sesión,
     *         incluyendo el idUsuario, nombre, rol e inicio.
     */
    @Override
    public String toString() {
        return "Sesion{" +
                "idUsuario='" + idUsuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", rol='" + rol + '\'' +
                ", inicio=" + inicio +
                '}';
    }
}

