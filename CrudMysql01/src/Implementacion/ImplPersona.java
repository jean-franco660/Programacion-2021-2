package Implementacion;

import Entidades.Persona;
import conexion.ConexionDB;
import java.sql.*;
import java.util.ArrayList;



public class ImplPersona {
    
    ConexionDB cx = new ConexionDB();
    ArrayList<Persona> listaPersona = new ArrayList<>();
    String sql = "";
    Statement stmt = null;
    ResultSet rset = null;

    
    public int registrarPersona(Persona p){
        int i=0;
          
        try {
            sql = "insert into persona (persona_nombre,persona_ap_paterno,persona_ap_materno, persona_codigo, persona_sexo, persona_usuario, persona_password) \n" +
                  "values('"+p.getNombre()+"','"+p.getAp_paterno()+"','"+p.getAp_materno()+"','"+p.getCodigo()+"','"+p.getSexo()+"','"+p.getUsuario()+"','"+p.getPassword()+"') ";
                    
            stmt = cx.conectaMysql().createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return i;
        
    }
    
    public ArrayList<Persona> reportePersonas(){
        ArrayList<Persona> listaPersonas = null;
        
        try {
            sql=" select * from persona ";
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            while(rset.next()){
                Persona ps = new Persona();
                ps.setId(rset.getString("persona_id"));
                ps.setNombre(rset.getString(2));
                ps.setAp_paterno(rset.getString(3));
                ps.setAp_materno(rset.getString(4));
                ps.setCodigo(rset.getString(5));
                listaPersonas.add(ps);            
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return listaPersonas;
        
    }
     public int eliminarRegistroPersona(String sid){
        
        int i=0;
        try {
            sql=" delete from persona where persona_id='"+sid+"' ";
            stmt=cx.conectaMysql().createStatement();
            i=stmt.executeUpdate(sql);
            System.out.println("Se elimino el registro");
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return i;
    }
    
    public int actualizarRegistroPersona(Persona p){
        
        int i=0;
        try {
            sql=" update  persona " +
                " set persona_nombre='"+p.getNombre()+"', persona_ap_paterno='"+p.getAp_paterno()+"', persona_ap_materno='"+p.getAp_materno()+"', persona_codigo='"+p.getCodigo()+"' " +
                " where persona_id  ='"+p.getId()+"' ";
            stmt=cx.conectaMysql().createStatement();
            i=stmt.executeUpdate(sql);
            
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return i;
        
    }
    
    public Persona reportePersonaUnico(String Scodigo, String a){
        Persona ps = new Persona();
        try {
            sql=" select * from persona where persona_Codigo='"+Scodigo+"' ";
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            if(rset.next()){
                
                ps.setId(rset.getString("persona_id"));
                ps.setNombre(rset.getString(2));
                ps.setAp_paterno(rset.getString(3));
                ps.setAp_materno(rset.getString(4));
                ps.setCodigo(rset.getString(5));                
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return ps;
    }
    
    public Persona LoginreportePersonaUnico(String Slogin, String Spassword){
           Persona ps = new Persona();
           ps = null;
        try {
            sql=" select * from persona where persona_usuario='"+Slogin+"' and persona_password='"+Spassword+"' ";
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            if(rset.next()){
                
                ps.setId(rset.getString("persona_id"));
                ps.setNombre(rset.getString(2));
                ps.setAp_paterno(rset.getString(3));
                ps.setAp_materno(rset.getString(4));
                ps.setCodigo(rset.getString(5));
                ps.setUsuario(rset.getString("persona_usuario"));
                ps.setPassword(rset.getString("persona_password"));

                
                
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return ps;
    }
    
}
