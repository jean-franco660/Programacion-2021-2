package implementacion;

import conexion.ConexionDBQ;
import entidades.Producto;
import generator.generator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Fray
 */
public class implProducto {
        ConexionDBQ cx= new ConexionDBQ();
    
    ArrayList<Producto> listaProductos= new ArrayList<>();
    String sql="";
    String query="";
    Statement stmt= null;
    ResultSet rset=null;    
    public int  registrarProducto(Producto p){
        int i=0;
        generator gn= new generator();
        String idproducto="P"+gn.generadorId();
        try {
            query=" insert into producto (producto_id, producto_nombre, producto_tipo, producto_marca, producto_precio, producto_stock) "+
                  " values('"+idproducto+"', '"+p.getProducto_nombre()+"', '"+p.getProducto_tipo()+"', '"+p.getProducto_marca()+"', '"+p.getProducto_precio()+"','"+p.getProducto_stock()+"') ";
            
            System.out.println("consulta:::::::"+query);
            stmt= cx.conectaMysql().createStatement();
            i   = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage()); 
        }        
        
        return i;
    }
    
        
    public ArrayList<Producto> reporteProducto(Producto p){   
        try {
            sql=" select * from producto where producto_tipo='"+p.getProducto_tipo()+"'";
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            listaProductos.clear();
            while(rset.next()){
                Producto ps = new Producto();
                ps.setProducto_id(rset.getString(1));
                ps.setProducto_nombre(rset.getString(2));
                ps.setProducto_tipo(rset.getString(3));
                ps.setProducto_marca(rset.getString(4));
                ps.setProducto_precio(rset.getDouble(5));
                ps.setProducto_stock(rset.getInt(6));                
                listaProductos.add(ps);            
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return listaProductos; 
    }
    public int actualizarRegistroProducto(Producto p){
        
        int i=0;
        try {
            sql="UPDATE  producto"+
                " SET producto_nombre='"+p.getProducto_nombre()+"', producto_tipo='"+p.getProducto_tipo()+"', producto_marca='"+p.getProducto_marca()+"', producto_precio='"+p.getProducto_precio()+"', producto_stock='"+p.getProducto_stock()+"' "+
                "where producto_id='"+p.getProducto_id()+"'";   
            
            stmt=cx.conectaMysql().createStatement();
            i=stmt.executeUpdate(sql);
            System.out.println(sql);
            
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return i;
        
    }
    
     public int eliminarRegistroProducto(Producto p){
        
        int i=0;
        try {
            sql="DELETE FROM producto WHERE producto_id='"+p.getProducto_id()+"'";
            stmt=cx.conectaMysql().createStatement();
            i=stmt.executeUpdate(sql);
            System.out.println("Se elimino el registro");
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return i;
    }
    
    public int reporteProductoUnico(Producto p){
        int i=0;
        try {
            sql=" select * from producto where producto_nombre='"+p.getProducto_nombre()+"' ";
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            if(rset.next()){
                
                p.setProducto_id(rset.getString(1));
                p.setProducto_nombre(rset.getString(2));
                p.setProducto_tipo(rset.getString(3));
                p.setProducto_marca(rset.getString(4));
                p.setProducto_precio(rset.getDouble(5)); 
                p.setProducto_stock(rset.getInt(6));   
               
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return i;  
    }  
}
