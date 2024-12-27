/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author marvin
 */
public class Reservaciones {
    private int idReservacion;
    private int idUsuario;
    private int idVuelo;
    private String fechaReservacion;
    private String estado;

    public Reservaciones(int idReservacion, int idUsuario, int idVuelo, String fechaReservacion, String estado) {
        this.idReservacion = idReservacion;
        this.idUsuario = idUsuario;
        this.idVuelo = idVuelo;
        this.fechaReservacion = fechaReservacion;
        this.estado = estado;
    }

    public int getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(String fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}

