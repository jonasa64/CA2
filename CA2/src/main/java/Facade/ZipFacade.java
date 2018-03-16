/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entities.CityInfo;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
/**
 *
 * @author Jonas
 */
public class ZipFacade implements IZipFacade{
    
    EntityManagerFactory emf;

    public ZipFacade() {
        
    }

    public ZipFacade(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
      this.emf = emf;
    }

    @Override
    public List<CityInfo> getAllZips() {
        EntityManager em = emf.createEntityManager();
        List<CityInfo> cityInfo = null;
        
        try{
            em.getTransaction().begin();
            cityInfo = em.createQuery("Select z.zipCode from CityInfo z").getResultList();
            em.getTransaction().commit();
            return cityInfo;
        }finally{
            em.close();
        }
        
    }
    
}
