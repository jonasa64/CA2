/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Entities.Address;
import Entities.CityInfo;
import Entities.Person;
import Entities.Phone;
import Facade.PersonFacade;
import Facade.PhoneFacade;
import JsonMessages.JSONMessage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oliver
 */
public class PersonDTO implements JSONMessage<Person> {
    
    public int id;
    public String firstName;
    public String lastName;
    public Address address;
    public CityInfo cityInfo;
    //public Phone phone;
    
    public List<Long> phoneIds;
    
    public PersonDTO(Person pers) {
        this.firstName = pers.getFirstName();
        this.lastName = pers.getLastName();
        this.address = pers.getAddress();
        this.cityInfo = pers.getAddress().getCityInfo();
        
        //this.phone = (Phone) pers.getPhones();
        //Get phones
        for (Phone p : pers.getPhones()) {
            phoneIds.add(p.getId());
        }
    }

    @Override
    public Person toInternal() {
        PhoneFacade pf = new PhoneFacade();
        ArrayList<Phone> phones = new ArrayList<>();
        for(Long id : phoneIds) {
            phones.add(pf.getPhoneById(id));
        }
        //return new Person(id, firstName, lastName, phones, address, cityInfo);
        Person person = null; //DETTE ER KUN SÅ METODEN KAN RETURN NOGET OG 
        return person;        //IKKE GIVE FEJL!!
        
    }
    
}
