/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entities.Person;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jonas
 */
public interface IPersonFacade {
public void addEntityManagerFactory(EntityManagerFactory emf);
public Person addPerson(Person p);
public Person editePerson(Person p);
public Person deletePerson(Person p);
public Person getPerson(String phone);
public List<Person> getPersons();
//public Person getPerson(String hobby);
public Person getPerson(int id);
public List<Person> getPersons(String zipcode);










}
