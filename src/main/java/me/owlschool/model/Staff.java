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
    @OneToOne(cascade = CascadeType.ALL)
    User user;
    @OneToOne(cascade = CascadeType.ALL)
    Permission permission;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable
    List<Matter> matters;

    private String function;

    public Staff() {
    }

    public Staff(Person person, User user, Permission permission, String function) {
        this.person = person;
        this.user = user;
        this.permission = permission;
        this.function = function;
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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public List<Matter> getMatters() {
        return matters;
    }

    public void setMatters(List<Matter> matters) {
        this.matters = matters;
    }
}
