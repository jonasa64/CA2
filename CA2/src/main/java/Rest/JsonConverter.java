/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entities.CityInfo;
import Entities.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

/**
 *
 * @author Oliver
 */
public class JsonConverter {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public Person getPersonFromJson(String javascript) {
        return GSON.fromJson(javascript, Person.class);
    }

    public String getJSONFromPerson(Person person) {
        return GSON.toJson(person);
    }

    public String getJSONFromPersons(List<Person> persons) {
        return GSON.toJson(persons);
    }
    
    public CityInfo getZipFromJson(String javascript) {
        return GSON.fromJson(javascript, CityInfo.class);
    }

    public String getJSONFromCityInfo(CityInfo zip) {
        return GSON.toJson(zip);
    }

    public String getJSONFromCityInfos(List<CityInfo> zips) {
        return GSON.toJson(zips);
    }
    
}
