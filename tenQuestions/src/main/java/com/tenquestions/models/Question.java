package com.tenquestions.models;

import javax.persistence.*;

@Entity
@Table(name = "answers_history")
public class Question {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;
    private String theme;
    private boolean active;

    public Question() {
    }

    public Question(String text, String theme, boolean active) {
        this.text = text;
        this.theme = theme;
        this.active = active;
    }

    @Override
    public String toString() {
        return "models.AnswerHistory{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", theme=" + theme +
                ", active=" + active +
                '}';
//
    }

}
