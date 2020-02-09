package com.tenquestions.models;

import javax.persistence.*;



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
    private short age;


    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition="enum('male','female')")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "prefer_gender", columnDefinition="enum('male','female')")
    private Gender preferGender;

    @Column(name = "prefer_age_from")
    private boolean preferAgeFrom;

    @Column(name = "prefer_age_to")
    private boolean preferAgeTo;

    private String password;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private ArrayList<AnswersHistory> answers;

    public User(String email, char number, String name, Gender gender, short age, Gender preferGender, boolean preferAgeFrom, boolean preferAgeTo, String password) {
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

    public User(){
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

    private enum Gender{male, female};

}
