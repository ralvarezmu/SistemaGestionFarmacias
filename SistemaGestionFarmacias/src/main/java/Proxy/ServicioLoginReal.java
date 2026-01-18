/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

import Builder.Cliente;

/**
 *
 * @author claud
 */
//Sujeto real
public class ServicioLoginReal implements ServicioLogin,ServicioRegistro {

    private final RepositorioUsuarios repo;

    /**
     * Crea una nueva instancia del servicio real, inyectando el repositorio de usuarios.
     *
     * @param repo Repositorio donde se almacenan todos los usuarios del sistema.
     */
    public ServicioLoginReal(RepositorioUsuarios repo) {
        this.repo = repo;
    }

    /**
     * {@inheritDoc}
     * 
     * Realiza la autenticación completa en tres pasos:
     *   Busca el usuario en el repositorio
     *   Valida la contraseña
     *   Verifica que el rol solicitado coincida
     * 
     */
    @Override
    public Sesion iniciarSesion(String usuario, String password, String rolSolicitado) {
        RepositorioUsuarios.UsuarioRecord record = repo.buscarPorUsuario(usuario);

        if (record == null) {
            throw new RuntimeException("Usuario no existe.");
        }

        if (!record.getPassword().equals(password)) {
            throw new RuntimeException("Contraseña incorrecta.");
        }

        if (!record.getRol().equalsIgnoreCase(rolSolicitado)) {
            throw new RuntimeException("Rol no autorizado para este usuario.");
        }

        return new Sesion(record.getId(), record.getNombre(), record.getRol());
    }
    
    /**
     * Registra un nuevo cliente delegando completamente en el repositorio.
     * 
     * Todas las validaciones (campos vacíos, usuario duplicado, generación de ID)
     * se realizan en {@link RepositorioUsuarios#registrarCliente(String, String, String)}.
     *
     * @param usuario  Nombre de usuario único para el nuevo cliente.
     * @param password Contraseña del nuevo cliente.
     * @param nombre   Nombre completo mostrado del cliente.
     * @throws RuntimeException Si las validaciones del repositorio fallan.
     */
    @Override
    public void registrarCliente(Cliente cliente) {
        repo.registrarCliente(cliente);
    }
}

