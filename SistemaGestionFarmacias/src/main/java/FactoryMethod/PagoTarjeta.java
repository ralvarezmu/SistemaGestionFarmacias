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
    
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    } 
    
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
    
    @Override
    public void realizarPago() {
        System.out.println("Pago efectuado con tarjeta correctamente");
    }
    
}
