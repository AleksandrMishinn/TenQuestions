package models;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int question;
    private String text;
    private boolean active;

    public Answer(int question, String text, boolean active) {
        this.question = question;
        this.text = text;
        this.active = active;
    }

    @Override
    public String toString() {
        return "models.Answer{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", text=" + text +
                ", active=" + active +
                '}';
    }
}
