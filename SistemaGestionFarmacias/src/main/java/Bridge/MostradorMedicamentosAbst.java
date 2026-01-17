/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bridge;

import AbstractFactory.Medicamento;
import javax.swing.DefaultListModel;

/**
 *
 * @author Admin
 */
public class MostradorMedicamentosAbst {
    
    private MostradorMedicamentosImp imp;
    
    /**
     * Asigna el implementador concreto que realizará la presentación de los medicamentos.
     *
     * @param imp Objeto de tipo {@link MostradorMedicamentosImp} que define
     *            cómo se mostrarán los medicamentos.
     */
    public void setImplementador(MostradorMedicamentosImp imp) {
        this.imp = imp;
    }
    
    /**
     * Llama al método de mostrador del implementador para presentar los medicamentos.
     * 
     * Este método delega completamente la acción al objeto implementador asignado previamente.
     *
     * @throws NullPointerException Si no se ha asignado un implementador antes de llamar al método.
     */
    public void mostrarMedicamentos() {
        imp.mostrarMedicamentos();
    }
    
}
