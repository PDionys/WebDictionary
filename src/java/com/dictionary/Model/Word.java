/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package com.dictionary.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Denis
 */
@Stateful
public class Word {
    private String wordname, transcription;
    private HashMap<String,Collection<Meanings>> meaning;
    private String[] translation;

    public Word() {
    }
    
    public Word(String wordname, HashMap<String,Collection<Meanings>> meaning, String[] translation, String transcription){
        this.wordname = wordname;
        this.meaning = new HashMap<>();
        
        for(String k : meaning.keySet()){
            int m_count = 1;
            List<Meanings> tempL = (List<Meanings>) meaning.get(k);
            for(int i = 0; i < tempL.size(); i++){
                String m_counter = m_count+"."+tempL.get(i).getMvalue();
                m_count++;
                tempL.get(i).setMvalue(m_counter);
            }
            this.meaning.put(k, meaning.get(k));
        }
        
        this.translation = translation;
        this.transcription = transcription;
    }
    
    public String getWordname(){
        return this.wordname.substring(0,1).toUpperCase() + this.wordname.substring(1);
    }
    public HashMap<String,Collection<Meanings>> getMeaning(){
        return this.meaning;
    }
    public String[] getTranslation(){
        return this.translation;
    }
    public String getTranscription(){
        return this.transcription;
    }
}
