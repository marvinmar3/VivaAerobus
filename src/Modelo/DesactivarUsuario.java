
package Modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DesactivarUsuario extends UsuarioAccion{
    private int id;
    
    public DesactivarUsuario(int id)
    {
        super();
        this.id=id;
    }
    
    @Override
    public void ejecutar()
    {
        String sql = "delete from Usuarios where id_usuario = ?";
        try(PreparedStatement stmt = con.prepareStatement(sql))
        {
            stmt.setInt(1, id);
            
            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0)
            {
                System.out.println("Usuario desactivado con éxito.");
            }
        }catch(SQLException e)
        {
            System.out.println("Error al desactivar usuario." + e.getMessage());
        }
    }
}
