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

    /**
     * Crea una nueva instancia de {@link Farmaceutico} con la información especificada.
     *
     * @param idFarmacia Identificador o nombre de la farmacia asociada.
     * @param nombre     Nombre completo del farmacéutico.
     * @param email      Correo electrónico del farmacéutico.
     * @param password   Contraseña de acceso del farmacéutico.
     */
    public Farmaceutico(String idFarmacia, String nombre, String email, String password) {
        super(nombre, email, password);
        this.idFarmacia = idFarmacia;
    }
    
    /**
     * Constructor vacío, utilizado para crear instancias del objeto sin parámetros.
     * 
     * Es útil para operaciones de serialización o frameworks que requieren constructores por defecto.
     * 
     */
    public Farmaceutico(){}
    
    /**
     * Devuelve el identificador de la farmacia a la que pertenece el farmacéutico.
     *
     * @return Identificador o nombre de la farmacia.
     */
    public String getIdFarmacia() {
        return idFarmacia;
    }

    /**
     * Establece el identificador de la farmacia asociada al farmacéutico.
     *
     * @param idFarmacia Nuevo identificador o nombre de la farmacia.
     */
    public void setIdFarmacia(String idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    /**
     * Devuelve una representación en cadena del farmacéutico, incluyendo sus datos principales
     * y la información de su farmacia.
     *
     * @return Cadena con los datos del farmacéutico.
     */
    @Override
    public String toString() {
        return "Farmaceutico{" +
               super.toString() +
               ", idFarmacia=" + idFarmacia +
               "}";
    }

    
}
