/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.BebidaDAO;
import modelo.Pedido;
import modelo.PedidoDAO;
import modelo.PlatoDAO;

/**
 *
 * @author Fabian
 */
@WebServlet(name = "ServletModificarPedido", urlPatterns = {"/ServletModificarPedido"})
public class ServletModificarPedido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(true);
        
        String rut_cliente = request.getParameter("rutModif");
        String plato =  request.getParameter("platoModif");
        String bebida = request.getParameter("bebidaModif");
        boolean despacho=true;
        if (Integer.parseInt(request.getParameter("despachoModif"))==1) {
            despacho = true;
        }else{
            despacho = false;
        }
        Calendar calen = Calendar.getInstance();
        String fecha = calen.get(Calendar.YEAR)+"-"+calen.get(Calendar.MONTH)+"-"+calen.get(Calendar.DAY_OF_MONTH);
        BebidaDAO b = new BebidaDAO();
        int valorBebida = b.existe(bebida);
        PlatoDAO p = new PlatoDAO();
        int valorPlato = p.existe(plato);
        try {
            Pedido ped = new Pedido(rut_cliente, plato, bebida, despacho, valorBebida+valorPlato, fecha);
            ped.setId_pedido(Integer.parseInt(request.getParameter("idModif")));
            PedidoDAO pedi = new PedidoDAO();
            pedi.modificar(ped);
            ArrayList<Pedido>lista = pedi.buscarPedidosDelCliente(rut_cliente,fecha);
            int totalPedido = pedi.existe(rut_cliente,fecha);
            sesion.setAttribute("totalPedido", totalPedido);
            sesion.setAttribute("pedidoCompleto", lista);
            sesion.setAttribute("cliente", rut_cliente);
        } catch (Exception e) {
            
        }
        response.sendRedirect("confirmacion.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
