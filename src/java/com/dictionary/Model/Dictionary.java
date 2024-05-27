/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package com.dictionary.Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;

/**
 *
 * @author Denis
 */
@Stateful
@LocalBean
public class Dictionary {
    private HashMap<String, Word> map = new HashMap<>();
    
//    public void loadRecords(String path, String type) throws FileNotFoundException, IOException{
//        BufferedReader br = new BufferedReader(new FileReader(path));
//        String wordname, transcription, partofspeach;
//        String[] meaning;
//        HashMap<String,Collection<Meanings>> map_m = new HashMap<>();
//        Word words;
//        
//        for(String line = br.readLine(); line != null; line = br.readLine()){
//            map_m.clear();
//            if(type.equals("expl")){
//                String[] parsedLine = line.split("<>");
////                System.out.println("[0]" + parsedLine[0] + " [1]" + parsedLine[1]);
//                wordname = parsedLine[0];
//                parsedLine = parsedLine[1].split("<->");
////                System.out.println("[0]" + parsedLine[0] + " [1]" + parsedLine[1]);
//                transcription = parsedLine[0];
//                parsedLine = parsedLine[1].split("<-->");
////                if(parsedLine.length > 1)
////                    System.out.println("[0]" + parsedLine[0] + " [1]" + parsedLine[1]);
////                else System.out.println("[0]" + parsedLine[0]); 
//                for (String p : parsedLine){
//                    partofspeach = p.split("<--->")[0];
////                    System.out.println("[---]" + partofspeach + "[----]");
//                    meaning = p.split("<--->")[1].split("<---->");
//                    //map_m.put(partofspeach, meaning); TODO
//                }
//                //meaning = parsedLine[1].split("<->");
//                
//                words = new Word(wordname, map_m, null, transcription);
//            }else{
//                String[] parsedLine = line.split("<>");
//                wordname = parsedLine[0];
//                String[] translation = parsedLine[1].split(",");
//                words = new Word(wordname, null, translation, null);
//            }
//            
//            this.map.put(wordname, words);
//        }
//        br.close();
//    }
    
    public HashMap<String, Word> getMap(){
        return this.map;
    }
}
