package Objects;

//import org.hibernate.annotations.GenerationTime;
//import javax.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.beans.property.*;
import sun.java2d.pipe.SpanShapeRenderer;

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
@Access(value = AccessType.PROPERTY)
public class Employee {

    private int id;

    private SimpleStringProperty login = new SimpleStringProperty();
    private SimpleStringProperty password = new SimpleStringProperty();
    private SimpleStringProperty email = new SimpleStringProperty();
    private SimpleBooleanProperty active = new SimpleBooleanProperty();

    public StringProperty emailProperty(){return email;}
    public String getEmail() {
        return email.get();
    }
    public void setEmail(String email) {
        this.email.set(email);
    }

    public BooleanProperty activeProperty(){return active;}
    public boolean getActive() {
        return active.get();
    }
    public void setActive(boolean active) {
        this.active.set(active);
    }

    public Employee() {}
    public Employee(String login, String password, String email, boolean active) {
        this.login.set(login);
        this.password.set(password);
        this.email.set(email);
        this.active.set(active);
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
   // public IntegerProperty idProperty(){return id;}
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
    }

    public StringProperty loginProperty(){return login;}
    public String getLogin() {
        return login.get();
    }
    public void setLogin(String login) {
        this.login.set(login);
    }

    public StringProperty passwordProperty(){return password;}
    public String getPassword() {
        return password.get();
    }
    public void setPassword(String password) {
        this.password.set(password);
    }

}
