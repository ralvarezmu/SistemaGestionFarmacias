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

    public Sesion(String idUsuario, String nombre, String rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.rol = rol;
        this.inicio = LocalDateTime.now();
    }

    public String getIdUsuario() { 
        return idUsuario; 
    }
    
    public String getNombre() {
        return nombre; 
    }
    
    public String getRol() {
        return rol; 
    }
    
    public LocalDateTime getInicio() {
        return inicio; 
    }

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

