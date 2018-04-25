/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabian
 */
public class Conexion {
    public static Conexion instancia;
    private Connection cnn;
    
    private Conexion()
    {
        String drive = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bd_restaurante";
        String usu = "root";
        String pass = "";
        
        try {
            Class.forName(drive);
            cnn = DriverManager.getConnection(url, usu, pass);
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public static Conexion getInstancia()
    {
        if (instancia==null) {
            instancia = new Conexion();
        }
        return instancia;
    }
    public Connection getCnn(){
        return cnn;
    }
}
