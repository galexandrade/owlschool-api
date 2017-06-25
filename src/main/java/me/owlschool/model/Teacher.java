package me.owlschool.model;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alex P. Andrade on 25/06/2017.
 */
@Entity
public class Teacher extends BaseEntity {
    @OneToOne
    Staff staff;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    List<Matter> matters;

    public Teacher() {
    }

    public Teacher(Staff staff, List<Matter> matters) {
        this.staff = staff;
        this.matters = matters;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<Matter> getMatters() {
        return matters;
    }

    public void setMatters(List<Matter> matters) {
        this.matters = matters;
    }
}
