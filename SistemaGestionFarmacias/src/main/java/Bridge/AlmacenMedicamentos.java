/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bridge;

import AbstractFactory.FBAnalgesico;
import AbstractFactory.Medicamento;
import java.math.BigDecimal;
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
    
    private static AlmacenMedicamentos instancia;
    
    private AlmacenMedicamentos() {
        iniciarAlmacen();
    }
    
    private void iniciarAlmacen() {
        Medicamento paracetamol = new FBAnalgesico(
            "A001", "Paracetamol", "Analgésico común", false,
            new BigDecimal("2.95"), 120, LocalDate.of(2027, 5, 10),
            "Farmacia Barcelona", "leve"
        );

        Medicamento ibuprofeno = new FBAnalgesico(
            "A002", "Ibuprofeno 400mg", "Dolor moderado", false,
            new BigDecimal("4.50"), 80, LocalDate.of(2026, 11, 2),
            "Farmacia Barcelona", "moderado"
        );

        Medicamento aspirina = new FBAnalgesico(
            "A003", "Aspirina 500mg", "Dolor y fiebre", false,
            new BigDecimal("1.80"), 200, LocalDate.of(2026, 8, 15),
            "Farmacia Barcelona", "leve"
        );
        
        Medicamento gelocatil = new FBAnalgesico(
            "A004", "Gelocatil 1g", "Dolor intenso", false,
            new BigDecimal("5.20"), 50, LocalDate.of(2027, 3, 20),
            "Farmacia Barcelona", "intenso"
        );

        Medicamento naproxeno = new FBAnalgesico(
            "A005", "Naproxeno 550mg", "Dolor muscular", false,
            new BigDecimal("6.75"), 40, LocalDate.of(2026, 12, 1),
            "Farmacia Barcelona", "muscular"
        );

        Medicamento metamizol = new FBAnalgesico(
            "A006", "Nolotil 575mg", "Dolor severo", true,
            new BigDecimal("3.90"), 30, LocalDate.of(2027, 1, 15),
            "Farmacia Barcelona", "severo"
        );
        
        this.anadirAnalgesicosBarcelona(paracetamol);
        this.anadirAnalgesicosBarcelona(ibuprofeno);
        this.anadirAnalgesicosBarcelona(aspirina);
        this.anadirAnalgesicosBarcelona(gelocatil);
        this.anadirAnalgesicosBarcelona(naproxeno);
        this.anadirAnalgesicosBarcelona(metamizol);
        
        this.anadirAnalgesicosMadrid(paracetamol);
        this.anadirAnalgesicosMadrid(ibuprofeno);
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
    
    public ArrayList<Medicamento> getAntinflamatoriosMadrid() {
        return antinflamatoriosMadrid;
    }
    
    public ArrayList<Medicamento> getAnalgesicosBarcelona() {
        return analgesicosBarcelona;
    }
    
    public ArrayList<Medicamento> getAntibioticosBarcelona() {
        return antibioticosBarcelona;
    }
    
    public ArrayList<Medicamento> getAntinflamatoriosBarcelona() {
        return antinflamatoriosBarcelona;
    }
    
    public void anadirAnalgesicosMadrid(Medicamento medicamento) {
        analgesicosMadrid.add(medicamento);
    }
    
    public void anadirAntibioticosMadrid(Medicamento medicamento) {
        //
    }
    
    public void anadirAntinflamatoriosMadrid(Medicamento medicamento) {
        //
    }
    
    public void anadirAnalgesicosBarcelona(Medicamento medicamento) {
        analgesicosBarcelona.add(medicamento);
    }
    
    public void anadirAntibioticoBarcelona(Medicamento medicamento) {
        //
    }
    
    public void anadirAntinflamatorioBarcelona(Medicamento medicamento) {
        //
    }
    
}
