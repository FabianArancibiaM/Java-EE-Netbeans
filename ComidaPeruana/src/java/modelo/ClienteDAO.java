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
public class ClienteDAO {
    PreparedStatement ps;
    private static final String buscarTodo = "select cl.rut, cl.clave,cl.`nombre completo` as nombre,cl.direccion,c.nombre,cl.telefono from cliente cl inner join comuna c on cl.comuna_id = c.id "; 
    private static final String insertar = "insert into cliente (rut,clave,`nombre completo`,direccion,comuna_id,telefono) VALUES (?,?,?,?,?,?)";
    private static final String buscaExiste = "select * from cliente where clave = ? and rut = ?";
            
    private static final Conexion cnn = Conexion.getInstancia();
    public ArrayList<Cliente> buscarTodo(){
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            ps = cnn.getCnn().prepareStatement(buscarTodo);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Cliente b = new Cliente();
                b.setNombre(res.getString("nombre"));
                b.setComodin(res.getString("c.nombre"));
                b.setClave(res.getString("cl.clave"));
                b.setDireccion(res.getString("cl.direccion"));
                b.setRut(res.getString("cl.rut"));
                b.setTelefono(res.getInt("cl.telefono"));
                lista.add(b);
            }
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public boolean insertar(Cliente c){
        int res = 0;
        try {
            ps = cnn.getCnn().prepareStatement(insertar);
            ps.setString(1, c.getRut());
            ps.setString(2, c.getClave());
            ps.setString(3, c.getNombre());
            ps.setString(4, c.getDireccion());
            ps.setInt(5, c.getComuna());
            ps.setInt(6, c.getTelefono());
            res = ps.executeUpdate();
            if (res>0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    public boolean existe(String clave,String rut){
        //int res = 0;
        try {
            ps = cnn.getCnn().prepareStatement(buscaExiste);
            ps.setString(1, clave);
            ps.setString(2, rut);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
