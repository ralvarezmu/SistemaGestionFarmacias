/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

/**
 *
 * @author claud
 */
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

//Proxy
public class ServicioLoginProxy implements ServicioLogin {

    private final ServicioLogin servicioReal;
    
    //Contador de cuántas veces ha fallado un usuario al iniciar sesión
    //Clave (usuario), valor (número de intentos fallidos)
    private final Map<String, Integer> intentosFallidos = new HashMap<>();
    //Bloquea temporalmente a un usuario cuando falla demasiadas veces el login
    //Clave (usuario), valor (instante en milisegundos hasta el que está bloqueado)
    private final Map<String, Long> tiempoUsuarioBloqueado = new HashMap<>();

    private final int maxIntentos;
    private final long bloqueoMs;

    /**
     * Constructor con configuración por defecto:
     * 3 intentos fallidos → bloqueo de 1 minuto (60 segundos).
     *
     * @param servicioReal Servicio de login real que se protegerá.
     */
    public ServicioLoginProxy(ServicioLogin servicioReal) {
        this(servicioReal, 3, 60000); // 3 intentos, 1 minuto (60000 milisegundos/60 segundos/1 minuto)
    }

    /**
     * Constructor configurable para ajustar la política de seguridad.
     *
     * @param servicioReal Servicio real de autenticación.
     * @param maxIntentos  Máximo número de intentos fallidos permitidos.
     * @param bloqueoMs    Duración del bloqueo temporal en milisegundos.
     */
    public ServicioLoginProxy(ServicioLogin servicioReal, int maxIntentos, long bloqueoMs) {
        this.servicioReal = servicioReal;
        this.maxIntentos = maxIntentos;
        this.bloqueoMs = bloqueoMs;
    }

    /**
     * {@inheritDoc}
     *
     * Flujo de procesamiento del Proxy:
     * 
     *   Validación de parámetros básicos
     *   Validación de rol permitido
     *   Comprobación de bloqueo temporal activo
     *   Registro del intento de login
     *   Delegación al servicio real
     *      ÉXITO: Reset de contadores → devuelve sesión
     *      FRACASO: Incrementa contador → bloquea si excede límite
     * 
     */
    @Override
    public Sesion iniciarSesion(String usuario, String password, String rolSolicitado) {

        // 1) Validaciones básicas
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new RuntimeException("Usuario vacío.");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new RuntimeException("Contraseña vacía.");
        }
        if (rolSolicitado == null || rolSolicitado.trim().isEmpty()) {
            throw new RuntimeException("Rol no indicado.");
        }

        // 2) Roles permitidos 
        if (!esRolPermitido(rolSolicitado)) {
            throw new RuntimeException("Rol no válido. Usa CLIENTE, FARMACEUTICO o ADMIN.");
        }

        // 3) Comprobar bloqueo
        long ahora = Instant.now().toEpochMilli();
        Long hasta = tiempoUsuarioBloqueado.get(usuario);

        if (hasta != null && ahora < hasta) {
            long segundos = (hasta - ahora) / 1000;
            throw new RuntimeException("Usuario bloqueado. Intenta en " + segundos + "s.");
        }

        // 4) Registro del intento de inicio de sesión
        System.out.println("[LOGIN] Intento -> usuario=" + usuario + " rol=" + rolSolicitado);

        try {
            // 5) Delegar al real
            Sesion sesion = servicioReal.iniciarSesion(usuario, password, rolSolicitado);

            // 6) Reset intentos si OK
            intentosFallidos.remove(usuario);
            tiempoUsuarioBloqueado.remove(usuario);

            System.out.println("[LOGIN] OK -> " + sesion);
            return sesion;

        } catch (RuntimeException ex) {
            // 7) Contar fallos
            int n = intentosFallidos.getOrDefault(usuario, 0) + 1;
            intentosFallidos.put(usuario, n);

            System.out.println("[LOGIN] FAIL (" + n + "/" + maxIntentos + ") -> " + ex.getMessage());

            if (n >= maxIntentos) {
                tiempoUsuarioBloqueado.put(usuario, ahora + bloqueoMs);
                intentosFallidos.put(usuario, 0); // resetea tras bloquear
                throw new RuntimeException("Demasiados intentos. Usuario bloqueado temporalmente.");
            }

            throw ex;
        }
    }

    /**
     * Valida si el rol solicitado es uno de los permitidos en el sistema.
     *
     * @param rol Rol a validar.
     * @return {@code true} si es CLIENTE, FARMACEUTICO o ADMIN.
     */
    private boolean esRolPermitido(String rol) {
        String r = rol.trim().toUpperCase();
        return r.equals("CLIENTE") || r.equals("FARMACEUTICO") || r.equals("ADMIN");
    }
}

