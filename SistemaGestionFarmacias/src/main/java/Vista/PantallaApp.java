/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Proxy.*;
import Bridge.AlmacenMedicamentos;
import AbstractFactory.Medicamento;
import Command.PedidoService;
import java.awt.CardLayout;
import java.util.List;

/**
 *
 * @author claud
 */
public class PantallaApp extends javax.swing.JFrame {

    private CardLayout cardLayout;

    // Servicios
    private ServicioLogin loginService;

    // Panels (JPanel)
    private PantallaRol pantallaRol;
    private PantallaInicioCliente pantallaInicioCliente;
    private PantallaLogin pantallaLogin;
    private PantallaRegistroCliente pantallaRegistroCliente;
    private PantallaCliente pantallaCliente;
    private PantallaFarmaceutico pantallaFarmaceutico;
    private PantallaAdmin pantallaAdmin;    
    private PantallaBuscarFarmacos pantallaBuscarFarmacos;
    private PantallaAltaBajaFarmacos pantallaAltaBajaFarmacos;
    private PantallaAltaFarmacos pantallaAltaFarmacos;
    private PantallaBajaFarmacos pantallaBajaFarmacos;
    private PantallaEleccionFarmacia pantallaEleccionFarmacia;
    private PantallaRealizacionPedido pantallaRealizacionPedido;
    private PantallaListaFarmacos pantallaListaFarmacos;
    private PantallaModificacionFarmacos pantallaModificacionFarmacos;

    // Nombres de cartas
    public static final String CARD_ROL = "ROL";
    public static final String CARD_INICIO_CLIENTE = "INICIO_CLIENTE";
    public static final String CARD_LOGIN = "LOGIN";
    public static final String CARD_REGISTRO_CLIENTE = "REGISTRO_CLIENTE";
    public static final String CARD_CLIENTE = "CLIENTE";
    public static final String CARD_FARMA = "FARMA";
    public static final String CARD_ADMIN = "ADMIN";
    public static final String CARD_BUSCAR_FARMACOS = "BUSCAR_FARMACOS";
    public static final String CARD_ALTA_BAJA = "ALTA_BAJA";
    public static final String CARD_ALTA_FARMACOS = "ALTA_FARMACOS";
    public static final String CARD_BAJA_FARMACOS = "BAJA_FARMACOS";
    public static final String CARD_ELECCION_FARMACIA = "ELEGIR_FARMACIA";
    public static final String CARD_REALIZACION_PEDIDO = "REALIZAR PEDIDO";
    public static final String CARD_LISTA_FARMACOS = "LISTA_FARMACOS";
    public static final String CARD_MODIFICACION_FARMACOS = "MODIFICACION_FARMACOS";

    
    public PantallaApp() {
        initComponents();
        initApp();
        pack();
        setLocationRelativeTo(null);

    }

    private void initApp() {
        // 1) Servicio real + proxy
        RepositorioUsuarios repo = new RepositorioUsuarios();
        ServicioLogin real = new ServicioLoginReal(repo);
        loginService = new ServicioLoginProxy(real);
        PedidoService pedidoService = new PedidoService();
        // 2) CardLayout
        cardLayout = (CardLayout) contentPanel.getLayout();
        
        // 3) Crear pantallas
        pantallaRol = new PantallaRol(this);
        pantallaInicioCliente = new PantallaInicioCliente(this);
        pantallaLogin = new PantallaLogin(this, loginService);
        pantallaRegistroCliente = new PantallaRegistroCliente(this,repo);
        pantallaCliente = new PantallaCliente(this);
        pantallaFarmaceutico = new PantallaFarmaceutico(this);
        pantallaAdmin = new PantallaAdmin(this);   
        pantallaBuscarFarmacos = new PantallaBuscarFarmacos(this);
        pantallaAltaBajaFarmacos = new PantallaAltaBajaFarmacos(this);
        pantallaAltaFarmacos = new PantallaAltaFarmacos(this);
        pantallaBajaFarmacos = new PantallaBajaFarmacos(this);
        pantallaEleccionFarmacia = new PantallaEleccionFarmacia(this);
        pantallaRealizacionPedido = new PantallaRealizacionPedido(this,pedidoService);
        pantallaListaFarmacos = new PantallaListaFarmacos(this);
        pantallaModificacionFarmacos = new PantallaModificacionFarmacos(this);

        

        // 4) Añadir al CardLayout
        contentPanel.add(wrap(pantallaRol), CARD_ROL);
        contentPanel.add(wrap(pantallaInicioCliente), CARD_INICIO_CLIENTE);
        contentPanel.add(wrap(pantallaLogin), CARD_LOGIN);
        contentPanel.add(wrap(pantallaRegistroCliente), CARD_REGISTRO_CLIENTE);

        contentPanel.add(wrap(pantallaCliente), CARD_CLIENTE);
        contentPanel.add(wrap(pantallaFarmaceutico), CARD_FARMA);
        contentPanel.add(wrap(pantallaAdmin), CARD_ADMIN);
        contentPanel.add(wrap(pantallaBuscarFarmacos), CARD_BUSCAR_FARMACOS);
        contentPanel.add(wrap(pantallaAltaBajaFarmacos), CARD_ALTA_BAJA);
        contentPanel.add(wrap(pantallaAltaFarmacos), CARD_ALTA_FARMACOS);
        contentPanel.add(wrap(pantallaBajaFarmacos), CARD_BAJA_FARMACOS);
        
        contentPanel.add(wrap(pantallaEleccionFarmacia), CARD_ELECCION_FARMACIA);
        contentPanel.add(wrap(pantallaRealizacionPedido), CARD_REALIZACION_PEDIDO);
        
        contentPanel.add(wrap(pantallaListaFarmacos), CARD_LISTA_FARMACOS);
        contentPanel.add(wrap(pantallaModificacionFarmacos), CARD_MODIFICACION_FARMACOS);

        // 5) Mostrar primero la selección de rol
        mostrarRol();
        
    }

