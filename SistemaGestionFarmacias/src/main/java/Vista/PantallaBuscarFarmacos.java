/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

/**
 *
 * @author claud
 */
import AbstractFactory.Analgesico;
import AbstractFactory.Antibiotico;
import AbstractFactory.Antiinflamatorio;
import AbstractFactory.Medicamento;
import Strategy.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.DefaultListModel;

public class PantallaBuscarFarmacos extends javax.swing.JPanel {
    
    private PantallaApp app;

    private List<Medicamento> medicamentos = new ArrayList<>();
    private String volverACard;

    private ConsultorMedicamentos consultor = new ConsultorMedicamentos(new ConsultaPorNombre());

    public PantallaBuscarFarmacos(PantallaApp app) {
        this.app = app;
        initComponents();
        configurarEventos();
    }

    public void setContext(String volverACard, List<Medicamento> medicamentos) {
        this.volverACard = volverACard;
        this.medicamentos = (medicamentos != null) ? medicamentos : new ArrayList<>();

        lblStatus.setText(" ");
        txtBuscar.setText("");
        limpiarLista();
    }

    private void configurarEventos() {
        btnVolver.addActionListener(e -> app.mostrarCard(volverACard));
        jButton1.addActionListener(e -> doBuscar());
        lblStatus.setText(" ");
    }

    private void doBuscar() {
        lblStatus.setText(" ");

        String modo = String.valueOf(cmbBuscar.getSelectedItem()).trim().toUpperCase();
        String criterioRaw = txtBuscar.getText();

        String error = validarEntrada(modo, criterioRaw);
        if (error != null) {
            lblStatus.setText(error);
            limpiarLista();
            return;
        }

        // Elegir estrategia
        switch (modo) {
            case "TIPO" -> consultor.setEstrategia(new ConsultaPorTipo());
            case "NOMBRE" -> consultor.setEstrategia(new ConsultaPorNombre());
            case "FARMACIA" -> consultor.setEstrategia(new ConsultaPorFarmacia());
            default -> {
                lblStatus.setText("Selecciona un tipo de búsqueda válido.");
                limpiarLista();
                return;
            }
        }

        List<Medicamento> resultados;
        try {
            resultados = consultor.consultar(medicamentos, criterioRaw);
        } catch (RuntimeException ex) {
            lblStatus.setText(ex.getMessage());
            limpiarLista();
            return;
        }

        if (resultados == null || resultados.isEmpty()) {
            lblStatus.setText("No se han encontrado resultados.");
            limpiarLista();
            return;
        }

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Medicamento m : resultados) {
            model.addElement(formatearCompleto(m));
        }
        listBusqueda.setModel(model);
    }

    private void limpiarLista() {
        listBusqueda.setModel(new DefaultListModel<>());
    }

    private String validarEntrada(String modo, String criterioRaw) {
        if (criterioRaw == null || criterioRaw.trim().isEmpty()) {
            return "Introduce un criterio de búsqueda.";
        }

        String criterio = normalizar(criterioRaw);

        if (modo.equals("FARMACIA")) {
            if (!criterio.equals("madrid") && !criterio.equals("barcelona")) {
                return "Farmacia inválida. Solo: 'farmacia de madrid' o 'farmacia de barcelona'.";
            }
        } else if (modo.equals("TIPO")) {
            Set<String> permitidos = Set.of("analgesico", "antibiotico", "antiinflamatorio");
            if (!permitidos.contains(criterio)) {
                return "Tipo inválido. Solo: analgesico, antibiotico o antiinflamatorio.";
            }
        }
        // NOMBRE: libre
        return null;
    }

    private String normalizar(String s) {
        return s.trim().toLowerCase()
                .replace("á", "a").replace("é", "e").replace("í", "i")
                .replace("ó", "o").replace("ú", "u");
    }

    public static String formatearCompleto(Medicamento m) {
        if (m == null) return "(null)";
        
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Detalle específico según tipo
        String detalle = "";
        if (m instanceof Analgesico a) {
            detalle = "nivelDolor=" + a.getNivelDolor();
        } else if (m instanceof Antiinflamatorio ai) {
            detalle = "zonaInflamacion=" + ai.getZonaInflamacion();
        } else if (m instanceof Antibiotico ab) {
            detalle = "bacteria=" + ab.getTipoBacteria();
        } else {
            detalle = "detalle=(n/a)";
        }

        String receta = m.isRecetaMedica() ? "Sí" : "No";
        String fecha = (m.getFechaCaducidad() != null) ? m.getFechaCaducidad().format(f) : "(sin fecha)";

        return String.format(
            "ID=%s | Nombre=%s | Tipo=%s | %s | Desc=%s | Receta=%s | Precio=%.2f | Stock=%d | Cad=%s | Farmacia=%s",
            m.getId(),
            m.getNombre(),
            m.getTipo(),
            detalle,
            m.getDescripcion(),
            receta,
            m.getPrecio(),
            m.getStock(),
            fecha,
            m.getFarmacia()
        );
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
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBusqueda = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        cmbBuscar = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 250, 252));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(16, 86, 148));
        lblTitle.setText("Buscar fármacos");

        jScrollPane1.setViewportView(listBusqueda);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Buscar por:");

        cmbBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TIPO", "NOMBRE", "FARMACIA" }));

        jButton1.setBackground(new java.awt.Color(240, 245, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Buscar");

        btnVolver.setBackground(new java.awt.Color(240, 245, 255));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVolver.setText("Volver al menú");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel1)
                                .addGap(40, 40, 40)
                                .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVolver)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JList<String> listBusqueda;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
