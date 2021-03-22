/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JOptionPane;

/**
 *
 * @author Pablo
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Pricipal
     */
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);//Ubicamos el formulario al inicar. 
        //this.setExtendedState(MAXIMIZED_BOTH);//Maximizamos el fomulario.
        setTitle("AUTOMOVILES");//Agregamos el Nombre al Fomulario
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuAplicacion = new javax.swing.JMenu();
        opSalir = new javax.swing.JMenuItem();
        mnuChofer = new javax.swing.JMenu();
        opGestionConductor = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        opGestionAutomovil = new javax.swing.JMenuItem();
        mnuAsignacion = new javax.swing.JMenu();
        opAutoChofer = new javax.swing.JMenuItem();
        opAyuda = new javax.swing.JMenu();
        opAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelEscritorioLayout = new javax.swing.GroupLayout(panelEscritorio);
        panelEscritorio.setLayout(panelEscritorioLayout);
        panelEscritorioLayout.setHorizontalGroup(
            panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1181, Short.MAX_VALUE)
        );
        panelEscritorioLayout.setVerticalGroup(
            panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
        );

        mnuAplicacion.setText("Aplicacion");
        mnuAplicacion.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        opSalir.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        opSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/emergency-exit.png"))); // NOI18N
        opSalir.setText("Salir");
        opSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opSalirActionPerformed(evt);
            }
        });
        mnuAplicacion.add(opSalir);

        jMenuBar1.add(mnuAplicacion);

        mnuChofer.setText("Conductor");
        mnuChofer.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        opGestionConductor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        opGestionConductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Conductor.png"))); // NOI18N
        opGestionConductor.setText("Gestión Conductor");
        opGestionConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opGestionConductorActionPerformed(evt);
            }
        });
        mnuChofer.add(opGestionConductor);

        jMenuBar1.add(mnuChofer);

        jMenu2.setText("Automovil");
        jMenu2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        opGestionAutomovil.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        opGestionAutomovil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/coche.png"))); // NOI18N
        opGestionAutomovil.setText("Gestión Automovil");
        opGestionAutomovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opGestionAutomovilActionPerformed(evt);
            }
        });
        jMenu2.add(opGestionAutomovil);

        jMenuBar1.add(jMenu2);

        mnuAsignacion.setText("Asignacion");
        mnuAsignacion.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        opAutoChofer.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        opAutoChofer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/autoconductor.png"))); // NOI18N
        opAutoChofer.setText("Auto Conductor");
        opAutoChofer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opAutoChoferActionPerformed(evt);
            }
        });
        mnuAsignacion.add(opAutoChofer);

        jMenuBar1.add(mnuAsignacion);

        opAyuda.setText("Ayuda");
        opAyuda.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        opAcercaDe.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        opAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Desktop_icon-icons.com_75233 (1).png"))); // NOI18N
        opAcercaDe.setText("Acerca de");
        opAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opAcercaDeActionPerformed(evt);
            }
        });
        opAyuda.add(opAcercaDe);

        jMenuBar1.add(opAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEscritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opSalirActionPerformed
       int a = JOptionPane.showConfirmDialog(null, "Desea Cerrar el Formulario!", "Iformación", JOptionPane.OK_CANCEL_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_opSalirActionPerformed

    private void opGestionConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opGestionConductorActionPerformed
        VentanaConductor frm = new VentanaConductor();
        panelEscritorio.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_opGestionConductorActionPerformed

    private void opGestionAutomovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opGestionAutomovilActionPerformed
        VentanaAutomoviles frm = new VentanaAutomoviles();
        panelEscritorio.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_opGestionAutomovilActionPerformed

    private void opAutoChoferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opAutoChoferActionPerformed
        VentanaAutoConductor frm = new VentanaAutoConductor();
        panelEscritorio.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_opAutoChoferActionPerformed

    private void opAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opAcercaDeActionPerformed
        VentanaAcercaDe frm = new VentanaAcercaDe();
        panelEscritorio.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_opAcercaDeActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnuAplicacion;
    private javax.swing.JMenu mnuAsignacion;
    private javax.swing.JMenu mnuChofer;
    private javax.swing.JMenuItem opAcercaDe;
    private javax.swing.JMenuItem opAutoChofer;
    private javax.swing.JMenu opAyuda;
    private javax.swing.JMenuItem opGestionAutomovil;
    private javax.swing.JMenuItem opGestionConductor;
    private javax.swing.JMenuItem opSalir;
    private javax.swing.JDesktopPane panelEscritorio;
    // End of variables declaration//GEN-END:variables
}
