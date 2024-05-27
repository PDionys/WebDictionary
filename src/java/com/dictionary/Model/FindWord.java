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
public class FindWord {
    public Word findWord(Dictionary dict, String word){
        for(String i : dict.getMap().keySet()){
            if(i.equals(word)){
                return dict.getMap().get(i);
            }
        }
        return null;
    }
}
