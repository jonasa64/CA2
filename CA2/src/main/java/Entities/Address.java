/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Oliver
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Address;
    private String additionalInfo;
    @OneToMany(mappedBy = "address")
    private List<InfoEntity> InfoEntity;
    @ManyToOne
    private CityInfo cityInfo;

    public Address() {
    }

    public Address(Long id, String Address, String additionalInfo) {
        this.id = id;
        this.Address = Address;
        this.additionalInfo = additionalInfo;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public void setInfoEntity(List<InfoEntity> InfoEntity) {
        this.InfoEntity = InfoEntity;
    }

    public String getAddress() {
        return Address;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public List<InfoEntity> getInfoEntity() {
        return InfoEntity;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", Address=" + Address + ", additionalInfo=" + additionalInfo + '}';
    }

}
