/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dictionary.Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.ejb.Stateless;

/**
 *
 * @author Denis
 */
@Stateless
public class Autorization {
    public boolean UserExist(String username, String password) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Denis\\Documents\\NetBeansProjects\\WebApplication2\\admins.txt"));
        
        for(String line = br.readLine(); line != null; line = br.readLine()){
            String[] sLine = line.split(" ");
            String aName = sLine[0];
            String aPass = sLine[1];
            if(aName.equals(username) && aPass.equals(password))
                return true;
        }
        br.close();
        
        return false;
    }
}
