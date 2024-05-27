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
public interface PartsOfSpeachFacadeLocal {

    void create(PartsOfSpeach partsOfSpeach);

    void edit(PartsOfSpeach partsOfSpeach);

    void remove(PartsOfSpeach partsOfSpeach);

    PartsOfSpeach find(Object id);

    List<PartsOfSpeach> findAll();

    List<PartsOfSpeach> findRange(int[] range);

    int count();
    
    void addNewPof(Collection<PartsOfSpeach> pofC);
    
}
