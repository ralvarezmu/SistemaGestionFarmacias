/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bridge;

import AbstractFactory.FBMedicamentoFactory;
import AbstractFactory.FMMedicamentoFactory;
import AbstractFactory.Medicamento;
import AbstractFactory.MedicamentoFactory;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AlmacenMedicamentos {
    
    private ArrayList<Medicamento> analgesicosMadrid = new ArrayList<>();
    private ArrayList<Medicamento> antibioticosMadrid = new ArrayList<>();
    private ArrayList<Medicamento> antinflamatoriosMadrid = new ArrayList<>();
    private ArrayList<Medicamento> analgesicosBarcelona = new ArrayList<>();
    private ArrayList<Medicamento> antibioticosBarcelona = new ArrayList<>();
    private ArrayList<Medicamento> antinflamatoriosBarcelona = new ArrayList<>();
    private ArrayList<Medicamento> todosLosMedicamentos = new ArrayList<>();
    
    private static AlmacenMedicamentos instancia;
    
    private AlmacenMedicamentos() {
        iniciarAlmacen();
    }
    
    private void iniciarAlmacen() {
        MedicamentoFactory factoriaMadrid = new FMMedicamentoFactory();
        MedicamentoFactory factoriaBarcelona = new FBMedicamentoFactory();

        Medicamento paracetamol = factoriaBarcelona.crearAnalgesico(
            "A101", "Paracetamol 1g", "Analgésico común", false,
            3.10, 100, LocalDate.of(2027, 6, 15),
            "leve"
        );

        Medicamento amoxicilina = factoriaBarcelona.crearAntibiotico(
            "AB101", "Amoxicilina 500mg", "Antibiótico antibacteriano", true,
            8.75, 30, LocalDate.of(2026, 9, 20),
            "E. coli"
        );

        Medicamento ibuprofeno = factoriaBarcelona.crearAntiinflamatorio(
            "AI101", "Ibuprofeno 600mg", "Inflamación muscular", false,
            5.40, 60, LocalDate.of(2026, 12, 10),
            "muscular"
        );

        Medicamento gelocatil = factoriaMadrid.crearAnalgesico(
            "A201", "Gelocatil 1g", "Dolor intenso", false,
            4.90, 80, LocalDate.of(2027, 3, 5),
            "intenso"
        );

        Medicamento azitromicina = factoriaMadrid.crearAntibiotico(
            "AB201", "Azitromicina 500mg", "Antibiótico respiratorio", true,
            11.60, 20, LocalDate.of(2026, 7, 30),
            "S. pneumoniae"
        );

        Medicamento naproxeno = factoriaMadrid.crearAntiinflamatorio(
            "AI201", "Naproxeno 550mg", "Dolor articular", false,
            6.80, 40, LocalDate.of(2026, 11, 25),
            "articular"
        );

        // Medicamentos Barcelona
        this.anadirAnalgesicosBarcelona(paracetamol);
        this.anadirAntibioticosBarcelona(amoxicilina);
        this.anadirAntiinflamatoriosBarcelona(ibuprofeno);
        // Medicamentos Madrid
        this.anadirAnalgesicosMadrid(gelocatil);
        this.anadirAntibioticosMadrid(azitromicina);
        this.anadirAntiinflamatoriosMadrid(naproxeno);
    }
    
    public static AlmacenMedicamentos getInstancia() {
        if(instancia == null) {
            instancia = new AlmacenMedicamentos();
        }
        return instancia;
    }
    
    public ArrayList<Medicamento> getAnalgesicosMadrid() {
        return analgesicosMadrid;
    }
    
    public ArrayList<Medicamento> getAntibioticosMadrid() {
        return antibioticosMadrid;
    }
    
    public ArrayList<Medicamento> getAntiinflamatoriosMadrid() {
        return antinflamatoriosMadrid;
    }
    
    public ArrayList<Medicamento> getAnalgesicosBarcelona() {
        return analgesicosBarcelona;
    }
    
    public ArrayList<Medicamento> getAntibioticosBarcelona() {
        return antibioticosBarcelona;
    }
    
    public ArrayList<Medicamento> getAntiinflamatoriosBarcelona() {
        return antinflamatoriosBarcelona;
    }
    
    public ArrayList<Medicamento> getTodosLosMedicamentos() {    
        // Añadimos todos los medicamentos de Madrid
        todosLosMedicamentos.addAll(analgesicosMadrid);
        todosLosMedicamentos.addAll(antibioticosMadrid);
        todosLosMedicamentos.addAll(antinflamatoriosMadrid);
        
        // Añadimos todos los medicamentos de Barcelona
        todosLosMedicamentos.addAll(analgesicosBarcelona);
        todosLosMedicamentos.addAll(antibioticosBarcelona);
        todosLosMedicamentos.addAll(antinflamatoriosBarcelona);
        
        return todosLosMedicamentos;  
    }
    
    public void anadirAnalgesicosMadrid(Medicamento medicamento) {
        analgesicosMadrid.add(medicamento);
    }
    
    public void anadirAntibioticosMadrid(Medicamento medicamento) {
        //
    }
    
    public void anadirAntiinflamatoriosMadrid(Medicamento medicamento) {
        //
    }
    
    public void anadirAnalgesicosBarcelona(Medicamento medicamento) {
        analgesicosBarcelona.add(medicamento);
    }
    
    public void anadirAntibioticosBarcelona(Medicamento medicamento) {
        //
    }
    
    public void anadirAntiinflamatoriosBarcelona(Medicamento medicamento) {
        //
    }
      
}
