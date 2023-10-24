/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal.AccesoADatos;

import hotelideal.Entidades.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Melina
 */
public class HabitacionData {

    private Connection conn;

    public HabitacionData() throws SQLException {
        conn = Conexion.getConnection();
    }

    public List<Habitacion> buscarTodos() {
        List<Habitacion> habitaciones = new ArrayList<>();
        String sql = "SELECT * FROM habitacion";
        try (
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Habitacion hab = crearHabitacion(rs);
                habitaciones.add(hab);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return habitaciones;
    }

    public Habitacion buscarPorId(int id) {
        Habitacion hab = null;
        String sql = "SELECT * FROM habitacion WHERE id_habitacion = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    hab = crearHabitacion(rs);
                } else {
                    JOptionPane.showMessageDialog(null, "No existe la habitacion");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hab;
    }

    public Habitacion guardar(Habitacion habitacion) {

        String sql;
        if (habitacion.getId_habitacion() > 0) {
            sql = "UPDATE habitacion SET nroHabitacion = ?, descripcion = ?, id_tipoDeHabitacion = ?, piso = ?, estado = ? WHERE id_habitacion = ?";
        } else {
            sql = "INSERT INTO habitacion (nroHabitacion, descripcion, id_tipoDeHabitacion, piso, estado) VALUES(?,?,?,?,?)";
        }
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, habitacion.getNroHabitacion());
            ps.setString(2, habitacion.getDescripcion());
            ps.setInt(3, habitacion.getTipoHabitacion().getId_tipoDeHabitacion());
            ps.setInt(4, habitacion.getPiso());
            ps.setBoolean(5, habitacion.isEstado());

            if (habitacion.getId_habitacion() > 0) {
                ps.setInt(6, habitacion.getId_habitacion());
                ps.executeUpdate();
            } else {
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        habitacion.setId_habitacion(rs.getInt(1));
                    }
                }
            }
            return habitacion;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Habitacion crearHabitacion(ResultSet rs) throws SQLException {
        Habitacion hab = new Habitacion();
        TipoHabitacionData thr = new TipoHabitacionData();
        hab.setId_habitacion(rs.getInt("id_habitacion"));
        hab.setNroHabitacion(rs.getInt("nroHabitacion"));
        hab.setDescripcion(rs.getString("descripcion"));
        hab.setTipoHabitacion(thr.buscarPorId(rs.getInt("id_tipoDeHabitacion")));
        hab.setPiso(rs.getInt("piso"));
        hab.setEstado(rs.getBoolean("estado"));
        return hab;
    }

    public int desactivarHabitacion(int id) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE habitacion SET estado = 0 WHERE estado = 1 AND id_habitacion = ?")) {
            stmt.setInt(1, id);

            return stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean buscaNumHabitacion(int nro) {

        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM habitacion WHERE nroHabitacion = ?")) {
            stmt.setInt(1, nro);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int aux = rs.getInt(1);
                    //se considera que la habitacion existe
                    return aux > 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List buscaPorDescripcion(String des) {
        List<Habitacion> habitaciones = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM habitacion WHERE descripcion = ?")) {
            stmt.setString(1, des);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Habitacion hb = crearHabitacion(rs);
                    habitaciones.add(hb);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return habitaciones;
    }
}
