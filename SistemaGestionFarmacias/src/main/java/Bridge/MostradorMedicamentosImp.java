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
    
    /**
     * Constructor que inicializa la implementación del mostrador con los componentes de la interfaz gráfica
     * y el almacén de medicamentos correspondiente.
     *
     * @param listaAnalgesicos       Lista visual donde se mostrarán los analgésicos.
     * @param listaAntibioticos      Lista visual donde se mostrarán los antibióticos.
     * @param listaAntinflamatorios  Lista visual donde se mostrarán los antiinflamatorios.
     * @param almacen                Referencia al {@link AlmacenMedicamentos} que contiene los datos.
     */
    public MostradorMedicamentosImp(JList<Medicamento> listaAnalgesicos, JList<Medicamento> listaAntibioticos, JList<Medicamento> listaAntinflamatorios, AlmacenMedicamentos almacen) {
        this.listaAnalgesicos = listaAnalgesicos;
        this.listaAntibioticos = listaAntibioticos;
        this.listaAntinflamatorios = listaAntinflamatorios;
        this.almacen = almacen;
        this.listaAnalgesicos.setModel(modeloMedicamentosAnalgesicos);
        this.listaAntibioticos.setModel(modeloMedicamentosAntibioticos);
        this.listaAntinflamatorios.setModel(modeloMedicamentosAntinflamatorios);
    }
    
    /**
     * Devuelve el modelo de datos de los medicamentos analgésicos.
     *
     * @return Modelo {@link DefaultListModel} de analgésicos.
     */
    public DefaultListModel<Medicamento> getModeloMedicamentosAnalgesicos() {
        return this.modeloMedicamentosAnalgesicos;
    }
    
    /**
     * Devuelve el modelo de datos de los medicamentos antibióticos.
     *
     * @return Modelo {@link DefaultListModel} de antibióticos.
     */
    public DefaultListModel<Medicamento> getModeloMedicamentosAntibioticos() {
        return this.modeloMedicamentosAntibioticos;
    }
    
    /**
     * Devuelve el modelo de datos de los medicamentos antiinflamatorios.
     *
     * @return Modelo {@link DefaultListModel} de antiinflamatorios.
     */
    public DefaultListModel<Medicamento> getModeloMedicamentosAntinflamatorios() {
        return this.modeloMedicamentosAntinflamatorios;
    }
    
    /**
     * Devuelve la referencia al almacén general de medicamentos.
     *
     * @return Objeto {@link AlmacenMedicamentos} asociado a esta implementación.
     */
    public AlmacenMedicamentos getAlmacen() {
        return this.almacen;
    }
    
    /**
     * Método abstracto que debe implementar cada clase concreta para mostrar los medicamentos.
     * 
     * En esta operación se define la lógica específica de cómo los medicamentos son 
     * cargados o visualizados (por ejemplo, en una interfaz Swing o un entorno web).
     * 
     */
    public abstract void mostrarMedicamentos();
    
}
