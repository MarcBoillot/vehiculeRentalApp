package fr.cnaps.vehiculeRental.vehiculeRentalApp.model;

import jakarta.persistence.*;

import java.util.Optional;

// @DATA pour ne pas avoir a crée les GETTER et pouvoir directement acceder aux données
@Entity
@Table (name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String immat;
    private String brand;
    private String model;
    private String color;
    private int power;
    private int price;
    private int pricekm;

    public Car(int price, int pricekm) {
    }


    public void setId(int id) {
        this.id = id;
    }

    public Car() {
    }

    public Car(int id,String immat, String brand, String model,  String color, int power, int price, int pricekm){
        this.id = id;
        this.immat = immat;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.power = power;
        this.price = price;
        this.pricekm = pricekm;
    }

    public int getId() {
        return id;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPricekm() {
        return pricekm;
    }

    public void setPricekm(int pricekm) {
        this.pricekm = pricekm;
    }
}