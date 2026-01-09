/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FactoryMethod;

/**
 *
 * @author Admin
 */
public class PagoBizum implements MetodoPago{
    
    private String numeroTelefono;
    
    public String getNumeroTelefono() {
        return numeroTelefono;
    } 
    
    @Override
    public void verificarDatos(String nTelefono) {
        String num = nTelefono.trim();

        // Por ejemplo, un teléfono de 9 dígitos (España fijo/móvil)
        if (num.length() != 9) {
            throw new IllegalArgumentException("El teléfono debe tener 9 dígitos");
        }

        // Comprobamos que todos sean dígitos
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                throw new IllegalArgumentException("El teléfono solo puede contener números");
            }
        }

        this.numeroTelefono = num;
    }
    
    @Override
    public void realizarPago() {
        System.out.println("Pago efectuado con bizum correctamente");
    }
    
}
