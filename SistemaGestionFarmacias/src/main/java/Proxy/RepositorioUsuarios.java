/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

/**
 *
 * @author claud
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioUsuarios {

    // clave (String) es el nombre (cliente1) y el valor (UsuarioRecord) todos los datos de ese usuario
    private final Map<String, UsuarioRecord> usuarios = new HashMap<>();

    /**
     * Constructor que inicializa el repositorio con usuarios predefinidos:
     *   2 clientes de prueba
     *   2 farmacéuticos de prueba
     *   1 administrador
     */
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

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param usuario Nombre de usuario (clave en el mapa).
     * @return {@link UsuarioRecord} del usuario encontrado, o {@code null} si no existe.
     */
    public UsuarioRecord buscarPorUsuario(String usuario) {
        return usuarios.get(usuario);
    }

    /**
     * Clase interna inmutable que representa los datos completos de un usuario.
     */
    public static class UsuarioRecord {
        private final String password;
        private final String rol;
        private final String id;
        private final String nombre;

        /**
         * Crea un nuevo registro de usuario con datos inmutables.
         *
         * @param password Contraseña en texto plano.
         * @param rol      Rol del usuario.
         * @param id       ID único.
         * @param nombre   Nombre completo mostrado.
         */
        public UsuarioRecord(String password, String rol, String id, String nombre) {
            this.password = password;
            this.rol = rol;
            this.id = id;
            this.nombre = nombre;
        }

        /** Devuelve la contraseña del usuario. */
        public String getPassword() { 
            return password; 
        }
        
        /** Devuelve el rol del usuario. */
        public String getRol() {
            return rol; 
        }
        
        /** Devuelve el ID único del usuario. */
        public String getId() {
            return id; 
        }
        
        /** Devuelve el nombre mostrado del usuario. */
        public String getNombre() {
            return nombre; 
        }
    }
    
    /**
     * Registra un nuevo cliente en el sistema.
     *
     * Valida que no existan campos vacíos y que el usuario no esté ya registrado.
     * Genera automáticamente un ID secuencial del tipo "C-###".
     * 
     *
     * @param usuario        Nombre de usuario único.
     * @param password       Contraseña del nuevo cliente.
     * @param nombreMostrado Nombre completo que se mostrará.
     * @throws RuntimeException Si faltan datos obligatorios o el usuario ya existe.
     */
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

    /**
     * Genera un nuevo ID secuencial para clientes del formato "C-###".
     * 
     * Analiza todos los clientes existentes y asigna el siguiente número disponible.
     *
     * @return Nuevo ID del tipo "C-003", "C-004", etc.
     */
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
    
    /**
     * Recogemos el nombre de todos los usuarios.
     * 
     * Nos devuelve una lista de todos los clientes.
     *
     * @return Lista de clientes.
     */
    public List<String> getUsernamesClientes() {
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, UsuarioRecord> e : usuarios.entrySet()) {
            UsuarioRecord r = e.getValue();
            if ("CLIENTE".equalsIgnoreCase(r.getRol())) {
                res.add(e.getKey()); 
            }
        }
        res.sort(String::compareToIgnoreCase); 
        return res;
    }
    /**
     * Eliminacion de un cliente por su nombre.
     * 
     * @param username nombre de usuario que eliminar
     *
     */
    public void eliminarCliente(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new RuntimeException("Usuario vacío.");
        }

        UsuarioRecord r = usuarios.get(username);
        if (r == null) {
            throw new RuntimeException("El cliente no existe.");
        }

        if (!"CLIENTE".equalsIgnoreCase(r.getRol())) {
            throw new RuntimeException("Solo se pueden dar de baja clientes.");
        }

        usuarios.remove(username);
    }
    
}

