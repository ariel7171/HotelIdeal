/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal.AccesoADatos;

import static hotelideal.AccesoADatos.Conexion.getConnection;
import hotelideal.Entidades.Reserva;
import java.sql.Connection;
import java.sql.Date;
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
public class ReservaData {

    private Connection conn;

    public ReservaData() throws SQLException {
        conn = Conexion.getConnection();
    }

    public List<Reserva> buscarTodos() {
        List<Reserva> rHuespedes = new ArrayList<>();
        String sql = "SELECT * FROM reserva";

        try (
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Reserva rHue = crearReservaHuesped(rs);
                rHuespedes.add(rHue);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rHuespedes;
    }

    public Reserva buscarPorId(int id) {
        Reserva res = null;
        String sql = "SELECT * FROM reserva WHERE idReserva   = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    res = crearReservaHuesped(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public Reserva guardar(Reserva rHuesped) {
        String sql;
        if (rHuesped.getIdReserva() > 0) {
            sql = "UPDATE reserva SET id_habitacion = ?, id_huesped = ?, fechaIngreso = ?, fechaSalida = ?, precio = ?, cant_personas = ?, estado = ? WHERE idReserva  = ?";
        } else {
            sql = "INSERT INTO reserva (id_habitacion, id_huesped, fechaIngreso, fechaSalida, precio, cant_personas, estado) VALUES(?,?,?,?,?,?,?)";
        }
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, rHuesped.getHabitacion().getId_habitacion());
            ps.setInt(2, rHuesped.getHuesped().getId_huesped());
            ps.setDate(3, Date.valueOf(rHuesped.getF_ingreso()));
            ps.setDate(4, Date.valueOf(rHuesped.getF_salida()));
            ps.setDouble(5, rHuesped.getPrecio());
            ps.setInt(6, rHuesped.getCant_personas());
            ps.setBoolean(7, rHuesped.isEstado());

            if (rHuesped.getIdReserva() > 0) {
                ps.setInt(8, rHuesped.getIdReserva());
                ps.executeUpdate();
            } else {
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        rHuesped.setIdReserva(rs.getInt(1));
                    }
                }
            }
            return rHuesped;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Reserva crearReservaHuesped(ResultSet rs) throws SQLException {
        Reserva rHuesped = new Reserva();
        HabitacionData habR = new HabitacionData();
        HuespedData hueR = new HuespedData();

        rHuesped.setIdReserva(rs.getInt("idReserva "));
        rHuesped.setHabitacion(habR.buscarPorId(rs.getInt("id_habitacion ")));
        rHuesped.setHuesped(hueR.buscarPorId(rs.getInt("id_huesped ")));
        rHuesped.setF_ingreso(rs.getDate("fechaIngreso").toLocalDate());
        rHuesped.setF_salida(rs.getDate("fechaSalida").toLocalDate());
        rHuesped.setPrecio(rs.getDouble("precio"));
        rHuesped.setCant_personas(rs.getInt("cant_personas"));
        rHuesped.setEstado(rs.getBoolean("estado"));

        return rHuesped;

    }

}
