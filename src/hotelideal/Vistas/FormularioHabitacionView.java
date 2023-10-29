package hotelideal.Vistas;

import com.formdev.flatlaf.FlatClientProperties;
import hotelideal.AccesoADatos.HabitacionData;
import hotelideal.AccesoADatos.TipoHabitacionData;
import hotelideal.Entidades.Habitacion;
import hotelideal.Entidades.TipoHabitacion;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Marcos
 */
public class FormularioHabitacionView extends javax.swing.JInternalFrame {

    private HabitacionData hdata;
    private Habitacion habitacion;

    private TipoHabitacionData thd;
    private List<TipoHabitacion> listaHabitaciones;

    //private boolean isNew;
    private int estado;

    public FormularioHabitacionView() throws SQLException {

        setBorder(new EmptyBorder(3, 3, 3, 3));

        initComponents();
        
         mostrarInfoCampos();

        txtId.setText("0");

        hdata = new HabitacionData();
        thd = new TipoHabitacionData();

        listaHabitaciones = thd.buscarTodos();

        setFrameIcon(new ImageIcon(getClass().getResource("/icon/hotel_21.png")));

        cargaTipo();

        //nuevo, editar, eliminar, guardar, cancelar, buscar
        estadosBotones(true, false, false, false, false, true);
        limpiarCampos();
        //piso, numero, descripcion, estado, tipo
        estadoCampos(false, true, false, false, false);

        //isNew = false;
        estado = 0;

        jbSalir.addActionListener(
                (e) -> {
                    dispose();
                }
        );
        
        pasarFoco(jtNumero);
       
    }

    public void estadosBotones(boolean bNuevo, boolean bEditar, boolean bEliminar, boolean bGuardar, boolean bCancelar, boolean bBuscar) {
        jbBuscar.setEnabled(bNuevo);
        jbNuevo.setEnabled(bNuevo);
        jbEditar.setEnabled(bEditar);
        jbGuardar.setEnabled(bGuardar);
        jbCancelar.setEnabled(bCancelar);
        jbEliminar.setEnabled(bEliminar);
    }

    public void estadoCampos(boolean piso, boolean numero, boolean descripcion, boolean estado, boolean combo) {
        //jtCodHabitacion.setEnabled(habitacion);
        jtPiso.setEnabled(piso);
        jtNumero.setEnabled(numero);
        jtDescripcion.setEnabled(descripcion);
        jcEstado.setEnabled(estado);
        jComboTipo.setEnabled(combo);
    }

    public void limpiarCampos() {
        //jtCodHabitacion.setText("0");
        //jtCodHabitacion.setHorizontalAlignment(SwingConstants.RIGHT);
        jtPiso.setText("0");
        jtPiso.setHorizontalAlignment(SwingConstants.RIGHT);
        jtNumero.setText("0");
        jtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        jtDescripcion.setText("");
        jcEstado.setSelected(true);
    }

    public boolean validarCod_Hab(String codigo) {
        return codigo.trim().matches("^[1-9]\\d{0,5}$");
    }

    public boolean validarPiso(String piso) {
        return piso.trim().matches("^[0-9]\\d{0,5}$");
    }

    public boolean validarNumero(String numero) {
        return numero.trim().matches("^[1-9]\\d{0,6}$");
    }

    public boolean validarDescripcion(String descripcion) {
        return descripcion.trim().matches("^([A-ZÁÉÍÓÚÜÑ]([.]|[a-záéíóüñ]+))([ ][A-ZÁÉÍÓÚÜÑ1-9]([.]|[a-záéíóüñ1-9]*)){0,5}");
    }

