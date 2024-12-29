
package Modelo;

public class Vuelo{
    private String origen;
    private String destino;
    private String fechaSalida;
    private String horaSalida;
    private double precio;
    
    public Vuelo(String origen, String destino, String fechaSalida, String horaSalida, double precio) {
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.precio = precio;
    }

    // Getters
    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }
    public String getFechaSalida() { return fechaSalida; }
    public String getHoraSalida() { return horaSalida; }
    public double getPrecio() { return precio; }
}

