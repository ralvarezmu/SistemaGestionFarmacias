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
        
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    
    public String getNumeroTelefono() {
        return numeroTelefono;
    } 
    
    @Override
    public void PedirDatos() {
        System.out.println("Pidiendo datos");
    }
    
    @Override
    public void realizarPago() {
        System.out.println("Pago efectuado con bizum correctamente");
    }
    
}
