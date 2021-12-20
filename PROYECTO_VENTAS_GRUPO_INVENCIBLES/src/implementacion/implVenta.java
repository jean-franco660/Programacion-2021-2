package implementacion;

import java.sql.Connection;
//import com.sun.jdi.connect.spi.Connection;
import conexion.ConexionDBQ;
import entidades.Producto;
import generator.generator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Fray
 */
public class implVenta {
    
       public Connection con;
       ConexionDBQ cx= new ConexionDBQ();
       PreparedStatement ps;
       ResultSet rs;
       
       int r;
    
    ArrayList<Producto> listaProductos= new ArrayList<>();
    String sql="";
    String query="";
    Statement stmt= null;
    ResultSet rset=null;    
   
    public int RegistrarDetalleVenta(Producto p){
       String sql = "INSERT INTO registroventa (venta_producto, venta_producto_tipo, venta_precio_unid, venta_cantidad_vendida, venta_igv_total, venta_monto_total) "+
                    "VALUES (?,?,?,?,?,?)";
               
        try {
            con=cx.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getProducto_nombre());
            ps.setString(2, p.getProducto_tipo());
            ps.setDouble(3, p.getProducto_precio());
            ps.setInt(4, p.getVenta_cantidad_vendida());
            ps.setDouble(5, p.getVenta_igv_total());
            ps.setDouble(5, p.getVenta_monto_total());
         
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    
    public int  registrarVenta(Producto p){
        int i=0;
    
        try {
            query=" insert into registroventa (venta_producto, venta_producto_tipo, venta_precio_unid, venta_cantidad_vendida, venta_igv_total, venta_monto_total) "+
                  " values('"+p.getProducto_nombre()+"', '"+p.getProducto_tipo()+"', '"+p.getProducto_precio()+"', '"+p.getVenta_cantidad_vendida()+"', '"+p.getVenta_igv_total()+"','"+p.getVenta_monto_total()+"') ";
            
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
    public int actualizarStock(Producto p){
        
        int i=0;
        try {
            sql="UPDATE  producto"+
                " SET producto_stock='"+p.getProducto_stock()+"' "+
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
