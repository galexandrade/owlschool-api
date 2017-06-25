package me.owlschool.model;

import javax.persistence.Entity;

/**
 * Created by Alex P. Andrade on 24/06/2017.
 */
@Entity
public class Contact extends BaseEntity {
    String email;
    String phone;
    String website;

    public Contact() {
    }

    public Contact(String email, String phone, String website) {
        this.email = email;
        this.phone = phone;
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
