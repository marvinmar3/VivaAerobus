/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author marvin
 */
public class Vuelo implements MostrarDetalles{
    private int idVuelo;
    private String origen;
    private String destino;
    private String horaSalida;
    private String fechaSalida;
    private String duracionVuelo;
    private double precio;
    
    public Vuelo(int idVuelo, String origen, String destino, String horaSalida, String fechaSalida, String duracionVuelo, double precio)
    {
        this.idVuelo = idVuelo;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.fechaSalida = fechaSalida;
        this.duracionVuelo = duracionVuelo;
        this.precio = precio;
    }
    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDuracionVuelo() {
        return duracionVuelo;
    }

    public void setDuracionVuelo(String duracionVuelo) {
        this.duracionVuelo = duracionVuelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("ID Vuelo: "+ idVuelo);
        System.out.println("Origen: "+ origen);
        System.out.println("Destino: " + destino);
        System.out.println("Fecha de Salida: " + fechaSalida);
        System.out.println("Hora de Salida: " + horaSalida);
        System.out.println("Duración del Vuelo: " + duracionVuelo);
        System.out.println("Precio: " + precio);
        }
}

