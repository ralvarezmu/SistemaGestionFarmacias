/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author sete
 */
public class Farmaceutico extends Usuario{
    
    private String idFarmacia;

    public Farmaceutico(String idFarmacia, String nombre, String email, String password) {
        super(nombre, email, password);
        this.idFarmacia = idFarmacia;
    }
    public Farmaceutico(){}
    
    public String getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(String idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    @Override
    public String toString() {
        return "Farmaceutico{" +
               super.toString() +
               ", idFarmacia=" + idFarmacia +
               "}";
    }

    
}
