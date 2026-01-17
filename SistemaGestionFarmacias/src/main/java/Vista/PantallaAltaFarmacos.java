/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

/**
 *
 * @author claud
 */
import AbstractFactory.FBMedicamentoFactory;
import AbstractFactory.FMMedicamentoFactory;
import AbstractFactory.Medicamento;
import AbstractFactory.MedicamentoFactory;
import Bridge.AlmacenMedicamentos;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.time.LocalDate;

public class PantallaAltaFarmacos extends javax.swing.JPanel {

    private PantallaApp app;

    public PantallaAltaFarmacos(PantallaApp app) {
        this.app = app;
        initComponents();
        configurarEventos();
    }
    
      // Guarda el detalle específico elegido en el JDialog
    // ANALGESICO -> nivelDolor: leve/moderado/intenso
    // ANTIINFLAMATORIO -> zona: articular/muscular/general
    // ANTIBIOTICO -> bacteria: texto
    private String detalleTipo = null;

    private void configurarEventos() {
        // Atrás
        btnVolver.addActionListener(e -> app.mostrarAltaBajaFarmacos());

        // Dar de alta
        btnAlta.addActionListener(e -> darDeAlta());

        // Abrir diálogo de detalles
        btnDetalles.addActionListener(e -> abrirDetalles());

        // Si cambias el tipo, el detalle anterior ya no vale
        cmbTipo.addActionListener(e -> detalleTipo = null);
    }

    private void abrirDetalles() {
        String tipo = String.valueOf(cmbTipo.getSelectedItem()).trim().toUpperCase();

        // Abrimos el JDialog modal
        java.awt.Frame parent = (java.awt.Frame) SwingUtilities.getWindowAncestor(this);

        PantallaDetallesTipo dlg = new PantallaDetallesTipo(parent, true);
        dlg.preparar(tipo, detalleTipo);
        dlg.setVisible(true); // bloquea hasta pulsar Aceptar

        // Recuperamos el detalle (si aceptó)
        String nuevo = dlg.getDetalle();
        if (nuevo != null && !nuevo.isBlank()) {
            detalleTipo = nuevo;
            // Si tienes un label para mostrarlo, aquí:
            // lblDetalle.setText("Detalle: " + detalleTipo);
        }
    }

