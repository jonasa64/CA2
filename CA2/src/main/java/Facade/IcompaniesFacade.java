/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entities.Company;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jonas
 */
public interface IcompaniesFacade {

    public void addEntityManagerFactory(EntityManagerFactory emf);

    public Company addCompany(Company c);

    public Company editCompany(Company c);

    public Company getCompany(String phone);

    public List<Company> getEmployes(int employes);

    public Company getInfo( String cvr);

}
