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
    
    /**
     * Construye un objeto {@link Cliente} completamente configurado utilizando
     * el builder especificado y los parámetros proporcionados.
     *
     * @param builder   Builder concreto encargado de crear el cliente.
     * @param nombre    Nombre completo del cliente.
     * @param email     Correo electrónico del cliente.
     * @param password  Contraseña de acceso del cliente.
     * @param direccion Dirección física del cliente.
     * @return Objeto {@link Cliente} totalmente inicializado y validado.
     *
     * @throws IllegalStateException Si alguno de los campos obligatorios está vacío
     *                               o no se cumple alguna validación del builder.
     */
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
    
    /**
     * Construye un objeto {@link Farmaceutico} completamente configurado utilizando
     * el builder correspondiente y los datos proporcionados.
     *
     * @param builder    Builder concreto encargado de crear el farmacéutico.
     * @param nombre     Nombre completo del farmacéutico.
     * @param email      Correo electrónico del farmacéutico.
     * @param password   Contraseña de acceso del farmacéutico.
     * @param idFarmacia Identificador o nombre de la farmacia asociada.
     * @return Objeto {@link Farmaceutico} totalmente inicializado y validado.
     *
     * @throws IllegalStateException Si el builder detecta información faltante o inválida.
     */
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