/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entities.Company;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

/**
 *
 * @author Jonas
 */
public class CompaniesFacade implements IcompaniesFacade{
EntityManagerFactory emf;

public CompaniesFacade(EntityManagerFactory emf){
    this.emf = emf;
}
     
    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Company addCompany(Company c) {
       EntityManager em = emf.createEntityManager();
       
       try{
           em.getTransaction().begin();
           em.persist(c);
           em.getTransaction().commit();
       }finally{
           em.close();
       }
       return c;
    }

    @Override
    public Company editCompany(Company c) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return c;
    }

    @Override
    public Company getCompany(String phone) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Company company = (Company) em.createQuery("SELECT c FROM COMPANY c WHERE c.PHONE ="+ phone).getResultList();
            em.getTransaction().commit();
            return company;
        } finally{
            em.close();
        }
    }

    @Override
    public List<Company> getEmployes(int employes) {
       EntityManager em = emf.createEntityManager();
        List<Company> company = null;
        
        try{
            em.getTransaction().begin();
            company = em.createQuery("Select c from Company c where Company.numEmployees =" + employes).getResultList();
            em.getTransaction().commit();
            return company;
        }finally{
            em.close();
        }
    }

    @Override
    public Company getInfo(String cvr) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Company company = em.find(Company.class, cvr);
            em.getTransaction().commit();
            return company;
        }finally{
            em.close();
        }
    }
    
}
