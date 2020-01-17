/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NKAZIMULO
 */
public class appServlet extends HttpServlet {
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
       
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String identity = request.getParameter("identity");
        String time = request.getParameter("time");
        String message = request.getParameter("message");
        
        int num = 0;
        database data = new database();
        register reg = null;
        try {
            reg = new register(name, surname, email, phone, identity, time, message);
            num = data.insert(reg);
            RequestDispatcher disp = request.getRequestDispatcher("index.html");
            disp.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
