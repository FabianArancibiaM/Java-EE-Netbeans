/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabian
 */
public class PedidoDAO {
    PreparedStatement ps;
    private static final String buscarTodo = "select * from pedido "; 
    private static final String insertar = "insert into pedido (rut_cliente,plato,bebida,despacho,total,fecha) VALUES (?,?,?,?,?,?)";
    private static final String actualizar = "update pedido set rut_cliente = ?, plato=?,bebida= ?, despacho=?,total=?,fecha= ? WHERE id_pedido = ?";
    private static final String eliminar = "delete from pedido where id_pedido= ?";
    private static final String buscarPedidos = "select * from pedido where rut_cliente = ? and fecha = ? "; 
    private static final String buscarHistorial = "select * from pedido where rut_cliente = ? "; 
    private static final String buscarPedidoPorID = "select * from pedido where id_pedido = ? "; 
    private static final String buscaExiste = "select sum(total) as total from pedido where rut_cliente = ? and fecha = ? GROUP BY rut_cliente"; 
    private static final Conexion cnn = Conexion.getInstancia();
    public ArrayList<Pedido> buscarTodo(){
        ArrayList<Pedido> lista = new ArrayList<>();
        try {
            ps = cnn.getCnn().prepareStatement(buscarTodo);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Pedido b = new Pedido();
                b.setBebida(res.getString("bebida"));
                b.setDespacho(res.getBoolean("despacho"));
                b.setFecha(res.getString("fecha"));
                b.setPlato(res.getString("plato"));
                b.setRut_cliente(res.getString("rut_cliente"));
                b.setTotal(res.getInt("total"));
                lista.add(b);
            }
        } catch (Exception ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public boolean insertar(Pedido p){
        int res = 0;
        try {
            ps = cnn.getCnn().prepareStatement(insertar);
            ps.setString(1, p.getRut_cliente());
            ps.setString(2, p.getPlato());
            ps.setString(3, p.getBebida());
            ps.setBoolean(4, p.isDespacho());            
            ps.setInt(5, p.getTotal());
            ps.setDate(6,Date.valueOf(p.getFecha()));
            res = ps.executeUpdate();
            if (res>0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    public boolean modificar(Pedido p){
        int res = 0;
        try {
            ps = cnn.getCnn().prepareStatement(actualizar);
            ps.setString(1, p.getRut_cliente());
            ps.setString(2, p.getPlato());
            ps.setString(3, p.getBebida());
            ps.setBoolean(4, p.isDespacho());            
            ps.setInt(5, p.getTotal());
            ps.setDate(6,Date.valueOf(p.getFecha()));
            ps.setInt(7, p.getId_pedido());
            res = ps.executeUpdate();
            if (res>0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    public boolean eliminarPedido(int id){
        int res = 0;
        try {
            ps = cnn.getCnn().prepareStatement(eliminar);
            ps.setInt(1, id);
            res = ps.executeUpdate();
            if (res>0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    public ArrayList<Pedido> buscarPedidosDelCliente(String rut_cliente,String fecha){
        ArrayList<Pedido> lista = new ArrayList<>();
        try {
            ps = cnn.getCnn().prepareStatement(buscarPedidos);
            ps.setString(1, rut_cliente);
            ps.setString(2, fecha);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Pedido b = new Pedido();
                b.setId_pedido(res.getInt("id_pedido"));
                b.setBebida(res.getString("bebida"));
                b.setDespacho(res.getBoolean("despacho"));
                b.setFecha(res.getString("fecha"));
                b.setPlato(res.getString("plato"));
                b.setRut_cliente(res.getString("rut_cliente"));
                b.setTotal(res.getInt("total"));
                lista.add(b);
            }
        } catch (Exception ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public int existe(String rut,String fecha){
        int valor = 0;
        try {
            ps = cnn.getCnn().prepareStatement(buscaExiste);
            ps.setString(1, rut);
            ps.setString(2, fecha);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                valor = res.getInt("total");
            }
        } catch (Exception e) {
            valor = 0;
        }
        return valor;
    }
    public Pedido buscarPedidosPorId(int id_pedido){
        Pedido b = new Pedido();
        try {
            ps = cnn.getCnn().prepareStatement(buscarPedidoPorID);
            ps.setInt(1, id_pedido);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                b.setId_pedido(res.getInt("id_pedido"));
                b.setBebida(res.getString("bebida"));
                b.setDespacho(res.getBoolean("despacho"));
                b.setFecha(res.getString("fecha"));
                b.setPlato(res.getString("plato"));
                b.setRut_cliente(res.getString("rut_cliente"));
                b.setTotal(res.getInt("total"));
            }
        } catch (Exception ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
    public ArrayList<Pedido> buscarHistorial(String rut_cliente){
        ArrayList<Pedido> lista = new ArrayList<>();
        try {
            ps = cnn.getCnn().prepareStatement(buscarHistorial);
            ps.setString(1, rut_cliente);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Pedido b = new Pedido();
                b.setId_pedido(res.getInt("id_pedido"));
                b.setBebida(res.getString("bebida"));
                b.setDespacho(res.getBoolean("despacho"));
                b.setFecha(res.getString("fecha"));
                b.setPlato(res.getString("plato"));
                b.setRut_cliente(res.getString("rut_cliente"));
                b.setTotal(res.getInt("total"));
                lista.add(b);
            }
        } catch (Exception ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
