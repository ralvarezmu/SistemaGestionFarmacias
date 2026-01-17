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
    public static final int BIZUM = 2;
    
    /**
     * Constructor privado para prevenir instanciación externa
     * (implementación del patrón Singleton).
     */
    private ElectorMetodoPago(){
    }
    
    /**
     * Devuelve la única instancia de {@code ElectorMetodoPago} (lazy initialization).
     *
     * @return Instancia única del elector de métodos de pago.
     */
    public static ElectorMetodoPago getInstancia() {
        if(instancia == null) {
            instancia = new ElectorMetodoPago();
        }
        return instancia;
    }
    
    /**
     * Devuelve la única instancia de {@code ElectorMetodoPago} (lazy initialization).
     *
     * @return Instancia única del elector de métodos de pago.
     */
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
