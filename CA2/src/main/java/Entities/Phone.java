/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Oliver
 */
@Entity
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String description;
    @ManyToOne
    private InfoEntity infoEntity;

    public Phone() {
    }

    public Phone(Long id, String number, String description) {
        this.id = id;
        this.number = number;
        this.description = description;
    }

    public InfoEntity getInfoEntity() {
        return infoEntity;
    }

    public void setInfoEntity(InfoEntity infoEntity) {
        this.infoEntity = infoEntity;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Phone{" + "id=" + id + ", number=" + number + ", description=" + description + '}';
    }

}
