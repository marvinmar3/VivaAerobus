
package Modelo;

public class Vuelo{
    private int idVuelo;
    private String origen;
    private String destino;
    private String fechaSalida;
    private String horaSalida;
    private String duracion;
    private double precio;

    public Vuelo(int idVuelo, String origen, String destino, String fechaSalida, String horaSalida, String duracion, double precio) {
        this.idVuelo = idVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.duracion = duracion;
        this.precio = precio;
    }

    public Vuelo(String origen, String destino, String fechaSalida, String horaSalida, double precio) {
    this.origen = origen;
    this.destino = destino;
    this.fechaSalida = fechaSalida;
    this.horaSalida = horaSalida;
    this.precio = precio;
    }


    public int getIdVuelo() {
        return idVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getDuracion() {
        return duracion;
    }

    public double getPrecio() {
        return precio;
    }
    
    

    
    
    
}
    