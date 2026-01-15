/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proxy;

/**
 *
 * @author claud
 */
public class PruebaPatron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RepositorioUsuarios repo = new RepositorioUsuarios();

        // Sujeto real
        ServicioLogin real = new ServicioLoginReal(repo);

        // Proxy
        ServicioLogin login = new ServicioLoginProxy(real);

        // Cliente OK
        try {
            Sesion s1 = login.iniciarSesion("cliente1", "1234", "CLIENTE");
            System.out.println("Sesion cliente: " + s1);
        } catch (Exception e) {
            System.out.println("Error al iniciar sesión con cliente1: " + e.getMessage());
        }

        // Farmacéutico OK
        try {
            Sesion s2 = login.iniciarSesion("farmaceutico1", "admin", "FARMACEUTICO");
            System.out.println("Sesion farma: " + s2);
        } catch (Exception e) {
            System.out.println("Error al iniciar sesión con farmaceutico1: " + e.getMessage());
        }

        // Admin OK
        try {
            Sesion s3 = login.iniciarSesion("admin1", "root", "ADMIN");
            System.out.println("Sesion admin: " + s3);
        } catch (Exception e) {
            System.out.println("Error al iniciar sesión con admin1: " + e.getMessage());
        }

        // Fallo de rol
        try {
            login.iniciarSesion("cliente1", "1234", "ADMIN");
        } catch (Exception e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
    }
}

