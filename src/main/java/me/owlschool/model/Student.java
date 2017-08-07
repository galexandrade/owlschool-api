package me.owlschool.model;

import me.owlschool.model.BaseEntity;
import me.owlschool.model.Parent;
import me.owlschool.model.Person;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alex P. Andrade on 24/06/2017.
 */
@Entity
public class Student extends BaseEntity {
    @OneToOne(cascade = CascadeType.ALL)
    Person person;

    @ManyToMany(cascade = CascadeType.PERSIST)
    //@JoinTable(name = "student_parent", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "id"))
    @JoinTable
    List<Parent> parents;

    @ManyToOne
    ClassRoom classRoom;

    public Student() {
    }

    public Student(Person person, ClassRoom classRoom) {
        this.person = person;
        this.classRoom = classRoom;
    }

    public Student(Person person, ClassRoom classRoom, List<Parent> parents) {
        this.person = person;
        this.classRoom = classRoom;
        this.parents = parents;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }
}
