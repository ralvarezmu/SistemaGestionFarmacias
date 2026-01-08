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
    public void PedirDatos() {
        System.out.println("Pidiendo datos");
    }
    
    @Override
    public void realizarPago() {
        System.out.println("Pago efectuado con tarjeta correctamente");
    }
    
}
