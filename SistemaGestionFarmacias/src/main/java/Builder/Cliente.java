/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author sete
 */
public class Cliente extends Usuario{
    
    private String direccion;

    public Cliente(String direccion, String nombre, String email, String password) {
        super(nombre, email, password);
        this.direccion = direccion;
    }
    public Cliente(){}

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
               super.toString() +
               ", direccion=" + direccion +
               "}";
    }
    
    
    
}
