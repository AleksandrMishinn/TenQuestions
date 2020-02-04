package models;

import javax.persistence.*;

@Entity
@Table (name = "users")
public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



}
