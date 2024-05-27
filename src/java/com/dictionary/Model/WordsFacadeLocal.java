/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dictionary.Model;

import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Denis
 */
@Local
public interface WordsFacadeLocal {

    void create(Words words);

    void edit(Words words);

    void remove(Words words);

    Words find(Object id);

    List<Words> findAll();

    List<Words> findRange(int[] range);

    int count();
    
    Collection<Words> findAllByWord(String word);
    
    Words findByWord (String word);
    
    void createNewWord(String wordName, Collection<String> speech, List<Collection<String>> mList);
    
    void updateExistWord(String wordName, Collection<String> speech, List<Collection<String>> mList, Words existWord);
    
}
