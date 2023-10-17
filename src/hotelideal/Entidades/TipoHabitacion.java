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
public class TipoHabitacion {

    private int id_tipoDeHabitacion, cantSimple, cantQueen, cantKing, cantPersonas;
    private String descripcion;
    private double precioNoche;
    private boolean estado;

    public TipoHabitacion() {
    }

    public TipoHabitacion(int id_tipoDeHabitacion, int cantSimple, int cantQueen, int cantKing, int cantPersonas, String descripcion, double precioNoche, boolean estado) {
        this.id_tipoDeHabitacion = id_tipoDeHabitacion;
        this.cantSimple = cantSimple;
        this.cantQueen = cantQueen;
        this.cantKing = cantKing;
        this.cantPersonas = cantPersonas;
        this.descripcion = descripcion;
        this.precioNoche = precioNoche;
        this.estado = estado;
    }

    public TipoHabitacion(int cantSimple, int cantQueen, int cantKing, int cantPersonas, String descripcion, double precioNoche, boolean estado) {
        this.cantSimple = cantSimple;
        this.cantQueen = cantQueen;
        this.cantKing = cantKing;
        this.cantPersonas = cantPersonas;
        this.descripcion = descripcion;
        this.precioNoche = precioNoche;
        this.estado = estado;
    }

    public int getId_tipoDeHabitacion() {
        return id_tipoDeHabitacion;
    }

    public void setId_tipoDeHabitacion(int id_tipoDeHabitacion) {
        this.id_tipoDeHabitacion = id_tipoDeHabitacion;
    }

    public int getCantSimple() {
        return cantSimple;
    }

    public void setCantSimple(int cantSimple) {
        this.cantSimple = cantSimple;
    }

    public int getCantQueen() {
        return cantQueen;
    }

    public void setCantQueen(int cantQueen) {
        this.cantQueen = cantQueen;
    }

    public int getCantKing() {
        return cantKing;
    }

    public void setCantKing(int cantKing) {
        this.cantKing = cantKing;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
