package models;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table (name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private char number;
    private String name;
    private boolean gender;
    private short age;

    @Column(name = "prefer_gender")
    private boolean preferGender;

    @Column(name = "prefer_age_from")
    private boolean preferAgeFrom;

    @Column(name = "prefer_age_to")
    private boolean preferAgeTo;

    private String password;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private ArrayList<AnswersHistory> answers;

    public User(String email, char number, String name, boolean gender, short age, boolean preferGender, boolean preferAgeFrom, boolean preferAgeTo, String password) {
        this.email = email;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.preferGender = preferGender;
        this.preferAgeFrom = preferAgeFrom;
        this.preferAgeTo = preferAgeTo;
        this.password = password;
//        answers = new ArrayList<AnswersHistory>();
    }

//    public void addAnswer(Answer answer) {
//    }

    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", preferGender=" + preferGender +
                ", preferAgeFrom='" + preferAgeFrom + '\'' +
                ", preferAgeTo=" + preferAgeTo +
                '}';
    }
}
