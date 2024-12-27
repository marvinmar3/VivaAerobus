/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConexionDAO {
    
    public ArrayList<String[]> buscarVuelos(String origen, String destino, String fecha) {
    ArrayList<String[]> vuelos = new ArrayList<>();
    StringBuilder sql = new StringBuilder("SELECT id_vuelo, origen, destino, fechaSalida, horaSalida, duracionVuelo, precio FROM vuelos WHERE 1=1");
    
    // Agregar filtros solo si los valores no son nulos o vacíos
    if (origen != null && !origen.isEmpty()) {
        sql.append(" AND origen = ?");
    }
    if (destino != null && !destino.isEmpty()) {
        sql.append(" AND destino = ?");
    }
    if (fecha != null && !fecha.isEmpty()) {
        sql.append(" AND fechaSalida = ?");
    }

    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql.toString())) {

        int paramIndex = 1;
        if (origen != null && !origen.isEmpty()) {
            ps.setString(paramIndex++, origen);
        }
        if (destino != null && !destino.isEmpty()) {
            ps.setString(paramIndex++, destino);
        }
        if (fecha != null && !fecha.isEmpty()) {
            ps.setString(paramIndex++, fecha);
        }

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String[] vuelo = {
                rs.getString("id_vuelo"),
                rs.getString("origen"),
                rs.getString("destino"),
                rs.getString("fechaSalida"),
                rs.getString("horaSalida"),
                rs.getString("duracionVuelo"),
                rs.getString("precio")
            };
            vuelos.add(vuelo);
        }
    } catch (SQLException e) {
        System.out.println("Error al buscar vuelos: " + e.getMessage());
    }
    return vuelos;
}

    
}
