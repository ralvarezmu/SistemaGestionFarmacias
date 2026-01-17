/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package FactoryMethod;

/**
 *
 * @author Admin
 */
public interface MetodoPago {
    
    /**
     * Verifica la validez de los datos proporcionados para el método de pago.
     * 
     * Este método debe validar la información sensible del pago (número de tarjeta,
     * CVV, datos de PayPal, teléfono Bizum, etc.) antes de proceder con la transacción.
     * 
     *
     * @param datos Datos específicos del método de pago (cadena formateada).
     * @throws IllegalArgumentException Si los datos son inválidos o incompletos.
     */
    public void verificarDatos(String datos);
    
    /**
     * Realiza el pago utilizando los datos previamente verificados.
     * 
     * Este método ejecuta la transacción real con el proveedor de pagos,
     * actualizando el estado del pedido y notificando el resultado.
     * 
     *
     * @throws RuntimeException Si la transacción falla por cualquier motivo.
     */
    public void realizarPago();
    
}
