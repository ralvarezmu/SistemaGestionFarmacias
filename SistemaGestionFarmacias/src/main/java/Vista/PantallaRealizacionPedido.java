/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import AbstractFactory.FBAnalgesico;
import AbstractFactory.Medicamento;
import Bridge.AlmacenMedicamentos;
import Bridge.MostradorMedicamentosAbst;
import Bridge.MostradorMedicamentosImp;
import Bridge.MostradorMedicamentosImpBarcelona;
import Bridge.MostradorMedicamentosImpMadrid;
import Decorator.Pedido;
import com.mycompany.sistemagestionfarmacias.ServicioPedido;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class PantallaRealizacionPedido extends javax.swing.JFrame {
    
    private String cliente;
    private Pedido pedido;
    private ServicioPedido servicioPedido;
    private MostradorMedicamentosAbst mostrador;
    private MostradorMedicamentosImp implementador;
    private AlmacenMedicamentos almacen;
    
    private DefaultListModel<Medicamento> modeloMedicamentosAnalgesicos = new DefaultListModel<>();
    private DefaultListModel<Medicamento> modeloMedicamentosAntibioticos = new DefaultListModel<>();
    private DefaultListModel<Medicamento> modeloMedicamentosAntinflamatorios = new DefaultListModel<>();
    private DefaultListModel<Medicamento> modeloCarrito = new DefaultListModel<>();
    
    /**
     * Creates new form PantallaRealizacionPedido
     */
    public PantallaRealizacionPedido(String usuario, String farmacia) {
        initComponents();
        almacen = AlmacenMedicamentos.getInstancia();
        jList4.setModel(modeloCarrito);
        this.cliente = usuario;
        this.servicioPedido = new ServicioPedido();
        servicioPedido.crearPedido(cliente);
        this.pedido = servicioPedido.getPedido();
        this.mostrador = new MostradorMedicamentosAbst();
        cargarImplementador(farmacia);
        mostrador.setImplementador(implementador);
        mostrador.mostrarMedicamentos();
        //jList1.setModel(modeloMedicamentosAnalgesicos);
        //jList2.setModel(modeloMedicamentosAntibioticos);
        //jList3.setModel(modeloMedicamentosAntinflamatorios);
        
    }
    
    public void sumarMedicamento() {
        String textoActual = jLabel10.getText().trim();
        
        int valorActual = Integer.parseInt(textoActual);
        jLabel10.setText(String.valueOf(valorActual + 1));
    }
    
    public void actualizarImporte() {
        servicioPedido.actualizarImpoerte();
        jLabel12.setText(pedido.getImporte().toString());
    }
    
    public void cargarImplementador(String farmacia) {
        if (farmacia.equals("M")) {
            this.implementador = new MostradorMedicamentosImpMadrid(jList1, jList2, jList3, almacen);
        }
        else {
            this.implementador = new MostradorMedicamentosImpBarcelona(jList1, jList2, jList3, almacen);
        }
        
    }
        
    public void cargarMedicamentos() {
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
        
        ArrayList<Medicamento> medicamentosPedido = new ArrayList<>();
        medicamentosPedido.add(paracetamol);
        medicamentosPedido.add(ibuprofeno);
        medicamentosPedido.add(aspirina);
        medicamentosPedido.add(gelocatil);
        medicamentosPedido.add(naproxeno);
        medicamentosPedido.add(metamizol);
        
        for(Medicamento m : medicamentosPedido) {
            modeloMedicamentosAnalgesicos.addElement(m);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Realizar Pedido");

        jLabel2.setText("1. Seleccione los medicamentos deseados:");

        jScrollPane1.setViewportView(jList1);

        jLabel3.setText("Analgésicos:");

        jLabel4.setText("Antibióticos:");

        jScrollPane2.setViewportView(jList2);

        jLabel5.setText("Antinflamatorios:");

        jScrollPane3.setViewportView(jList3);

        jLabel6.setText("2. Seleccione un método de pago:");

        jButton1.setText("Pago con tarjeta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pago con PayPal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Pago con Bizum");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setText("3. Confirme y finalice el pedido:");

        jButton4.setText("Confirmar Pedido");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Medicamentos seleccionados:");

        jScrollPane4.setViewportView(jList4);

        jButton5.setText("Seleccionar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Seleccionar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Seleccionar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel9.setText("Número de artículos: ");

        jLabel10.setText("0");

        jLabel11.setText("Precio Total:");

        jLabel12.setText("0");

        jLabel13.setText("Método de Pago:");

        jLabel14.setText("-");

        jButton8.setText("Cancelar Pedido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Medicamento medicamento = jList1.getSelectedValue();
        pedido.anadirMedicamento(medicamento);
        modeloCarrito.addElement(medicamento);
        sumarMedicamento();
        actualizarImporte();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Medicamento medicamento = jList2.getSelectedValue();
        pedido.anadirMedicamento(medicamento);
        modeloCarrito.addElement(medicamento);
        sumarMedicamento();
        actualizarImporte();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Medicamento medicamento = jList3.getSelectedValue();
        pedido.anadirMedicamento(medicamento);
        modeloCarrito.addElement(medicamento);
        sumarMedicamento();
        actualizarImporte();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (servicioPedido.pasarPago()) {
            pedido.seleccionarMetodoPago(0);
            PantallaDatosTarjeta PDTarjeta = new PantallaDatosTarjeta(pedido.getMetodoPago());
            PDTarjeta.setVisible(true);
            jLabel14.setText("Tarjeta");
        }
        else {
            JOptionPane.showMessageDialog(
            this, 
            "No es posible realizar el pago aún.\n" +
            "Primero selecciona medicamentos del carrito.", 
            "Estado incorrecto", 
            JOptionPane.WARNING_MESSAGE
            );
        }      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (servicioPedido.pasarPago()) {
            pedido.seleccionarMetodoPago(1);
            PantallaDatosPayPal PDPayPal = new PantallaDatosPayPal(pedido.getMetodoPago());
            PDPayPal.setVisible(true);
            jLabel14.setText("PayPal");
        }
        else {
            JOptionPane.showMessageDialog(
            this, 
            "No es posible realizar el pago aún.\n" +
            "Primero selecciona medicamentos del carrito.", 
            "Estado incorrecto", 
            JOptionPane.WARNING_MESSAGE
            );
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (servicioPedido.pasarPago()) {
            pedido.seleccionarMetodoPago(2);
            PantallaDatosBizum PDBizum = new PantallaDatosBizum(pedido.getMetodoPago());
            PDBizum.setVisible(true);
            jLabel14.setText("Bizum");
        }
        else {
            JOptionPane.showMessageDialog(
            this, 
            "No es posible realizar el pago aún.\n" +
            "Primero selecciona medicamentos del carrito.", 
            "Estado incorrecto", 
            JOptionPane.WARNING_MESSAGE
            );
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Confirmacion del pedido
        try {
            servicioPedido.pasarEstadoConfirmacion();

            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Numero de Teléfono valido",
                "Éxito",
                javax.swing.JOptionPane.INFORMATION_MESSAGE
            );

            this.setVisible(false);
        } catch (IllegalArgumentException ex) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),              
                "Selleccione antes un metodo de pago",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<Medicamento
    > jList1;
    private javax.swing.JList<Medicamento> jList2;
    private javax.swing.JList<Medicamento> jList3;
    private javax.swing.JList<Medicamento> jList4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
