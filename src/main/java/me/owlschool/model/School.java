package me.owlschool.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by Alex P. Andrade on 24/06/2017.
 */
@Entity
public class School extends BaseEntity {
    String name;
    String companyRegistration;
    @OneToOne(cascade = CascadeType.ALL)
    Contact contact;
    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    public School() {
    }

    public School(String name, String companyRegistration, Contact contact, Address address) {
        this.name = name;
        this.companyRegistration = companyRegistration;
        this.contact = contact;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyRegistration() {
        return companyRegistration;
    }

    public void setCompanyRegistration(String companyRegistration) {
        this.companyRegistration = companyRegistration;
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
