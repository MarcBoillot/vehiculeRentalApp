package fr.cnaps.vehiculeRental.vehiculeRentalApp.model;

import jakarta.persistence.*;

import java.sql.Date;

// @DATA pour ne pas avoir a crée les GETTER et pouvoir directement acceder aux données
@Entity
@Table(name = "clients_has_cars")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int clients_id;
    private int cars_id;
    private java.sql.Date start_date;
    private java.sql.Date end_date;
    private int kilometer;
    private int price_resa;


    public Reservation() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClients_id() {
        return clients_id;
    }

    public void setClients_id(int clients_id) {
        this.clients_id = clients_id;
    }

    public int getCars_id() {
        return cars_id;
    }

    public void setCars_id(int cars_id) {
        this.cars_id = cars_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getKilometer() {
        return kilometer;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
    }

    public int getPrice_resa() {
        return price_resa;
    }

    public void setPrice_resa(int price_resa) {
        this.price_resa = price_resa;
    }
}