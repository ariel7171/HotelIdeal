package hotelideal.Vistas;

//import colortheme.ToolBarAccentColor;
import colortheme.ToolBarAccentColor;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import hotelideal.Entidades.Usuario;
import hotelideal.AccesoADatos.*;
import hotelideal.Entidades.EnumColor;
import hotelideal.eventos.LoginListener;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.util.Collections;
import javax.swing.border.EmptyBorder;

public class Login extends javax.swing.JInternalFrame {

    private LoginListener loginListener;
    private UsuarioRepositorio ur;
    
    private ToolBarAccentColor accent;
    
    private boolean isChange;
    
    private EnumColor colorLogin;

    public Login() throws SQLException {
        
        isChange = false;

        ur = new UsuarioRepositorio();
        
        accent = new ToolBarAccentColor(jPanel1);

        setBorder(new EmptyBorder(3, 3, 3, 3));
        
        initComponents();

        init();

        setFrameIcon(new ImageIcon(getClass().getResource("/icon/hotel_21.png")));

        addSelectAllOnFocusToTextFields(this);
        
        mostrarInfoCampos();
        
        pasarFoco(txtUserName);

    }

    private void init() {

        cmdLogin.addActionListener((e) -> {

            if (ur.login(txtUserName.getText(), new String(txtPassword.getPassword()), chkRememberMe.isSelected()) != null) {

                Usuario usu = ur.login(txtUserName.getText(), new String(txtPassword.getPassword()), chkRememberMe.isSelected());

                dispose();
                notifyLoginSuccess(usu.getIdUsuario(), usu.getUsuario().toUpperCase(),colorLogin);
                notifyMethodExecution();

            } else {

                JOptionPane.showConfirmDialog(this, "Error de Logueo", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
                pasarFoco(txtUserName);

            }

        });

        txtUserName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                buscarUsuario();
            }
        });

        txtUserName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                buscarUsuario();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                buscarUsuario();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                buscarUsuario();
            }
        });

        txtPassword.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true");

    }

    private void buscarUsuario() {

        Usuario usu = ur.buscarPorUsuario(txtUserName.getText());

        if (usu != null) {

            if (usu.isRemember()) {

                chkRememberMe.setSelected(true);
                txtPassword.setText(usu.getPassword());

            }
            
            EventQueue.invokeLater(() -> {
                    
                    FlatAnimatedLafChange.showSnapshot();
                    
                    if (usu.isDark()) {
                        
                        FlatMacDarkLaf.setup();
                        
                    } else {
                        
                        FlatMacLightLaf.setup();
                        
                    }
                    
                    FlatLaf.updateUI();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                    
                    String colorAccent = usu.getAccent();
                    asignarColorEnum(colorAccent);
                    accent.colorAccentChanged(colorAccent);
                    isChange = true;

                });

        } else {

            chkRememberMe.setSelected(false);
            txtPassword.setText("");
            
            if (isChange) {
                
                    asignarColorEnum("App.accent.default");

                    EventQueue.invokeLater(() -> {

                        FlatAnimatedLafChange.showSnapshot();
                        FlatLaf.registerCustomDefaultsSource("universidadulp/theme");
                        FlatLaf.setGlobalExtraDefaults(Collections.singletonMap("@accentColor", ("#4B6EAF").toString()));
                        FlatMacDarkLaf.setup();
                        FlatLaf.updateUI();
                        FlatAnimatedLafChange.hideSnapshotWithAnimation();

                    });

                    isChange = false;

                }
            
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        cmdLogin = new javax.swing.JButton();
        chkRememberMe = new javax.swing.JCheckBox();
        txtPassword = new javax.swing.JPasswordField();

        setTitle("BIENVENIDO AL GRAN HOTEL");
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

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUser.setText("USUARIO");

        lblPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPass.setText("PASSWORD");

        cmdLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User Locked_16.png"))); // NOI18N
        cmdLogin.setText("Iniciar Sesión");

        chkRememberMe.setText("Recordarme");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chkRememberMe, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117))
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(cmdLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkRememberMe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(cmdLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

        pasarFoco(txtUserName);

    }//GEN-LAST:event_formInternalFrameOpened

    private void mostrarInfoCampos() {
        
        lblUser.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        lblPass.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );

        txtUserName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese su Usuario");
        txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese su Password");

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

        SwingUtilities.invokeLater(() -> {

            com.requestFocusInWindow();

//                if (com instanceof JTextField) {
//                    ((JTextField) com).selectAll();
//                }
        });

    }

    public void setLoginListener(LoginListener listener) {

        this.loginListener = listener;

    }

    private void notifyLoginSuccess(int idUser, String Username, EnumColor color) {

        if (loginListener != null) {

            loginListener.onLoginSuccess(idUser, Username, colorLogin);

        }

    }

    private void notifyMethodExecution() {

        if (loginListener != null) {

            loginListener.onMethodExecution();

        }

    }
    
    private void asignarColorEnum(String color){
        
        switch (color) {
            
            case "App.accent.default":
                colorLogin = EnumColor.DEFAULT;
                break;
            case "App.accent.blue":
                colorLogin = EnumColor.BLUE;
                break;
            case "App.accent.purple":
                colorLogin = EnumColor.PURPLE;
                break;
            case "App.accent.red":
                colorLogin = EnumColor.RED;
                break;
            case "App.accent.orange":
                colorLogin = EnumColor.ORANGE;
                break;
            case "App.accent.yellow":
                colorLogin = EnumColor.YELLOW;
                break;
            case "App.accent.green":
                colorLogin = EnumColor.GREEN;
                break;
            
        }
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkRememberMe;
    private javax.swing.JButton cmdLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
