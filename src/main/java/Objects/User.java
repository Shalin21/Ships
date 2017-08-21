package Objects;


import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;

    private String Login;
    private String Password;
    private String Name;

    public User(){}

    public User( String login, String password, String name) {
        Login = login;
        Password = password;
        Name = name;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public String getLogin() {
        return Login;
    }
    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
}
