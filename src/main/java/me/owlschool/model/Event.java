package me.owlschool.model;

import org.springframework.aop.target.LazyInitTargetSource;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 * Created by Alex P. Andrade on 25/06/2017.
 */
@Entity
public class Event extends BaseEntity {
    String title;
    Date date;
    String description;
    @ManyToOne
    ClassRoom classRoom;
    @OneToMany(cascade = CascadeType.ALL)
    List<Image> images;

    public Event() {
    }

    public Event(String title, Date date) {
        this.title = title;
        this.date = date;
    }

    public Event(String title, Date date, String description, ClassRoom classRoom, List<Image> images) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.classRoom = classRoom;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
