/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal.Vistas;

import hotelideal.AccesoADatos.ReservaData;
import hotelideal.Entidades.Reserva;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcos
 */
public class GestionReservas extends javax.swing.JInternalFrame {
private DefaultTableModel modelo;
private ReservaData rData;
private List<Reserva> reservas=new ArrayList<>();
private Reserva reserva,r;
private LocalDate f1,f2,hoy;
    /**;
     * Creates new form gestionReservas
     */
    public GestionReservas() {
    try {
        rData=new ReservaData();
    } catch (SQLException ex) {
        Logger.getLogger(GestionReservas.class.getName()).log(Level.SEVERE, null, ex);
    }
        initComponents();
        jButtonAvanzado.setEnabled(false);
        jCheckBoxActivas.setSelected(true);
        hoy=LocalDate.now();
        setearFormato();
        cerrarReservas();
        jTableReservas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
             // El evento se ejecuta cuando cambia la selección de fila
                if (!e.getValueIsAdjusting()) {
                    
                    if(jTableReservas.getSelectedRow()>-1){
                        r=(Reserva) jTableReservas.getValueAt(jTableReservas.getSelectedRow(), 0);
                        if(r.isEstado()){
                            jButtonAvanzado.setEnabled(true);
                        }else{
                            jButtonAvanzado.setEnabled(false);
                        }
                    }else{
                        jButtonAvanzado.setEnabled(false);
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReservas = new javax.swing.JTable();
        jButtonAvanzado = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonFiltrar = new javax.swing.JButton();
        jRadioButtonTodo = new javax.swing.JRadioButton();
        jDateChooserF1 = new com.toedter.calendar.JDateChooser();
        jDateChooserF2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBoxActivas = new javax.swing.JCheckBox();

        jTableReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Estado", "Hab.N°", "Huesped", "R.Desde", "R.Hasta", "Ingreso", "Egreso", "Capita", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableReservas);
        if (jTableReservas.getColumnModel().getColumnCount() > 0) {
            jTableReservas.getColumnModel().getColumn(0).setMinWidth(0);
            jTableReservas.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTableReservas.getColumnModel().getColumn(0).setMaxWidth(0);
            jTableReservas.getColumnModel().getColumn(1).setMinWidth(70);
            jTableReservas.getColumnModel().getColumn(1).setPreferredWidth(70);
            jTableReservas.getColumnModel().getColumn(1).setMaxWidth(70);
            jTableReservas.getColumnModel().getColumn(2).setMinWidth(60);
            jTableReservas.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTableReservas.getColumnModel().getColumn(2).setMaxWidth(60);
            jTableReservas.getColumnModel().getColumn(4).setMinWidth(90);
            jTableReservas.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTableReservas.getColumnModel().getColumn(4).setMaxWidth(90);
            jTableReservas.getColumnModel().getColumn(5).setMinWidth(90);
            jTableReservas.getColumnModel().getColumn(5).setPreferredWidth(90);
            jTableReservas.getColumnModel().getColumn(5).setMaxWidth(90);
            jTableReservas.getColumnModel().getColumn(6).setMinWidth(70);
            jTableReservas.getColumnModel().getColumn(6).setPreferredWidth(70);
            jTableReservas.getColumnModel().getColumn(6).setMaxWidth(70);
            jTableReservas.getColumnModel().getColumn(7).setMinWidth(90);
            jTableReservas.getColumnModel().getColumn(7).setPreferredWidth(90);
            jTableReservas.getColumnModel().getColumn(7).setMaxWidth(90);
            jTableReservas.getColumnModel().getColumn(8).setMinWidth(70);
            jTableReservas.getColumnModel().getColumn(8).setPreferredWidth(70);
            jTableReservas.getColumnModel().getColumn(8).setMaxWidth(70);
            jTableReservas.getColumnModel().getColumn(9).setMinWidth(70);
            jTableReservas.getColumnModel().getColumn(9).setPreferredWidth(70);
            jTableReservas.getColumnModel().getColumn(9).setMaxWidth(70);
        }

        jButtonAvanzado.setText("Avanzado");
        jButtonAvanzado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAvanzadoActionPerformed(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        jRadioButtonTodo.setText("Todas las reservas");
        jRadioButtonTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTodoActionPerformed(evt);
            }
        });

        jLabel1.setText("Desde:");

        jLabel2.setText("Hasta:");

        jCheckBoxActivas.setText("Activas");
        jCheckBoxActivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxActivasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxActivas)
                                    .addComponent(jRadioButtonTodo))
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooserF1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jDateChooserF2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(110, 110, 110)
                                .addComponent(jButtonFiltrar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAvanzado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonFiltrar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jRadioButtonTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooserF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxActivas)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalir)
                    .addComponent(jButtonAvanzado))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAvanzadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAvanzadoActionPerformed
        // TODO add your handling code here:
        JDesktopPane desk=MenuView.getjDesktopPane1();
        desk.repaint();
        ReservaAvanzado gestionReservas=new ReservaAvanzado();
        int n=jTableReservas.getSelectedRow();
        reserva=(Reserva) jTableReservas.getValueAt(n, 0);
        gestionReservas.setReserva(reserva);
        gestionReservas.setGestR(this);
        gestionReservas.setVisible(true);
        desk.add(gestionReservas);
        desk.moveToFront(gestionReservas);
    }//GEN-LAST:event_jButtonAvanzadoActionPerformed

    private void jRadioButtonTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTodoActionPerformed
        // TODO add your handling code here:
        if(jRadioButtonTodo.isSelected()){
            habiliatrElementos(false, false, false);
        }else{
            habiliatrElementos(true, true, true);
        }
        cargarTabla();
    }//GEN-LAST:event_jRadioButtonTodoActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        JDesktopPane desk=MenuView.getjDesktopPane1();
        desk.removeAll();
        desk.repaint();
        dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jCheckBoxActivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxActivasActionPerformed
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_jCheckBoxActivasActionPerformed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        // TODO add your handling code here:
        if(controlarFecha()){
            cargarTabla();
        }
    }//GEN-LAST:event_jButtonFiltrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAvanzado;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JCheckBox jCheckBoxActivas;
    private com.toedter.calendar.JDateChooser jDateChooserF1;
    private com.toedter.calendar.JDateChooser jDateChooserF2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButtonTodo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableReservas;
    // End of variables declaration//GEN-END:variables
