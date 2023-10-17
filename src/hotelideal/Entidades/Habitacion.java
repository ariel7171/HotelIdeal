/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal.Entidades;

/**
 *
 * @author Marcos
 */
public class Habitacion {

    private int id_habitacion, piso, nroHabitacion;
    private String descripcion;
    private boolean estado;
    private TipoHabitacion tipoHabitacion;

    public Habitacion() {
    }

    public Habitacion(int id_habitacion, int piso, int nroHabitacion, String descripcion, boolean estado, TipoHabitacion tipoHabitacion) {
        this.id_habitacion = id_habitacion;
        this.piso = piso;
        this.nroHabitacion = nroHabitacion;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipoHabitacion = tipoHabitacion;
    }

    public Habitacion(int piso, int nroHabitacion, String descripcion, boolean estado, TipoHabitacion tipoHabitacion) {
        this.piso = piso;
        this.nroHabitacion = nroHabitacion;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "id_habitacion=" + id_habitacion + ", piso=" + piso + ", nroHabitacion=" + nroHabitacion + ", descripcion=" + descripcion + ", estado=" + estado + ", tipoHabitacion=" + tipoHabitacion + '}';
    }

}
