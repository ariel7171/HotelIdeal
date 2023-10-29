/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal.Vistas;

import hotelideal.AccesoADatos.HabitacionData;
import hotelideal.AccesoADatos.TipoHabitacionData;
import hotelideal.Entidades.Habitacion;
import hotelideal.Entidades.TipoHabitacion;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author clau
 */
public class PlanillaHabitaciones extends javax.swing.JInternalFrame {

    private HabitacionData hdata;
    private TipoHabitacionData tipoHaDa;
    private Habitacion habitacion;
    private TipoHabitacion tipoHab;
    private List<TipoHabitacion> listaHabitaciones;
    private DefaultTableModel modelo;
    TipoHabitacion tipohab;

    public PlanillaHabitaciones() throws SQLException {

        setBorder(new EmptyBorder(3, 3, 3, 3));

        initComponents();

        hdata = new HabitacionData();
        tipoHaDa = new TipoHabitacionData();

        listaHabitaciones = tipoHaDa.buscarTodos();

        setFrameIcon(new ImageIcon(getClass().getResource("/icon/hotel_21.png")));

        cargaTipo();

        jComboTipo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    tipoHab = (TipoHabitacion) jComboTipo.getSelectedItem();
                }
            }
        });

        dibujaTabla();
        
        jtTotalHabitaciones.setHorizontalAlignment(SwingConstants.RIGHT);
        
        mostrarInfoCampos();
        jtTotalHabitaciones.setEnabled(false);
        
        pasarFoco(jComboTipo);

    }

    public void cargaTipo() {

        jComboTipo.removeAllItems();

        for (TipoHabitacion th : listaHabitaciones) {
            jComboTipo.addItem(th);
        }
        if (jComboTipo.getItemCount() > 0) {
            tipohab = (TipoHabitacion) jComboTipo.getSelectedItem();
        }
    }

    public void dibujaTabla() {

        // Personalizar la alineación y la fuente de la cabecera
        JTableHeader tableHeader = jTable.getTableHeader();
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();

        // Cambiar la alineación de la cabecera (izquierda en este caso)
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Cambiar la fuente de la cabecera
        jTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

        // Crear renderizadores personalizados para diferentes alineaciones
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);

        jTable.getColumnModel().getColumn(0).setCellRenderer(leftRenderer);   // numero de habitacion
        jTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); // piso 

        modelo = (DefaultTableModel) jTable.getModel();

        cargarTabla();
    }

    public void cargarTabla() {
        modelo = (DefaultTableModel) jTable.getModel();
        modelo.setRowCount(0);

        if (tipohab != null) {
            int descripcionId = tipoHab.getId_tipoDeHabitacion();
            List<Habitacion> habitaciones = hdata.buscaPorIdTipoHabitacion(descripcionId);
//        System.out.println(habitaciones.size());
            for (Habitacion hab : habitaciones) {
                modelo.addRow(new Object[]{
                    hab.getId_habitacion(),
                    hab.getNroHabitacion(),
                    hab.getPiso()});
            }
        }
        jTable.setModel(modelo);
        jtTotalHabitaciones.setText("" + jTable.getRowCount());
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
    
    private void mostrarInfoCampos() {

        //lblTitle.putClientProperty("FlatLaf.style", "font: bold $h1.font");
        lblTipo.putClientProperty("FlatLaf.style", "font: bold $h2.font");
        lblCantidad.putClientProperty("FlatLaf.style", "font: bold $h2.font");

    }
    
    private void pasarFoco(Component com) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                com.requestFocusInWindow();

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
        jTable = new javax.swing.JTable();
        lblTipo = new javax.swing.JLabel();
        jComboTipo = new javax.swing.JComboBox<>();
        jbSalir = new javax.swing.JButton();
        lblCantidad = new javax.swing.JLabel();
        jtTotalHabitaciones = new javax.swing.JTextField();

        setTitle("PLANILLA DE HABITACIONES");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUMERO", "PISO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        lblTipo.setText("Tipo De Habitacion");

        jComboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTipoActionPerformed(evt);
            }
        });

        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Exit_16.png"))); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        lblCantidad.setText("Cantidad de Habitaciones");

        jtTotalHabitaciones.setEditable(false);
        jtTotalHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTotalHabitacionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtTotalHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                        .addComponent(lblTipo)
                        .addComponent(jComboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblTipo)
                .addGap(2, 2, 2)
                .addComponent(jComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtTotalHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad))
                .addGap(15, 15, 15)
                .addComponent(jbSalir)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTipoActionPerformed
        tipoHab = (TipoHabitacion) jComboTipo.getSelectedItem();
        //System.out.println(tipoHab);
        cargarTabla();
    }//GEN-LAST:event_jComboTipoActionPerformed

    private void jtTotalHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTotalHabitacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTotalHabitacionesActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<TipoHabitacion> jComboTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTextField jtTotalHabitaciones;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblTipo;
    // End of variables declaration//GEN-END:variables
}
