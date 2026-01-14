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
    List<Medicamento> buscar(List<Medicamento> medicamentos, String criterio);
}
