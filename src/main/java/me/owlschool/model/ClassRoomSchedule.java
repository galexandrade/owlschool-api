package me.owlschool.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Alex P. Andrade on 25/06/2017.
 */
@Entity
public class ClassRoomSchedule extends BaseEntity {
    @OneToMany
    List<Matter> sunday;
    @OneToMany
    List<Matter> monday;
    @OneToMany
    List<Matter> tuesday;
    @OneToMany
    List<Matter> wednesday;
    @OneToMany
    List<Matter> thursday;
    @OneToMany
    List<Matter> friday;
    @OneToMany
    List<Matter> saturday;

    public ClassRoomSchedule() {
    }

    public ClassRoomSchedule(List<Matter> sunday, List<Matter> monday, List<Matter> tuesday, List<Matter> wednesday, List<Matter> thursday, List<Matter> friday, List<Matter> saturday) {
        this.sunday = sunday;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
    }

    public List<Matter> getSunday() {
        return sunday;
    }

    public void setSunday(List<Matter> sunday) {
        this.sunday = sunday;
    }

    public List<Matter> getMonday() {
        return monday;
    }

    public void setMonday(List<Matter> monday) {
        this.monday = monday;
    }

    public List<Matter> getTuesday() {
        return tuesday;
    }

    public void setTuesday(List<Matter> tuesday) {
        this.tuesday = tuesday;
    }

    public List<Matter> getWednesday() {
        return wednesday;
    }

    public void setWednesday(List<Matter> wednesday) {
        this.wednesday = wednesday;
    }

    public List<Matter> getThursday() {
        return thursday;
    }

    public void setThursday(List<Matter> thursday) {
        this.thursday = thursday;
    }

    public List<Matter> getFriday() {
        return friday;
    }

    public void setFriday(List<Matter> friday) {
        this.friday = friday;
    }

    public List<Matter> getSaturday() {
        return saturday;
    }

    public void setSaturday(List<Matter> saturday) {
        this.saturday = saturday;
    }
}
