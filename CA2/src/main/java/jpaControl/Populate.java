/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import Entities.Address;
import Entities.CityInfo;
import Entities.Person;
import Entities.Phone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oliver
 */
public class Populate {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        CityInfo c1 = new CityInfo("2800", "Lyngby");
        Address a1 = new Address();
        Phone phone1 = new Phone();
        Person p1 = new Person();
        
        a1.setStreet("somewhere");
        a1.setAdditionalInfo("AdditionalSomething");
        a1.setCityInfo(c1);

        phone1.setNumber("+4511111111");
        phone1.setDescription("phone1");

        p1.setFirstName("first1");
        p1.setLastName("last1");
        p1.setEmail("p1@dk.dk");
        p1.setAddress(a1);
        p1.addPhone(phone1);

        em.persist(p1);
        em.persist(phone1);

        CityInfo c2 = new CityInfo("2800", "Lyngby");
        Address a2 = new Address();
        Phone phone2 = new Phone();
        Person p2 = new Person();

        a2.setStreet("somewhere2");
        a2.setCityInfo(c2);

        phone2.setNumber("+4522222222");
        phone2.setDescription("phone2");

        p2.setFirstName("first2");
        p2.setLastName("last2");
        p2.setEmail("p2@dk.dk");
        p2.setAddress(a2);
        p2.addPhone(phone2);

        em.persist(p2);
        em.persist(phone2);

        em.getTransaction().commit();
        em.close();
    }
}
