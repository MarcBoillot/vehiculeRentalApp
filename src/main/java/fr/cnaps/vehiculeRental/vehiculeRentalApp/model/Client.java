package fr.cnaps.vehiculeRental.vehiculeRentalApp.model;

import jakarta.persistence.*;

import java.util.Date;

// @DATA pour ne pas avoir a crée les GETTER et pouvoir directement acceder aux données
@Entity
@Table (name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstname;
    private String lastname;
    private java.sql.Date birthday;
    private int license;




    public Client() {
    }

    public Client(int id, String firstname, String lastname, java.sql.Date birthday, int license) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.license = license;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }
}