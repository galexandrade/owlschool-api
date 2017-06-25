package me.owlschool.model;

import javax.persistence.Entity;

/**
 * Created by Alex P. Andrade on 25/06/2017.
 */
@Entity
public class Permission extends BaseEntity {
    Boolean canCreateEvent;
    Boolean canCreateNews;
    Boolean canChat;
    Boolean canUpdateSchool;
    Boolean canUpdateStudent;
    Boolean canCreateStudent;
    Boolean canUpdateClass;
    Boolean canCreateClass;

    public Permission() {
    }

    public Permission(Boolean canCreateEvent, Boolean canCreateNews, Boolean canChat, Boolean canUpdateSchool, Boolean canUpdateStudent, Boolean canCreateStudent, Boolean canUpdateClass, Boolean canCreateClass) {
        this.canCreateEvent = canCreateEvent;
        this.canCreateNews = canCreateNews;
        this.canChat = canChat;
        this.canUpdateSchool = canUpdateSchool;
        this.canUpdateStudent = canUpdateStudent;
        this.canCreateStudent = canCreateStudent;
        this.canUpdateClass = canUpdateClass;
        this.canCreateClass = canCreateClass;
    }

    public Boolean getCanCreateEvent() {
        return canCreateEvent;
    }

    public void setCanCreateEvent(Boolean canCreateEvent) {
        this.canCreateEvent = canCreateEvent;
    }

    public Boolean getCanCreateNews() {
        return canCreateNews;
    }

    public void setCanCreateNews(Boolean canCreateNews) {
        this.canCreateNews = canCreateNews;
    }

    public Boolean getCanChat() {
        return canChat;
    }

    public void setCanChat(Boolean canChat) {
        this.canChat = canChat;
    }

    public Boolean getCanUpdateSchool() {
        return canUpdateSchool;
    }

    public void setCanUpdateSchool(Boolean canUpdateSchool) {
        this.canUpdateSchool = canUpdateSchool;
    }

    public Boolean getCanUpdateStudent() {
        return canUpdateStudent;
    }

    public void setCanUpdateStudent(Boolean canUpdateStudent) {
        this.canUpdateStudent = canUpdateStudent;
    }

    public Boolean getCanCreateStudent() {
        return canCreateStudent;
    }

    public void setCanCreateStudent(Boolean canCreateStudent) {
        this.canCreateStudent = canCreateStudent;
    }

    public Boolean getCanUpdateClass() {
        return canUpdateClass;
    }

    public void setCanUpdateClass(Boolean canUpdateClass) {
        this.canUpdateClass = canUpdateClass;
    }

    public Boolean getCanCreateClass() {
        return canCreateClass;
    }

    public void setCanCreateClass(Boolean canCreateClass) {
        this.canCreateClass = canCreateClass;
    }
}
