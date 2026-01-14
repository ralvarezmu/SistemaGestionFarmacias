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
    
    void reset();
    UsuarioBuilder setNombre(String nombre);
    UsuarioBuilder setEmail(String email);
    UsuarioBuilder setPassword(String password);
    Usuario build();  
}
