/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.dictionary.Model;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Denis
 */
@Stateless
@LocalBean
public class IndentifyDict {
    public String findPath(String lang, String type){
        String result;
        
        if(lang.equals("us") && type.equals("expl"))
            result = "words-us.txt";
        else if(lang.equals("us") && type.equals("biling"))
            result = "words-us-to-ua.txt";
        else if (lang.equals("ua") && type.equals("expl"))
            result = "words-ua.txt";
        else if (lang.equals("us") && type.equals("biling"))
            result = "words-ua-to-us";
        else return null;
        
        return "C:\\Users\\Denis\\Documents\\NetBeansProjects\\WebDictionary\\" + result;
    }
}
