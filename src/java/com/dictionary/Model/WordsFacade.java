/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dictionary.Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Denis
 */
@Stateless
public class WordsFacade extends AbstractFacade<Words> implements WordsFacadeLocal {
    @EJB
    CreateCollectionsLocal createCollectionsLocal;
    @EJB
    PartsOfSpeachFacadeLocal pofLocal;

    @PersistenceContext(unitName = "WebDictionaryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WordsFacade() {
        super(Words.class);
    }

    @Override
    public Collection<Words> findAllByWord(String word) {
        String keyword = "%"+word+"%";
        TypedQuery<Words> query = getEntityManager().createNamedQuery("Words.findAllByWord", Words.class);
        query.setParameter("keyword", keyword);
        
        return query.getResultList();
    }

    @Override
    public void createNewWord(String wordName, Collection<String> speech, List<Collection<String>> mList) {
//        System.out.println(wordName);
        Query query =  em.createNativeQuery("INSERT INTO WORDS (word) VALUES (?)");
        query.setParameter(1, wordName);
        query.executeUpdate();
        
        //select this word and get id
        Words word = findByWord(wordName);
//        System.out.println(word.getWId());
        
        //create all pof with new wid
        Collection<PartsOfSpeach> pofC = createCollectionsLocal.POFCollection(speech, word, null);
        pofLocal.addNewPof(pofC);
        
        //select all pof with wid and get pof_id
        query = em.createNativeQuery("SELECT * FROM parts_of_speach WHERE w_id = ?", PartsOfSpeach.class);
        query.setParameter(1, word.getWId());
        List<PartsOfSpeach> pofL = query.getResultList();
        
        //create all meanings with new pof_id
        query = em.createNativeQuery("INSERT INTO MEANINGS (mvalue, pof_id) VALUES(?,?)");
        for(int i = 0; i < pofL.size(); i++){
            for(String mean : mList.get(i)){
                query.setParameter(1, mean);
                query.setParameter(2, pofL.get(i).getPofId());
                query.executeUpdate();
            }
        }
    }

    @Override
    public Words findByWord(String word) {
        TypedQuery<Words> query = getEntityManager().createNamedQuery("Words.findByWord", Words.class);
        query.setParameter("word", word);
        
        return query.getSingleResult();
    }

    @Override
    public void updateExistWord(String wordName, Collection<String> speech, 
            List<Collection<String>> mList, Words existWord) {
        existWord.setWord(wordName);

        if(speech.size() == existWord.getPartsOfSpeachCollection().size()){
            List<String> speechL = new ArrayList<>(speech);
            int i = 0;
            for(PartsOfSpeach pof : existWord.getPartsOfSpeachCollection()){
                pof.setPof(speechL.get(i));
                i++;
            }
        }else{
            // update if pof > existPof or < existPof
        }
        
        int i = 0;
        for(PartsOfSpeach pof : existWord.getPartsOfSpeachCollection()){
            int k = 0;
            for(Meanings m : pof.getMeaningsCollection()){
                List<String> temp = new ArrayList<>(mList.get(i));
                m.setMvalue(temp.get(k));
                k++;
            }
            i++;
        }
        
        edit(existWord);
    }
    
}
