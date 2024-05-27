/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.dictionary.Controller;

import com.dictionary.Model.Dictionary;
import com.dictionary.Model.FindWord;
import com.dictionary.Model.IndentifyDict;
import com.dictionary.Model.Meanings;
import com.dictionary.Model.PartsOfSpeach;
import com.dictionary.Model.Word;
import com.dictionary.Model.Words;
import com.dictionary.Model.WordsFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Denis
 */
@WebServlet(name = "BrowesServlet", urlPatterns = {"/browes"})
public class BrowesServlet extends HttpServlet {
    //Old ejbs
//    @EJB
//    Word word;
//    @EJB
//    Dictionary dictionary;
//    @EJB
//    IndentifyDict indentifyDict;
//    @EJB
//    FindWord findWord;
    
    //New ejbs
    @EJB
    WordsFacadeLocal wordsFacadeLocal;

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
        
        String browesWord = request.getParameter("word").toLowerCase();
        String dict_type = request.getParameter("dict-type");
        String language = request.getParameter("language");
        
//        String path = indentifyDict.findPath(language, dict_type);
//        dictionary.loadRecords(path, dict_type);
//        word = findWord.findWord(dictionary, browesWord);

        Collection<Words> wordC = wordsFacadeLocal.findAllByWord(browesWord);
        List<Word> words = new ArrayList<>();
        for(Words w:wordC){
            String wordname = w.getWord();
            Collection<PartsOfSpeach> pofC = w.getPartsOfSpeachCollection();
            HashMap<String,Collection<Meanings>> meaning = new HashMap<>();
            for(PartsOfSpeach pof:pofC){
                meaning.put(pof.getPof(), pof.getMeaningsCollection());
            }
//            word = new Word(wordname,meaning,null,"");
            words.add(new Word(wordname,meaning,null,""));
        }
        
        
        request.setAttribute("word", words);
        request.setAttribute("type", dict_type);
        request.getRequestDispatcher("/WEB-INF/jsp/browes.jsp").forward(request, response);
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
