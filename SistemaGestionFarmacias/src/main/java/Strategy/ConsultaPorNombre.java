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
import java.util.ArrayList;
import java.util.List;

//Estrategia concreta
public class ConsultaPorNombre implements EstrategiaConsultaMedicamentos {

    /**
     * Busca medicamentos cuyo nombre contenga el criterio especificado.
     * 
     * Ejemplos de uso:
     * 
     *   criterio="para" → encuentra "Paracetamol 1g"
     *   criterio="ibu" → encuentra "Ibuprofeno 600mg"
     *   criterio="Gelo" → encuentra "Gelocatil 1g"
     * 
     * @param medicamentos Lista completa de medicamentos del inventario.
     * @param criterio     Parte del nombre del medicamento a buscar.
     * @return Lista de medicamentos cuyo nombre contiene el criterio.
     */
    @Override
    public List<Medicamento> buscar(List<Medicamento> medicamentos, String criterio) {
        //El criterio sería el nombre del medicamento
        List<Medicamento> resultado = new ArrayList<>();
        if (medicamentos == null || criterio == null) return resultado;

        String c = criterio.trim().toLowerCase();

        for (Medicamento m : medicamentos) { 
            if (m != null && m.getNombre() != null) { 
                if (m.getNombre().toLowerCase().contains(c)) { //Comprobar si el nombre del medicamento m contiene el criterio de búsqueda c
                    resultado.add(m);
                }
            }
        }
        return resultado;
    }
}

