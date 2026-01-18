/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Command.PedidoService;
import Decorator.Pedido;
import Proxy.Sesion;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 *
 * @author sete
 */
public class PantallaGestionarPedidosCliente extends javax.swing.JPanel {

    private final PantallaApp app;
    private PedidoService pedidoService;
    private Sesion sesion;
    private String volverCard = PantallaApp.CARD_CLIENTE;
    private DefaultListModel<Pedido> modelo = new DefaultListModel<>();
    /**
     * Creates new form PantallaGestionarPedidosCliente
     */
    
    private JList<Pedido> listPedidos;
    private JButton btnActualizar;
    private JButton btnVerDetalle;
    private JButton btnCancelar;
    private JButton btnVolver;
    private JLabel lblTitulo;
    private JLabel lblSubtitulo;

    public PantallaGestionarPedidosCliente(PantallaApp app) {
        this.app = app;
        initUI();
        wireEvents();
    }
    
    public void prepararPantalla(Sesion sesion, PedidoService pedidoService, String volverCard) {
        this.sesion = sesion;
        this.pedidoService = pedidoService;
        if (volverCard != null && !volverCard.isBlank()) {
            this.volverCard = volverCard;
        }

        lblSubtitulo.setText("Cliente: " + sesion.getNombre());
        cargarPedidos();
    }

    private void initUI() {
        setLayout(new BorderLayout(16, 16));
        setBackground(new Color(248, 250, 252));

        lblTitulo = new JLabel("Gestionar Pedidos");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(16, 86, 148));

        lblSubtitulo = new JLabel("Cliente: -");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JPanel header = new JPanel(new GridLayout(2, 1));
        header.setOpaque(false);
        header.add(lblTitulo);
        header.add(lblSubtitulo);

        listPedidos = new JList<>(modelo);
        listPedidos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        listPedidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Render bonito: "ID | Fecha | Importe"
        listPedidos.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (value instanceof Pedido p) {
                    // Ajusta getters si tu Pedido usa otros nombres
                    String id = safe(() -> p.getId(), "-");
                    String fecha = safe(() -> String.valueOf(p.getFecha()), "-");
                    String importe = safe(() -> String.format("%.2f €", p.getImporte()), "-");

                    setText(id + "  |  " + fecha + "  |  " + importe);
                }
                return this;
            }
        });

        JScrollPane scroll = new JScrollPane(listPedidos);

        btnActualizar = new JButton("Actualizar");
        btnVerDetalle = new JButton("Ver detalle");
        btnCancelar = new JButton("Cancelar pedido");
        btnVolver = new JButton("Volver");

        btnActualizar.setBackground(new Color(240, 245, 255));
        btnVerDetalle.setBackground(new Color(240, 245, 255));
        btnCancelar.setBackground(new Color(240, 245, 255));
        btnVolver.setBackground(new Color(240, 245, 255));

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        actions.setOpaque(false);
        actions.add(btnActualizar);
        actions.add(btnVerDetalle);
        actions.add(btnCancelar);
        actions.add(btnVolver);

        add(header, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(actions, BorderLayout.SOUTH);
    }
    
    private void wireEvents() {
        btnActualizar.addActionListener(e -> cargarPedidos());

        btnVerDetalle.addActionListener(e -> {
            Pedido p = listPedidos.getSelectedValue();
            if (p == null) {
                JOptionPane.showMessageDialog(this, "Selecciona un pedido.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            mostrarDetallePedido(p);
        });

        btnCancelar.addActionListener(e -> {
            Pedido p = listPedidos.getSelectedValue();
            if (p == null) {
                JOptionPane.showMessageDialog(this, "Selecciona un pedido.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int op = JOptionPane.showConfirmDialog(
                    this,
                    "¿Cancelar el pedido " + p.getId() + "?",
                    "Confirmar cancelación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (op != JOptionPane.YES_OPTION) return;

            try {
                pedidoService.cancelarPedidoPorId(p.getId());
                cargarPedidos();
                JOptionPane.showMessageDialog(this, "✅ Pedido cancelado.", "OK", JOptionPane.INFORMATION_MESSAGE);
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(this, "❌ " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnVolver.addActionListener(e -> app.mostrarCard(volverCard));
    }
    
    private void cargarPedidos() {
        modelo.clear();

        if (pedidoService == null || sesion == null) return;

        // 🔧 OJO: esto depende del getter que uses en PedidoService.getPedidosDeCliente(...)
        List<Pedido> pedidos = pedidoService.getPedidosDeCliente(sesion.getNombre());
        for (Pedido p : pedidos) {
            modelo.addElement(p);
        }

        if (modelo.isEmpty()) {
            // opcional: mensaje suave
            // JOptionPane.showMessageDialog(this, "No hay pedidos realizados.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void mostrarDetallePedido(Pedido p) {
        StringBuilder sb = new StringBuilder();

        sb.append("ID: ").append(safe(() -> p.getId(), "-")).append("\n");
        sb.append("Cliente: ").append(safe(() -> p.getUsuario(), "-")).append("\n"); // <-- Ajusta si tu Pedido no tiene getCliente()
        sb.append("Fecha: ").append(safe(() -> String.valueOf(p.getFecha()), "-")).append("\n");
        sb.append("Importe: ").append(safe(() -> String.format("%.2f €", p.getImporte()), "-")).append("\n\n");

        sb.append("Medicamentos:\n");
        try {
            var meds = p.getMedicamentos(); // Ajusta si el método se llama distinto
            if (meds == null || meds.isEmpty()) {
                sb.append(" - (sin medicamentos)\n");
            } else {
                for (var m : meds) {
                    sb.append(" - ").append(m).append("\n");
                }
            }
        } catch (Exception ignored) {
            sb.append(" - (no disponible)\n");
        }

        JTextArea area = new JTextArea(sb.toString());
        area.setEditable(false);
        area.setFont(new Font("Consolas", Font.PLAIN, 13));
        area.setRows(18);

        JOptionPane.showMessageDialog(
                this,
                new JScrollPane(area),
                "Detalle del pedido",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // Helpers para evitar petar si algún getter no existe o devuelve null
    private interface SupplierEx<T> { T get() throws Exception; }

    private <T> T safe(SupplierEx<T> s, T fallback) {
        try {
            T v = s.get();
            return (v != null) ? v : fallback;
        } catch (Exception ex) {
            return fallback;
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
