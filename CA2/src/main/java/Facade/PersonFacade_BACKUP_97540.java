/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entities.Person;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

/**
 *
 * @author Jonas
 */
public class PersonFacade implements IPersonFacade {

    EntityManagerFactory emf;

    public PersonFacade() {

    }

//    public PersonFacade(EntityManagerFactory emf){
//        this.emf = emf;
//    }
    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Person addPerson(Person p) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return p;

    }

    @Override
    public Person editePerson(Person p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();;
            em.merge(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return p;
    }

    @Override
    public Person deletePerson(Person p) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;

    }

    @Override
    public Person getPerson(String phone) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Person person = em.find(Person.class, phone);
            em.getTransaction().commit();
            return person;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Person> getPersons() {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = null;
        try {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p").getResultList();
            em.getTransaction().commit();
            return persons;
        } finally {
            em.close();
        }

    }

    @Override
    public Person getPerson(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Person person = em.find(Person.class, id);

            em.getTransaction().commit();
            return person;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Person> getPersons(String zipcode) {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = null;
        try {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p where CityInfo.zipCode =" + zipcode).getResultList();
            em.getTransaction().commit();
            return persons;
        } finally {
            em.close();
        }
    }


    @Override
    public List<Person> getPersonsByHobby(String hobbyName) {
        EntityManager em = emf.createEntityManager();

        List<Person> persons = null;

        try {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p where Hobby.name =" + hobbyName).getResultList();
            em.getTransaction().commit();
            return persons;
        } finally {
            em.close();
        }
    }
    
}
