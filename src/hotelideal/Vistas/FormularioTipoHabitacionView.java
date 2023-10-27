package hotelideal.Vistas;

import com.formdev.flatlaf.FlatClientProperties;
import hotelideal.AccesoADatos.TipoHabitacionData;
import hotelideal.Entidades.TipoHabitacion;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class FormularioTipoHabitacionView extends javax.swing.JInternalFrame {

    private TipoHabitacionData thd;
    private TipoHabitacion th;

    private int estado;

    public FormularioTipoHabitacionView() {
        
        setBorder(new EmptyBorder(3, 3, 3, 3));

        initComponents();
        try {
            thd = new TipoHabitacionData();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        th = new TipoHabitacion();

        setFrameIcon(new ImageIcon(getClass().getResource("/icon/hotel_21.png")));

        estado = 0;
        
        limpiarDatosTipoHabitacion();

        addSelectAllOnFocusToTextFields(this);

        cargarTipoHabitacion();
        
        mostrarInfoCampos();

        pasarFoco(jcbTipoHabitacion);

    }

    private void cargarTipoHabitacion() {
        jcbTipoHabitacion.removeAllItems();
        for (TipoHabitacion tipoh : thd.buscarTodos()) {
            if (tipoh != null) {
                jcbTipoHabitacion.addItem(tipoh);
            }
        }
    }

    private void limpiarDatosTipoHabitacion() {

        limpiarCampos();
        estadosCampos(false, false, false, false, false, false, false);
        estadosBotones(true, false, false, false);

    }

    private void restaurarDatosTipoHabitacion() {

        estadosBotones(true, true, false, false);
        estadosCampos(false, false, false, false, false, false, false);
        txtId.setText("" + th.getId_tipoDeHabitacion());
        txtDescripcion.setText(th.getDescripcion());
        txtPrecioNoche.setText("" + th.getPrecioNoche());
        txtCamasKing.setText("" + th.getCantKing());
        txtCamasQueen.setText("" + th.getCantQueen());
        txtCamasSimples.setText("" + th.getCantSimple());
        txtCantPer.setText("" + th.getCantPersonas());
        chkActivo.setSelected(th.isEstado());

    }

    private void estadosBotones(boolean btnNuevo, boolean btnEditar, boolean btnGuardar, boolean btnCancelar) {

        cmdNuevo.setEnabled(btnNuevo);
        cmdEditar.setEnabled(btnEditar);
        cmdGuardar.setEnabled(btnGuardar);
        cmdCancelar.setEnabled(btnCancelar);

    }

    private void estadosCampos(boolean tfDescripcion, boolean tfPrecioNoche, boolean tfCamasKing, boolean tfCamasQueen, boolean tfCamasSimples, boolean tfCantPer, boolean ckActivo) {

        txtDescripcion.setEnabled(tfDescripcion);
        txtPrecioNoche.setEnabled(tfPrecioNoche);
        txtCamasKing.setEnabled(tfCamasKing);
        txtCamasQueen.setEnabled(tfCamasQueen);
        txtCamasSimples.setEnabled(tfCamasSimples);
        txtCantPer.setEnabled(tfCantPer);
        chkActivo.setEnabled(ckActivo);

    }

    private void limpiarCampos() {

        txtDescripcion.setText("");
        txtPrecioNoche.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPrecioNoche.setText("0.00");
        txtCamasKing.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCamasKing.setText("0");
        txtCamasQueen.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCamasQueen.setText("0");
        txtCamasSimples.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCamasSimples.setText("0");
        txtCantPer.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCantPer.setText("0");
        chkActivo.setSelected(true);

    }

    private boolean validarDescripcion(String descripcion) {
        return descripcion.matches("^[a-zA-Z0-9\\s-]{1,50}$");
    }

    private boolean validarPrecioNoche(String precioNoche) {
        return precioNoche.matches("^[0-9]+(\\.[0-9]{1,2})?$");
    }

    private boolean validarCantidadCamas(String cantidadCamas) {
        return cantidadCamas.matches("^[0-9]$");
    }

    private boolean validarCantidad(String cantidad) {
        return cantidad.matches("^[1-9]$");
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

        txtId = new javax.swing.JTextField();
        lblNom1 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        lblNom3 = new javax.swing.JLabel();
        txtNombre3 = new javax.swing.JTextField();
        panel = new javax.swing.JPanel();
        lblTipo = new javax.swing.JLabel();
        lblNom = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        txtPrecioNoche = new javax.swing.JTextField();
        chkActivo = new javax.swing.JCheckBox();
        cmdNuevo = new javax.swing.JButton();
        cmdEditar = new javax.swing.JButton();
        cmdSalir = new javax.swing.JButton();
        cmdGuardar = new javax.swing.JButton();
        cmdCancelar = new javax.swing.JButton();
        lblKing = new javax.swing.JLabel();
        txtCamasKing = new javax.swing.JTextField();
        lblQueen = new javax.swing.JLabel();
        txtCamasQueen = new javax.swing.JTextField();
        lblSimples = new javax.swing.JLabel();
        txtCamasSimples = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        jcbTipoHabitacion = new javax.swing.JComboBox<>();
        txtCantPer = new javax.swing.JTextField();
        lblCant = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();

        txtId.setText("jTextField1");

        lblNom1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNom1.setText("NOMBRE");

        lblNom3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNom3.setText("NOMBRE");

        setTitle("Tipo Habitacion");
        setToolTipText("");

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTipo.setText("TIPO");

        lblNom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNom.setText("DESCRIPCION");

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrecio.setText("PRECIO NOCHE");

        chkActivo.setText("Activo");

        cmdNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/New_16.png"))); // NOI18N
        cmdNuevo.setText("Nuevo");
        cmdNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNuevoActionPerformed(evt);
            }
        });

        cmdEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit_File_16.png"))); // NOI18N
        cmdEditar.setText("Editar");
        cmdEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditarActionPerformed(evt);
            }
        });

        cmdSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Exit_16.png"))); // NOI18N
        cmdSalir.setText("Salir");
        cmdSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSalirActionPerformed(evt);
            }
        });

        cmdGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save_File_16.png"))); // NOI18N
        cmdGuardar.setText("Guardar");
        cmdGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardarActionPerformed(evt);
            }
        });

        cmdCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancel_File_16.png"))); // NOI18N
        cmdCancelar.setText("Cancelar");
        cmdCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelarActionPerformed(evt);
            }
        });

        lblKing.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblKing.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblKing.setText("CAMAS KING");

        lblQueen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblQueen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQueen.setText("CAMAS QUEEN");

        lblSimples.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSimples.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSimples.setText("CAMAS SIMPLES");

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("FORMULARIO TIPO HABITACION");

        jcbTipoHabitacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTipoHabitacionItemStateChanged(evt);
            }
        });

        lblCant.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCant.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCant.setText("CANT. PERS.");

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEstado.setText("ESTADO");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(cmdNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmdEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmdSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(cmdGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmdCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblSimples, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(lblQueen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCamasKing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioNoche, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCamasQueen, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCamasSimples, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCant, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkActivo)
                            .addComponent(txtCantPer, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(170, 170, 170)))
                .addGap(244, 244, 244))
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNom)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio)
                    .addComponent(txtPrecioNoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKing)
                    .addComponent(txtCamasKing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQueen)
                    .addComponent(txtCamasQueen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSimples)
                    .addComponent(txtCamasSimples, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdNuevo)
                    .addComponent(cmdEditar)
                    .addComponent(cmdSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdGuardar)
                    .addComponent(cmdCancelar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("TipoHabitacion");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNuevoActionPerformed

        estado = 1;

        limpiarCampos();
        estadosCampos(true, true, true, true, true, true, true);
        estadosBotones(false, false, true, true);
        pasarFoco(txtDescripcion);
        jcbTipoHabitacion.setEnabled(false);

    }//GEN-LAST:event_cmdNuevoActionPerformed

    private void cmdEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditarActionPerformed

        estado = 2;

        estadosCampos(true, true, true, true, true, true, true);
        estadosBotones(false, false, true, true);
        pasarFoco(txtDescripcion);
        jcbTipoHabitacion.setEnabled(false);
    }//GEN-LAST:event_cmdEditarActionPerformed

    private void cmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelarActionPerformed

        if (estado == 1) {

            limpiarDatosTipoHabitacion();
            restaurarDatosTipoHabitacion();
            pasarFoco(jcbTipoHabitacion);

        } else if (estado == 2) {

            restaurarDatosTipoHabitacion();
            pasarFoco(cmdEditar);

        } else {
            restaurarDatosTipoHabitacion();          
            pasarFoco(jcbTipoHabitacion);

        }

        estado = 0;
        jcbTipoHabitacion.setEnabled(true);
    }//GEN-LAST:event_cmdCancelarActionPerformed

    private void cmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarActionPerformed

        if (!validarDescripcion(txtDescripcion.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese una Descripcion Correcta", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(txtDescripcion);
            return;
        }

        if (!validarPrecioNoche(txtPrecioNoche.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese un Precio Correcto", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(txtPrecioNoche);
            return;
        }

        if (!validarCantidadCamas(txtCamasKing.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese una cantidad de Camas King Correcta", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(txtCamasKing);
            return;
        }

        if (!validarCantidadCamas(txtCamasQueen.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese una cantidad de Camas Queen Correcta", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(txtCamasQueen);
            return;
        }

        if (!validarCantidadCamas(txtCamasSimples.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese una cantidad de Camas Simples Correcta", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(txtCamasSimples);
            return;
        }

        if (!validarCantidad(txtCantPer.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese una cantidad de Personas Correcta", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(txtCantPer);
            return;
        }

        if (estado == 1) {
            th = new TipoHabitacion(Integer.parseInt(txtCamasSimples.getText()), Integer.parseInt(txtCamasQueen.getText()), Integer.parseInt(txtCamasKing.getText()), Integer.parseInt(txtCantPer.getText()), "" + txtDescripcion.getText(), Double.parseDouble(txtPrecioNoche.getText()), chkActivo.isSelected());
        } else if (estado == 2) {
            th = new TipoHabitacion(Integer.parseInt(txtId.getText()), Integer.parseInt(txtCamasSimples.getText()), Integer.parseInt(txtCamasQueen.getText()), Integer.parseInt(txtCamasKing.getText()), Integer.parseInt(txtCantPer.getText()), "" + txtDescripcion.getText(), Double.parseDouble(txtPrecioNoche.getText()), chkActivo.isSelected());
        }

        // limpiarDatosHuesped();
        th = thd.guardar(th);

        if (th != null) {
            if (estado == 1) {
                JOptionPane.showConfirmDialog(this, "El Tipo de Habitacion fue agregado correctamente", "Tipo de Habitacion Creado", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            } else if (estado == 2) {
                JOptionPane.showConfirmDialog(this, "El Tipo de Habitacion fue modificado correctamente", "Tipo de Habitacion Modificado", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }
            restaurarDatosTipoHabitacion();
        }

        estado = 0;
        jcbTipoHabitacion.setEnabled(true);
        pasarFoco(jcbTipoHabitacion);
        cargarTipoHabitacion();
        jcbTipoHabitacion.setSelectedItem(th);
        restaurarDatosTipoHabitacion();
        
    }//GEN-LAST:event_cmdGuardarActionPerformed

    private void jcbTipoHabitacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTipoHabitacionItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            th = (TipoHabitacion) jcbTipoHabitacion.getSelectedItem();
            if (th != null) {
                restaurarDatosTipoHabitacion();
            }
        }
    }//GEN-LAST:event_jcbTipoHabitacionItemStateChanged

    private void cmdSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSalirActionPerformed
        dispose();
    }//GEN-LAST:event_cmdSalirActionPerformed
    
    
    private void mostrarInfoCampos() {

        lblTitle.putClientProperty( "FlatLaf.style", "font: bold $h1.font" );
        lblTipo.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        lblNom.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        lblNom.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        lblPrecio.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        lblQueen.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        lblSimples.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        lblCant.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        lblEstado.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        
        txtDescripcion.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese la descripción");
        txtPrecioNoche.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "0.00");
        txtCamasKing.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "0");
        txtCamasQueen.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "0");
        txtCamasSimples.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "0");
        txtCantPer.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "0");
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JButton cmdCancelar;
    private javax.swing.JButton cmdEditar;
    private javax.swing.JButton cmdGuardar;
    private javax.swing.JButton cmdNuevo;
    private javax.swing.JButton cmdSalir;
    private javax.swing.JComboBox<TipoHabitacion> jcbTipoHabitacion;
    private javax.swing.JLabel lblCant;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblKing;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblNom1;
    private javax.swing.JLabel lblNom3;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblQueen;
    private javax.swing.JLabel lblSimples;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtCamasKing;
    private javax.swing.JTextField txtCamasQueen;
    private javax.swing.JTextField txtCamasSimples;
    private javax.swing.JTextField txtCantPer;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre3;
    private javax.swing.JTextField txtPrecioNoche;
    // End of variables declaration//GEN-END:variables

}
