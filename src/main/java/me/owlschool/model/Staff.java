package me.owlschool.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alex P. Andrade on 24/06/2017.
 */
@Entity
public class Staff extends BaseEntity {
    @OneToOne(cascade = CascadeType.ALL)
    Person person;
    @OneToOne(cascade = CascadeType.MERGE)
    User user;
    @OneToOne(cascade = CascadeType.ALL)
    Permission permission;

    public Staff() {
    }

    public Staff(Person person, User user, Permission permission) {
        this.person = person;
        this.user = user;
        this.permission = permission;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
