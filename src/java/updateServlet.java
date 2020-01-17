/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NKAZIMULO
 */
public class updateServlet extends HttpServlet {
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
       String password = request.getParameter("password");
        
        database data = new database();
        
        try {
            update up = data.updates(password);
            String desk = "login.html";
            
            if(up != null){
                HttpSession session = request.getSession();
                session.setAttribute("up", up);
               desk = "update.jsp";
            }else{
                String message = "Invalid  password";
                request.setAttribute("message", message);
            }
            RequestDispatcher disp = request.getRequestDispatcher(desk);
            disp.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
