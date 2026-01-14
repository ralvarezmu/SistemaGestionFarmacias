/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author sete
 */
public class UsuarioDirector {
    public Cliente constructCliente(ClienteBuilder builder,
                                    String nombre,
                                    String email,
                                    String password,
                                    String direccion) {

        builder.reset();
        builder.setNombre(nombre)
               .setEmail(email)
               .setPassword(password)
               .setDireccion(direccion);

        Usuario u = builder.build();   
        return (Cliente) u;            
    }
    
    
    public Farmaceutico constructFarmaceutico(FarmaceuticoBuilder builder,
                                              String nombre,
                                              String email,
                                              String password,
                                              String idFarmacia) {

        builder.reset();
        builder.setNombre(nombre)
               .setEmail(email)
               .setPassword(password)
               .setIdFarmacia(idFarmacia);

        Usuario u = builder.build();
        return (Farmaceutico) u;
    }
}