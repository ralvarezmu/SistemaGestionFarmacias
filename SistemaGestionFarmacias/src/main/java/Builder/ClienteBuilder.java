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

    /**
     * Crea una nueva instancia del {@link ClienteBuilder} y resetea el objeto cliente en construcción.
     */
    public ClienteBuilder() {
        reset();
    }

    /**
     * Reinicia el proceso de construcción creando un nuevo objeto {@link Cliente}.
     * 
     * Este método se invoca automáticamente después de cada llamada a {@link #build()}
     * para mantener el builder preparado para crear una nueva instancia.
     * 
     */
    @Override
    public void reset() {
        cliente = new Cliente();
    }

    /**
     * Establece el nombre del cliente en construcción.
     *
     * @param nombre Nombre del cliente.
     * @return La instancia actual de {@code ClienteBuilder} (para permitir llamadas encadenadas).
     */
    @Override
    public ClienteBuilder setNombre(String nombre) {
        cliente.setNombre(nombre);
        return this;
    }

    /**
     * Establece el correo electrónico del cliente.
     *
     * @param email Correo electrónico del cliente.
     * @return La instancia actual de {@code ClienteBuilder}.
     */
    @Override
    public ClienteBuilder setEmail(String email) {
        cliente.setEmail(email);
        return this;
    }

    /**
     * Establece la contraseña del cliente.
     *
     * @param password Contraseña de acceso del cliente.
     * @return La instancia actual de {@code ClienteBuilder}.
     */
    @Override
    public ClienteBuilder setPassword(String password) {
        cliente.setPassword(password);
        return this;
    }

    /**
     * Establece la dirección física del cliente.
     *
     * @param direccion Dirección asociada al cliente.
     * @return La instancia actual de {@code ClienteBuilder}.
     */
    public ClienteBuilder setDireccion(String direccion) {
        cliente.setDireccion(direccion);
        return this;
    }

    /**
     * Finaliza el proceso de construcción y devuelve el objeto {@link Cliente} creado.
     * <p>
     * Antes de devolver el objeto, se validan todos los campos obligatorios.
     * Si alguno está ausente o vacío, se lanza una excepción {@link IllegalStateException}.
     * </p>
     *
     * @return Objeto {@link Cliente} completamente configurado.
     * @throws IllegalStateException Si falta alguno de los atributos obligatorios:
     *                               nombre, email, contraseña o dirección.
     */
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
