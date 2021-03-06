/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Bebida;
import modelo.BebidaDAO;
import modelo.ClienteDAO;
import modelo.Plato;
import modelo.PlatoDAO;

/**
 *
 * @author Fabian
 */
@WebServlet(name = "ServletValidarExiste", urlPatterns = {"/ServletValidarExiste"})
public class ServletValidarExiste extends HttpServlet {

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
        try {
            ClienteDAO cliente = new ClienteDAO();
            String rut = request.getParameter("txtRun");
            String clave = request.getParameter("txtPass");
            boolean existe = cliente.existe(clave, rut);
            if (existe==true) {
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                String fecha = dateFormat.format(date);
                sesion.setAttribute("fecha", fecha);
                sesion.setAttribute("usuario", rut);
                PlatoDAO pedidos = new PlatoDAO();
                ArrayList<Plato>listaP = pedidos.buscarTodo();
                sesion.setAttribute("listaPlatos", listaP);
                BebidaDAO bebidas = new BebidaDAO();
                ArrayList<Bebida>listaB = bebidas.buscarTodo();
                sesion.setAttribute("listaBebidas", listaB);
                response.sendRedirect("pedido.jsp");
            }else{
                response.sendRedirect("index.html");
            }
        } catch (Exception e) {
            response.sendRedirect("index.html");
        }
        
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
