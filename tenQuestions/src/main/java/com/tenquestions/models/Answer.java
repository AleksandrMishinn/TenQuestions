package com.tenquestions.models;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;
    private boolean active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question")
    private Question question;

    public Answer() {
    }

    public Answer(Question question, String text, boolean active) {
        this.question = question;
        this.text = text;
        this.active = active;
    }

    @Override
    public String toString() {

        return "{" +
                "\"id\" : " + id +
                ", \"text\" : \"" + text + "\"" +
                ", \"active\" : \"" + active + "\"" +
                ", \"question\" : " + question +
                '}';

    }
}
