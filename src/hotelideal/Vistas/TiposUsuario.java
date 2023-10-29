package hotelideal.Vistas;

//import colortheme.LightDarkMode;
//import colortheme.ToolBarAccentColor;
import colortheme.ToolBarAccentColor;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import hotelideal.Entidades.TipoUsuario;
import hotelideal.Entidades.Usuario;
import hotelideal.AccesoADatos.TipoUsuarioRepositorio;
import hotelideal.AccesoADatos.UsuarioRepositorio;
import hotelideal.Entidades.EnumColor;
import hotelideal.eventos.LoginListener;
import hotelideal.eventos.OptionListener;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class TiposUsuario extends javax.swing.JInternalFrame {
    
    private OptionListener optionListener;

    private TipoUsuarioRepositorio tr;
    private TipoUsuario tipoSeleccionado;
    private UsuarioRepositorio ur;
    private Usuario usuarioSeleccionado;
    
    private ToolBarAccentColor accent;
    private int IdSystemUser;
    private EnumColor colorOption;

    private ItemListener radioButtonListener;

    private boolean isSave;

    public TiposUsuario(int IdSystemUser) throws SQLException {
        
        this.IdSystemUser = IdSystemUser;

        tr = new TipoUsuarioRepositorio();
        ur = new UsuarioRepositorio();
        
        setBorder(new EmptyBorder(3, 3, 3, 3));

        setFrameIcon(new ImageIcon(getClass().getResource("/icon/hotel_21.png")));

        initComponents();

        accent = new ToolBarAccentColor(jPanel1);

        accent.setBounds(115, 200, 185, 27);

        jPanel1.add(accent);

        init();
        
        mostrarInfoCampos();
        
        pasarFoco(cmbTipos);

    }

    private void init() {

        getTiposUsuario();

        this.radioButtonListener = new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED && isSave) {
                    // Se seleccionó un botón, determina cuál fue seleccionado

                    if (e.getSource() == optAdmin) {

                        if (tr.guardar(new TipoUsuario(tipoSeleccionado.getIdTipoUsuario(), tipoSeleccionado.getDescripcion(), true, false, false)) != null) {

                            JOptionPane.showConfirmDialog(null, "Tipo Usuario Actualizado", "Actualizado", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);

                        }

                    } else if (e.getSource() == optCrud) {

                        if (tr.guardar(new TipoUsuario(tipoSeleccionado.getIdTipoUsuario(), tipoSeleccionado.getDescripcion(), false, true, false)) != null) {

                            JOptionPane.showConfirmDialog(null, "Tipo Usuario Actualizado", "Actualizado", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);

                        }

                    } else if (e.getSource() == optQueries) {

                        if (tr.guardar(new TipoUsuario(tipoSeleccionado.getIdTipoUsuario(), tipoSeleccionado.getDescripcion(), false, false, true)) != null) {

                            JOptionPane.showConfirmDialog(null, "Tipo Usuario Actualizado", "Actualizado", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);

                        }

                    }
//                        else if (e.getStateChange() == ItemEvent.DESELECTED) {
//
//                         //Se deseleccionó un botón, puedes manejarlo aquí si es necesario
//                                 
//                                 }
                }

            }

        };

        optAdmin.addItemListener(radioButtonListener);
        optCrud.addItemListener(radioButtonListener);
        optQueries.addItemListener(radioButtonListener);

        cmbTipos.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {

                    //// Obtiene el ítem seleccionado
                    tipoSeleccionado = (TipoUsuario) cmbTipos.getSelectedItem();

                    getAcceso();

                }
            }
        });

        cmdExit.addActionListener((e) -> {

            usuarioSeleccionado = ur.buscarPorId(IdSystemUser);

            ur.guardar(new Usuario(usuarioSeleccionado.getIdUsuario(), usuarioSeleccionado.getNombre(), usuarioSeleccionado.getApellido(), usuarioSeleccionado.isGenero(),usuarioSeleccionado.getTipoUsuario(), usuarioSeleccionado.getUsuario(), usuarioSeleccionado.getPassword(),lightDarkMode1.isDarked(),accent.colorAccentLocated(), usuarioSeleccionado.isRemember(), usuarioSeleccionado.isActivo()));
            
            asignarColorEnum(accent.colorAccentLocated());
            notifyOptionSuccess(colorOption);
            
            JOptionPane.showConfirmDialog(null, "Tipo Usuario Actualizado", "Actualizado", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);

            

            dispose();
        });

    }

    private void getTiposUsuario() {

        cmbTipos.removeAllItems();

        tr.buscarTodos().forEach(alu -> cmbTipos.addItem(alu));

        if (cmbTipos.getItemCount() > 0) {

            tipoSeleccionado = (TipoUsuario) cmbTipos.getSelectedItem();

            getAcceso();

        }

    }

    private void getAcceso() {

        isSave = false;

        String result = tr.buscarAcceso(tipoSeleccionado.getIdTipoUsuario());

        switch (result) {

            case "ADMIN":
                optAdmin.setSelected(true);
                isSave = true;
                break;
            case "CRUD":
                optCrud.setSelected(true);
                isSave = true;
                break;
            case "QUERIES":
                optQueries.setSelected(true);
                isSave = true;
                break;
            default:
                optAdmin.setSelected(true);
                isSave = true;
                break;

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

        lblTheme.putClientProperty("FlatLaf.style", "font: bold $h2.font");
        lblTipo.putClientProperty("FlatLaf.style", "font: bold $h2.font");
        lblAccent.putClientProperty("FlatLaf.style", "font: bold $h2.font");

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
    
    private void asignarColorEnum(String color){
        
        switch (color) {
            
            case "App.accent.default":
                colorOption = EnumColor.DEFAULT;
                break;
            case "App.accent.blue":
                colorOption = EnumColor.BLUE;
                break;
            case "App.accent.purple":
                colorOption = EnumColor.PURPLE;
                break;
            case "App.accent.red":
                colorOption = EnumColor.RED;
                break;
            case "App.accent.orange":
                colorOption = EnumColor.ORANGE;
                break;
            case "App.accent.yellow":
                colorOption = EnumColor.YELLOW;
                break;
            case "App.accent.green":
                colorOption = EnumColor.GREEN;
                break;
            
        }
        
    }
    
    public void setOptionListener(OptionListener listener) {

        this.optionListener = listener;

    }

    private void notifyOptionSuccess(EnumColor color) {

        if (optionListener != null) {

            optionListener.onOptionSuccess(colorOption);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupTypes = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblTipo = new javax.swing.JLabel();
        cmbTipos = new javax.swing.JComboBox<>();
        optAdmin = new javax.swing.JRadioButton();
        optCrud = new javax.swing.JRadioButton();
        optQueries = new javax.swing.JRadioButton();
        cmdExit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblTheme = new javax.swing.JLabel();
        lblAccent = new javax.swing.JLabel();
        lightDarkMode1 = new colortheme.LightDarkMode();

        setTitle("OPCIONES DE SISTEMA");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTipo.setText("TIPO USUARIO");

        groupTypes.add(optAdmin);
        optAdmin.setText("ADMINISTRAR");

        groupTypes.add(optCrud);
        optCrud.setText("CRUD");

        groupTypes.add(optQueries);
        optQueries.setText("QUERIES");

        cmdExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Exit_16.png"))); // NOI18N
        cmdExit.setText("Salir");

        lblTheme.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTheme.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTheme.setText("TEMA");

        lblAccent.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAccent.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAccent.setText("COLOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAccent)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTheme)
                                .addGap(18, 18, 18)
                                .addComponent(lightDarkMode1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(156, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTipo)
                                .addGap(18, 18, 18)
                                .addComponent(cmbTipos, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(optAdmin)
                                .addGap(35, 35, 35)
                                .addComponent(optCrud)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(optQueries)))
                        .addGap(54, 54, 54))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cmdExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(optAdmin)
                            .addComponent(optCrud)
                            .addComponent(optQueries))
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lblTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lightDarkMode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(lblAccent)
                .addGap(18, 18, 18)
                .addComponent(cmdExit)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        //
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<TipoUsuario> cmbTipos;
    private javax.swing.JButton cmdExit;
    private javax.swing.ButtonGroup groupTypes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAccent;
    private javax.swing.JLabel lblTheme;
    private javax.swing.JLabel lblTipo;
    private colortheme.LightDarkMode lightDarkMode1;
    private javax.swing.JRadioButton optAdmin;
    private javax.swing.JRadioButton optCrud;
    private javax.swing.JRadioButton optQueries;
    // End of variables declaration//GEN-END:variables
}
