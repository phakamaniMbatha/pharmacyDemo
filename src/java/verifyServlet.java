/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NKAZIMULO
 */
public class verifyServlet extends HttpServlet {
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
            throws ServletException, IOException, UnsupportedEncodingException {
        String code = request.getParameter("code");
        String subject = "Reset password cose";
        String sendermail = "phakamani0768887712@gmail.com";
        String password = "@Ph91A09Mo20";
        int rand = (int) (Math.random()*9999) + 1;  
        String host = "smtp.gmail.com";
        String port = "587";
        String message = "Here is your verification code" + rand;
        String senderName = "Phakamani";
        
        VerifyCode ver = null;
        try {
            Utility.sendEmail(host, port, sendermail, senderName, password, sendermail, subject, message);
            ver = new VerifyCode(code);
            if(ver.getCode().equals(rand)){
                RequestDispatcher disp = request.getRequestDispatcher("update.jsp");
            disp.forward(request, response);
            }else{
               
                RequestDispatcher disp = request.getRequestDispatcher("verify.jsp");
                disp.forward(request, response);
            }
            
        } catch (MessagingException ex) {
            Logger.getLogger(verifyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
