/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal.Entidades;

import java.time.LocalDate;

/**
 *
 * @author Marcos
 */
public class Reserva {

    private int idReserva, cant_personas;
    private double precio;
    private boolean estado,ingreso;
    private Habitacion habitacion;
    private Huesped huesped;
    private LocalDate f_ingreso, f_salida,salida;

    public Reserva() {
    }

    public Reserva(int cant_personas, double precio, boolean estado, boolean ingreso, Habitacion habitacion, Huesped huesped, LocalDate f_ingreso, LocalDate f_salida, LocalDate salida) {
        this.cant_personas = cant_personas;
        this.precio = precio;
        this.estado = estado;
        this.ingreso = ingreso;
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.f_ingreso = f_ingreso;
        this.f_salida = f_salida;
        this.salida = salida;
    }

    public Reserva(int idReserva, int cant_personas, double precio, boolean estado, boolean ingreso, Habitacion habitacion, Huesped huesped, LocalDate f_ingreso, LocalDate f_salida, LocalDate salida) {
        this.idReserva = idReserva;
        this.cant_personas = cant_personas;
        this.precio = precio;
        this.estado = estado;
        this.ingreso = ingreso;
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.f_ingreso = f_ingreso;
        this.f_salida = f_salida;
        this.salida = salida;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getCant_personas() {
        return cant_personas;
    }

    public void setCant_personas(int cant_personas) {
        this.cant_personas = cant_personas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isIngreso() {
        return ingreso;
    }

    public void setIngreso(boolean ingreso) {
        this.ingreso = ingreso;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public LocalDate getF_ingreso() {
        return f_ingreso;
    }

    public void setF_ingreso(LocalDate f_ingreso) {
        this.f_ingreso = f_ingreso;
    }

    public LocalDate getF_salida() {
        return f_salida;
    }

    public void setF_salida(LocalDate f_salida) {
        this.f_salida = f_salida;
    }

    public LocalDate getSalida() {
        return salida;
    }

    public void setSalida(LocalDate salida) {
        this.salida = salida;
    }

    
   
}
