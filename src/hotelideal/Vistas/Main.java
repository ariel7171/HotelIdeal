/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal.Vistas;

import hotelideal.AccesoADatos.HuespedData;
import hotelideal.Entidades.Huesped;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Melina
 */
public class Main {

    public static void main(String[] args) {
        try {
       
            HuespedData huespedData = new HuespedData();

            // buscarTodos
            List<Huesped> todosLosHuespedes = huespedData.buscarTodos();
            for (Huesped huesped : todosLosHuespedes) {
                System.out.println(huesped);
            }

            //buscarPorId
            int idABuscar = 1; 
            Huesped huespedPorId = huespedData.buscarPorId(idABuscar);
            if (huespedPorId != null) {
                System.out.println("Huesped encontrado por ID: " + huespedPorId);
            } else {
                System.out.println("Huesped no encontrado por ID.");
            }

            //buscarPorDNI
            String dniABuscar = "32456456";
            Huesped huespedPorDNI = huespedData.buscarPorDNI(dniABuscar);
            if (huespedPorDNI != null) {
                System.out.println("Huesped encontrado por DNI: " + huespedPorDNI);
            } else {
                System.out.println("Huesped no encontrado por DNI.");
            }

            //guardar
            Huesped nuevoHuesped = new Huesped("María", "Gómez", "Avenida 456", "maria@gmail.com", "117654321", "38765432", true);
            Huesped huespedGuardado = huespedData.guardar(nuevoHuesped);
            if (huespedGuardado != null) {
                System.out.println("Huesped guardado con éxito. ID: " + huespedGuardado.getId_huesped());
            } else {
                System.out.println("Error al guardar el huesped.");
            }
            
            //modificar
            huespedGuardado.setDomicilio("Avenida 444");
            huespedGuardado = huespedData.guardar(huespedGuardado);
            if (huespedGuardado != null) {
                System.out.println("Huesped modificado con éxito. ID: " + huespedGuardado.getId_huesped());
            } else {
                System.out.println("Error al modificar el huesped.");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
