
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    Connection con; 
    
    PreparedStatement ps;
    ResultSet rs;
    
    
    //Conexion cn= Conexion.getInstance();
    
    public login log(String email, String contraseña)
    {
        login l= new login();
        String sql="select * from Usuarios where email= ? and contraseña= ?";
        
        Conexion cn = new Conexion();
        
        try
        {
            con= cn.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, contraseña);
            rs=ps.executeQuery();
            
            if(rs.next())
            {
                l.setId(rs.getInt("id_usuario"));
                l.setNombre(rs.getString("nombre"));
                l.setApellido(rs.getString("apellido"));
                l.setEmail(rs.getString("email"));
                l.setContraseña(rs.getString("contraseña"));
                
            }
        }catch(SQLException e)
        {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        }
        /*finally
        {
            conexion.closeConnection();
        }*/
        
        return l;
    }
    
}
