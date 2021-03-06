package com.tenquestions.models;

import javax.persistence.*;
import java.util.Map;


@Entity
@Table (name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String number;
    private String name;
    private short age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition="enum('male','female')")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "prefer_gender", columnDefinition="enum('male','female')")
    private Gender preferGender;

    @Column(name = "prefer_age_from")
    private int preferAgeFrom;

    @Column(name = "prefer_age_to")
    private int preferAgeTo;

    private String password;

    public int getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setGender(String gender) {
        this.gender = Gender.valueOf(gender.toUpperCase());
    }

    public void setPreferGender(Gender preferGender) {
        this.preferGender = preferGender;
    }

    public void setPreferGender(String gender) {
        this.gender = Gender.valueOf(gender.toUpperCase());
    }

    public void setPreferAgeFrom(int preferAgeFrom) {
        this.preferAgeFrom = preferAgeFrom;
    }

    public void setPreferAgeTo(int preferAgeTo) {
        this.preferAgeTo = preferAgeTo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String email, String number, String name, Gender gender, short age, Gender preferGender, int preferAgeFrom, int preferAgeTo, String password) {
        this.email = email;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.preferGender = preferGender;
        this.preferAgeFrom = preferAgeFrom;
        this.preferAgeTo = preferAgeTo;
        this.password = password;
    }

    public User(Map<String, String> data){
        this.email = data.get("email");
        this.number = data.get("number");
        this.name = data.get("name");
        this.gender = Gender.valueOf(data.get("gender"));
        this.age = Short.parseShort(data.get("age"));
        this.preferGender = Gender.valueOf(data.get("preferGender"));
        this.preferAgeFrom = Integer.parseInt(data.get("preferAgeFrom"));
        this.preferAgeTo = Integer.parseInt(data.get("preferAgeTo"));
        this.password = data.get("password");
    }



    @Override
    public String toString() {
        return "{" +
                "\"id\" : " + id +
                ", \"email\" : \"" + email + "\"" +
                ", \"number\" : \"" + number + "\"" +
                ", \"name\" : \"" + name + "\"" +
                ", \"age\" : " + age +
                ", \"gender\" : \"" + gender + "\"" +
                ", \"preferGender\" : \"" + preferGender + "\"" +
                ", \"preferAgeFrom\" : " + preferAgeFrom +
                ", \"preferAgeTo\" : " + preferAgeTo +
                '}';
    }

    private enum Gender{male, female};

}
