/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import java.util.HashMap;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oliver
 */
public class Structure {
    
    public static void main(String[] args) {
        HashMap puProperties = new HashMap();
        
        puProperties.put("javax.persistence.sql-load-script-source", "Scripts/populateCityInfo.sql");
        
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        //emf.getProperties().put("javax.persistence.sql-load-script-source", "Scripts/populateCityInfo.sql");
        Persistence.generateSchema("PU", puProperties);
    }
    
    
}
