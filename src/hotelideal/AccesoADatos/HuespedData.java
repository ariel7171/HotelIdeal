/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal.AccesoADatos;

import hotelideal.Entidades.Huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Melina
 */
public class HuespedData {

    private Connection conn;

    public HuespedData() throws SQLException {
        conn = Conexion.getConnection();
    }

    public List<Huesped> buscarTodos() {
        List<Huesped> huespedes = new ArrayList<>();
        String sql = "SELECT * FROM huesped ORDER BY apellido, nombre";

        try (
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Huesped hue = crearHuesped(rs);
                huespedes.add(hue);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return huespedes;
    }

    public Huesped buscarPorId(int id) {
        Huesped hue = null;
        String sql = "SELECT * FROM huesped WHERE id_huesped  = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    hue = crearHuesped(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return hue;
    }

    public Huesped buscarPorDNI(String dni) {
        Huesped hue = null;
        String sql = "SELECT * FROM huesped WHERE dni  = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    hue = crearHuesped(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hue;
    }

    public Huesped guardar(Huesped huesped) {
        String sql;
        if (huesped.getId_huesped() > 0) {
            sql = "UPDATE huesped SET dni = ?, apellido = ?, nombre = ?, domicilio = ?, celular = ?, correo = ?, estado = ? WHERE id_huesped = ?";
        } else {
            sql = "INSERT INTO huesped (dni, apellido, nombre, domicilio, celular, correo, estado) VALUES(?,?,?,?,?,?,?)";
        }
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, huesped.getDni());
            ps.setString(2, huesped.getApellido());
            ps.setString(3, huesped.getNombre());
            ps.setString(4, huesped.getDomicilio());
            ps.setString(5, huesped.getCelular());
            ps.setString(6, huesped.getCorreo());
            ps.setBoolean(7, huesped.isEstado());

            if (huesped.getId_huesped() > 0) {
                ps.setInt(8, huesped.getId_huesped());
                ps.executeUpdate();
            } else {
                ps.executeUpdate();//linea 83
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        huesped.setId_huesped(rs.getInt(1));
                    }
                }
            }
            return huesped;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private Huesped crearHuesped(ResultSet rs) throws SQLException {
        Huesped hue = new Huesped();
        hue.setId_huesped(rs.getInt("id_huesped"));
        hue.setDni(rs.getString("dni"));
        hue.setApellido(rs.getString("apellido"));
        hue.setNombre(rs.getString("nombre"));
        hue.setDomicilio(rs.getString("domicilio"));
        hue.setCelular(rs.getString("celular"));
        hue.setCorreo(rs.getString("correo"));
        hue.setEstado(rs.getBoolean("estado"));
        return hue;

    }
}
