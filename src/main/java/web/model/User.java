package web.model;
import com.mysql.cj.protocol.x.XMessage;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Pattern(
            regexp = "^[A-Za-zА-Яа-яЁё]+$",
            message = "Name must contain oly letters"
    )
    private String name;

    @NotNull
    @Pattern(
            regexp = "^[A-Za-zА-Яа-яЁё]+$",
            message = "Name must contain oly letters"
    )
    private String surname;

    @NotNull
    @Min(value = 1, message = "Age must be greater than 0")
    @Max(value = 120, message = "Age must be less than 120")
    private int age;

    @NotNull
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-@]+(\\.com)$",
            message = "Email must end with .com"
    )
    private String email;

    public User() {    }

    public User(String name, String surname, int age, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}
}
