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

/**
 *
 * @author marvin
 */
public class ConexionDAO extends Conexion{
    
    public ArrayList<String[]> buscarVuelos(String origen, String destino, String fecha) throws SQLException
    {
        ArrayList<String[]> vuelos= new ArrayList<>();
        String sql = "select * from vuelos where origen = ? and destino = ? and fecha = ?";
        
        try(Connection conn = getConnection();
        PreparedStatement stmt= conn.prepareStatement(sql))
        {
            stmt.setString(1, origen);
            stmt.setString(2, destino);
            stmt.setString(3, fecha);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                String[] vuelo = {
                    rs.getString("id_vuelo"),
                    rs.getString("origen"),
                    rs.getString("destino"),
                    rs.getString("fecha"),
                    rs.getString("precio")
                };
                vuelos.add(vuelo);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return vuelos;
    }
    
}
