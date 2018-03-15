/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entities.Person;
import Facade.IPersonFacade;
import Facade.PersonFacade;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Oliver
 */
@Path("Person")
public class PersonResource {
    private IPersonFacade personFacade = new PersonFacade();
    private JsonConverter jsonConverter = new JsonConverter();
    private JsonObject jOPersons;
    private JsonObject jOPerson;
    private JsonArray jOPersonsArray;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
        personFacade.addEntityManagerFactory(Persistence.createEntityManagerFactory("PU"));
    }

    /**
     * Retrieves representation of an instance of Rest.PersonResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/person/{id}")
    public String getPerson(@PathParam("id") int id) {
        Person person = personFacade.getPerson(id);
        return jsonConverter.getJSONFromPerson(person);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public String getPersons() {
        List<Person> persons = personFacade.getPersons();
        return jsonConverter.getJSONFromPersons(persons);
    }

    /**
     * PUT method for updating or creating an instance of PersonResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
