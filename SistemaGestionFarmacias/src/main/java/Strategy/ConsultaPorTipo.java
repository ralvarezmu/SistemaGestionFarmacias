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
public class ConsultaPorTipo implements EstrategiaConsultaMedicamentos {

    @Override
    public List<Medicamento> buscar(List<Medicamento> medicamentos, String criterio) {
        List<Medicamento> resultado = new ArrayList<>();
        if (medicamentos == null || criterio == null) return resultado;

        String c = normalizar(criterio);

        for (Medicamento m : medicamentos) {
            if (m == null) continue; //Si m es null se salta la iteración y pasa al siguiente medicamento

            String tipoMedicamento = normalizar(m.getTipo()); // ej: "analgesico"
            if (tipoMedicamento.contains(c)) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    private String normalizar(String s) {
        return s.trim().toLowerCase()
                .replace("á", "a").replace("é", "e").replace("í", "i")
                .replace("ó", "o").replace("ú", "u");
    }
}

