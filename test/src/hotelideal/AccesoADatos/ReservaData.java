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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    
    public boolean comprobarFechaIngresoSalida(int id_habitacion,int idRes,LocalDate n1,LocalDate n2) {
        List<Reserva> rHuespedes = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE (estado=1 AND id_habitacion="+id_habitacion+" AND idReserva!="+idRes+")";
        LocalDate auxIng=null;
        LocalDate auxEgr=null;
        int n=0;
        try (
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Reserva rHue = crearReservaHuesped(rs);
                rHuespedes.add(rHue);
            }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------            
            for (Reserva rHuesped : rHuespedes) {
                LocalDate F_ingreso=rHuesped.getF_ingreso();
                LocalDate F_salida=rHuesped.getF_salida();
                if(((F_ingreso.compareTo(n2))<=0)&&((F_ingreso.compareTo(n1))>0)){
                    
                    if(auxIng==null){
                        auxIng=F_ingreso;
                    }else if((auxIng.compareTo(F_ingreso))>0){
                        auxIng=F_ingreso;
                    }      
                }
                if(((n1.compareTo(F_salida))<=0)&&((F_salida.compareTo(n2))<0)){
                    
                    if(auxEgr==null){
                        auxEgr=F_salida;
                    }else if((auxEgr.compareTo(F_salida))>0){
                        auxEgr=F_salida;
                    }
                }
                if(   ((n1.compareTo(F_ingreso))>=0&&((n1.compareTo(F_salida))<0))  &&  ((n2.compareTo(F_salida))<=0&&((n2.compareTo(F_ingreso))>0))  ){
                    n++;
                    if(auxIng==null){
                        auxIng=F_ingreso;
                    }else if((auxIng.compareTo(F_ingreso))<0){
                        auxIng=F_ingreso;
                    } 
                    
                    if(auxEgr==null){
                        auxEgr=F_salida;
                    }else if((auxEgr.compareTo(F_salida))<0){
                        auxEgr=F_salida;
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if(auxIng!=null&&auxEgr!=null){
            javax.swing.JOptionPane.showMessageDialog(null, "Se detectó un conflicto con una reserva\ndonde inicia el dia ->"+auxIng+"\nSe detectó un conflicto con una reserva\ndonde finaliza el dia ->"+auxEgr, "", javax.swing.JOptionPane.WARNING_MESSAGE);
                return false; 
        }else if(auxIng!=null&&auxEgr==null){
            javax.swing.JOptionPane.showMessageDialog(null, "Se detectó un conflicto con una reserva\ndonde inicia el dia ->"+auxIng, "", javax.swing.JOptionPane.WARNING_MESSAGE);
                return false;
        }else if(auxIng==null&&auxEgr!=null){
            javax.swing.JOptionPane.showMessageDialog(null, "Se detectó un conflicto con una reserva\ndonde finaliza el dia ->"+auxEgr, "", javax.swing.JOptionPane.WARNING_MESSAGE);
                return false;
        }
        return true; 
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------    
    public void eliminar(int id, boolean fisico){
        if(fisico){
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM `reserva` WHERE idReserva="+id)) {
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else{
            try (PreparedStatement ps = conn.prepareStatement("UPDATE `reserva` SET `estado`=0 WHERE idReserva="+id)) {
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
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
    
    public List<Reserva> buscarTodos_Activos() {
        List<Reserva> rHuespedes = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE estado=1";

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
    
    public List<Reserva> buscarTodos_InActivos() {
        List<Reserva> rHuespedes = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE estado=0";

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
    
    public List<Reserva> buscarPorFecha_inicioFin_Activos(LocalDate f1,LocalDate f2) {
        List<Reserva> res =  new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE estado=1 AND fechaIngreso>='"+f1+"' AND fechaSalida<='"+f2+"'";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
                 
            while (rs.next()) {
                Reserva rHue = crearReservaHuesped(rs);
                res.add(rHue);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
    public List<Reserva> buscarPorFecha_inicioFin_InActivos(LocalDate f1,LocalDate f2) {
        List<Reserva> res = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE estado=0 AND fechaIngreso>='"+f1+"' AND fechaSalida<='"+f2+"'";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
                 
            while (rs.next()) {
                Reserva rHue = crearReservaHuesped(rs);
                res.add(rHue);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
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
            sql = "UPDATE reserva SET id_habitacion = ?, id_huesped = ?, fechaIngreso = ?, fechaSalida = ?, precio = ?, cant_personas = ?, estado = ? , ingreso=? , salida=? WHERE idReserva  = ?";
        } else {
            sql = "INSERT INTO reserva (id_habitacion, id_huesped, fechaIngreso, fechaSalida, precio, cant_personas, estado, ingreso , salida) VALUES(?,?,?,?,?,?,?,?,?)";
        }
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, rHuesped.getHabitacion().getId_habitacion());
            ps.setInt(2, rHuesped.getHuesped().getId_huesped());
            ps.setDate(3, Date.valueOf(rHuesped.getF_ingreso()));
            ps.setDate(4, Date.valueOf(rHuesped.getF_salida()));
            ps.setDouble(5, rHuesped.getPrecio());
            ps.setInt(6, rHuesped.getCant_personas());
            ps.setBoolean(7, rHuesped.isEstado());
            ps.setBoolean(8, rHuesped.isIngreso());
            ps.setDate(9, Date.valueOf(rHuesped.getSalida()));

            if (rHuesped.getIdReserva() > 0) {
                ps.setInt(10, rHuesped.getIdReserva());
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

        rHuesped.setIdReserva(rs.getInt("idReserva"));
        rHuesped.setHabitacion(habR.buscarPorId(rs.getInt("id_habitacion")));
        rHuesped.setHuesped(hueR.buscarPorId(rs.getInt("id_huesped")));
        rHuesped.setF_ingreso(rs.getDate("fechaIngreso").toLocalDate());
        rHuesped.setIngreso(rs.getBoolean("ingreso"));
        rHuesped.setF_salida(rs.getDate("fechaSalida").toLocalDate());
        rHuesped.setSalida(rs.getDate("salida").toLocalDate());
        rHuesped.setPrecio(rs.getDouble("precio"));
        rHuesped.setCant_personas(rs.getInt("cant_personas"));
        rHuesped.setEstado(rs.getBoolean("estado"));

        return rHuesped;

    }
}
