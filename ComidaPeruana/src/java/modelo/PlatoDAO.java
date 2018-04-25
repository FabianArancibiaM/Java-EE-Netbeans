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
public class PlatoDAO {
    PreparedStatement ps;
    private static final String buscarTodo = "select * from plato "; 
    private static final String buscaExiste = "select precio from plato where nombre = ? "; 
    private static final Conexion cnn = Conexion.getInstancia();
    public ArrayList<Plato> buscarTodo(){
        ArrayList<Plato> lista = new ArrayList<>();
        try {
            ps = cnn.getCnn().prepareStatement(buscarTodo);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Plato b = new Plato();
                b.setNombre(res.getString("nombre"));
                b.setPrecio(res.getInt("precio"));
                lista.add(b);
            }
        } catch (Exception ex) {
            Logger.getLogger(BebidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public int existe(String nombre){
        int valor = 0;
        try {
            ps = cnn.getCnn().prepareStatement(buscaExiste);
            ps.setString(1, nombre);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                valor = res.getInt("precio");
            }
        } catch (Exception e) {
            valor = 0;
        }
        return valor;
    }
}
