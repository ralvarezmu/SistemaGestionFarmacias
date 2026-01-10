/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bridge;

import AbstractFactory.Medicamento;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Admin
 */
public abstract class MostradorMedicamentosImp {
    
    private DefaultListModel<Medicamento> modeloMedicamentosAnalgesicos = new DefaultListModel<>();
    private DefaultListModel<Medicamento> modeloMedicamentosAntibioticos = new DefaultListModel<>();
    private DefaultListModel<Medicamento> modeloMedicamentosAntinflamatorios = new DefaultListModel<>();
    
    private JList<Medicamento> listaAnalgesicos;
    private JList<Medicamento> listaAntibioticos;
    private JList<Medicamento> listaAntinflamatorios;
    
    private AlmacenMedicamentos almacen;
    
    public MostradorMedicamentosImp(JList<Medicamento> listaAnalgesicos, JList<Medicamento> listaAntibioticos, JList<Medicamento> listaAntinflamatorios, AlmacenMedicamentos almacen) {
        this.listaAnalgesicos = listaAnalgesicos;
        this.listaAntibioticos = listaAntibioticos;
        this.listaAntinflamatorios = listaAntinflamatorios;
        this.almacen = almacen;
        this.listaAnalgesicos.setModel(modeloMedicamentosAnalgesicos);
        this.listaAntibioticos.setModel(modeloMedicamentosAntibioticos);
        this.listaAntinflamatorios.setModel(modeloMedicamentosAntinflamatorios);
    }
    
    public DefaultListModel<Medicamento> getModeloMedicamentosAnalgesicos() {
        return this.modeloMedicamentosAnalgesicos;
    }
    
    public DefaultListModel<Medicamento> getModeloMedicamentosAntibioticos() {
        return this.modeloMedicamentosAntibioticos;
    }
    
    public DefaultListModel<Medicamento> getModeloMedicamentosAntinflamatorios() {
        return this.modeloMedicamentosAntinflamatorios;
    }
    
    public AlmacenMedicamentos getAlmacen() {
        return this.almacen;
    }
    
    public abstract void mostrarMedicamentos();
    
}
