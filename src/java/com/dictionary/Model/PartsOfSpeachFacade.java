/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dictionary.Model;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Denis
 */
@Stateless
public class PartsOfSpeachFacade extends AbstractFacade<PartsOfSpeach> implements PartsOfSpeachFacadeLocal {

    @PersistenceContext(unitName = "WebDictionaryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PartsOfSpeachFacade() {
        super(PartsOfSpeach.class);
    }

    @Override
    public void addNewPof(Collection<PartsOfSpeach> pofC) {
        Query query = em.createNativeQuery("INSERT INTO PARTS_OF_SPEACH (pof, w_id) VALUES(?,?)");
        for(PartsOfSpeach pof : pofC){
            query.setParameter(1, pof.getPof());
            query.setParameter(2, pof.getWId().getWId());
            query.executeUpdate();
        }
    }
    
}
