
package Modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marvin
 */
public class VuelosDAO {
    public List<Vuelo> buscarVuelos(String origen, String destino, String fecha) {
        List<Vuelo> vuelos = new ArrayList<>();
        StringBuilder sql = new StringBuilder("""
                SELECT id_vuelo, origen, destino, fechaSalida, horaSalida, duracion, precio
                FROM Vuelos
                WHERE 1=1
                """);

        // Agregar condiciones dinámicas
        if (origen != null && !origen.isEmpty()) {
            sql.append(" AND origen LIKE ?");
        }
        if (destino != null && !destino.isEmpty()) {
            sql.append(" AND destino LIKE ?");
        }
        if (fecha != null && !fecha.isEmpty()) {
            sql.append(" AND fechaSalida = ?");
        }

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql.toString())) {

            int index = 1;
            if (origen != null && !origen.isEmpty()) {
                ps.setString(index++, "%" + origen + "%");
            }
            if (destino != null && !destino.isEmpty()) {
                ps.setString(index++, "%" + destino + "%");
            }
            if (fecha != null && !fecha.isEmpty()) {
                ps.setString(index++, fecha);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    vuelos.add(new Vuelo(
                            rs.getInt("id_vuelo"),
                            rs.getString("origen"),
                            rs.getString("destino"),
                            rs.getString("fechaSalida"),
                            rs.getString("horaSalida"),
                            rs.getString("duracion"),
                            rs.getDouble("precio")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar vuelos: " + e.getMessage());
        }

        return vuelos;
    }
}
