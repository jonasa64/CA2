/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entities.Phone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Oliver
 */
public class PhoneFacade implements IPhoneFacade {

    EntityManagerFactory emf;

    public PhoneFacade() {
    }
    
    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Phone getPhoneById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Phone phone = em.find(Phone.class, id);
            em.getTransaction().commit();
            return phone;
        } finally {
            em.close();
        }
    }

    

}
