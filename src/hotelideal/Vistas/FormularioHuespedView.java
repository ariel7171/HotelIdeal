package hotelideal.Vistas;

import com.formdev.flatlaf.FlatClientProperties;
import hotelideal.AccesoADatos.HuespedData;
import hotelideal.Entidades.Huesped;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class FormularioHuespedView extends javax.swing.JInternalFrame {

    private HuespedData hp;
    private Huesped hue;
    private boolean reserva = false;
    private int estado;
    private FormularioReservaView fReserva;

    public FormularioHuespedView() throws SQLException {

        setBorder(new EmptyBorder(3, 3, 3, 3));

        initComponents();

        hp = new HuespedData();

        setFrameIcon(new ImageIcon(getClass().getResource("/icon/hotel_21.png")));

        estado = 0;

        limpiarDatosHuesped();

        mostrarInfoCampos();

        addSelectAllOnFocusToTextFields(this);

        pasarFoco(txtDNI);

    }

    private void limpiarDatosHuesped() {

        limpiarCampos();
        estadosCampos(true, false, false, false, false, false, false);
        estadosBotones(true, false, false, false, true);

    }

    private void restaurarDatosHuesped() {

        estadosBotones(true, true, false, true, false);
        estadosCampos(false, false, false, false, false, false, false);
        txtId.setText("" + hue.getId_huesped());
        txtDNI.setText(hue.getDni());
        txtApellido.setText(hue.getApellido());
        txtNombre.setText(hue.getNombre());
        txtDomicilio.setText(hue.getDomicilio());
        txtCelular.setText(hue.getCelular());
        txtCorreo.setText(hue.getCorreo());
        chkActivo.setSelected(hue.isEstado());

    }

    private void estadosBotones(boolean btnNuevo, boolean btnEditar, boolean btnGuardar, boolean btnCancelar, boolean btnBuscar) {

        cmdNuevo.setEnabled(btnNuevo);
        cmdEditar.setEnabled(btnEditar);
        cmdGuardar.setEnabled(btnGuardar);
        cmdCancelar.setEnabled(btnCancelar);
        cmdBuscar.setEnabled(btnBuscar);

    }

    private void estadosCampos(boolean tfDni, boolean tfApellido, boolean tfNombre, boolean tfDomicilio, boolean tfCelular, boolean tfCorreo, boolean ckActivo) {

        txtDNI.setEnabled(tfDni);
        txtApellido.setEnabled(tfApellido);
        txtNombre.setEnabled(tfNombre);
        txtDomicilio.setEnabled(tfDomicilio);
        txtCelular.setEnabled(tfCelular);
        txtCorreo.setEnabled(tfCorreo);
        chkActivo.setEnabled(ckActivo);

    }

    private void limpiarCampos() {

        txtDNI.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDNI.setText("0");
        txtApellido.setText("");
        txtNombre.setText("");
        txtDomicilio.setText("");
        txtCelular.setText("");
        txtCorreo.setText("");
        chkActivo.setSelected(true);

    }

    private boolean validarDNI(String dni) {
        //return dni.matches("^[1-9]\\d{0,8}$");
        return dni.matches("^[1-9]\\d{6,8}$");
    }

    private boolean validarNomApe(String nomApe) {
        return nomApe.matches("^([A-ZÁÉÍÓÚÜÑ]([.]|[a-záéíóüñ]+))([ ][A-ZÁÉÍÓÚÜÑ]([.]|[a-záéíóüñ]+)){0,5}");
    }

    private boolean validarDomicilio(String domicilio) {
        //return domicilio.matches("^[a-zA-Z0-9.\\s]*$");
        return domicilio.matches("^([A-ZÁÉÍÓÚÜÑ]([.]|[a-záéíóüñ]+))([ ][A-ZÁÉÍÓÚÜÑ]([.]|[a-záéíóüñ]+)){0,5}([ ](S/N|([1-9]\\d{0,5})))");
    }

    private boolean validarCelular(String celular) {
        //return celular.matches("^[+]?[0-9]{10}$");
        return celular.matches("^[1-9]\\d{1}-\\d{8}|[1-9]\\d{2}-\\d{7}|[1-9]\\d{3}-\\d{6}$");
    }

    private boolean validarCorreo(String correo) {
        //return correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        return correo.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$");
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
        lblDni = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        cmdBuscar = new javax.swing.JButton();
        lblApe = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblNom = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        chkActivo = new javax.swing.JCheckBox();
        cmdEditar = new javax.swing.JButton();
        cmdEliminar = new javax.swing.JButton();
        cmdGuardar = new javax.swing.JButton();
        cmdCancelar = new javax.swing.JButton();
        lblDom = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        lblCel = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        lblMail = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        cmdNuevo = new javax.swing.JButton();
        cmdSalir = new javax.swing.JButton();

        txtId.setText("jTextField1");

        lblNom1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNom1.setText("NOMBRE");

        lblNom3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNom3.setText("NOMBRE");

        setTitle("HUESPED");
        setToolTipText("");

        lblDni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDni.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDni.setText("DNI");

        cmdBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search_16.png"))); // NOI18N
        cmdBuscar.setText("Buscar");
        cmdBuscar.setSelected(true);
        cmdBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBuscarActionPerformed(evt);
            }
        });

        lblApe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblApe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblApe.setText("APELLIDO");

        lblNom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNom.setText("NOMBRE");

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEstado.setText("ESTADO");

        chkActivo.setText("Activo");

        cmdEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit_File_16.png"))); // NOI18N
        cmdEditar.setText("Editar");
        cmdEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditarActionPerformed(evt);
            }
        });

        cmdEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete_File_16.png"))); // NOI18N
        cmdEliminar.setText("Eliminar");
        cmdEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEliminarActionPerformed(evt);
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

        lblDom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDom.setText("DOMICILIO");

        lblCel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCel.setText("CELULAR");

        lblMail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMail.setText("CORREO");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("FORMULARIO DE HUESPED");

        cmdNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/New_16.png"))); // NOI18N
        cmdNuevo.setText("Nuevo");
        cmdNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNuevoActionPerformed(evt);
            }
        });

        cmdSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Exit_16.png"))); // NOI18N
        cmdSalir.setText("Salir");
        cmdSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkActivo))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNom)
                            .addComponent(lblApe)
                            .addComponent(lblDni))
                        .addGap(6, 6, 6)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(txtApellido)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCel)
                                    .addComponent(lblDom)
                                    .addComponent(lblMail))
                                .addGap(6, 6, 6)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCelular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                    .addComponent(txtDomicilio)
                                    .addComponent(txtCorreo)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(cmdGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(cmdNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDni)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApe)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNom)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDom)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCel)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMail)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(chkActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdEliminar)
                    .addComponent(cmdEditar)
                    .addComponent(cmdNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdGuardar)
                    .addComponent(cmdCancelar)
                    .addComponent(cmdSalir))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditarActionPerformed

        estado = 2;

        estadosCampos(true, true, true, true, true, true, true);
        estadosBotones(false, false, true, true, false);
        pasarFoco(txtDNI);

    }//GEN-LAST:event_cmdEditarActionPerformed

    private void cmdBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBuscarActionPerformed

        if (validarDNI("" + txtDNI.getText())) {

            hue = hp.buscarPorDNI("" + txtDNI.getText());

            if (hue != null) {

                restaurarDatosHuesped();
                pasarFoco(cmdEditar);
            } else {
                txtDNI.setText("0");
                JOptionPane.showConfirmDialog(this, "El DNI del Huesped ingresado no existe en la BD", "DNI Inexistente", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                pasarFoco(txtDNI);
            }
            estado = 0;
        } else {
            JOptionPane.showConfirmDialog(this, "Ingrese un DNI Correcto", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(txtDNI);
        }
    }//GEN-LAST:event_cmdBuscarActionPerformed

    private void cmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelarActionPerformed

        if (estado == 1) {

            limpiarDatosHuesped();
            pasarFoco(txtDNI);

        } else if (estado == 2) {

            restaurarDatosHuesped();
            pasarFoco(cmdEditar);

        } else {

            limpiarDatosHuesped();
            pasarFoco(txtDNI);

        }
        
        estado = 0;

        if (reserva) {
            fReserva.setHuesped(null);
        }
    }//GEN-LAST:event_cmdCancelarActionPerformed

    private void cmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarActionPerformed

        if (!validarDNI(txtDNI.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese un DNI Correcto", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(txtDNI);
            return;
        }

        if (!validarNomApe(txtApellido.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese un Apellido Correcto", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(txtApellido);
            return;
        }

        if (!validarNomApe(txtNombre.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese un Nombre Correcto", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(txtNombre);
            return;
        }

        if (!validarDomicilio(txtDomicilio.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese un Domicilio Correcto", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(txtDomicilio);
            return;
        }

        if (!validarCelular(txtCelular.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese un Celular Correcto", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(txtCelular);
            return;
        }

        if (!validarCorreo(txtCorreo.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese un Correo Correcto", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            pasarFoco(txtCorreo);
            return;
        }

        if (estado == 1) {
            hue = new Huesped("" + txtNombre.getText(), "" + txtApellido.getText(), "" + txtDomicilio.getText(), "" + txtCorreo.getText(), "" + txtCelular.getText(), "" + txtDNI.getText(), chkActivo.isSelected());
        } else if (estado == 2) {
            hue = new Huesped("" + txtNombre.getText(), "" + txtApellido.getText(), "" + txtDomicilio.getText(), "" + txtCorreo.getText(), "" + txtCelular.getText(), "" + txtDNI.getText(), Integer.parseInt(txtId.getText()), chkActivo.isSelected());
        }

        hue = hp.guardar(hue);

        if (hue != null) {
            if (estado == 1) {
                JOptionPane.showConfirmDialog(this, "El Huesped fue agregado correctamente", "Huesped Creado", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            } else if (estado == 2) {
                JOptionPane.showConfirmDialog(this, "El Huesped fue modificado correctamente", "Huesped Modificado", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }
            restaurarDatosHuesped();
            if (reserva) {
                fReserva.setHuesped(null);
                Object[] botones = {"Aceptar", "Cancelar"};
                int op = javax.swing.JOptionPane.showOptionDialog(this, "Desea utilizar los datos del nuevo cliente:\n" + hue, "", JOptionPane.DEFAULT_OPTION, JOptionPane.OK_OPTION, null, botones, botones[0]);
                if (op == 0) {
                    fReserva.setHuesped(hue);
                    dispose();
                }
            }
        }

        limpiarDatosHuesped();
        estado = 0;
        pasarFoco(txtDNI);

    }//GEN-LAST:event_cmdGuardarActionPerformed

    private void cmdEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEliminarActionPerformed

        String dni = txtDNI.getText();

        if (JOptionPane.showConfirmDialog(this, "Esta Seguro que desea eliminar el Alumno?", "Eliminar Alumno", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {

            int result = hp.eliminarPorDNI(dni);

            if (result == 1) {

                JOptionPane.showConfirmDialog(this, "El Alumno fue eliminado correctamente", "Alumno Eliminado", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);

            } else {

                JOptionPane.showConfirmDialog(this, "El Alumno ya estaba eliminado", "Alumno Inactivo", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);

            }

        }

        limpiarDatosHuesped();
        estado = 0;
        pasarFoco(txtDNI);

    }//GEN-LAST:event_cmdEliminarActionPerformed

    private void cmdNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNuevoActionPerformed

        estado = 1;

        limpiarCampos();
        estadosCampos(true, true, true, true, true, true, true);
        estadosBotones(false, false, true, true, false);
        pasarFoco(txtDNI);

    }//GEN-LAST:event_cmdNuevoActionPerformed

    private void cmdSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSalirActionPerformed

        if (reserva && hue != null) {
            Object[] botones = {"Aceptar", "Cancelar"};
            int op = javax.swing.JOptionPane.showOptionDialog(this, "Desea utilizar los datos del cliente:\n" + hue, "", JOptionPane.DEFAULT_OPTION, JOptionPane.OK_OPTION, null, botones, botones[0]);
            if (op == 0) {
                fReserva.setHuesped(hue);
                dispose();
            }
        } else if (reserva && hue == null) {
            Object[] botones = {"Salir", "Cancelar"};
            int op = javax.swing.JOptionPane.showOptionDialog(this, "Desea salir sin datos de un cliente?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.OK_OPTION, null, botones, botones[0]);
            if (op == 0) {
                fReserva.setHuesped(hue);
                dispose();
            } else {
                dispose();
            }
        } else {
            dispose();
        }

    }//GEN-LAST:event_cmdSalirActionPerformed

    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }

    public void setfReserva(FormularioReservaView fReserva) {
        this.fReserva = fReserva;
    }

    private void mostrarInfoCampos() {

        lblTitle.putClientProperty( "FlatLaf.style", "font: bold $h1.font" );
        lblDni.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        lblApe.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        lblNom.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        lblDom.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        lblMail.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        lblEstado.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        
        txtDNI.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese su DNI");
        txtApellido.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese su Apellido");
        txtNombre.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese su Nombre ");
        txtDomicilio.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese su Domicilio");
        txtCelular.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "11-11111111");
        txtCorreo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "algun@correo.com");

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JButton cmdBuscar;
    private javax.swing.JButton cmdCancelar;
    private javax.swing.JButton cmdEditar;
    private javax.swing.JButton cmdEliminar;
    private javax.swing.JButton cmdGuardar;
    private javax.swing.JButton cmdNuevo;
    private javax.swing.JButton cmdSalir;
    private javax.swing.JLabel lblApe;
    private javax.swing.JLabel lblCel;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblDom;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblNom1;
    private javax.swing.JLabel lblNom3;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre3;
    // End of variables declaration//GEN-END:variables

}