public void habiliatrElementos(boolean f1,boolean f2, boolean filtrar){
    jDateChooserF1.setEnabled(f1);
    jDateChooserF2.setEnabled(f2);
    jButtonFiltrar.setEnabled(filtrar);
}

public void setearFormato(){
    jDateChooserF1.setDateFormatString("dd MMMM yyyy");
    jDateChooserF2.setDateFormatString("dd MMMM yyyy");
    Date n=Date.valueOf(hoy);
    jDateChooserF1.setDate(n);
    jDateChooserF2.setDate(n);
}

public boolean controlarFecha(){
    if(jDateChooserF1.getDate()!=null&&jDateChooserF2.getDate()!=null){
        f1=jDateChooserF1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        f2=jDateChooserF2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(f2.compareTo(f1)<0||f2.compareTo(f1)==0){
            javax.swing.JOptionPane.showMessageDialog(this, "Alerta!\nEl campo \"Desde\", debe contener\nuna fecha previa a la del\ncampo \"Hasta\" ", "", javax.swing.JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return true;
        }
    }else{
        javax.swing.JOptionPane.showMessageDialog(this, "Alerta!\nDebe completar los campos\n\"Desde/Hasta\" para filtrar\nhabitaciones disponibles\ndurante aquel periodo", "", javax.swing.JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

public void cargarTabla(){
    modelo=(DefaultTableModel) jTableReservas.getModel();
    modelo.setRowCount(0);
    String estado="Inactivo";
    String ingreso;
    String egreso;
    LocalDate n=LocalDate.parse("0001-01-01");
    if(jRadioButtonTodo.isSelected()){
        if(jCheckBoxActivas.isSelected()){
            reservas=rData.buscarTodos_Activos();
        }else{
            reservas=rData.buscarTodos_InActivos();
        }
    }else{
        if(jCheckBoxActivas.isSelected()){
            reservas=rData.buscarPorFecha_inicioFin_Activos(f1, f2);
        }else{
            reservas=rData.buscarPorFecha_inicioFin_InActivos(f1, f2);
        }
    }
    for (Reserva re : reservas) {
        if(re.isEstado()){
            estado="Activo";
        }
        if(re.isIngreso()){
            ingreso="Si";
        }else{
            ingreso="No";
        }
        if(re.getSalida().equals(n)){
            egreso="No";
        }else{
            egreso=""+re.getSalida();
        }
        modelo.addRow(new Object[]{re,estado,re.getHabitacion().getNroHabitacion(),re.getHuesped(),re.getF_ingreso(),re.getF_salida(),ingreso,egreso,re.getCant_personas(),re.getPrecio()});
    }
    jTableReservas.setModel(modelo);
}
public void cerrarReservas(){
    reservas=rData.buscarTodos_Activos();
    int sinEgreso=0;
    int sinIngreso=0;
    LocalDate n=LocalDate.parse("0001-01-01");
    for (Reserva res : reservas) {
        if((res.getF_salida()).compareTo(hoy)<=0){
            if(res.getF_salida().compareTo(n)==0){
                res.setSalida(res.getF_salida());
                sinEgreso+=1;
            }else if(res.isIngreso()==false){
                sinIngreso+=1;
            }
            res.setEstado(false);
            rData.guardar(res);
        }
    }
    if(sinEgreso>=1||sinIngreso>=1){
        javax.swing.JOptionPane.showMessageDialog(this, "Se cerraron "+sinIngreso+" reservas.\nSe cerraron "+sinEgreso+" ocupaciones.\n(nuevo estado = inactivo)", "", javax.swing.JOptionPane.WARNING_MESSAGE);
    }
}
}