    public void cargaTipo() {

        jComboTipo.removeAllItems();

        for (TipoHabitacion th : listaHabitaciones) {
            jComboTipo.addItem(th);
        }
        if (jComboTipo.getItemCount() > 0) {
            TipoHabitacion tipohab = (TipoHabitacion) jComboTipo.getSelectedItem();
        }
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
;
        lblNum.putClientProperty("FlatLaf.style", "font: bold $h2.font");
        lblDes.putClientProperty("FlatLaf.style", "font: bold $h2.font");
        lblPiso.putClientProperty("FlatLaf.style", "font: bold $h2.font");
        lblTipo.putClientProperty("FlatLaf.style", "font: bold $h2.font");
        lblEstado.putClientProperty("FlatLaf.style", "font: bold $h2.font");

        jtNumero.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese Nº");
        jtDescripcion.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese la descripción");
        jtPiso.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese Piso");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jbBuscar = new javax.swing.JButton();
        lblPiso = new javax.swing.JLabel();
        jtPiso = new javax.swing.JTextField();
        lblNum = new javax.swing.JLabel();
        jtNumero = new javax.swing.JTextField();
        lblDes = new javax.swing.JLabel();
        jtDescripcion = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        jcEstado = new javax.swing.JCheckBox();
        lblTipo = new javax.swing.JLabel();
        jComboTipo = new javax.swing.JComboBox<>();
        jbNuevo = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        txtId.setText("jTextField1");

        setTitle("HABITACIONES");

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search_16.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        lblPiso.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPiso.setText("PISO");

        jtPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPisoActionPerformed(evt);
            }
        });

        lblNum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNum.setText("NUMERO");

        jtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNumeroActionPerformed(evt);
            }
        });

        lblDes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDes.setText("DESCRIPCION");

        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEstado.setText("ESTADO");

        jcEstado.setText("Activo");

        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTipo.setText("TIPO");

        jbNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/New_16.png"))); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit_File_16.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete_File_16.png"))); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save_File_16.png"))); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancel_File_16.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Exit_16.png"))); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNum, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblDes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPiso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcEstado)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum)
                    .addComponent(jbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPiso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(jComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(jcEstado))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbEditar)
                    .addComponent(jbEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbCancelar)
                    .addComponent(jbSalir))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        if (validarNumero(jtNumero.getText())) {

            habitacion = hdata.buscarPorNumHabitacion(Integer.parseInt(jtNumero.getText()));

            if (habitacion != null) {
                restaurarDatosHabitacion();
                pasarFoco(jbEditar);
            } else {
                jtNumero.setText("0");
                JOptionPane.showConfirmDialog(this, "la habitacion no existe", "Numero inexistente", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                pasarFoco(jtNumero);
            }
            estado = 0;

        } else {
            JOptionPane.showConfirmDialog(this, "Ingrese un codigo valido", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(jtNumero);
        }

    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        txtId.setText("0");
        //isNew = true;
        estado = 1;
        limpiarCampos();
        //nuevo, editar, eliminar, guardar, cancelar, buscar
        estadosBotones(false, false, false, true, true, false);
        //piso, numero, descripcion, estado, combo
        estadoCampos(true, true, true, true, true);
        pasarFoco(jtNumero);

    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed

//        limpiarCampos();
//        //piso, numero, descripcion, estado,combo
//        estadoCampos(false, true, false, false, false);
//        //nuevo, editar, eliminar, guardar, cancelar, buscar
//        estadosBotones(true, false, false, false, false, true);
//        pasarFoco(jtNumero);
        if (estado == 1) {

            limpiarCampos();
            estadoCampos(false, true, false, false, false);
            estadosBotones(true, false, false, false, false, true);
            pasarFoco(jtNumero);

        } else if (estado == 2) {

            restaurarDatosHabitacion();
            pasarFoco(jbEditar);

        } else {

            limpiarCampos();
            estadoCampos(false, true, false, false, false);
            estadosBotones(true, false, false, false, false, true);
            pasarFoco(jtNumero);

        }
        
        estado = 0;

    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed

        estado = 2;
        estadosBotones(false, false, true, true, true, false);
        estadoCampos(true, true, true, true, true);
        pasarFoco(jtNumero);

    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed

        if (JOptionPane.showConfirmDialog(this, "Desea eliminar la habitacion?", "Eliminar habitacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
            int hab = hdata.desactivarHabitacion(Integer.parseInt(txtId.getText()));

            if (hab == 1) {
                JOptionPane.showConfirmDialog(this, "La Habitacion fue eliminada correctamente", "Habitacion Eliminada", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showConfirmDialog(this, "La Habitacion ya estaba eliminada", "Habitacion Inactiva", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }
            limpiarCampos();
            estadoCampos(false, true, false, false, false);
            estadosBotones(true, false, false, false, false, true);
            estado = 0;
            pasarFoco(jtNumero);
        }

    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        Habitacion aux = new Habitacion();
//        if (!isNew && !validarCod_Hab(jtCodHabitacion.getText())) {
//            JOptionPane.showConfirmDialog(this, "codigo Incorrecto", "codigo invalido", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
//            pasarFoco(jtCodHabitacion);
//            return;
//        }

        if (!validarNumero(jtNumero.getText())) {
            jtNumero.setText("0");
            JOptionPane.showConfirmDialog(this, "numero Incorrecto", "numero invalido", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(jtNumero);
            return;
        }

        //tengo que buscar que el numero de habitacion ya existe o no con el metodo buscaNumHabitacion
        aux = hdata.buscarPorNumHabitacion(Integer.parseInt(jtNumero.getText()));
        if (aux != null && aux.getId_habitacion() != Integer.parseInt(txtId.getText()) || aux != null && txtId.getText().equals("0")) {
            JOptionPane.showConfirmDialog(this, "Ya existe una habitacion con el mismo numero", "numero invalido", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(jtNumero);
            return;
        }

        if (!validarPiso(jtPiso.getText())) {
            JOptionPane.showConfirmDialog(this, "piso Incorrecto", "el piso no existe", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(jtPiso);
            return;
        }

        if (!validarDescripcion(jtDescripcion.getText())) {
            JOptionPane.showConfirmDialog(this, "descrpcion Incorrecta", "descripcion invalida", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(jtDescripcion);
            return;
        }

        TipoHabitacion tipohab = (TipoHabitacion) jComboTipo.getSelectedItem();

        if (estado == 1) {
            habitacion = new Habitacion(
                    Integer.parseInt(jtPiso.getText().trim()),
                    Integer.parseInt(jtNumero.getText().trim()),
                    "" + jtDescripcion.getText(),
                    jcEstado.isSelected(),
                    tipohab);
        } else if (estado == 2){
            habitacion = new Habitacion(
                    Integer.parseInt(txtId.getText().trim()),
                    Integer.parseInt(jtPiso.getText().trim()),
                    Integer.parseInt(jtNumero.getText().trim()),
                    "" + jtDescripcion.getText(),
                    jcEstado.isSelected(),
                    tipohab);
        }

        habitacion = hdata.guardar(habitacion);

        if (estado == 1) {
            JOptionPane.showConfirmDialog(this, "Habitacion agregada correctamente", "Habitacion Creada", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
        } else if (estado == 2){
            JOptionPane.showConfirmDialog(this, "Habitacion modificada correctamente", "Habitacion Modificada", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
        }
        limpiarCampos();
        estadoCampos(false, true, false, false, false);
        estadosBotones(true, false, false, false, false, true);

        pasarFoco(jtNumero);
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jtPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPisoActionPerformed

    private void jtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNumeroActionPerformed

    public void restaurarDatosHabitacion() {

        estadosBotones(true, true, true, false, true, false);
        estadoCampos(false, false, false, false, false);
        txtId.setText("" + habitacion.getId_habitacion());
        jtPiso.setText("" + habitacion.getPiso());
        jtNumero.setText("" + habitacion.getNroHabitacion());
        jtDescripcion.setText(habitacion.getDescripcion());
        jcEstado.setSelected(habitacion.isEstado());

        TipoHabitacion n = habitacion.getTipoHabitacion();

        int cont = jComboTipo.getItemCount();
        for (int i = 0; i <= cont; i++) {
            if (n.equals(jComboTipo.getItemAt(i))) {
                jComboTipo.setSelectedIndex(i);
            }
        }
    }

    public static void addSelectAllOnFocusToTextFields(Container container) {

        for (Component component : container.getComponents()) {

            if (component instanceof JTextField) {

                JTextField textField = (JTextField) component;

                textField.addFocusListener(new FocusAdapter() {

                    @Override
                    public void focusGained(FocusEvent e) {

                        textField.selectAll();

                    }

                });

            } else if (component instanceof Container) {

                // Si es un contenedor, busca campos de texto dentro del contenedor
                addSelectAllOnFocusToTextFields((Container) component);

            }

        }

    }

    public void pasarFoco(Component com) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                com.requestFocusInWindow();

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<TipoHabitacion> jComboTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcEstado;
    private javax.swing.JTextField jtDescripcion;
    private javax.swing.JTextField jtNumero;
    private javax.swing.JTextField jtPiso;
    private javax.swing.JLabel lblDes;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblPiso;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
