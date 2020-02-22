package com.tenquestions.models;

import javax.persistence.*;

@Entity
@Table(name = "answers_history")
public class AnswersHistory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer")
    private Answer answer;

    public AnswersHistory() {
    }

    public AnswersHistory(User user, Question question, Answer answer) {
        this.user = user;
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "models.AnswerHistory{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", answer=" + answer +
                '}';
    }
}
