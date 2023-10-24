/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal.AccesoADatos;

import hotelideal.Entidades.TipoHabitacion;
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
public class TipoHabitacionData{
    
    private Connection conn;

    public TipoHabitacionData() throws SQLException {
        conn = Conexion.getConnection();
    }
     
        public List<TipoHabitacion> buscarTodos() {
        List<TipoHabitacion> tipohabitaciones = new ArrayList<>();
        String sql = "SELECT * FROM tipodehabitacion";
        
        try (
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                TipoHabitacion tipoh = crearTipoHabitacion(rs);
                tipohabitaciones.add(tipoh);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tipohabitaciones;
    }

    public TipoHabitacion buscarPorId(int id) {
        TipoHabitacion tipoh = null;
        String sql = "SELECT * FROM tipodehabitacion WHERE id_tipoDeHabitacion   = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    tipoh = crearTipoHabitacion(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tipoh;
    }

    public TipoHabitacion guardar(TipoHabitacion tipoh) {
        String sql;
        if (tipoh.getId_tipoDeHabitacion() > 0) {
            sql = "UPDATE tipodehabitacion SET descripcion = ?, precioNoche = ?, cantKing = ?, cantQueen = ?, cantSimple = ?, cantPersonas = ?, estado = ? WHERE id_tipoDeHabitacion = ?";
        } else {
            sql = "INSERT INTO tipodehabitacion (descripcion, precioNoche, cantKing, cantQueen, cantSimple, cantPersonas, estado) VALUES(?,?,?,?,?,?,?)";
        }
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, tipoh.getDescripcion());
            ps.setDouble(2, tipoh.getPrecioNoche());
            ps.setInt(3, tipoh.getCantKing());
            ps.setInt(4, tipoh.getCantQueen());
            ps.setInt(5, tipoh.getCantSimple());
            ps.setInt(6, tipoh.getCantPersonas());
            ps.setBoolean(7, tipoh.isEstado());

            if (tipoh.getId_tipoDeHabitacion()> 0) {
                ps.setInt(8, tipoh.getId_tipoDeHabitacion());
                ps.executeUpdate();
            } else {
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        tipoh.setId_tipoDeHabitacion(rs.getInt(1));
                    }
                }
            }
            return tipoh;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public TipoHabitacion crearTipoHabitacion(ResultSet rs) throws SQLException {
        TipoHabitacion tipoh = new TipoHabitacion();
        
        tipoh.setId_tipoDeHabitacion(rs.getInt("id_tipoDeHabitacion"));
        tipoh.setDescripcion(rs.getString("descripcion"));
        tipoh.setPrecioNoche(rs.getDouble("precioNoche"));
        tipoh.setCantKing(rs.getInt("cantKing"));
        tipoh.setCantQueen(rs.getInt("cantQueen"));
        tipoh.setCantSimple(rs.getInt("cantSimple"));
        tipoh.setCantPersonas(rs.getInt("cantPersonas"));
        tipoh.setEstado(rs.getBoolean("estado"));
        return tipoh;

    }
}
