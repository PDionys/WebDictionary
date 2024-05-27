/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.dictionary.Controller;

import com.dictionary.Model.Autorization;
import com.dictionary.Model.UsersFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Denis
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @EJB
    Autorization autorization;
    @EJB
    UsersFacadeLocal usersFacadeLocal;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60*10);
//        System.out.println(session.getAttribute("login"));
        

        if(session.getAttribute("login") == null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login-page.jsp");
            dispatcher.forward(request, response);
            session.setAttribute("login", true);
//            response.sendRedirect("login-page.jsp");
        }else{
            //System.out.println("Hello its not NULL");
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
//            dispatcher.forward(request, response);
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
             
//            System.out.println("usrename: " + username + " password: " + password);
            
//            if(autorization.UserExist(username, password)){
//                session.setAttribute("LOGIN", "TRUE");
//                session.setAttribute("USERNAME", username);
//                response.sendRedirect("http://localhost:8080/WebDictionary/admin/home");
//            }else{
//              RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login-page.jsp");
//              dispatcher.forward(request, response);  
//            }
            
            if(usersFacadeLocal.userExist(username, password)){
                session.setAttribute("LOGIN", "TRUE");
                session.setAttribute("USERNAME", username);
                response.sendRedirect("http://localhost:8080/WebDictionary/admin/home");
            }else{
              RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login-page.jsp");
              dispatcher.forward(request, response);  
            }
            
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
