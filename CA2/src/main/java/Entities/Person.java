package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

import javax.persistence.ManyToMany;

@Entity
public class Person extends InfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;

    @ManyToMany
    private List<Hobby> hobbies;

    //Constructors
    public Person() {
    }

    public Person(String firstName, String lastName, List<Hobby> hobbies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobbies = hobbies;
    }

    //Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
    
    public void addHobby(Hobby hobby){
        this.hobbies.add(hobby);
    }

    @Override
    public String toString() {
        return "FirstName: " + firstName + "\n"
                + "LastName: " + lastName + "\n"
                + "Hobbies: " + hobbies;
    }

}
