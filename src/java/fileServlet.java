/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NKAZIMULO
 */
public class fileServlet extends HttpServlet {
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
    String identity = request.getParameter("id");
    String time = request.getParameter("time");
    String message = request.getParameter("message");
    
    bookClient book = new bookClient();
    
        try {
            FileWriter wr = new FileWriter("booked.txt", true);
            wr.write(System.getProperty("line.separator"));
            wr.write("Name " + "Surname " + "email " + "phone " + "identity " + "time " 
             + "message");
             wr.write( book.getName() + book.getSurname() + book.getEmail() + book.getPhone() + book.getIdentity() + book.getTime()
             + book.getMessage());
            wr.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        
        RequestDispatcher disp = request.getRequestDispatcher("/index.html");
        disp.forward(request, response);
    }
}
