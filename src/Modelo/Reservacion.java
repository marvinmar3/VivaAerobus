
package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reservacion extends FiltrosBase<Reservaciones>{
   
    public List<Reservaciones> ejecutarConsola()
    {
        List<Reservaciones> reservaciones = new ArrayList<>();
        String sql = """
                     select Reservaciones.id_reservacion as ID_Reservacion, Reservaciones.estado as Estado, Usuarios.nombre as Nombre, 
                     Usuarios.apellido as Apellido, Usuarios.email as Correo, Vuelos.origen as Origen, Vuelos.destino as Destino,
                     Vuelos.fechaSalida as Fecha_Vuelo
                     from Reservaciones
                     join Usuarios
                     on Reservaciones.r_usuario=Usuarios.id_usuario 
                     join Vuelos
                     on Reservaciones.r_vuelo = Vuelos.id_vuelo""";
        sql= construirConsultaBase(sql);
        
        try (Connection con = Conexion.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) 
        {
        
            for (int i = 0; i < parametros.size(); i++) {
                ps.setObject(i + 1, parametros.get(i));
            }

            try (ResultSet rs = ps.executeQuery()) 
            {
                while (rs.next()) {
                    reservaciones.add(new Reservaciones(
                        rs.getInt("ID_Reservacion"),
                        rs.getString("Estado"),
                        rs.getString("Nombre") + " " + rs.getString("Apellido"),
                        rs.getString("Correo"),
                        rs.getString("Origen"),
                        rs.getString("Destino"),
                        rs.getString("Fecha_Vuelo")
                    ));
                }
            }
        } catch (SQLException e) 
        {
            System.out.println("Error al obtener las reservaciones:  " + e.getMessage());
        }
        
        return reservaciones;  
    }

    @Override
    public List<Reservaciones> ejecutarConsulta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
