/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal.Vistas;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 *
 * @author Karim
 */
public class MenuView extends javax.swing.JFrame {

    static MenuView test;

    /**
     * Creates new form Test
     */
    public MenuView() {
        initComponents();
        setSize(1280, 720);
    }

    private void centrarInternalFrame(JInternalFrame form) {

        Dimension desktopSize = jDesktopPane1.getSize();
        int x = (desktopSize.width - form.getWidth()) / 2;
        int y = (desktopSize.height - form.getHeight()) / 2;
        form.setLocation(x, y);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuHuesped = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuHabitacion = new javax.swing.JMenuItem();
        menuTipoHabitacion = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuReserva = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 965, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );

        jMenu1.setText("Huesped");

        menuHuesped.setText("Formulario Huesped");
        menuHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHuespedActionPerformed(evt);
            }
        });
        jMenu1.add(menuHuesped);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Habitacion");

        menuHabitacion.setText("Formulario Habitacion");
        menuHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHabitacionActionPerformed(evt);
            }
        });
        jMenu2.add(menuHabitacion);

        menuTipoHabitacion.setText("Formulario Tipo de Habitacion");
        menuTipoHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTipoHabitacionActionPerformed(evt);
            }
        });
        jMenu2.add(menuTipoHabitacion);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Reserva");

        menuReserva.setText("Manejo de Reservas");
        menuReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReservaActionPerformed(evt);
            }
        });
        jMenu4.add(menuReserva);

        jMenuBar1.add(jMenu4);

        menuSalir.setText("Salir");
        menuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSalirMouseClicked(evt);
            }
        });
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void menuHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHuespedActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        FormularioHuespedView frmHuesped = new FormularioHuespedView();
        centrarInternalFrame(frmHuesped);
        frmHuesped.setVisible(true);
        jDesktopPane1.add(frmHuesped);
        jDesktopPane1.moveToFront(frmHuesped);
    }//GEN-LAST:event_menuHuespedActionPerformed

    private void menuHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHabitacionActionPerformed
        try {
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            FormularioHabitacionView fhv = new FormularioHabitacionView();
            centrarInternalFrame(fhv);
            fhv.setVisible(true);
            jDesktopPane1.add(fhv);
            jDesktopPane1.moveToFront(fhv);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_menuHabitacionActionPerformed

    private void menuReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReservaActionPerformed

    }//GEN-LAST:event_menuReservaActionPerformed

    private void menuTipoHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTipoHabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuTipoHabitacionActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_menuSalirMouseClicked

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
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuHabitacion;
    private javax.swing.JMenuItem menuHuesped;
    private javax.swing.JMenuItem menuReserva;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JMenuItem menuTipoHabitacion;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JDesktopPane getjDesktopPane1() {
        return jDesktopPane1;
    }
}
