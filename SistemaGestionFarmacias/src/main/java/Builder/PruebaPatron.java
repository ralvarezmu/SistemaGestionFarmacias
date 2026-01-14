/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author sete
 */
public class PruebaPatron {
    
    public static void main(String[] args) {

        UsuarioDirector director = new UsuarioDirector();
        ClienteBuilder clienteBuilder = new ClienteBuilder();
        Cliente cliente = director.constructCliente(
                clienteBuilder,
                "Ana López",
                "ana@gmail.com",
                "1234",
                "Calle Mayor 10, Madrid"
        );

        System.out.println("CLIENTE CREADO:");
        System.out.println(cliente);
        FarmaceuticoBuilder farmBuilder = new FarmaceuticoBuilder();
        Farmaceutico farmaceutico = director.constructFarmaceutico(
                farmBuilder,
                "Carlos Pérez",
                "carlos@farmacia.com",
                "abcd",
                "FARM-001"
        );

        System.out.println("\nFARMACÉUTICO CREADO:");
        System.out.println(farmaceutico);
    }
    
}