    private void darDeAlta() {
        // 1) Leer campos
        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String tipo = String.valueOf(cmbTipo.getSelectedItem()).trim().toUpperCase();
        String descripcion = txtDescripcion.getText().trim();

        boolean receta = RadioButtonSi.isSelected();

        String precioTxt = txtPrecio.getText().trim().replace(",", ".");
        String stockTxt = txtStock.getText().trim();
        String fechaTxt = txtFecha.getText().trim();

        // Farmacia (lo guardamos como texto “usable” por búsqueda)
        String farmacia = RadioButtonMadrid.isSelected()
                ? "farmacia de madrid"
                : (RadioButtonBarcelona.isSelected() ? "farmacia de barcelona" : "");

        // 2) Validar generales
        String error = validarCampos(id, nombre, descripcion, precioTxt, stockTxt, fechaTxt, farmacia, tipo);
        if (error != null) {
            JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3) Validar detalle específico (obligatorio)
        String errorDetalle = validarDetalle(tipo, detalleTipo);
        if (errorDetalle != null) {
            JOptionPane.showMessageDialog(this, errorDetalle, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 4) Parseos
        double precio = Double.parseDouble(precioTxt);
        int stock = Integer.parseInt(stockTxt);
        LocalDate caducidad = LocalDate.parse(fechaTxt); // YYYY-MM-DD

        // 5) Elegir factoría según farmacia
        MedicamentoFactory factory = RadioButtonMadrid.isSelected()
                ? new FMMedicamentoFactory()
                : new FBMedicamentoFactory();

        // 6) Crear medicamento según tipo
        Medicamento nuevo;
        switch (tipo) {
            case "ANALGESICO" -> nuevo = factory.crearAnalgesico(
                    id, nombre, descripcion, receta,
                    precio, stock, caducidad,
                    detalleTipo // nivelDolor
            );

            case "ANTIBIOTICO" -> nuevo = factory.crearAntibiotico(
                    id, nombre, descripcion, receta,
                    precio, stock, caducidad,
                    detalleTipo // bacteria
            );

            case "ANTIINFLAMATORIO" -> nuevo = factory.crearAntiinflamatorio(
                    id, nombre, descripcion, receta,
                    precio, stock, caducidad,
                    detalleTipo // zonaInflamacion
            );

            default -> {
                JOptionPane.showMessageDialog(this, "Tipo inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // 7) Guardar en almacén
        AlmacenMedicamentos.getInstancia().anadirMedicamento(nuevo);

        // 8) OK + limpiar
        JOptionPane.showMessageDialog(this, "Fármaco dado de alta correctamente.");
        limpiarCampos();
    }

    private String validarCampos(String id, String nombre, String descripcion,
                                 String precioTxt, String stockTxt, String fechaTxt,
                                 String farmacia, String tipo) {

        if (id.isEmpty()) return "El ID es obligatorio.";
        if (nombre.isEmpty()) return "El nombre es obligatorio.";
        if (descripcion.isEmpty()) return "La descripción es obligatoria.";
        if (farmacia.isEmpty()) return "Selecciona farmacia (Madrid o Barcelona).";

        if (!(tipo.equals("ANALGESICO") || tipo.equals("ANTIBIOTICO") || tipo.equals("ANTIINFLAMATORIO"))) {
            return "Tipo inválido.";
        }

        try {
            double p = Double.parseDouble(precioTxt);
            if (p <= 0) return "El precio debe ser mayor que 0.";
        } catch (NumberFormatException e) {
            return "Precio inválido. Ejemplo: 5.40";
        }

        try {
            int s = Integer.parseInt(stockTxt);
            if (s < 0) return "El stock no puede ser negativo.";
        } catch (NumberFormatException e) {
            return "Stock inválido. Debe ser un entero.";
        }

        try {
            LocalDate.parse(fechaTxt); // YYYY-MM-DD
        } catch (Exception e) {
            return "Fecha inválida. Formato: YYYY-MM-DD (ej: 2027-06-15).";
        }

        return null;
    }

    private String validarDetalle(String tipo, String detalle) {
        if (detalle == null || detalle.isBlank()) {
            return "Faltan los detalles del tipo. Pulsa el botón 'Detalles'.";
        }

        String d = detalle.trim().toLowerCase();

        if (tipo.equals("ANALGESICO")) {
            if (!(d.equals("leve") || d.equals("moderado") || d.equals("intenso"))) {
                return "Nivel de dolor inválido (leve, moderado, intenso).";
            }
        } else if (tipo.equals("ANTIINFLAMATORIO")) {
            if (!(d.equals("articular") || d.equals("muscular") || d.equals("general"))) {
                return "Zona de inflamación inválida (articular, muscular, general).";
            }
        } else if (tipo.equals("ANTIBIOTICO")) {
            if (d.isBlank()) return "La bacteria es obligatoria.";
        }

        return null;
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        cmbTipo.setSelectedIndex(0);

        RadioButtonNo.setSelected(true);
        RadioButtonMadrid.setSelected(true);

        txtPrecio.setText("");
        txtStock.setText("");
        txtFecha.setText("");

        detalleTipo = null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        lblTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAlta = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        lblStock = new javax.swing.JLabel();
        lblReceta = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblFechaCaducidad = new javax.swing.JLabel();
        lblSFarmacia = new javax.swing.JLabel();
        RadioButtonSi = new javax.swing.JRadioButton();
        RadioButtonNo = new javax.swing.JRadioButton();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        RadioButtonBarcelona = new javax.swing.JRadioButton();
        RadioButtonMadrid = new javax.swing.JRadioButton();
        btnVolver = new javax.swing.JButton();
        lblDescripción = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        btnDetalles = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(16, 86, 148));
        lblTitle.setText("Alta de fármacos");

        btnAlta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAlta.setText("Dar de alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblId.setText("Id:");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombre.setText("Nombre:");

        txtStock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblTipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTipo.setText("Tipo:");

        cmbTipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ANALGESICO", "ANTIINFLAMATORIO", "ANTIBIOTICO" }));

        lblStock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblStock.setText("Stock:");

        lblReceta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblReceta.setText("Receta médica:");

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPrecio.setText("Precio:");

        lblFechaCaducidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFechaCaducidad.setText("Fecha caducidad:");

        lblSFarmacia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSFarmacia.setText("Farmacia:");

        buttonGroup1.add(RadioButtonSi);
        RadioButtonSi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RadioButtonSi.setText("Si");
        RadioButtonSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonSiActionPerformed(evt);
            }
        });

        buttonGroup1.add(RadioButtonNo);
        RadioButtonNo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RadioButtonNo.setText("No");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        buttonGroup2.add(RadioButtonBarcelona);
        RadioButtonBarcelona.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RadioButtonBarcelona.setText("Barcelona");
        RadioButtonBarcelona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonBarcelonaActionPerformed(evt);
            }
        });

        buttonGroup2.add(RadioButtonMadrid);
        RadioButtonMadrid.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RadioButtonMadrid.setText("Madrid");
        RadioButtonMadrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonMadridActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVolver.setText("Atrás");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblDescripción.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDescripción.setText("Descripción:");

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnDetalles.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDetalles.setText("Detalles");
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblStock)
                                    .addComponent(lblPrecio)
                                    .addComponent(lblFechaCaducidad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(txtPrecio)
                                    .addComponent(txtStock)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblId)
                                    .addComponent(lblTipo)
                                    .addComponent(lblNombre)
                                    .addComponent(lblDescripción))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtId)
                                    .addComponent(txtNombre)
                                    .addComponent(txtDescripcion))))
                        .addGap(31, 31, 31)
                        .addComponent(btnDetalles)))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(179, 179, 179))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(lblReceta)
                        .addGap(53, 53, 53)
                        .addComponent(RadioButtonSi)
                        .addGap(55, 55, 55)
                        .addComponent(RadioButtonNo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(RadioButtonMadrid)
                                .addGap(18, 18, 18)
                                .addComponent(RadioButtonBarcelona))
                            .addComponent(lblSFarmacia)
                            .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDetalles))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripción)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReceta)
                    .addComponent(RadioButtonSi)
                    .addComponent(RadioButtonNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaCaducidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioButtonMadrid)
                    .addComponent(RadioButtonBarcelona)
                    .addComponent(lblSFarmacia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlta)
                    .addComponent(btnVolver))
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAltaActionPerformed

    private void RadioButtonSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonSiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonSiActionPerformed

    private void RadioButtonBarcelonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonBarcelonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonBarcelonaActionPerformed

    private void RadioButtonMadridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonMadridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonMadridActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetallesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RadioButtonBarcelona;
    private javax.swing.JRadioButton RadioButtonMadrid;
    private javax.swing.JRadioButton RadioButtonNo;
    private javax.swing.JRadioButton RadioButtonSi;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnVolver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDescripción;
    private javax.swing.JLabel lblFechaCaducidad;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblReceta;
    private javax.swing.JLabel lblSFarmacia;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
