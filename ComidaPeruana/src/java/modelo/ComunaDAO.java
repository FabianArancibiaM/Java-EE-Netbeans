/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabian
 */
public class ComunaDAO {
    PreparedStatement ps;
    private static final String buscarTodo = "select * from comuna "; 
    private static final Conexion cnn = Conexion.getInstancia();
    public ArrayList<Comuna> buscarTodo(){
        ArrayList<Comuna> lista = new ArrayList<>();
        try {
            ps = cnn.getCnn().prepareStatement(buscarTodo);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Comuna b = new Comuna();
                b.setNombre(res.getString("nombre"));
                b.setId(res.getInt("id"));
                lista.add(b);
            }
        } catch (Exception ex) {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
