
package Modelo;

/**
 *
 * @author marvin
 */
public class Reservaciones {
    private int idReservacion;
    private String estado;
    private String nombreUsuario;
    private String emailUsuario;
    private String origenVuelo;
    private String destinoVuelo;
    private String fechaVuelo;
    

    public Reservaciones(int idReservacion, String estado, String nombreUsuario,  String emailUsuario, String origenVuelo, String destinoVuelo, String fechaVuelo) {
        this.idReservacion = idReservacion;
        this.estado = estado;
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
        this.origenVuelo = origenVuelo;
        this.destinoVuelo = destinoVuelo;
        this.fechaVuelo = fechaVuelo;
        
    }

    public int getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getOrigenVuelo() {
        return origenVuelo;
    }

    public void setOrigenVuelo(String origenVuelo) {
        this.origenVuelo = origenVuelo;
    }

    public String getDestinoVuelo() {
        return destinoVuelo;
    }

    public void setDestinoVuelo(String destinoVuelo) {
        this.destinoVuelo = destinoVuelo;
    }

    public String getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    
    
    
}

