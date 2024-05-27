/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.dictionary.Controller;

import com.dictionary.Model.CreateCollectionsLocal;
import com.dictionary.Model.PartsOfSpeach;
import com.dictionary.Model.Words;
import com.dictionary.Model.WordsFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javafx.print.Collation;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Denis
 */
@WebServlet(name = "EditDBServlet", urlPatterns = {"/admin/edit"})
public class EditDBServlet extends HttpServlet {
    @EJB
    WordsFacadeLocal wordsFacadeLocal;
    @EJB
    CreateCollectionsLocal createCollectionsLocal;

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
        RequestDispatcher dispatcher;
        Integer state; String word_name,speech,meaning; Words existWord;
        List<Words> dictionary = wordsFacadeLocal.findAll();
        String stateStr = request.getParameter("STATE");
//        System.out.println(tempstr);
        switch (stateStr) {
            case "Submit":
                state = 2;
                break;
            case "Delete":
                state = 3;
                break;
            default:
                state = Integer.parseInt(stateStr);
                break;
        }
        
        switch (state) {
            case 0:
                request.setAttribute("dict", dictionary);
                request.setAttribute("pSTATE", state);
                dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/admin-edit.jsp");
                dispatcher.forward(request, response);
                break;
            case 1:
                String word = request.getParameter("word-list");
//                System.out.print(word);
                request.setAttribute("pSTATE", state);
                
                if(word.equals("new-word"))
                    request.setAttribute("wSTATE", "n");
                else{
                    request.setAttribute("wSTATE", "e");
                    existWord = wordsFacadeLocal.findByWord(word);
                    request.setAttribute("eWord", existWord);
                }
                dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/admin-edit.jsp");
                dispatcher.forward(request, response);
                break;
            case 2:
                String wState = request.getParameter("wState");
//                System.out.println(test);
                word_name = request.getParameter("word-name");
                speech = request.getParameter("speech");
                meaning = request.getParameter("meaning");
                
                //create collection of speech
                Collection<String> speechC = createCollectionsLocal.SpeechCollection(speech);
                //create list of collection of meanings
                List<Collection<String>> mL = createCollectionsLocal.MeanList(meaning);
                
                //check if word exist
                if(wState.equals("n"))
                    wordsFacadeLocal.createNewWord(word_name, speechC, mL);
                else if(wState.equals("e")){
                    existWord = wordsFacadeLocal.findByWord(request.getParameter("exist-word"));
                    wordsFacadeLocal.updateExistWord(word_name, speechC, mL, existWord);
//                    System.out.println(request.getParameter("exist-word"));
                }
                
                //send all this collections to method
//                wordsFacadeLocal.createNewWord(word_name, speechC, mL);
                response.sendRedirect("http://localhost:8080/WebDictionary/admin/home");
                break;
            case 3:
                word_name = request.getParameter("word-name");
                existWord = wordsFacadeLocal.findByWord(word_name);
                wordsFacadeLocal.remove(existWord);
                response.sendRedirect("http://localhost:8080/WebDictionary/admin/home");
                break;
            default:
                throw new AssertionError();
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
