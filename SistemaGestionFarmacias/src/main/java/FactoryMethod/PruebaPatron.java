/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FactoryMethod;

/**
 *
 * @author Admin
 */
public class PruebaPatron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ElectorMetodoPago E1;
        
        E1 = ElectorMetodoPago.getInstancia();
        
        MetodoPago MP1 = E1.elegirMetodoPago(0);
        MP1.realizarPago();
        
        MP1 = E1.elegirMetodoPago(1);
        MP1.realizarPago();
        
    }
    
}
