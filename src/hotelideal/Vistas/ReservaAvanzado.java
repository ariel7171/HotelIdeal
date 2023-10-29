/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal.Vistas;

import com.formdev.flatlaf.FlatClientProperties;
import hotelideal.AccesoADatos.ReservaData;
import hotelideal.Entidades.Reserva;
import hotelideal.Vistas.GestionReservas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Marcos
 */
public class ReservaAvanzado extends javax.swing.JInternalFrame {

    private Reserva reserva;
    private ReservaData rData;
    private GestionReservas gestR;
    private LocalDate fout, hoy, f1, f2;

    /**
     * Creates new form ReservaAvanzado
     */
    public ReservaAvanzado() {

        try {

            rData = new ReservaData();

        } catch (SQLException ex) {

            JOptionPane.showConfirmDialog(this, ex.getMessage(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);

        }
        setBorder(new EmptyBorder(3, 3, 3, 3));
        initComponents();

        jDateChooserF1.setIcon(new ImageIcon(getClass().getResource("/icon/Calendar_16.png")));
        jDateChooserF2.setIcon(new ImageIcon(getClass().getResource("/icon/Calendar_16.png")));
        jDateChooserFout.setIcon(new ImageIcon(getClass().getResource("/icon/Calendar_16.png")));

        setFrameIcon(new ImageIcon(getClass().getResource("/icon/hotel_21.png")));

        hoy = LocalDate.now();

        setearFormatos();
        mostrarInfoCampos();
        habilitarCampos(false, false, false, false, false, false);
        habilitarBotones(true, true, false, false, true);

    }

    private void mostrarInfoCampos() {

        lblID.putClientProperty("FlatLaf.style", "font: bold $h2.font");
        lblEstado.putClientProperty("FlatLaf.style", "font: bold $h2.font");
        lblHab.putClientProperty("FlatLaf.style", "font: bold $h2.font");
        lblDesde.putClientProperty("FlatLaf.style", "font: bold $h2.font");
        lblHasta.putClientProperty("FlatLaf.style", "font: bold $h2.font");
        lblIng.putClientProperty("FlatLaf.style", "font: bold $h2.font");
        lblEgr.putClientProperty("FlatLaf.style", "font: bold $h2.font");
        lblCapita.putClientProperty("FlatLaf.style", "font: bold $h2.font");
        lblMonto.putClientProperty("FlatLaf.style", "font: bold $h2.font");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblHab = new javax.swing.JLabel();
        lblHues = new javax.swing.JLabel();
        lblDesde = new javax.swing.JLabel();
        lblHasta = new javax.swing.JLabel();
        lblIng = new javax.swing.JLabel();
        lblEgr = new javax.swing.JLabel();
        lblCapita = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jCheckBoxActivo = new javax.swing.JCheckBox();
        jTextFieldMontoFin = new javax.swing.JTextField();
        jDateChooserF1 = new com.toedter.calendar.JDateChooser();
        jDateChooserF2 = new com.toedter.calendar.JDateChooser();
        jDateChooserFout = new com.toedter.calendar.JDateChooser();
        jButtonEditar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonFinOcupaciones = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jCheckBoxConfirmado = new javax.swing.JCheckBox();
        jLabelHuesped = new javax.swing.JLabel();
        jLabelCapita = new javax.swing.JLabel();
        jLabelNroHabitacion = new javax.swing.JLabel();

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblID.setText("ID");

        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEstado.setText("ESTADO");

        lblHab.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHab.setText("HABITACION Nº");

        lblHues.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHues.setText("HUESPED");

        lblDesde.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDesde.setText("RESERVADO DESDE");

        lblHasta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHasta.setText("RESERVADO HASTA");

        lblIng.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIng.setText("INGRESO HUESPED");

        lblEgr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEgr.setText("EGRESO HUESPUED");

        lblCapita.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCapita.setText("CAPITA");

        lblMonto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonto.setText("MONTO FINAL");

        jCheckBoxActivo.setText("Activo");

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit_File_16.png"))); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save_File_16.png"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete_File_16.png"))); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonFinOcupaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Final_16.png"))); // NOI18N
        jButtonFinOcupaciones.setLabel("Finalizar");
        jButtonFinOcupaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinOcupacionesActionPerformed(evt);
            }
        });

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Exit_16.png"))); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancel_File_16.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jCheckBoxConfirmado.setText("Confirmado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMonto)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(68, 68, 68)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblHues)
                                        .addComponent(lblEstado)
                                        .addComponent(lblID)))
                                .addComponent(lblHasta, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblDesde, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblEgr, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCapita, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblHab, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lblIng))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBoxConfirmado)
                                .addComponent(jLabelNroHabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxActivo)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldMontoFin)
                                        .addComponent(jLabelCapita, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jDateChooserF2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(jDateChooserF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateChooserFout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabelHuesped, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonFinOcupaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(jCheckBoxActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblHab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNroHabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblHues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelHuesped, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooserF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooserF2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIng, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxConfirmado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooserFout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEgr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCapita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCapita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMontoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMonto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonFinOcupaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonSalir)
                    .addComponent(jButtonEditar))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        if (jCheckBoxConfirmado.isSelected()) {
            javax.swing.JOptionPane.showMessageDialog(this, "El cliente ya ingresó a la habitacion.\nNo se puede editar la ocupación.", "", javax.swing.JOptionPane.WARNING_MESSAGE);
        } else {
            habilitarCampos(true, true, true, true, true, false);
            habilitarBotones(false, false, true, true, false);
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonFinOcupacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinOcupacionesActionPerformed
        // TODO add your handling code here:
        if (jCheckBoxConfirmado.isSelected()) {
            jCheckBoxActivo.setSelected(false);
            jDateChooserFout.setDate(Date.valueOf(hoy));
            habilitarCampos(false, false, true, false, false, false);
            habilitarBotones(false, false, true, true, false);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No se puede dar un fin a las ocupaciones si primero no se confirmaron.", "", 0);
        }
    }//GEN-LAST:event_jButtonFinOcupacionesActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        if (jButtonGuardar.isEnabled()) {
            Object[] botones = {"Aceptar", "Cancelar"};
            if (0 == (javax.swing.JOptionPane.showOptionDialog(this, "Al salir, se perderan todos los datos no guardados.\nDesea continuar?", "Alerta", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.ERROR_MESSAGE, null, botones, botones[0]))) {
                dispose();
            }
        } else {
            dispose();
        }
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        inicializarCampos();
        habilitarCampos(false, false, false, false, false, false);
        habilitarBotones(true, true, false, false, true);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        Object[] botones = {"Guardar", "Cancelar"};
        Object[] botones01 = {"Continuar", "Cancelar"};
        f1 = jDateChooserF1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        f2 = jDateChooserF2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (jDateChooserFout.isEnabled() && todosLosCamposHabilitados() == false) {
            if (ningunCampoVacio() && campoFoutNoVacio()) {
                if (ControlarFcheck_out(true)) {
                    if (0 == (javax.swing.JOptionPane.showOptionDialog(this, "Se actualizaran los datos y no se\npodrán revertir los cambios\nDesea guardar?", "", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE, null, botones, botones[0]))) {
                        capturarDatos(false);
                        if ((fout.compareTo(reserva.getF_salida())) <= 1) {
                            int dias = (int) ChronoUnit.DAYS.between(reserva.getF_ingreso(), fout);
                            dias = Math.abs(dias);
                            double precioNoche = reserva.getHabitacion().getTipoHabitacion().getPrecioNoche();
                            double monto1 = reserva.getPrecio();
                            double monto2 = precioNoche * dias;
                            if (monto2 == 0) {
                                monto2 = precioNoche;
                            }
                            Object[] botones2 = {"Actualizar", "No Actualizar"};
                            if (0 == (javax.swing.JOptionPane.showOptionDialog(this, "El cliente se retirará antes de lo previsto.\nDesea actualizar el monto final?\n\nMonto Actual: " + reserva.getPrecio() + "$\nNuevo Monto: " + monto2 + "$", "", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE, null, botones2, botones2[0]))) {
                                reserva.setPrecio(monto2);
                                rData.guardar(reserva);
                                gestR.cargarTabla();
                                dispose();
                            } else {
                                rData.guardar(reserva);
                                gestR.cargarTabla();
                                dispose();
                            }
                        }
                    }
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Se detectaron campos vacios!\nDebe completar todos los\ncampos para poder continuar.", "", javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        } else {
            if (ningunCampoVacio()) {
                if (f1.compareTo(f2) < 0 && f1.compareTo(hoy) >= 0) {
                    if (rData.comprobarFechaIngresoSalida(reserva.getHabitacion().getId_habitacion(), reserva.getIdReserva(), f1, f2)) {
                        if (ControlarFcheck_out(false)) {
                            int dias1 = (int) ChronoUnit.DAYS.between(f1, f2);
                            double precioNoche = reserva.getHabitacion().getTipoHabitacion().getPrecioNoche();
                            dias1 = Math.abs(dias1);
                            double monto1 = precioNoche * dias1;
                            reserva.setPrecio(monto1);
                            capturarDatos(true);
                            if (jDateChooserFout.getDate() != null) {
                                capturarDatos(false);
                                if (ControlarFcheck_out(true)) {
                                    int dias2 = (int) ChronoUnit.DAYS.between(fout, f1);
                                    dias2 = Math.abs(dias2);
                                    double monto2 = (precioNoche * dias2);
                                    if (monto2 == 0) {
                                        monto2 = precioNoche;
                                    }
                                    reserva.setPrecio(monto2);

                                    if (jCheckBoxActivo.isSelected() == false || jCheckBoxConfirmado.isSelected()) {
                                        if (hoy.compareTo(f1) < 0) {
                                            javax.swing.JOptionPane.showMessageDialog(this, "No se puede confirmar el ingreso del huesped antes de " + f1 + "\nSe descartarán los cambios ingresados.");
                                        } else {
                                            if (0 == (javax.swing.JOptionPane.showOptionDialog(this, "Atención!!\nSi el check \"Activo\" está vacío\nse dará de baja la ocupación y\nSi el Egreso está confirmado\nNo se podrá editar la ocupación.\nDesea continuar?", "", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE, null, botones01, botones01[0]))) {
                                                rData.guardar(reserva);
                                                gestR.cargarTabla();
                                                dispose();
                                            }
                                        }

                                    } else {
                                        rData.guardar(reserva);
                                        gestR.cargarTabla();
                                        dispose();
                                    }
                                }
                            } else {
                                if (jCheckBoxActivo.isSelected() == false || jCheckBoxConfirmado.isSelected()) {
                                    if (hoy.compareTo(f1) < 0) {
                                        javax.swing.JOptionPane.showMessageDialog(this, "No se puede confirmar el ingreso del huesped antes de " + f1 + "\nSe descartarán los cambios ingresados.");
                                    } else {
                                        if (0 == (javax.swing.JOptionPane.showOptionDialog(this, "Atención!!\nSi el check \"Activo\" está vacío\nse dará de baja la ocupación y\nSi el Egreso está confirmado\nNo se podrá editar la ocupación.\nDesea continuar?", "", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE, null, botones01, botones01[0]))) {
                                            rData.guardar(reserva);
                                            gestR.cargarTabla();
                                            dispose();
                                        }
                                    }
                                } else {
                                    rData.guardar(reserva);
                                    gestR.cargarTabla();
                                    dispose();
                                }
                            }
                        }
                    }
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "La fecha ingresada en el campo \"Desde\", no puede ser previa a la fecha actual\nTampoco es aceptable que la fecha del campo \"Hasta\", sea previa a la del campo\"Desde\" ", "", 0);
                }
            }
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
        Object[] botones = {"Cancelar", "Continuar"};
        if (1 == (javax.swing.JOptionPane.showOptionDialog(this, "Este procedimiento eliminará los\ndatos y ya no se podran recuperar.\nComprende este procedimiento y\ndesea continuar?", "Alerta", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.ERROR_MESSAGE, null, botones, botones[0]))) {
            Object[] botones2 = {"Cancelar", "Confirmar"};
            if (1 == (javax.swing.JOptionPane.showOptionDialog(this, "Confirme proceso de eliminacion", "Confirmacion", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE, null, botones2, botones2[0]))) {
                rData.eliminar(reserva.getIdReserva(), true);
                gestR.cargarTabla();
                dispose();
            }
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonFinOcupaciones;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JCheckBox jCheckBoxActivo;
    private javax.swing.JCheckBox jCheckBoxConfirmado;
    private com.toedter.calendar.JDateChooser jDateChooserF1;
    private com.toedter.calendar.JDateChooser jDateChooserF2;
    private com.toedter.calendar.JDateChooser jDateChooserFout;
    private javax.swing.JLabel jLabelCapita;
    private javax.swing.JLabel jLabelHuesped;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelNroHabitacion;
    private javax.swing.JTextField jTextFieldMontoFin;
    private javax.swing.JLabel lblCapita;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JLabel lblEgr;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblHab;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JLabel lblHues;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIng;
    private javax.swing.JLabel lblMonto;
    // End of variables declaration//GEN-END:variables

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
        inicializarCampos();
    }

    public void setGestR(GestionReservas gestR) {
        this.gestR = gestR;
    }

    public void inicializarCampos() {
        jLabelID.setText("" + reserva.getIdReserva());
        jLabelNroHabitacion.setText("" + reserva.getHabitacion().getNroHabitacion());
        jLabelHuesped.setText(reserva.getHuesped().toString());
        jLabelCapita.setText("" + reserva.getCant_personas());
        jDateChooserF1.setDate(Date.valueOf(reserva.getF_ingreso()));
        jDateChooserF2.setDate(Date.valueOf(reserva.getF_salida()));
        jCheckBoxActivo.setSelected(reserva.isEstado());
        jCheckBoxConfirmado.setSelected(reserva.isIngreso());
        jTextFieldMontoFin.setText(reserva.getPrecio() + " $");
        jDateChooserFout.setDate(null);
    }

    public void capturarDatos(boolean foutNull) {

        boolean actv = jCheckBoxActivo.isSelected();
        boolean cnfrmd = jCheckBoxConfirmado.isSelected();
        String monto = jTextFieldMontoFin.getText();
        if (monto.contains("$") || monto.contains(",")) {
            monto.replace("$", "");
            monto.replace(",", ".");
        }
        if (foutNull) {
            fout = LocalDate.parse("0001-01-01");
            reserva.setSalida(fout);
        } else {
            reserva.setSalida(fout);
        }
        reserva.setF_ingreso(f1);
        reserva.setF_salida(f2);
        reserva.setEstado(actv);
        reserva.setIngreso(cnfrmd);
    }

    public void habilitarCampos(boolean f1, boolean f2, boolean fout, boolean activo, boolean confirmado, boolean monto) {
        jDateChooserF1.setEnabled(f1);
        jDateChooserF2.setEnabled(f2);
        jDateChooserFout.setEnabled(fout);
        jCheckBoxActivo.setEnabled(activo);
        jCheckBoxConfirmado.setEnabled(confirmado);
        jTextFieldMontoFin.setEnabled(monto);
    }

    public void habilitarBotones(boolean editar, boolean finRes, boolean cancelar, boolean guardar, boolean eliminar) {
        jButtonEditar.setEnabled(editar);
        jButtonFinOcupaciones.setEnabled(finRes);
        jButtonCancelar.setEnabled(cancelar);
        jButtonGuardar.setEnabled(guardar);
        jButtonEliminar.setEnabled(eliminar);
    }

    public boolean ControlarFcheck_out(boolean tru) {

        if (tru) {
            if (jDateChooserFout.getDate() != null) {
                fout = jDateChooserFout.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if ((fout.compareTo(hoy)) < 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "La fecha ingresada en el campo \"Egreso\"\nno puede ser previa a la actual\n(" + hoy + ")", "", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return false;
                } else if ((fout.compareTo(reserva.getF_salida())) > 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "La fecha ingresada en el campo \"Egreso\"\nno puede ser posterior a " + reserva.getF_salida(), "", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {

                    Object[] botones01 = {"Continuar", "Cancelar"};
                    if (1 == (javax.swing.JOptionPane.showOptionDialog(this, "Al completar el campo \"Egreso\", ya no se podrá editar la reserva,\nDesea continuar?", "", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE, null, botones01, botones01[0]))) {
                        return false;
                    } else {
                        return true;
                    }
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "El campo \"Egreso\" no puede estar vacio.", "", javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } else {

            if (jDateChooserFout.getDate() != null) {
                fout = jDateChooserFout.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if ((fout.compareTo(hoy)) < 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "La fecha ingresada en el campo \"Egreso\"\nno puede ser previa a la actual\n(" + hoy + ")", "", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return false;
                } else if ((fout.compareTo(reserva.getF_salida())) > 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "La fecha ingresada en el campo \"Egreso\"\nno puede ser posterior a " + reserva.getF_salida(), "", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    Object[] botones01 = {"Guardar", "Cancelar"};
                    if (1 == (javax.swing.JOptionPane.showOptionDialog(this, "Se actualizaran los datos y no se\npodrán revertir los cambios\nDesea guardar?", "", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE, null, botones01, botones01[0]))) {
                        return false;
                    } else {
                        return true;
                    }
                }
            } else {
                Object[] botones01 = {"Guardar", "Cancelar"};
                if (1 == (javax.swing.JOptionPane.showOptionDialog(this, "Se actualizaran los datos y no se\npodrán revertir los cambios\nDesea guardar?", "", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE, null, botones01, botones01[0]))) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    public void setearFormatos() {
        jTextFieldMontoFin.setHorizontalAlignment(SwingConstants.RIGHT);

        jDateChooserF1.setDateFormatString("dd MMMM yyyy");
        jDateChooserF2.setDateFormatString("dd MMMM yyyy");
        jDateChooserFout.setDateFormatString("dd MMMM yyyy");
    }

    public boolean todosLosCamposHabilitados() {
        return jDateChooserF1.isEnabled() && jDateChooserF2.isEnabled() && jDateChooserFout.isEnabled() && jCheckBoxActivo.isEnabled() && jCheckBoxConfirmado.isEnabled();
    }

    public boolean ningunCampoVacio() {

        return jDateChooserF1.getDate() != null && jDateChooserF2.getDate() != null && jTextFieldMontoFin.getText() != null;
    }

    public boolean campoFoutNoVacio() {

        return jDateChooserFout.getDate() != null;
    }

    @Override
    protected void paintComponent(Graphics g) {

        int width = getWidth();
        int height = getHeight();
        int arc = 20; // Ajusta este valor para controlar el radio de las esquinas

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(getBackground());

        g2d.fill(new RoundRectangle2D.Float(0, 0, width, height, arc, arc));

        g2d.setColor(getBackground());
        g2d.draw(new RoundRectangle2D.Float(0, 0, width - 1, height - 1, arc, arc));

        g2d.dispose();
        super.paintComponent(g);
    }
}
