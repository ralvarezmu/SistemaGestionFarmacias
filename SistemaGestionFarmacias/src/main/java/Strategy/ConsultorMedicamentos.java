/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

/**
 *
 * @author claud
 */
import AbstractFactory.Medicamento;
import java.util.List;

//Contexto
public class ConsultorMedicamentos {

    private EstrategiaConsultaMedicamentos estrategia;

    /**
     * Crea un consultor con la estrategia de búsqueda especificada.
     * 
     * La estrategia debe estar definida antes de cualquier consulta.
     *
     * @param estrategia Estrategia concreta para realizar las búsquedas.
     * @throws IllegalArgumentException si la estrategia es {@code null}.
     */
    public ConsultorMedicamentos(EstrategiaConsultaMedicamentos estrategia) {
        this.estrategia = estrategia;
    }

    /**
     * Cambia la estrategia de búsqueda en tiempo de ejecución
     * (polimorfismo dinámico).
     * 
     * Ejemplo de uso:
     * {@code consultor.setEstrategia(new ConsultaPorFarmacia());}
     * 
     *
     * @param estrategia Nueva estrategia de búsqueda a utilizar.
     * @throws IllegalArgumentException si la estrategia es {@code null}.
     */
    public void setEstrategia(EstrategiaConsultaMedicamentos estrategia) {
        this.estrategia = estrategia;
    }

    /**
     * Ejecuta la búsqueda delegando completamente a la estrategia actual.
     * 
     * Flujo de ejecución:
     * 
     *   Valida que la estrategia esté definida
     *   Invoca {@link EstrategiaConsultaMedicamentos#buscar}
     *   Devuelve resultados sin conocer la implementación concreta
     * 
     * @param medicamentos Lista completa del inventario.
     * @param criterio     Texto de búsqueda específico del tipo de estrategia.
     * @return Lista de medicamentos que coinciden con el criterio.
     * @throws IllegalStateException si no hay estrategia definida.
     */
    public List<Medicamento> consultar(List<Medicamento> medicamentos, String criterio) {
        if (estrategia == null) {
            throw new IllegalStateException("La estrategia de consulta no está definida.");
        }
        return estrategia.buscar(medicamentos, criterio);
    }
}

