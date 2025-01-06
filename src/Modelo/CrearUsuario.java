/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearUsuario extends UsuarioAccion{
    private final String nombre;
    private final String apellido;
    private final String email;
    private final String contraseña;
    private final String tipoUsuario;
    
    public CrearUsuario(String nombre, String apellido, String email, String contraseña, String tipoUsuario)
    {
        super();
        this.nombre = nombre;
        this.apellido= apellido;
        this.email = email;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }
    
    @Override
    public void ejecutar()
    {
        String sql = "insert into Usuarios (nombre, apellido, email, contraseña, tipoUsuario) values(?,?,?,?,?)";
        try(PreparedStatement stmt = con.prepareStatement(sql))
        {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, email);
            stmt.setString(4, contraseña);
            stmt.setString(5, tipoUsuario);
            
            int rowsAffected= stmt.executeUpdate();
            if(rowsAffected > 0)
            {
                System.out.println("Usuario creado con éxito.");
            }
        }catch(SQLException e)
        {
            System.out.println("Error al crear usuario: " + e.getMessage());
        }
    }
}
