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

//Contexto
public class ConsultorMedicamentos {

    private EstrategiaConsultaMedicamentos estrategia;

    public ConsultorMedicamentos(EstrategiaConsultaMedicamentos estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaConsultaMedicamentos estrategia) {
        this.estrategia = estrategia;
    }

    public List<Medicamento> consultar(List<Medicamento> medicamentos, String criterio) {
        if (estrategia == null) {
            throw new IllegalStateException("La estrategia de consulta no está definida.");
        }
        return estrategia.buscar(medicamentos, criterio);
    }
}

