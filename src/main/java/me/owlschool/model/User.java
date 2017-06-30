package me.owlschool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.owlschool.model.BaseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class User extends BaseEntity {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String[] roles;
    @ManyToOne
    private School school;

    protected User(){
        super();
    }

    public User(String email, String password, String[] roles) {
        this();
        this.email = email;
        this.setPassword(password);
        this.roles = roles;
    }

    public User(String email, String password, String[] roles, School school) {
        this();
        this.email = email;
        this.setPassword(password);
        this.roles = roles;
        this.school = school;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String getPassword() {
        return password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
