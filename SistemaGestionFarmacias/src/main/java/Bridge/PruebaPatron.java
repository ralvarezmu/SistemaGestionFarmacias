/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Bridge;

import AbstractFactory.Analgesico;
import AbstractFactory.Antibiotico;
import AbstractFactory.Antiinflamatorio;
import AbstractFactory.FBAnalgesico;
import AbstractFactory.Medicamento;
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
            
            // Crear almacén con datos de prueba
            AlmacenMedicamentos almacen;
            almacen = AlmacenMedicamentos.getInstancia();

            // Analgésicos Barcelona
            almacen.anadirAnalgesicosBarcelona(paracetamol);
            almacen.anadirAnalgesicosBarcelona(ibuprofeno);
            almacen.anadirAnalgesicosBarcelona(aspirina);
            almacen.anadirAnalgesicosBarcelona(gelocatil);
            almacen.anadirAnalgesicosBarcelona(naproxeno);
            almacen.anadirAnalgesicosBarcelona(metamizol);
            
            // Crear implementador concreto (Barcelona)
            MostradorMedicamentosImp impBarcelona =
                    new MostradorMedicamentosImpBarcelona(
                            listaAnalgesicos,
                            listaAntibioticos,
                            listaAntinflamatorios,
                            almacen
                    );
            
            almacen.anadirAnalgesicosMadrid(paracetamol);
            almacen.anadirAnalgesicosMadrid(ibuprofeno);
            
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
