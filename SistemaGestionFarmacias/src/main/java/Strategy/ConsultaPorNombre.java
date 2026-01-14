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

    @Override
    public List<Medicamento> buscar(List<Medicamento> medicamentos, String criterio) {
        //El criterio sería el nombre del medicamento
        List<Medicamento> resultado = new ArrayList<>();
        //Si medicamentos es null, no hay nada que consultar
        //Si criterio es null, no hay una palabra clave para buscar
        if (medicamentos == null || criterio == null) return resultado;

        String c = criterio.trim().toLowerCase();

        for (Medicamento m : medicamentos) { //Iterar a través de cada medicamento en la lista medicamentos
            if (m != null && m.getNombre() != null) { 
                if (m.getNombre().toLowerCase().contains(c)) { //Comprobar si el nombre del medicamento m contiene el criterio de búsqueda c
                    resultado.add(m);
                }
            }
        }
        return resultado;
    }
}

