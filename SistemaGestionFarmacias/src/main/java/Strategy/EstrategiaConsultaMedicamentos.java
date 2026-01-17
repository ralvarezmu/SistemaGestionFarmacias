/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Strategy;

/**
 *
 * @author claud
 */
import AbstractFactory.Medicamento;
import java.util.List;

//Estrategia
public interface EstrategiaConsultaMedicamentos {
    
    /**
     * Aplica el algoritmo de búsqueda/filtrado específico de la estrategia
     * sobre la lista completa de medicamentos.
     *
     * @param medicamentos Lista completa de medicamentos disponibles.
     * @param criterio     Criterio de búsqueda (nombre, precio, tipo, etc.).
     * @return Lista filtrada de medicamentos que coinciden con el criterio.
     */
    List<Medicamento> buscar(List<Medicamento> medicamentos, String criterio);
}
