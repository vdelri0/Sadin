/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase permite la conexion a la base de datos.
 * @author Victor Del Rio Prens
 */
public class Conexion {
    private final String conexionFallida = "Existen problemas para conectar a la base de datos";
    private final String conexionExitosa = "Conexión a la base de datos test OK";
    private final String url = "jdbc:postgresql://localhost:5432/test";
    private final String usuario = "postgres";
    private final String contrasena = "root";
    private final String driver = "org.postgresql.Driver";
    private Connection conexion;
    
    public void conectar() {
      try{
         //obtenemos el driver de para postgre
         Class.forName(driver);
         //obtenemos la conexión
         conexion = DriverManager.getConnection(url,usuario,contrasena);
 
         if (conexion != null){
            System.out.println(conexionExitosa);
         } else {
            System.out.println(conexionFallida); 
         }
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
   }
    
    public void desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConexion() {
        return conexion;
    }
}
