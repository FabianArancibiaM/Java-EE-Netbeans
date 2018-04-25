/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import modelo.BebidaDAO;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.ComunaDAO;
import modelo.Pedido;
import modelo.PedidoDAO;
import modelo.PlatoDAO;

/**
 *
 * @author Fabian
 */
public class Main {
    public static void main(String[] args){
        /*BebidaDAO bDAO= new BebidaDAO();
        System.out.println(bDAO.buscarTodo());
        PlatoDAO pDAO = new PlatoDAO();
        System.out.println(pDAO.buscarTodo());
        ComunaDAO cDAO = new ComunaDAO();
        System.out.println(cDAO.buscarTodo());
        ClienteDAO clDAO = new ClienteDAO();
        System.out.println(clDAO.buscarTodo());
        PedidoDAO peDAO = new PedidoDAO();
        System.out.println(peDAO.buscarTodo());
        
        Cliente cliente = new Cliente("15", "15", "15", "15", 5, 15);
        Pedido pedido = new Pedido("15", "Aji Gallina", "Bilz", true, 23555, "2017-11-21");
        
        System.out.println(clDAO.insertar(cliente));
        System.out.println(peDAO.insertar(pedido));
        Pedido pedido2 = new Pedido("13", "Ceviche", "Bilz", true, 23555, "2017-11-21");
        pedido2.setId_pedido(2);
        System.out.println(peDAO.modificar(pedido2));
        System.out.println(peDAO.buscarTodo());
        System.out.println(peDAO.insertar(pedido2));
        System.out.println(peDAO.buscarTodo());
        System.out.println(peDAO.buscarPedidosDelCliente("15"));
        ClienteDAO clDAO = new ClienteDAO();
        Cliente cliente = new Cliente("ss6", "151ss", "15", "15", 5, 15);
        
        System.out.println(clDAO.insertar(cliente));
        System.out.println(clDAO.buscarTodo());
        ClienteDAO clDAO = new ClienteDAO();
        System.out.println(clDAO.existe("13", "13"));
        System.out.println(clDAO.existe("13", "14"));
        PlatoDAO pDAO = new PlatoDAO();
        System.out.println(pDAO.buscarTodo());*/
        
         PedidoDAO peDAO = new PedidoDAO();
         System.out.println(peDAO.buscarTodo());
         System.out.println("----------------------------------------------");
        Pedido pedido2 = new Pedido("13", "Ceviche", "Bilz", true, 23555, "2017-11-21");
        pedido2.setId_pedido(14);
        System.out.println(peDAO.modificar(pedido2));
        System.out.println(peDAO.buscarTodo());
    }
}
