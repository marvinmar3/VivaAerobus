
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VueloDAO {
    public Vuelo buscarVueloPorID(int idVuelo) {
        Vuelo vuelo = null;
        String sql = "SELECT origen, destino, fechaSalida, horaSalida, precio FROM vuelos WHERE id_vuelo = ?";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setInt(1, idVuelo);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                vuelo = new Vuelo(
                    rs.getString("origen"),
                    rs.getString("destino"),
                    rs.getString("fechaSalida"),
                    rs.getString("horaSalida"),
                    rs.getDouble("precio")
                );
            }
            
        } catch (SQLException e) {
            System.out.println("Error al buscar el vuelo: " + e.getMessage());
        }
        
        return vuelo;
    }
}
