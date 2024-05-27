/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.dictionary.Model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Denis
 */
@Local
public interface CreateCollectionsLocal {
    public Collection<Meanings> MeaningCollection(String meanings);
    public Collection<PartsOfSpeach> POFCollection(Collection<String> pof, Words wId, List<BigDecimal> pofId);
    public Collection<String> SpeechCollection(String speech);
    public List<Collection<String>> MeanList(String meanString);
}
