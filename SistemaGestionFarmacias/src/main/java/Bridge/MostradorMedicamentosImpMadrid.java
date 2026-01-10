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
public class MostradorMedicamentosImpMadrid extends MostradorMedicamentosImp {
    
    public MostradorMedicamentosImpMadrid(JList<Medicamento> listaAnalgesicos, JList<Medicamento> listaAntibioticos, JList<Medicamento> listaAntinflamatorios, AlmacenMedicamentos almacen) {
        super(listaAnalgesicos, listaAntibioticos, listaAntinflamatorios, almacen);
    }
    
    @Override
    public void mostrarMedicamentos() {
        for (Medicamento m : super.getAlmacen().getAnalgesicosMadrid()) {
            super.getModeloMedicamentosAnalgesicos().addElement(m);
        }
        
        for (Medicamento m : super.getAlmacen().getAntibioticosMadrid()) {
            super.getModeloMedicamentosAntibioticos().addElement(m);
        }
        
        for (Medicamento m : super.getAlmacen().getAntinflamatoriosMadrid()) {
            super.getModeloMedicamentosAntinflamatorios().addElement(m);
        }
    }
    
}
