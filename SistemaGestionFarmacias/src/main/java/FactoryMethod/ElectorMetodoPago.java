/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FactoryMethod;

/**
 *
 * @author Admin
 */
public class ElectorMetodoPago {
    
    private static ElectorMetodoPago instancia;
 
    public static final int TARJETA = 0;
    public static final int PAYPAL = 1;
    public static final int BIZUM = 0;
    
    private ElectorMetodoPago(){
    }
    
    public static ElectorMetodoPago getInstancia() {
        if(instancia == null) {
            instancia = new ElectorMetodoPago();
        }
        return instancia;
    }
    
    public MetodoPago elegirMetodoPago(int tipo) {
        if (tipo == TARJETA) {
            return (new PagoTarjeta());
        }
        else if(tipo == PAYPAL) {
            return (new PagoPayPal());
        }
        else {
            return (new PagoBizum());
        }
    }
    
}
