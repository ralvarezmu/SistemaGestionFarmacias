/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FactoryMethod;

/**
 *
 * @author Admin
 */
public class PagoTarjeta implements MetodoPago{
    
    private String numeroTarjeta;
    
    /**
     * Establece el número de tarjeta para esta instancia de pago.
     *
     * @param numeroTarjeta Número de tarjeta de 16 dígitos.
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
    /**
     * Devuelve el número de tarjeta almacenado y validado.
     *
     * @return Número de tarjeta de 16 dígitos.
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    } 
    
    /**
     * Verifica la validez de los datos de la tarjeta de crédito/débito.
     * 
     * Realiza las siguientes validaciones:
     * 
     *   Longitud exacta de 16 dígitos
     *   Solo caracteres numéricos
     *
     * @param nTCredito Número de tarjeta proporcionado por el usuario.
     * @throws IllegalArgumentException Si el número no tiene 16 dígitos o contiene caracteres no numéricos.
     */
    @Override
    public void verificarDatos(String nTCredito) {
        // Eliminamos espacios al principio y final
        String num = nTCredito.trim();
        
        // Comprobamos que tenga 16 caracteres
        if (num.length() != 16) {
            throw new IllegalArgumentException("La tarjeta debe tener 16 dígitos");
        }
        
        // Comprobamos que todos sean dígitos
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                throw new IllegalArgumentException("La tarjeta solo puede contener números");
            }
        }
        
        // Si todo está bien, guardamos el número
        this.numeroTarjeta = num;
    }
    
    /**
     * Simula la realización del pago mediante tarjeta utilizando el número validado.
     */
    @Override
    public void realizarPago() {
        System.out.println("Pago efectuado con tarjeta correctamente");
    }
    
}
