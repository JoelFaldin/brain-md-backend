package com.example.brainmd.user;

import com.example.brainmd.note.Note;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String picture;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes;

    protected User() {}

    public User(String name, String email, String picture) {
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    // Getters and setters:
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return String.format(
                "User {\n" +
                        " id: '" + this.id + "', \n" +
                        " name: '" + this.name + "', \n" +
                        " email: '" + this.email + "', \n" +
                        " picture: '" + this.picture + "', \n" +
                        "}"
        );
    }
}
