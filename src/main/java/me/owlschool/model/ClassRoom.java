package me.owlschool.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created by Alex P. Andrade on 25/06/2017.
 */
@Entity
public class ClassRoom extends BaseEntity {
    String name;
    String period;
    @OneToOne
    Teacher mainTeacher;
    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.MERGE)
    List<Student> students;
    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    List<ClassRoomTeacherMatter> classRoomTeacherMatters;

    public ClassRoom() {
    }

    public ClassRoom(String name, String period) {
        this.name = name;
        this.period = period;
    }

    public ClassRoom(String name, String period, Teacher mainTeacher) {
        this.name = name;
        this.period = period;
        this.mainTeacher = mainTeacher;
    }

    public ClassRoom(String name, String period, Teacher mainTeacher, List<Student> students, List<ClassRoomTeacherMatter> classRoomTeacherMatters) {
        this.name = name;
        this.period = period;
        this.mainTeacher = mainTeacher;
        this.students = students;
        this.classRoomTeacherMatters = classRoomTeacherMatters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Teacher getMainTeacher() {
        return mainTeacher;
    }

    public void setMainTeacher(Teacher mainTeacher) {
        this.mainTeacher = mainTeacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<ClassRoomTeacherMatter> getClassRoomTeacherMatters() {
        return classRoomTeacherMatters;
    }

    public void setClassRoomTeacherMatters(List<ClassRoomTeacherMatter> classRoomTeacherMatters) {
        this.classRoomTeacherMatters = classRoomTeacherMatters;
    }
}
