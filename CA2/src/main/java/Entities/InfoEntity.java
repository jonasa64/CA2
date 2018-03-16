package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class InfoEntity implements Serializable {

    //Variables
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;


    @OneToMany(mappedBy = "infoEntity")
    private List<Phone> phones;

    
    //Constructors
    public InfoEntity() {
    }

    public InfoEntity(String email, Address address, List<Phone> phones) {
        this.email = email;
        this.address = address;
        this.phones = phones;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void addPhone(Phone phone) {
        if(this.phones == null){
            this.phones = new ArrayList<>();
        }
        phone.setInfoEntity(this);
        this.phones.add(phone);
    }
    
    

//    @Override
//    public String toString() {
//        return "InfoEntity id: " + id + "\n"
//                + "Email: " + email + "\n"
//                + "Address: " + address + "\n";
//    }

    @Override
    public String toString() {
        return "InfoEntity{" + "id=" + id + ", email=" + email + ", address=" + address + ", phones=" + phones + '}';
    }

}
