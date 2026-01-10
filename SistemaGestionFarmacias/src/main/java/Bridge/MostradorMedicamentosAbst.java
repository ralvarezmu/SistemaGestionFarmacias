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
    
    public void setImplementador(MostradorMedicamentosImp imp) {
        this.imp = imp;
    }
    
    public void mostrarMedicamentos() {
        imp.mostrarMedicamentos();
    }
    
}
