package me.owlschool.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alex P. Andrade on 24/06/2017.
 */
@Entity
public class Parent extends BaseEntity {
    @OneToOne(cascade = CascadeType.ALL)
    Person person;
    @ManyToMany(mappedBy = "parents",cascade = CascadeType.ALL)
    //@JoinTable(name = "student_parent", joinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    List<Student> students;

    String relationship;

    /*@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    List<StudentParent> students;
    */

    public Parent() {
    }

    public Parent(Person person, String relationship) {
        this.person = person;
        this.relationship = relationship;
    }

    public Parent(Person person, List<Student> students, String relationship) {
        this.person = person;
        this.students = students;
        this.relationship = relationship;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
