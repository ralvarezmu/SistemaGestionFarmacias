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
public class ConsultaPorFarmacia implements EstrategiaConsultaMedicamentos {

    /**
     * Busca medicamentos cuya farmacia coincida (parcialmente) con el criterio.
     * 
     * Ejemplos de uso:
     * 
     *   criterio="madr" → encuentra farmacia "Madrid"
     *   criterio="bar" → encuentra farmacia "Barcelona"
     * 
     * @param medicamentos Lista completa de medicamentos del inventario.
     * @param criterio     Nombre o parte del nombre de la farmacia a buscar.
     * @return Lista de medicamentos de la farmacia coincidente.
     */
    @Override
    public List<Medicamento> buscar(List<Medicamento> medicamentos, String criterio) {
        List<Medicamento> resultado = new ArrayList<>();
        if (medicamentos == null || criterio == null) return resultado;

        String c = normalizar(criterio);

        for (Medicamento m : medicamentos) {
            if (m == null) continue;

            String f = normalizar(m.getFarmacia());  
            if (f.contains(c)) {
                resultado.add(m);
            }
        }
        return resultado;
    }
    
     /**
     * Normaliza texto para búsqueda insensible a mayúsculas/minúsculas
     * y caracteres acentuados.
     *
     * Transformaciones aplicadas:
     * 
     *   Trim espacios
     *   Minúsculas
     *   á→a, é→e, í→i, ó→o, ú→u
     * 
     * @param s Texto a normalizar.
     * @return Texto normalizado para comparación.
     */
        private String normalizar(String s) {
        if (s == null) return "";
        return s.trim().toLowerCase()
                .replace("á", "a").replace("é", "e").replace("í", "i")
                .replace("ó", "o").replace("ú", "u");
    }
}

