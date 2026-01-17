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
    
    /**
     * Devuelve el número de teléfono validado y almacenado para este pago Bizum.
     *
     * @return Número de teléfono de 9 dígitos.
     */
    public String getNumeroTelefono() {
        return numeroTelefono;
    } 
    
    /**
     * Verifica la validez de los datos del pago Bizum.
     * 
     * Realiza las siguientes validaciones:
     * 
     *   Longitud exacta de 9 dígitos
     *   Solo caracteres numéricos
     *
     * @param nTelefono Número de teléfono en formato cadena.
     * @throws IllegalArgumentException Si el número no tiene 9 dígitos o contiene caracteres no numéricos.
     */
    @Override
    public void verificarDatos(String nTelefono) {
        String num = nTelefono.trim();

        // Teléfono de 9 dígitos (España fijo/móvil)
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
    
    /**
     * Simula la realización del pago mediante Bizum utilizando el número de teléfono validado.
     */
    @Override
    public void realizarPago() {
        System.out.println("Pago efectuado con bizum correctamente");
    }
    
}
