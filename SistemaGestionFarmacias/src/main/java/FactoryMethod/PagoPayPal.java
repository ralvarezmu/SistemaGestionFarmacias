/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FactoryMethod;

/**
 *
 * @author Admin
 */
public class PagoPayPal implements MetodoPago{
    
    private String codigo;
    
    /**
     * Verifica la validez de los datos del pago PayPal.
     * 
     * Realiza las siguientes validaciones:
     * 
     *   Longitud exacta de 10 caracteres
     *   Solo letras mayúsculas (A-Z) y dígitos (0-9)
     *
     * @param codigo Código de PayPal proporcionado por el usuario.
     * @throws IllegalArgumentException Si el código no cumple los requisitos de formato.
     */
    @Override
    public void verificarDatos(String codigo) {
        String cod = codigo.trim();

        // Por ejemplo, exigimos 10 caracteres
        if (cod.length() != 10) {
            throw new IllegalArgumentException("El código de PayPal debe tener 10 caracteres");
        }

        // Permitimos solo letras mayúsculas y dígitos
        for (int i = 0; i < cod.length(); i++) {
            char c = cod.charAt(i);
            if (!Character.isDigit(c) && !(c >= 'A' && c <= 'Z')) {
                throw new IllegalArgumentException(
                    "El código de PayPal solo puede contener letras mayúsculas y números"
                );
            }
        }

        this.codigo = cod;
    }
    
    /**
     * Simula la realización del pago mediante PayPal utilizando el código validado.
     */
    @Override
    public void realizarPago() {
        System.out.println("Pago efectuado con PayPal correctamente");
    }
    
}
