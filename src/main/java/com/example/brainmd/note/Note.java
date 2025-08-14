package com.example.brainmd.note;

import jakarta.persistence.*;

@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    protected Note() {}

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters and setters:
    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format(
            "Note {\n" +
                    " id: '" + this.id + "', \n" +
                    " title: '" + this.title + "', \n" +
                    " content: '" + this.content + "', \n" +
                    "}"
        );
    }
}
