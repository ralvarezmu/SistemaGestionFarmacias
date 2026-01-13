/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Bridge;

import AbstractFactory.Analgesico;
import AbstractFactory.Antibiotico;
import AbstractFactory.Antiinflamatorio;
import AbstractFactory.FBMedicamentoFactory;
import AbstractFactory.FMMedicamentoFactory;
import AbstractFactory.Medicamento;
import AbstractFactory.MedicamentoFactory;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Admin
 */
public class PruebaPatron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            // Crear listas visuales
            JList<Medicamento> listaAnalgesicos = new JList<>();
            JList<Medicamento> listaAntibioticos = new JList<>();
            JList<Medicamento> listaAntinflamatorios = new JList<>();
            
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
            
            // Crear almacén con datos de prueba
            AlmacenMedicamentos almacen;
            almacen = AlmacenMedicamentos.getInstancia();

            // Medicamentos Barcelona
            almacen.anadirAnalgesicosBarcelona(paracetamol);
            almacen.anadirAntibioticosBarcelona(amoxicilina);
            almacen.anadirAntiinflamatoriosBarcelona(ibuprofeno);
            // Medicamentos Madrid
            almacen.anadirAnalgesicosMadrid(gelocatil);
            almacen.anadirAntibioticosMadrid(azitromicina);
            almacen.anadirAntiinflamatoriosMadrid(naproxeno);
            
            // Crear implementador concreto (Barcelona)
            MostradorMedicamentosImp impBarcelona =
                    new MostradorMedicamentosImpBarcelona(
                            listaAnalgesicos,
                            listaAntibioticos,
                            listaAntinflamatorios,
                            almacen
                    );
            
            // Crear implementador concreto (Madrid)
            MostradorMedicamentosImp impMadrid =
                    new MostradorMedicamentosImpMadrid(
                            listaAnalgesicos,
                            listaAntibioticos,
                            listaAntinflamatorios,
                            almacen
                    );

            // Crear abstracción y enlazar implementador
            MostradorMedicamentosAbst mostrador = new MostradorMedicamentosAbst();
            mostrador.setImplementador(impBarcelona);

            // Llenar las listas
            mostrador.mostrarMedicamentos();
            
            mostrador.setImplementador(impMadrid);

            // Llenar las listas
            mostrador.mostrarMedicamentos();

            // Crear ventana para ver las listas
            JFrame frame = new JFrame("Mostrador medicamentos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new java.awt.GridLayout(1, 3));

            panel.add(new JScrollPane(listaAnalgesicos));
            panel.add(new JScrollPane(listaAntibioticos));
            panel.add(new JScrollPane(listaAntinflamatorios));

            frame.add(panel);
            frame.setSize(600, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
    
}
