/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

/**
 *
 * @author claud
 */
import java.util.HashMap;
import java.util.Map;

public class RepositorioUsuarios {

    // clave (String) es el nombre (cliente1) y el valor (UsuarioRecord) todos los datos de ese usuario
    private final Map<String, UsuarioRecord> usuarios = new HashMap<>();

    public RepositorioUsuarios() {
        // CLIENTES
        usuarios.put("cliente1", new UsuarioRecord("1234", "CLIENTE", "C-001", "Ana Sánchez"));
        usuarios.put("cliente2", new UsuarioRecord("abcd", "CLIENTE", "C-002", "Luis López"));

        // FARMACÉUTICOS
        usuarios.put("farma1", new UsuarioRecord("admin", "FARMACEUTICO", "F-001", "Marta Gutiérrez"));
        usuarios.put("farma2", new UsuarioRecord("pass", "FARMACEUTICO", "F-002", "Carlos Gracía"));

        // ADMIN
        usuarios.put("admin1", new UsuarioRecord("root", "ADMIN", "AD-001", "Administrador"));
    }

    public UsuarioRecord buscarPorUsuario(String usuario) {
        return usuarios.get(usuario);
    }

    public static class UsuarioRecord {
        private final String password;
        private final String rol;
        private final String id;
        private final String nombre;

        public UsuarioRecord(String password, String rol, String id, String nombre) {
            this.password = password;
            this.rol = rol;
            this.id = id;
            this.nombre = nombre;
        }

        public String getPassword() { 
            return password; 
        }
        
        public String getRol() {
            return rol; 
        }
        
        public String getId() {
            return id; 
        }
        
        public String getNombre() {
            return nombre; 
        }
    }
    
    public void registrarCliente(String usuario, String password, String nombreMostrado) {

        if (usuario == null || usuario.trim().isEmpty())
            throw new RuntimeException("Usuario vacío.");

        if (password == null || password.trim().isEmpty())
            throw new RuntimeException("Contraseña vacía.");

        if (nombreMostrado == null || nombreMostrado.trim().isEmpty())
            throw new RuntimeException("Nombre vacío.");

        String key = usuario.trim();

        if (usuarios.containsKey(key)) {
            throw new RuntimeException("Ese usuario ya existe.");
        }

        String id = generarNuevoIdCliente();
        usuarios.put(key, new UsuarioRecord(password, "CLIENTE", id, nombreMostrado));
    }

    private String generarNuevoIdCliente() {
        int max = 0;
        for (UsuarioRecord r : usuarios.values()) {
            if ("CLIENTE".equalsIgnoreCase(r.getRol()) && r.getId().startsWith("C-")) {
                try {
                    int n = Integer.parseInt(r.getId().substring(2));
                    if (n > max) max = n;
                } catch (NumberFormatException ignored) { }
            }
        }
        return String.format("C-%03d", max + 1);
    }
    
}

