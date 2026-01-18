
package Vista;
import AbstractFactory.Medicamento;
import Bridge.AlmacenMedicamentos;
import Strategy.ConsultorMedicamentos;
import Strategy.ConsultaPorFarmacia;
import Strategy.ConsultaPorNombre;
import Strategy.ConsultaPorTipo;

import javax.swing.*;
import java.awt.*;
import java.util.List;
/**
 *
 * @author sete
 */
public class PantallaStock extends javax.swing.JPanel {
    private final PantallaApp app;
    private final AlmacenMedicamentos almacen;
    private final ConsultorMedicamentos consultor;

    private JComboBox<String> cmbFiltro;
    private JTextField txtBusqueda;
    private JButton btnBuscar;
    private JButton btnVolver;

    private DefaultListModel<String> modeloResultados;
    private JList<String> lstResultados;
    /**
     * Creates new form PantallaStock
     */
    public PantallaStock(PantallaApp app) {
        this.app = app;
        // Datos + Strategy
        this.almacen = AlmacenMedicamentos.getInstancia();
        this.consultor = new ConsultorMedicamentos(new ConsultaPorNombre()); // por defecto

        initUI();
        configurarEventos();
    }
    private void initUI() {
        setLayout(new BorderLayout(16, 16));
        setBackground(new Color(248, 250, 252));

        JLabel titulo = new JLabel("Consulta de Stock");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titulo.setForeground(new Color(16, 86, 148));

        // Barra superior
        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);
        top.add(titulo, BorderLayout.WEST);

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        top.add(btnVolver, BorderLayout.EAST);

        add(top, BorderLayout.NORTH);

        // Panel filtros
        JPanel filtros = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 12));
        filtros.setOpaque(false);

        cmbFiltro = new JComboBox<>(new String[]{"Nombre", "Tipo", "Farmacia"});
        cmbFiltro.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        txtBusqueda = new JTextField(22);
        txtBusqueda.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        filtros.add(new JLabel("Filtrar por:"));
        filtros.add(cmbFiltro);
        filtros.add(new JLabel("Búsqueda:"));
        filtros.add(txtBusqueda);
        filtros.add(btnBuscar);

        add(filtros, BorderLayout.CENTER);

        // Resultados
        modeloResultados = new DefaultListModel<>();
        lstResultados = new JList<>(modeloResultados);
        lstResultados.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JScrollPane scroll = new JScrollPane(lstResultados);
        scroll.setPreferredSize(new Dimension(800, 350));

        JPanel resultadosPanel = new JPanel(new BorderLayout());
        resultadosPanel.setOpaque(false);
        resultadosPanel.add(new JLabel("Resultados:"), BorderLayout.NORTH);
        resultadosPanel.add(scroll, BorderLayout.CENTER);

        add(resultadosPanel, BorderLayout.SOUTH);
    }
    
    private void configurarEventos() {
        btnBuscar.addActionListener(e -> buscar());
        txtBusqueda.addActionListener(e -> buscar()); 

        btnVolver.addActionListener(e -> {
            app.mostrarCard(PantallaApp.CARD_ADMIN);
        });
    }
    
    private void buscar() {
        String criterio = txtBusqueda.getText().trim();

        if (criterio.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Escribe algo para buscar.",
                "Aviso",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // 1) Elegir estrategia según el combo
        String filtro = (String) cmbFiltro.getSelectedItem();
        if ("Nombre".equalsIgnoreCase(filtro)) {
            consultor.setEstrategia(new ConsultaPorNombre());
        } else if ("Tipo".equalsIgnoreCase(filtro)) {
            consultor.setEstrategia(new ConsultaPorTipo());
        } else {
            consultor.setEstrategia(new ConsultaPorFarmacia());
        }

        // 2) Ejecutar búsqueda
        List<Medicamento> todos = almacen.getTodosLosMedicamentos();
        List<Medicamento> res = consultor.consultar(todos, criterio);

        // 3) Pintar resultados
        cargarResultados(res);
    }
    
    private void cargarResultados(List<Medicamento> meds) {
        modeloResultados.clear();

        if (meds == null || meds.isEmpty()) {
            modeloResultados.addElement("No se encontraron resultados.");
            return;
        }

        for (Medicamento m : meds) {
            // 👉 ADAPTA ESTA LÍNEA a tu clase Medicamento (ver nota abajo)
            modeloResultados.addElement(formatear(m));
        }
    }

    private String formatear(Medicamento m) {
        // Si NO tienes getters, puedes dejar: return m.toString();
        // Yo te dejo un formato bonito para “stock”
        try {
            // Cambia estos getters si tus nombres son distintos
            String nombre = m.getNombre();
            String tipo = m.getTipo();
            String farmacia = m.getFarmacia();
            int stock = m.getStock();

            return String.format("%s | %s | %s | Stock: %d", nombre, tipo, farmacia, stock);
        } catch (Exception ex) {
            // fallback si no existen getters:
            return m.toString();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(16, 86, 148));
        lblTitle.setText("Consulta Stock");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(lblTitle)
                .addContainerGap(216, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addContainerGap(375, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
