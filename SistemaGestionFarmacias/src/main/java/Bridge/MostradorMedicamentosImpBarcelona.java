/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bridge;

import AbstractFactory.Medicamento;
import javax.swing.JList;

/**
 *
 * @author Admin
 */
public class MostradorMedicamentosImpBarcelona extends MostradorMedicamentosImp {
    
    /**
     * Crea una nueva instancia del mostrador de medicamentos para la farmacia de Barcelona.
     *
     * @param listaAnalgesicos      Lista visual donde se mostrarán los analgésicos de Barcelona.
     * @param listaAntibioticos     Lista visual donde se mostrarán los antibióticos de Barcelona.
     * @param listaAntinflamatorios Lista visual donde se mostrarán los antiinflamatorios de Barcelona.
     * @param almacen               Referencia al {@link AlmacenMedicamentos} que contiene los medicamentos.
     */
    public MostradorMedicamentosImpBarcelona(JList<Medicamento> listaAnalgesicos, JList<Medicamento> listaAntibioticos, JList<Medicamento> listaAntinflamatorios, AlmacenMedicamentos almacen) {
        super(listaAnalgesicos, listaAntibioticos, listaAntinflamatorios, almacen);
    }
    
    /**
     * Muestra los medicamentos de la farmacia de Barcelona en los componentes visuales asignados.
     * 
     * Obtiene los medicamentos almacenados en {@link AlmacenMedicamentos}
     * y los carga en los modelos correspondientes de la interfaz:
     * 
     *     Analgésicos → lista de analgésicos
     *     Antibióticos → lista de antibióticos
     *     Antiinflamatorios → lista de antiinflamatorios
     * 
     */
    @Override
    public void mostrarMedicamentos() {
        for (Medicamento m : super.getAlmacen().getAnalgesicosBarcelona()) {
            super.getModeloMedicamentosAnalgesicos().addElement(m);
        }
        
        for (Medicamento m : super.getAlmacen().getAntibioticosBarcelona()) {
            super.getModeloMedicamentosAntibioticos().addElement(m);
        }
        
        for (Medicamento m : super.getAlmacen().getAntiinflamatoriosBarcelona()) {
            super.getModeloMedicamentosAntinflamatorios().addElement(m);
        }
    }
    
}
