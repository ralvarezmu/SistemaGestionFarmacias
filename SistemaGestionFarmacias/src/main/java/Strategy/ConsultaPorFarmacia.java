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

    @Override
    public List<Medicamento> buscar(List<Medicamento> medicamentos, String criterio) {
        List<Medicamento> resultado = new ArrayList<>();
        if (medicamentos == null || criterio == null) return resultado;

        String c = criterio.trim().toLowerCase();

        for (Medicamento m : medicamentos) {
            if (m == null) continue;

            if (m.getFarmacia() != null && m.getFarmacia().toLowerCase().contains(c)) {
                resultado.add(m);
            }
        }
        return resultado;
    }
}

