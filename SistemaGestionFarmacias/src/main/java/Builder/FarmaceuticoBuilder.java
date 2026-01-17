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

    /**
     * Crea una nueva instancia del builder e inicializa un nuevo objeto {@link Farmaceutico}.
     */
    public FarmaceuticoBuilder() {
        reset();
    }

    /**
     * Reinicia el builder, creando un nuevo objeto vacío de tipo {@link Farmaceutico}.
     * 
     * Este método se invoca automáticamente después de llamar a {@link #build()}
     * para permitir una nueva construcción independiente.
     * 
     */
    @Override
    public void reset() {
        farmaceutico = new Farmaceutico();
    }

    /**
     * Asigna el nombre del farmacéutico.
     *
     * @param nombre Nombre completo del farmacéutico.
     * @return Esta misma instancia del builder para encadenar llamadas.
     */
    @Override
    public FarmaceuticoBuilder setNombre(String nombre) {
        farmaceutico.setNombre(nombre);
        return this;
    }

    /**
     * Asigna el correo electrónico del farmacéutico.
     *
     * @param email Dirección de correo electrónico.
     * @return Esta misma instancia del builder para encadenar llamadas.
     */
    @Override
    public FarmaceuticoBuilder setEmail(String email) {
        farmaceutico.setEmail(email);
        return this;
    }

    /**
     * Asigna la contraseña del farmacéutico.
     *
     * @param password Contraseña de acceso.
     * @return Esta misma instancia del builder para encadenar llamadas.
     */
    @Override
    public FarmaceuticoBuilder setPassword(String password) {
        farmaceutico.setPassword(password);
        return this;
    }

     /**
     * Asigna el identificador de la farmacia a la que pertenece el farmacéutico.
     *
     * @param idFarmacia Identificador o nombre de la farmacia.
     * @return Esta misma instancia del builder para encadenar llamadas.
     */
    public FarmaceuticoBuilder setIdFarmacia(String idFarmacia) {
        farmaceutico.setIdFarmacia(idFarmacia);
        return this;
    }

    /**
     * Devuelve el objeto {@link Farmaceutico} construido, validando antes que todos los
     * atributos obligatorios estén presentes.
     * <p>
     * Si algún campo requerido no ha sido establecido, se lanza una excepción
     * {@link IllegalStateException} indicando qué dato falta.
     * </p>
     *
     * @return Objeto {@link Farmaceutico} completamente construido y válido.
     * @throws IllegalStateException Si falta alguno de los campos obligatorios:
     *                               nombre, email, contraseña o idFarmacia.
     */
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
