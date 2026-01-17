/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

/**
 *
 * @author claud
 */
//Sujeto real
public class ServicioLoginReal implements ServicioLogin,ServicioRegistro {

    private final RepositorioUsuarios repo;

    public ServicioLoginReal(RepositorioUsuarios repo) {
        this.repo = repo;
    }

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
    
    public void registrarCliente(String usuario, String password, String nombre) {
        repo.registrarCliente(usuario, password, nombre);
    }
}

