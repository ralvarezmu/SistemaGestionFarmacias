/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

/**
 *
 * @author sete
 */
public interface ServicioRegistro {
    
    /**
     * Registra un nuevo cliente en el sistema.
     * El servicio debe validar:
     * 
     *   Que todos los parámetros no estén vacíos
     *   Que el nombre de usuario no esté ya registrado
     *   Generar un ID único para el cliente
     *
     * @param usuario  Nombre de usuario único para el nuevo cliente.
     * @param password Contraseña segura para el nuevo cliente.
     * @param nombre   Nombre completo del cliente (nombre mostrado).
     * @throws RuntimeException Si faltan datos obligatorios o el usuario ya existe.
     */
    void registrarCliente(String usuario, String password, String nombre);
}
