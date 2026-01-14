/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author sete
 */
public class ClienteBuilder implements UsuarioBuilder{
    
    private Cliente cliente;

    public ClienteBuilder() {
        reset();
    }

    @Override
    public void reset() {
        cliente = new Cliente();
    }

    @Override
    public ClienteBuilder setNombre(String nombre) {
        cliente.setNombre(nombre);
        return this;
    }

    @Override
    public ClienteBuilder setEmail(String email) {
        cliente.setEmail(email);
        return this;
    }

    @Override
    public ClienteBuilder setPassword(String password) {
        cliente.setPassword(password);
        return this;
    }

    public ClienteBuilder setDireccion(String direccion) {
        cliente.setDireccion(direccion);
        return this;
    }

    @Override
    public Usuario build() {
        
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty())
            throw new IllegalStateException("El nombre es obligatorio");

        if (cliente.getEmail() == null || cliente.getEmail().isEmpty())
            throw new IllegalStateException("El email es obligatorio");

        if (cliente.getPassword() == null || cliente.getPassword().isEmpty())
            throw new IllegalStateException("La contraseña es obligatoria");

        if (cliente.getDireccion() == null || cliente.getDireccion().isEmpty())
            throw new IllegalStateException("La dirección es obligatoria para un cliente");

        Cliente resultado = cliente;
        reset(); 
        return resultado;
    }
    
}
