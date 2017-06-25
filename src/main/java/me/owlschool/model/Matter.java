package me.owlschool.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by Alex P. Andrade on 25/06/2017.
 */
@Entity
public class Matter extends BaseEntity {
    String matterName;
    @ManyToMany(mappedBy = "matters",cascade = CascadeType.ALL)
    List<Teacher> teachers;

    public Matter() {
    }

    public Matter(String matterName) {
        this.matterName = matterName;
    }

    public Matter(String matterName, List<Teacher> teachers) {
        this.matterName = matterName;
        this.teachers = teachers;
    }

    public String getMatterName() {
        return matterName;
    }

    public void setMatterName(String matterName) {
        this.matterName = matterName;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeacher(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
