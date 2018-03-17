/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import DTO.PersonDTO;
import Entities.Hobby;
import Entities.Person;
import Exception.PersonsNotFoundException;
import Facade.IPersonFacade;
import Facade.PersonFacade;
import JsonMessages.JSONMessage;
import JsonMessages.MessageFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Oliver
 */
@Path("person")
public class PersonResource {

    //Variables to facade and gson library
    private final IPersonFacade personFacade = new PersonFacade();
    private final JsonConverter jsonConverter = new JsonConverter();
    private JsonObject jOPersons;
    private JsonObject jOPerson;
    private JsonArray jOPersonsArray;

    @Context
    private UriInfo context;

    public PersonResource() {
        personFacade.addEntityManagerFactory(Persistence.createEntityManagerFactory("PU"));
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/complete/{id}")
//    public String getPerson(@PathParam("id") Long id) {
//        Person pers = PersonFacade.getPerson(id);
//        return MessageFacade.messagetoJson(new PersonDTO(pers));
//    }
    
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/complete")
//    public String getPersons() {
//        ArrayList<JSONMessage> messages = new ArrayList<>();
//        for(Person pers : PersonFacade.getPersons()) {
//            messages.add(new PersonDTO(pers));
//        }
//        return gson.toJson(messages);
//    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("complete")
    public String getPersonss() throws PersonsNotFoundException {
        List<Person> personList = personFacade.getPersons();
        if(!personList.isEmpty()){
            //String personListS = new Gson().toJson(personList);
            JsonArray ja = new JsonArray();
            for (int i = 0; i < personList.size(); i++) {
                JsonObject jo=  new JsonObject();
                jo.addProperty("firstName", personList.get(i).getFirstName());
                jo.addProperty("lastName", personList.get(i).getLastName());
                jo.addProperty("Email", personList.get(i).getEmail());
                jo.addProperty("Address", personList.get(i).getAddress().getStreet());
                jo.addProperty("Phones", personList.get(i).getPhones().toString());
                System.out.println("this is the sheet: " + personList.get(i).getPhones().size());
                JsonArray hobbies = new JsonArray();
                System.out.println("antal hobbies: "+ personList.get(i).getHobbies().size());
                for (Hobby h : personList.get(i).getHobbies()) {
                   hobbies.add(h.getName());
                }
                ja.addAll(hobbies);
                ja.add(jo);
            }
            return ja.toString();
        }
        else {
            throw new PersonsNotFoundException();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/contactinfo")
    public String getPersonsInfo() throws PersonsNotFoundException{
         List<Person> personList = personFacade.getPersons();
         jOPersons = new JsonObject();
         jOPersonsArray = new JsonArray();
         
         for (int i = 0; i < personList.size(); i++) {
            JsonObject jOPerson = new JsonObject();
            
            jOPerson.addProperty("firstName", personList.get(i).getFirstName());
            jOPerson.addProperty("lastName", personList.get(i).getLastName());
            jOPerson.addProperty("Phone", personList.get(i).getPhones().toString());
            jOPerson.addProperty("email", personList.get(i).getEmail());
            
            jOPersonsArray.add(jOPerson);
        }
         jOPersons.add("persons", jOPersonsArray);
         
         if(jOPersons != null){
            return jOPersons.toString();
         }
         else{
             throw new PersonsNotFoundException();
         }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/contactinfo/{id}")
    public String getPersonInfo(@PathParam("id") Long id) {
        Person person = personFacade.getPerson(id);
        jOPerson = new JsonObject();
        
        jOPerson.addProperty("firstName", person.getFirstName());
        jOPerson.addProperty("lastName", person.getLastName());
        jOPerson.addProperty("Phone", person.getPhones().toString());
        jOPerson.addProperty("email", person.getEmail());
        
        return jOPerson.toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/phone")
    public String getPersonByPhone(String content) {
        
        return "";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addPerson(String content) {
        Person personToAdd = jsonConverter.getPersonFromJson(content);//convert Person object from JSON to Java
        Person personAdded = personFacade.addPerson(personToAdd);
        return jsonConverter.getJSONFromPerson(personAdded);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update")
    public String updatePerson(String content) {
        Person personToUpdate = jsonConverter.getPersonFromJson(content);
        Person personUpdated = personFacade.editePerson(personToUpdate);
        return jsonConverter.getJSONFromPerson(personUpdated);
    }

//    @DELETE
//    @Path("/delete/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public String deletePerson(@PathParam("id") int id) {
//        Person deletedPerson = personFacade.deletePerson(id);
//        return jsonConverter.getJSONFromPerson(deletedPerson);
//    }
    
    @GET
    @Path("{hobby}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonsByHobby(@PathParam("hobby") String hobby) {
        List<Person> persons = personFacade.getPersons(hobby);
        
        if(!persons.isEmpty()){
            
        }
        return "";
    }
}
