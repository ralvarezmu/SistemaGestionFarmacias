/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author sete
 */
public class FarmaceuticoBuilder implements UsuarioBuilder{
    
    private Farmaceutico farmaceutico;

    public FarmaceuticoBuilder() {
        reset();
    }

    @Override
    public void reset() {
        farmaceutico = new Farmaceutico();
    }

    @Override
    public FarmaceuticoBuilder setNombre(String nombre) {
        farmaceutico.setNombre(nombre);
        return this;
    }

    @Override
    public FarmaceuticoBuilder setEmail(String email) {
        farmaceutico.setEmail(email);
        return this;
    }

    @Override
    public FarmaceuticoBuilder setPassword(String password) {
        farmaceutico.setPassword(password);
        return this;
    }

    
    public FarmaceuticoBuilder setIdFarmacia(String idFarmacia) {
        farmaceutico.setIdFarmacia(idFarmacia);
        return this;
    }

    @Override
    public Usuario build() {
        
        if (farmaceutico.getNombre() == null || farmaceutico.getNombre().isEmpty())
            throw new IllegalStateException("El nombre es obligatorio");

        if (farmaceutico.getEmail() == null || farmaceutico.getEmail().isEmpty())
            throw new IllegalStateException("El email es obligatorio");

        if (farmaceutico.getPassword() == null || farmaceutico.getPassword().isEmpty())
            throw new IllegalStateException("La contraseña es obligatoria");

        if (farmaceutico.getIdFarmacia() == null || farmaceutico.getIdFarmacia().isEmpty())
            throw new IllegalStateException("El farmacéutico debe estar asociado a una farmacia");

        Farmaceutico resultado = farmaceutico;
        reset();
        return resultado;
    }
    
}
