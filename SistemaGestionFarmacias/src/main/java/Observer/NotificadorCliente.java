/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import Decorator.Pedido;

/**
 *
 * @author Admin
 */
public class NotificadorCliente implements Notificador{
    
    private String cliente;
    private Pedido pedido;
    
    /**
     * Crea un nuevo notificador para un cliente específico y su pedido asociado.
     *
     * @param nombreCliente Nombre del cliente destinatario de las notificaciones.
     * @param pedido        Pedido que se está monitoreando.
     */
    public NotificadorCliente(String nombreCliente, Pedido pedido) {
        this.cliente = nombreCliente;
        this.pedido = pedido;
    }
    
    /**
     * Notifica al cliente que su pedido está listo para recogida/entrega.
     * 
     * Realiza una notificación doble:
     * 
     *   Salida por consola personalizada con el nombre del cliente
     *   Diálogo modal Swing {@link JOptionPane} con icono de información
     */
    @Override
    public void actualizar() {
        System.out.println(cliente + ", tu pedido esta listo");
        javax.swing.JOptionPane.showMessageDialog(
            null,
            "Tu pedido esta listo",
            "Éxito",
            javax.swing.JOptionPane.INFORMATION_MESSAGE
        );
    }
    
}
