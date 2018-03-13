/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jonas
 */
public interface IcompaniesFacade {

    public void addEntityManagerFactory(EntityManagerFactory emf);

    public Companies addCompanie(Companies c);

    public Companies editCompanie(Companies c);

    public Companies deleteCompanie(int id);

    public Companies getCompanie(int id);

    public List<Companies> getEmployes();

    public Companies getInfo(String phone);

}
