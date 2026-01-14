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
    Sesion iniciarSesion(String usuario, String password, String rolSolicitado);
}
