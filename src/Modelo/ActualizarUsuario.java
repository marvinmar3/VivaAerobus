
package Modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarUsuario extends UsuarioAccion{
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private String tipoUsuario;
    
    public ActualizarUsuario(int id, String nombre, String apellido, String email, String contraseña, String tipoUsuario)
    {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email= email;
        this.contraseña = contraseña;
        this.tipoUsuario= tipoUsuario;
    }
    
    @Override
    public void ejecutar()
    {
        String sql= "update Usuarios set nombre= ?, apellido = ?,email = ?, contraseña=?, tipoUsuario = ? where id_usuario = ? ";
        try(PreparedStatement stmt = con.prepareStatement(sql))
        {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, email);
            stmt.setString(4, contraseña);
            stmt.setString(5, tipoUsuario);
            stmt.setInt(6, id);
            
            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0)
            {
                System.out.println("Usuario actualizado con éxito");
            }
        }catch(SQLException e)
        {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }
    
}
