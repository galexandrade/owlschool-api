package me.owlschool.model;

import javax.persistence.Entity;

/**
 * Created by Alex P. Andrade on 25/06/2017.
 */
@Entity
public class Image extends BaseEntity {
    String name;
    String fullPath;

    public Image() {
    }

    public Image(String name, String fullPath) {
        this.name = name;
        this.fullPath = fullPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }
}
