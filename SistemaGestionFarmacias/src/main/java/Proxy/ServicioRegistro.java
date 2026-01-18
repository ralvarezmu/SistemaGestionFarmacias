/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

import Builder.Cliente;

/**
 *
 * @author sete
 */
public interface ServicioRegistro {
    
    /**
     * Registra un nuevo cliente en el sistema.
     * El servicio debe validar:
     * 
     *   Que todos los parámetros estén rellenos
     *   Que el nombre de usuario no esté ya registrado
     *   Generar un ID único para el cliente
     *
     * @param Cliente cliente
     * @throws RuntimeException Si faltan datos obligatorios o el usuario ya existe.
     */
    void registrarCliente(Cliente cliente);
}
