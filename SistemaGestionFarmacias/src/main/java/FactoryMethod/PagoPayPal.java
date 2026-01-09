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
    
    @Override
    public void realizarPago() {
        System.out.println("Pago efectuado con PayPal correctamente");
    }
    
}
