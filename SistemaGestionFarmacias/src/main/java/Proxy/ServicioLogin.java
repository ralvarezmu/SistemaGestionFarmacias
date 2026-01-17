/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proxy;

/**
 *
 * @author claud
 */
//Sujeto
public interface ServicioLogin {
    
    /**
     * Inicia sesión para un usuario validando sus credenciales y devolviendo
     * una sesión con los permisos correspondientes.
     *
     * @param usuario        Nombre de usuario (clave en {@link RepositorioUsuarios}).
     * @param password       Contraseña del usuario.
     * @param rolSolicitado Rol que el usuario desea acceder (CLIENTE, FARMACEUTICO, ADMIN).
     * @return Objeto {@link Sesion} con los datos del usuario autenticado y permisos asignados.
     * @throws RuntimeException Si las credenciales son inválidas, el usuario no existe,
     *         o el rol solicitado no coincide con el rol del usuario.
     */
    Sesion iniciarSesion(String usuario, String password, String rolSolicitado);
}
