package me.owlschool.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Created by Alex P. Andrade on 24/06/2017.
 */
@Entity
public class Person extends BaseEntity {
    String firstName;
    String lastName;
    Date birthDay;
    Long registerNumber;
    String picture;
    String job;
    @OneToOne(cascade = CascadeType.ALL)
    Contact contact;
    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    public Person() {
    }

    public Person(String firstName, String lastName, Date birthDay, Long registerNumber, String picture, String job, Contact contact, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.registerNumber = registerNumber;
        this.picture = picture;
        this.job = job;
        this.contact = contact;
        this.address = address;
    }

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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Long getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(Long registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
