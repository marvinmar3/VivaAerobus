
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
        String sql="select * from Usuarios where email= ? and contraseña= ? and tipoUsuario = 'administrador' ";
        
        //Conexion cn = new Conexion();
        
        try
        {
            con= Conexion.getConnection();
            if(con==null)
            {
                System.out.println("Error, no se pudo establecer la conexión.");
                return l;
            }
            
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            
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
        }finally
        {
            try
            {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            }catch(SQLException ex)
            {
                System.out.println("Error al cerrar conexiones: " + ex.getMessage());
            }
        }
        
        return l;
    }
    
}
