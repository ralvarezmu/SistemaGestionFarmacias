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
    
    /**
     * Crea una nueva instancia del mostrador de medicamentos para la farmacia de Madrid.
     *
     * @param listaAnalgesicos      Lista visual donde se mostrarán los analgésicos de Madrid.
     * @param listaAntibioticos     Lista visual donde se mostrarán los antibióticos de Madrid.
     * @param listaAntinflamatorios Lista visual donde se mostrarán los antiinflamatorios de Madrid.
     * @param almacen               Referencia al {@link AlmacenMedicamentos} que contiene los medicamentos.
     */
    public MostradorMedicamentosImpMadrid(JList<Medicamento> listaAnalgesicos, JList<Medicamento> listaAntibioticos, JList<Medicamento> listaAntinflamatorios, AlmacenMedicamentos almacen) {
        super(listaAnalgesicos, listaAntibioticos, listaAntinflamatorios, almacen);
    }
    
    /**
     * Muestra los medicamentos de la farmacia de Madrid en las listas de la interfaz gráfica.
     * Este método obtiene los medicamentos de la sucursal de Madrid desde
     * 
     * {@link AlmacenMedicamentos} y los carga en los modelos visuales correspondientes:
     * 
     *   Analgésicos → lista de analgésicos
     *   Antibióticos → lista de antibióticos
     *   Antiinflamatorios → lista de antiinflamatorios
     * 
     */
    @Override
    public void mostrarMedicamentos() {
        for (Medicamento m : super.getAlmacen().getAnalgesicosMadrid()) {
            super.getModeloMedicamentosAnalgesicos().addElement(m);
        }
        
        for (Medicamento m : super.getAlmacen().getAntibioticosMadrid()) {
            super.getModeloMedicamentosAntibioticos().addElement(m);
        }
        
        for (Medicamento m : super.getAlmacen().getAntiinflamatoriosMadrid()) {
            super.getModeloMedicamentosAntinflamatorios().addElement(m);
        }
    }
    
}
