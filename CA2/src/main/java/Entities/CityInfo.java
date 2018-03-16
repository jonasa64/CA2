package Entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CityInfo implements Serializable {

    //Variables
    private static final long serialVersionUID = 1L;
    @Id
    private String zipCode;
    private String city;

    //Constructors
    public CityInfo() {
    }

    public CityInfo(String zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }

    //Getters and Setters
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "ZipCode: " + zipCode + "\n"
                + "City: " + city;
    }

}
