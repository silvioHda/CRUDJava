package com.silvioIgnacio.jdbc;

import com.silvioIgnacio.pojos.Usuario;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;
    private static PreparedStatement ps;
    private static Usuario usuarioActual;

    public static Connection getConn() {
        return conn;
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

   
    public static Statement getStmt() {
        return stmt;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static PreparedStatement getPs() {
        return ps;
    }
    
    
    
    public static void conectar(String host, String usuario, 
            String password, String database) 
            throws ClassNotFoundException, 
            InstantiationException, IllegalAccessException, 
            SQLException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection("jdbc:mysql://"+
                host+"/"+database+"?user="+
                usuario+"&useSSL=false&password="+password);

    }
    
    public static void insertarUsuario(Usuario usuario) 
            throws SQLException{
        ps =conn.prepareStatement("INSERT INTO "
                + "usuario (nombre, apellidos, "
                + "password, fechaNacimiento)"
                + " Values (?,?,MD5(?),?)");
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getApellidos());
        ps.setString(3, usuario.getPassword());
        ps.setString(4, usuario.getFechaNacimiento());
        ps.executeUpdate();
    }
     
    public static Usuario login(String usuario,
            String password)throws SQLException{

String query="SELECT * FROM Usuario where idUsuario ='"
        +usuario+"' and password = (SELECT MD5('"
        +password+"'))";
      
        stmt= conn.createStatement();
        rs= stmt.executeQuery(query);
        while (rs.next()) {  //nombres de columnas
         System.out.println("Si hay usuario");
         Usuario temporalUsuario = new Usuario(rs.getInt(1),
          rs.getString(2),rs.getString(3),
           rs.getString(4),rs.getString(5),rs.getString(6));
            usuarioActual = temporalUsuario;
            
        }
    return usuarioActual;
    }
    
    public static Usuario buscarUsuario(String ID)throws
            SQLException{
    Usuario temporalUsuario = null;
    ps = conn.prepareStatement("SELECT * FROM "
            + "Usuario where idUsuario = ?");
    ps.setString(1, ID);
    rs = ps.executeQuery();
        while (rs.next()) {
      temporalUsuario = new Usuario(rs.getInt(1), 
              rs.getString(2),rs.getString(3),
              rs.getString(4),rs.getString(5),rs.getString(6));   
        }
        return temporalUsuario;
    }
    public static void borrarUsuario(String ID)throws SQLException{
    
        ps = conn.prepareStatement("delete from usuario "
                + "where idUsuario = ?");
        ps.setString(1, ID);
        ps.executeUpdate();
        
    }
    
    public static void ActualizarRegistro(String nombre,
            String apellidos, String ID)throws SQLException{   
        ps = conn.prepareStatement("Update usuario SET"
                + " nombre = ?, apellidos = ?"
                + " where idUsuario=?");
        ps.setString(1, nombre);
        ps.setString(2, apellidos);
        ps.setString(3, ID);
        ps.executeUpdate();
}
    public static void CambiarContraseña(String password,
            String newPassword) throws SQLException{
    
        ps = conn.prepareStatement("Update usuario SET "
                + "password = md5(?) where password ="
                + " md5(?)");
        ps.setString(1, newPassword);
        ps.setString(2, password);
        ps.executeUpdate();
    }
}