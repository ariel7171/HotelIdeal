/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal.Vistas;


import hotelideal.AccesoADatos.HabitacionData;
import hotelideal.AccesoADatos.ReservaData;
import hotelideal.AccesoADatos.TipoHabitacionData;
import hotelideal.Entidades.Habitacion;
import hotelideal.Entidades.Huesped;
import hotelideal.Entidades.Reserva;
import hotelideal.Entidades.TipoHabitacion;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Melina
 */
public class FormularioReservaView extends javax.swing.JInternalFrame {
private JDesktopPane desk;
private HabitacionData hData;
private TipoHabitacionData htData;
private ReservaData rData;
private List<Habitacion> habitaciones;
private Habitacion habitacion;
private DefaultTableModel modelo;
private TipoHabitacion tipo;
private LocalDate f1,f2,hoy;
private int prsns,dias,num;
private Huesped huesped;
    /**
     * Creates new form FormularioReservaView1
     */
    public FormularioReservaView() {
        try {
            this.hData=new HabitacionData();
            this.rData=new ReservaData();
        } catch (SQLException ex) {
            Logger.getLogger(FormularioReservaView.class.getName()).log(Level.SEVERE, null, ex);
        }
        hoy=LocalDate.now();
        initComponents();
        setearFormatos();
        desk=MenuView.getjDesktopPane1();
       
        jTableHabitaciones.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
             // El evento se ejecuta cuando cambia la selección de fila
                if (!e.getValueIsAdjusting()) {
                    if(jTableHabitaciones.getSelectedRow()>-1){
                        jButtonHuesped.setEnabled(true);
                    }else{
                         jButtonHuesped.setEnabled(false);
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

        jButtonConfirmar = new javax.swing.JButton();
        jDateChooserFecha1 = new com.toedter.calendar.JDateChooser();
        jDateChooserFecha2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonFiltrar = new javax.swing.JButton();
        jSpinnerCapita = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jButtonHuesped = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelCliente = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHabitaciones = new javax.swing.JTable();

        jButtonConfirmar.setText("Confirmar Reservacion");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jLabel1.setText("Hasta:");

        jLabel2.setText("Desde:");

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        jLabel3.setText("Cápita:");

        jButtonHuesped.setText("Determinar");
        jButtonHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHuespedActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Requeriminetos del Cliente:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Habitaciones disponibles:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Reservar a nombre de:");

        jLabelCliente.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabelCliente.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCliente.setText("Cliente:");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("FORMULARIO DE RESERVAS");

        jTableHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "null", "N°", "Clase", "Cap-Personas", "Piso", "Prec-Noche", "Prec-Fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHabitaciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableHabitaciones);
        if (jTableHabitaciones.getColumnModel().getColumnCount() > 0) {
            jTableHabitaciones.getColumnModel().getColumn(0).setMinWidth(0);
            jTableHabitaciones.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTableHabitaciones.getColumnModel().getColumn(0).setMaxWidth(0);
            jTableHabitaciones.getColumnModel().getColumn(1).setMinWidth(35);
            jTableHabitaciones.getColumnModel().getColumn(1).setPreferredWidth(35);
            jTableHabitaciones.getColumnModel().getColumn(1).setMaxWidth(35);
            jTableHabitaciones.getColumnModel().getColumn(3).setMinWidth(100);
            jTableHabitaciones.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableHabitaciones.getColumnModel().getColumn(3).setMaxWidth(100);
            jTableHabitaciones.getColumnModel().getColumn(4).setMinWidth(40);
            jTableHabitaciones.getColumnModel().getColumn(4).setPreferredWidth(40);
            jTableHabitaciones.getColumnModel().getColumn(4).setMaxWidth(40);
            jTableHabitaciones.getColumnModel().getColumn(5).setMinWidth(80);
            jTableHabitaciones.getColumnModel().getColumn(5).setPreferredWidth(80);
            jTableHabitaciones.getColumnModel().getColumn(5).setMaxWidth(80);
            jTableHabitaciones.getColumnModel().getColumn(6).setMinWidth(80);
            jTableHabitaciones.getColumnModel().getColumn(6).setPreferredWidth(80);
            jTableHabitaciones.getColumnModel().getColumn(6).setMaxWidth(80);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(100, 100, 100))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooserFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSpinnerCapita, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jButtonFiltrar))
                            .addComponent(jLabel3)))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(89, 89, 89)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonConfirmar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCancelar)
                                .addGap(36, 36, 36)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSalir, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonHuesped, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserFecha2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserFecha1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinnerCapita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonFiltrar)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButtonHuesped))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonSalir))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        // TODO add your handling code here:
        if(controlarFecha()){
            modelo=(DefaultTableModel) jTableHabitaciones.getModel();
            modelo.setRowCount(0);
            prsns=(int) jSpinnerCapita.getValue();
            dias=(int) ChronoUnit.DAYS.between(f1, f2);
            habitaciones = hData.listarPorCapitaYfecha(prsns,f1,f2);
            
            if(habitaciones!=null){
                for (Habitacion hab : habitaciones) {
                    tipo=hab.getTipoHabitacion();
                    num=hab.getNroHabitacion();
                    double prec=tipo.getPrecioNoche();
                    modelo.addRow(new Object[]{hab,num,tipo.getDescripcion(),tipo.getCantPersonas(),hab.getPiso(),prec+"$",prec*dias+"$"});
                    jTableHabitaciones.setModel(modelo);
                }
            }
        }
        if(jTableHabitaciones.getRowCount()<1){
            jButtonHuesped.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        desk.removeAll();
        desk.repaint();
        dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHuespedActionPerformed
        // TODO add your handling code here:
        FormularioHuespedView frmHuesped = new FormularioHuespedView();
        frmHuesped.setReserva(true);
        frmHuesped.setVisible(true);
        desk.add(frmHuesped);
        desk.moveToFront(frmHuesped);
        desk.setSelectedFrame(frmHuesped);
        frmHuesped.setfReserva(this);
    }//GEN-LAST:event_jButtonHuespedActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        setearFormatos();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        // TODO add your handling code here:
        int fila=jTableHabitaciones.getSelectedRow();
        habitacion=(Habitacion) jTableHabitaciones.getValueAt(fila, 0);
        int num=(int) jTableHabitaciones.getValueAt(fila, 1);
        LocalDate n = LocalDate.parse("0001-01-01");
        String precio=(String) jTableHabitaciones.getValueAt(fila, 6);
        precio=precio.replace("$", "");
        double prec=Double.parseDouble(precio);
        Object[] botones={"Aceptar","Cancelar"};
        if(0==(javax.swing.JOptionPane.showOptionDialog(this, "Se reservará la habitacion N°"+num+" \nDesde: "+f1+"\nHasta: "+f2+"\nA solicitud de: "+huesped.toString()+"\nCon un precio final de: "+prec+"$", "", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE,null,botones,botones[0]))){
            Object[] botones2={"Confirmar","No Confrimar"};
            if(f1.compareTo(hoy)==0&&0==(javax.swing.JOptionPane.showOptionDialog(this, "Desea confirmar el ingreso del huesped?", "", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE,null,botones,botones[0]))){
                Reserva reserva=new Reserva(prsns, prec, true, true, habitacion, huesped, f1, f2, n);
                rData.guardar(reserva);
            }else{
                Reserva reserva=new Reserva(prsns, prec, true, false, habitacion, huesped, f1, f2, n);
                rData.guardar(reserva);
            }
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonHuesped;
    private javax.swing.JButton jButtonSalir;
    private com.toedter.calendar.JDateChooser jDateChooserFecha1;
    private com.toedter.calendar.JDateChooser jDateChooserFecha2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerCapita;
    private javax.swing.JTable jTableHabitaciones;
    // End of variables declaration//GEN-END:variables
public boolean controlarFecha(){
    if(jDateChooserFecha1.getDate()!=null&&jDateChooserFecha2.getDate()!=null){
        f1=jDateChooserFecha1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        f2=jDateChooserFecha2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(f2.compareTo(f1)<0||f2.compareTo(f1)==0){
            javax.swing.JOptionPane.showMessageDialog(this, "Alerta!\nEl campo \"Desde\", debe contener\nuna fecha previa a la del\ncampo \"Hasta\" ", "", javax.swing.JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(f2.compareTo(hoy)<0||f1.compareTo(hoy)<0){
            javax.swing.JOptionPane.showMessageDialog(this, "Alerta!\nLas fechas ingresadas\nno pueden ser anteriores\na "+hoy, "", javax.swing.JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return true;
        }
    }else{
        javax.swing.JOptionPane.showMessageDialog(this, "Alerta!\nDebe completar los campos\n\"Desde/Hasta\" para filtrar\nhabitaciones disponibles\ndurante aquel periodo", "", javax.swing.JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

public void setearFormatos(){
    SpinnerNumberModel numberModel = new SpinnerNumberModel(1, 1, 10, 1); // (valorInicial, valorMínimo, valorMáximo, paso)
    jSpinnerCapita.setModel(numberModel);
    modelo=(DefaultTableModel) jTableHabitaciones.getModel();
    modelo.setRowCount(0);
    jTableHabitaciones.setModel(modelo);
    jLabelCliente.setText("Cliente: ");
    jDateChooserFecha1.setDateFormatString("dd MMMM yyyy");
    jDateChooserFecha2.setDateFormatString("dd MMMM yyyy");
    Date n=Date.valueOf(hoy);
    jDateChooserFecha1.setDate(n);
    jDateChooserFecha2.setDate(n);
    jButtonCancelar.setEnabled(false);
    jButtonConfirmar.setEnabled(false);
    jButtonHuesped.setEnabled(false);
}

    public void setHuesped(Huesped huesped) {
        if(huesped!=null){
          this.huesped = huesped;
            jLabelCliente.setText("Cliente: "+huesped.toString());
            jButtonConfirmar.setEnabled(true);
            jButtonCancelar.setEnabled(true);
        }else{
            jLabelCliente.setText("Cliente: ");
            jButtonConfirmar.setEnabled(false);
            jButtonCancelar.setEnabled(false);
        } 
    }
}
