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
    String name;
    Date birthDay;
    Long registerNumber;
    @OneToOne(cascade = CascadeType.ALL)
    Contact contact;
    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    public Person() {
    }

    public Person(String name, Date birthDay, Long registerNumber, Contact contact, Address address) {
        this.name = name;
        this.birthDay = birthDay;
        this.registerNumber = registerNumber;
        this.contact = contact;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
