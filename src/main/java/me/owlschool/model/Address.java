package me.owlschool.model;

import javax.persistence.Entity;

/**
 * Created by Alex P. Andrade on 24/06/2017.
 */
@Entity
public class Address extends BaseEntity {
    String country;
    String state;
    String postalCode;
    String city;
    String address;
    int number;

    public Address() {
    }

    public Address(String country, String state, String postalCode, String city, String address, int number) {
        this.country = country;
        this.state = state;
        this.postalCode = postalCode;
        this.city = city;
        this.address = address;
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
