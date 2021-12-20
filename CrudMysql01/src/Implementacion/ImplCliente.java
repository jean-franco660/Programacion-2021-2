
package Implementacion;

import conexion.ConexionDB;
import Entidades.Cliente;
import Entidades.Persona;
import conexion.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplCliente {
    
    ConexionDB cx= new ConexionDB();
    ArrayList<Cliente> listaClientes= new ArrayList<>();
    String sql="";
    String query="";
    Statement stmt= null;
    ResultSet rset=null;
    ImplPersona ip= new ImplPersona();
    Persona ps = new Persona();
    
    public int  registrarCliente(Cliente c, String scodigo){
        ps=null;
        int i=0;
        ps=ip.reportePersonaUnico(scodigo, "");
        if(ps!=null){
        
            //codigo registre cliente
            try {
            query=" insert into cliente (cliente_id,tipo, cliente_persona_id) "+
                  " values('"+c.getCliente_id()+"','"+c.getCliente_tipo()+"','"+ps.getId()+"') ";            
            stmt= cx.conectaMysql().createStatement();
            i   = stmt.executeUpdate(query);
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }else{       
            
//codigo registrar cliente y persona    
            
            
        }
           
        return i;
    }
    
}
