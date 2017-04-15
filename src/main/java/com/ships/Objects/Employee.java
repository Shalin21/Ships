package com.ships.Objects;

//import org.hibernate.annotations.GenerationTime;
//import javax.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import javax.annotation.Generated;
import javax.persistence.*;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.MonthDay;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by admin on 04.04.17.
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String login;
    private String password;
    private String email;
    private boolean active;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Employee() {}
    public Employee(String fname, String lname, String email, boolean active) {
        this.login = fname;
        this.password = lname;
        this.email=email;
        this.active=active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
