package Rest;

import Entities.CityInfo;
import Facade.IZipFacade;
import Facade.ZipFacade;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

@Path("zip")
public class ZipResource {

    //variables to facade and converter
    IZipFacade zipFacade = new ZipFacade();
    JsonConverter jsonConverter = new JsonConverter();
    
    @Context
    private UriInfo context;

    public ZipResource() {
        //Create a EntityManagerFactory from the facade
        zipFacade.addEntityManagerFactory(Persistence.createEntityManagerFactory("PU"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String getAllZip() {
        //First we call the getAllZips-method from the facade and store it in a List-variable
        List<CityInfo> zips = zipFacade.getAllZips();
        //Then we convert the list and convert the data to Json with the JsonConverter
        return jsonConverter.getJSONFromCityInfos(zips);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