    // ========= NAVEGACIÓN =========

    public void mostrarRol() {
        // Si tienes método reset en rol, úsalo, si no no pasa nada
        // pantallaRol.resetFields();
        cardLayout.show(contentPanel, CARD_ROL);
    }

    public void mostrarInicioCliente() {
        cardLayout.show(contentPanel, CARD_INICIO_CLIENTE);
    }

    /**
     * Muestra login ya con un rol seleccionado.
     * Útil para: Admin/Farmacéutico (desde PantallaRol) y Cliente (desde PantallaInicioCliente)
     */
    public void mostrarLoginConRol(String rol) {
        pantallaLogin.resetFields();

        // Esto requiere que implementes este método en PantallaLogin (abajo te lo dejo)
        pantallaLogin.setRolSeleccionado(rol);

        cardLayout.show(contentPanel, CARD_LOGIN);
    }

    public void mostrarRegistroCliente() {
        // Si tienes reset en registro, puedes llamarlo aquí
        // pantallaRegistroCliente.resetFields();
        cardLayout.show(contentPanel, CARD_REGISTRO_CLIENTE);
    }

    // ========= LO QUE YA TENÍAS PARA IR A LOS MENÚS PRINCIPALES =========

    public void mostrarCliente(Sesion sesion) {
        pantallaCliente.setSesion(sesion);
        cardLayout.show(contentPanel, CARD_CLIENTE);
    }

    public void mostrarFarmaceutico(Sesion sesion) {
        pantallaFarmaceutico.setSesion(sesion);
        cardLayout.show(contentPanel, CARD_FARMA);
    }

    public void mostrarAdmin(Sesion sesion) {
        pantallaAdmin.setSesion(sesion);
        cardLayout.show(contentPanel, CARD_ADMIN);
    }
    
    public void mostrarBuscarFarmacos(String volverACard) {
    List<Medicamento> meds = AlmacenMedicamentos.getInstancia().getTodosLosMedicamentos();
    pantallaBuscarFarmacos.setContext(volverACard, meds);
    cardLayout.show(contentPanel, CARD_BUSCAR_FARMACOS);
    }
    
    public void mostrarAltaBajaFarmacos() {
        cardLayout.show(contentPanel, CARD_ALTA_BAJA);
    }

    public void mostrarAltaFarmacos() {
        cardLayout.show(contentPanel, CARD_ALTA_FARMACOS);
    }

    public void mostrarBajaFarmacos() {
        pantallaBajaFarmacos.cargarMedicamentos();
        cardLayout.show(contentPanel, CARD_BAJA_FARMACOS);
    }
    
    public void mostrarEleccionFarmacia(Sesion sesion) {
        pantallaEleccionFarmacia.setSesion(sesion);
        cardLayout.show(contentPanel, CARD_ELECCION_FARMACIA);
    }
    
    public void mostrarRealizacionPedido(Sesion sesion, String farmacia) {
        // 1. Preparar completamente el panel ANTES de mostrarlo
        pantallaRealizacionPedido.prepararPantalla(sesion, farmacia);

        // 2. Cambiar al card
        cardLayout.show(contentPanel, CARD_REALIZACION_PEDIDO);
    }
    
    public void mostrarListaFarmacos() {
        pantallaListaFarmacos.cargarMedicamentos(); // refresca lista al entrar
        cardLayout.show(contentPanel, CARD_LISTA_FARMACOS);
    }

    public void mostrarModificacionFarmacos(Medicamento seleccionado) {
        pantallaModificacionFarmacos.preparar(seleccionado); // carga valores por defecto
        cardLayout.show(contentPanel, CARD_MODIFICACION_FARMACOS);
    }


    
    public void mostrarCard(String card) {
        cardLayout.show(contentPanel, card);
    }
    
    private javax.swing.JPanel wrap(javax.swing.JPanel p) {
        javax.swing.JPanel w = new javax.swing.JPanel(new java.awt.GridBagLayout());
        w.setOpaque(false); // opcional, si quieres que herede el color de fondo
        w.add(p);           // sin constraints: queda centrado
        return w;
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    // End of variables declaration//GEN-END:variables
}
