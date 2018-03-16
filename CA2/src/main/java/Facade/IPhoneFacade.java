/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entities.Phone;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Oliver
 */
public interface IPhoneFacade {
    public void addEntityManagerFactory(EntityManagerFactory emf);
    public Phone getPhoneById(Long id);
    
}
