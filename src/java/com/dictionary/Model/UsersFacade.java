/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dictionary.Model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Denis
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> implements UsersFacadeLocal {

    @PersistenceContext(unitName = "WebDictionaryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }

    @Override
    public boolean userExist(String username, String password) {
        TypedQuery<Users> query = getEntityManager().createNamedQuery("Users.findByUsername", Users.class);
        query.setParameter("username", username);
        try {
            Users user = query.getSingleResult();
            return user.getPassword().equals(password);
        } catch (Exception e) {
            return false;
        }
    }
    
}
