package me.owlschool.model;

import javax.persistence.*;

/**
 * Created by Alex P. Andrade on 25/06/2017.
 */
@Entity
public class ClassRoomTeacherMatter extends BaseEntity {
    @OneToOne(cascade = CascadeType.MERGE)
    Teacher teacher;
    @OneToOne(cascade = CascadeType.MERGE)
    Matter matter;
    @ManyToOne
    ClassRoom classRoom;

    public ClassRoomTeacherMatter() {
    }

    public ClassRoomTeacherMatter(Teacher teacher, Matter matter, ClassRoom classRoom) {
        this.teacher = teacher;
        this.matter = matter;
        this.classRoom = classRoom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Matter getMatter() {
        return matter;
    }

    public void setMatter(Matter matter) {
        this.matter = matter;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
