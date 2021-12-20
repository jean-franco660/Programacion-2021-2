package implementacion;

import conexion.ConexionDBQ;
import entidades.Usuario;
import generator.generator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class implUsuario {
   ConexionDBQ cx= new ConexionDBQ();
    
    ArrayList<Usuario> listaPersonas= new ArrayList<>();
    String sql="";
    String query="";
    Statement stmt= null;
    ResultSet rset=null;      
    
      public int  registrarUsuario(Usuario u){
        int i=0;
        generator gn= new generator();
        String idusuario=gn.generadorId();
        try {
            query=" insert into usuario(usuario_id, usuario_nombre, usuario_apellido, usuario_sexo, usuario_edad, usuario_categoria, usuario_nombreusuario, usuario_pasword) "+
                  " values('"+idusuario+"', '"+u.getNombre()+"', '"+u.getApellido()+"', '"+u.getSexo()+"', '"+u.getEdad()+"', '"+u.getCategoria()+"', '"+u.getNombreUsuario()+"', '"+u.getPasword()+"') ";
            
            System.out.println("consulta:::::::"+query);
            stmt= cx.conectaMysql().createStatement();
            i   = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage()); 
        }                
        return i;
    }
      
    public Usuario LoginReportePersonaUnico(String slogin, String spassword){
        Usuario u = new Usuario();        
        try {
            sql=" select * from usuario where usuario_nombreusuario='"+slogin+"' and  usuario_pasword='"+spassword+"' ";
            System.out.println("consulta:"+sql);
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            u.setAcceso(false);
            if(rset.next()){
                System.out.println("dentro del ifff de la consulta:");     
                u.setNombre(rset.getString(2));  
                u.setCategoria(rset.getString(6));      
                u.setNombreUsuario(rset.getString(7));
                u.setPasword(rset.getString(8));
                u.setAcceso(true);
            }
        } catch (SQLException ex) {
                ex.getMessage();
                System.out.println("errrorrrrr:"+ex.getMessage());
        }
        return u;
    }
    
    
}
