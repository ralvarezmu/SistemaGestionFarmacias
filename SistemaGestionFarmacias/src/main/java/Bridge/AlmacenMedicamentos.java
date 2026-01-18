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
    private ArrayList<Medicamento> antiinflamatoriosMadrid = new ArrayList<>();
    private ArrayList<Medicamento> analgesicosBarcelona = new ArrayList<>();
    private ArrayList<Medicamento> antibioticosBarcelona = new ArrayList<>();
    private ArrayList<Medicamento> antiinflamatoriosBarcelona = new ArrayList<>();
    private ArrayList<Medicamento> todosLosMedicamentos = new ArrayList<>();
    
    private static AlmacenMedicamentos instancia;
    
    /**
     * Constructor privado que inicializa el almacén con algunos medicamentos de ejemplo.
     * Usa fábricas concretas para crear medicamentos de Madrid y Barcelona.
     */
    private AlmacenMedicamentos() {
        iniciarAlmacen();
    }
    
    /**
     * Inicializa el almacén con medicamentos predeterminados de ambas farmacias.
     */
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
    
    /**
     * Devuelve la única instancia del almacén de medicamentos.
     *
     * @return Instancia única de {@code AlmacenMedicamentos}.
     */
    public static AlmacenMedicamentos getInstancia() {
        if(instancia == null) {
            instancia = new AlmacenMedicamentos();
        }
        return instancia;
    }
    
    /** @return Lista de analgésicos disponibles en Madrid. */
    public ArrayList<Medicamento> getAnalgesicosMadrid() {
        return analgesicosMadrid;
    }
    
    /** @return Lista de antibióticos disponibles en Madrid. */
    public ArrayList<Medicamento> getAntibioticosMadrid() {
        return antibioticosMadrid;
    }
    
    /** @return Lista de antiinflamatorios disponibles en Madrid. */
    public ArrayList<Medicamento> getAntiinflamatoriosMadrid() {
        return antiinflamatoriosMadrid;
    }
    
    /** @return Lista de analgésicos disponibles en Barcelona. */
    public ArrayList<Medicamento> getAnalgesicosBarcelona() {
        return analgesicosBarcelona;
    }
    
    /** @return Lista de antibióticos disponibles en Barcelona. */
    public ArrayList<Medicamento> getAntibioticosBarcelona() {
        return antibioticosBarcelona;
    }
    
    /** @return Lista de antiinflamatorios disponibles en Barcelona. */
    public ArrayList<Medicamento> getAntiinflamatoriosBarcelona() {
        return antiinflamatoriosBarcelona;
    }
    
    /**
     * Devuelve una lista combinada con todos los medicamentos del sistema.
     * La lista se reconstruye cada vez que se llama al método para evitar duplicados.
     *
     * @return Lista con todos los medicamentos de Madrid y Barcelona.
     */
    public ArrayList<Medicamento> getTodosLosMedicamentos() {
        todosLosMedicamentos.clear(); // Para no duplicarlos
        // Añadimos todos los medicamentos de Madrid
        todosLosMedicamentos.addAll(analgesicosMadrid);
        todosLosMedicamentos.addAll(antibioticosMadrid);
        todosLosMedicamentos.addAll(antiinflamatoriosMadrid);
        
        // Añadimos todos los medicamentos de Barcelona
        todosLosMedicamentos.addAll(analgesicosBarcelona);
        todosLosMedicamentos.addAll(antibioticosBarcelona);
        todosLosMedicamentos.addAll(antiinflamatoriosBarcelona);
        
        return todosLosMedicamentos;  
    }
    
    /**
     * Añade un nuevo medicamento al almacén, clasificándolo por tipo y farmacia de origen.
     *
     * @param m Medicamento a añadir.
     */
    public void anadirMedicamento(Medicamento m) {
        if (m == null) return;

        String tipo = m.getTipo().trim().toUpperCase();
        String farmacia = m.getFarmacia().trim().toLowerCase();

        boolean esMadrid = farmacia.contains("madrid");
        boolean esBarcelona = farmacia.contains("barcelona");

        switch (tipo) {
            case "ANALGESICO" -> {
                if (esMadrid) anadirAnalgesicosMadrid(m);
                else if (esBarcelona) anadirAnalgesicosBarcelona(m);
            }
            case "ANTIBIOTICO" -> {
                if (esMadrid) anadirAntibioticosMadrid(m);
                else if (esBarcelona) anadirAntibioticosBarcelona(m);
            }
            case "ANTIINFLAMATORIO" -> {
                if (esMadrid) anadirAntiinflamatoriosMadrid(m);
                else if (esBarcelona) anadirAntiinflamatoriosBarcelona(m);
            }
            default -> {
                // opcional: log o excepción
                System.out.println("Tipo desconocido: " + tipo);
            }
        }
    }

    
    /**
     * Elimina un medicamento del almacén, sin importar su tipo o farmacia de procedencia.
     *
     * @param m Medicamento a eliminar.
     * @return {@code true} si el medicamento fue eliminado; {@code false} en caso contrario.
     */
    public boolean eliminarMedicamento(Medicamento m) {
        if (m == null) return false;

        boolean eliminado = false;

        eliminado |= analgesicosMadrid.remove(m);
        eliminado |= antibioticosMadrid.remove(m);
        eliminado |= antiinflamatoriosMadrid.remove(m);

        eliminado |= analgesicosBarcelona.remove(m);
        eliminado |= antibioticosBarcelona.remove(m);
        eliminado |= antiinflamatoriosBarcelona.remove(m);

        // Por si acaso: mantener la lista "todos" coherente
        todosLosMedicamentos.remove(m);

        return eliminado;
    }

    /** Añade un analgésico a la lista de Madrid. */
    public void anadirAnalgesicosMadrid(Medicamento medicamento) {
        analgesicosMadrid.add(medicamento);
    }
    
    /** Añade un antibiótico a la lista de Madrid. */
    public void anadirAntibioticosMadrid(Medicamento medicamento) {
        antibioticosMadrid.add(medicamento);
    }
    
    /** Añade un antiinflamatorio a la lista de Madrid. */
    public void anadirAntiinflamatoriosMadrid(Medicamento medicamento) {
        antiinflamatoriosMadrid.add(medicamento);
    }
    
    /** Añade un analgésico a la lista de Barcelona. */
    public void anadirAnalgesicosBarcelona(Medicamento medicamento) {
        analgesicosBarcelona.add(medicamento);
    }
    
    /** Añade un antibiótico a la lista de Barcelona. */
    public void anadirAntibioticosBarcelona(Medicamento medicamento) {
        antibioticosBarcelona.add(medicamento);
    }
    
    /** Añade un antiinflamatorio a la lista de Barcelona. */
    public void anadirAntiinflamatoriosBarcelona(Medicamento medicamento) {
        antiinflamatoriosBarcelona.add(medicamento);
    }
    
}
