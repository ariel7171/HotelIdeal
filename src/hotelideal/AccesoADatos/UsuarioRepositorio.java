package hotelideal.AccesoADatos;

import static hotelideal.AccesoADatos.Conexion.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import hotelideal.Entidades.Usuario;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class UsuarioRepositorio {

    private Connection conn;

    public UsuarioRepositorio() throws SQLException {
        
        conn = Conexion.getConnection();
        
    }
    
    public List<Usuario> buscarTodos() {

        List<Usuario> usuarios = new ArrayList<>();

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM usuario", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Usuario usu = crearUsuario(rs);
                usuarios.add(usu);

            }

        } catch (SQLException ex) {

            JOptionPane.showConfirmDialog(null, ex.getMessage(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);

        } finally {

            return usuarios;

        }

    }

    public List<Usuario> buscarTodosActivos() {

        List<Usuario> usuarios = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE estado = 1")) {

            while (rs.next()) {

                Usuario usu = crearUsuario(rs);
                usuarios.add(usu);

            }

        } catch (SQLException ex) {

            JOptionPane.showConfirmDialog(null, ex.getMessage(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);

        } finally {

            return usuarios;

        }

    }

    public Usuario buscarPorId(int id) {

        Usuario usu = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM usuario WHERE idUsuario = ? ORDER BY apellido, nombre")) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    usu = crearUsuario(rs);

                }

            }

        } catch (SQLException ex) {

            JOptionPane.showConfirmDialog(null, ex.getMessage(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);

        } finally {

            return usu;

        }

    }

    public Usuario buscarPorUsuario(String usuario) {

        Usuario usu = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM usuario WHERE estado = 1 AND BINARY usuario LIKE ?")) {

            stmt.setString(1, usuario);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    usu = crearUsuario(rs);

                }

            }

        } catch (SQLException ex) {

            JOptionPane.showConfirmDialog(null, ex.getMessage(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);

        } finally {

            return usu;

        }

    }

    public Usuario login(String usuario, String password, boolean remember) {

        Usuario usu = null;

        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM usuario WHERE estado = 1 AND BINARY usuario LIKE ? AND BINARY password LIKE ?")) {

            stmt.setString(1, usuario);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    usu = crearUsuario(rs);

                    try (PreparedStatement stmt1 = getConnection().prepareStatement("UPDATE usuario SET remember = ? WHERE idUsuario = ?", Statement.RETURN_GENERATED_KEYS)) {

                        stmt1.setBoolean(1, remember);
                        stmt1.setInt(2, usu.getIdUsuario());

                        stmt1.executeUpdate();

                    }

                }

            }

        } catch (SQLException ex) {

            JOptionPane.showConfirmDialog(null, ex.getMessage(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);

        } finally {

            return usu;

        }

    }

    public Usuario guardar(Usuario usuario) {

        String sql;

        if (usuario.getIdUsuario() > 0) {

            sql = "UPDATE usuario SET nombre = ?, apellido = ?, genero = ?, idtipousuario = ?, usuario = ?, password = ?, remember = ? , dark = ? , accent = ?, estado = ? WHERE idUsuario = ?";

        } else {

            sql = "INSERT INTO usuario (nombre, apellido, genero, idtipousuario, usuario, password, remember, dark, accent, estado) VALUES(?,?,?,?,?,?,?,?,?,?)";

        }

        try (PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setBoolean(3, usuario.isGenero());
            stmt.setInt(4, usuario.getTipoUsuario().getIdTipoUsuario());
            stmt.setString(5, usuario.getUsuario());
            stmt.setString(6, usuario.getPassword());
            stmt.setBoolean(7, usuario.isRemember());
            stmt.setBoolean(8, usuario.isDark());
            stmt.setString(9, usuario.getAccent());
            stmt.setBoolean(10, usuario.isActivo());

            if (usuario.getIdUsuario() > 0) {

                stmt.setInt(11, usuario.getIdUsuario());
                stmt.executeUpdate();

            } else {

                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()) {

                    if (rs.next()) {

                        usuario.setIdUsuario(rs.getInt(1));

                    }

                }

            }

        } catch (SQLException ex) {

            JOptionPane.showConfirmDialog(null, ex.getMessage(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);

        }

        return usuario;

    }

    public int eliminarPorId(int id) {

//        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM usuario WHERE idUsuario = ?")) {
//            
//            stmt.setInt(1, id);
//            return stmt.executeUpdate();
//            
//        } catch (SQLException ex) {
//            
//            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, ex.getMessage());
//            
//        }
//        
//        return 0;
        try (PreparedStatement stmt = getConnection().prepareStatement("UPDATE usuario SET estado = 0 WHERE idUsuario = ?")) {

            stmt.setInt(1, id);
            return stmt.executeUpdate();

        } catch (SQLException ex) {

            JOptionPane.showConfirmDialog(null, ex.getMessage(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);

        }

        return 0;

    }

    public Usuario crearUsuario(ResultSet rs) throws SQLException {

        Usuario usu = new Usuario();
        TipoUsuarioRepositorio tr = new TipoUsuarioRepositorio();

        usu.setIdUsuario(rs.getInt("idUsuario"));
        usu.setNombre(rs.getString("nombre"));
        usu.setApellido(rs.getString("apellido"));
        usu.setGenero(rs.getBoolean("genero"));
        usu.setTipoUsuario(tr.buscarPorId(rs.getInt("idtipousuario")));
        usu.setUsuario(rs.getString("usuario"));
        usu.setPassword(rs.getString("password"));
        usu.setRemember(rs.getBoolean("remember"));
        usu.setDark(rs.getBoolean("dark"));
        usu.setAccent(rs.getString("accent"));
        usu.setActivo(rs.getBoolean("estado"));

        return usu;

    }

}
