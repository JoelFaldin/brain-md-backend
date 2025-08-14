package com.example.brainmd.note.dto;

import jakarta.validation.constraints.NotBlank;

public class NoteDto {

    @NotBlank(message = "Title can't be empty!")
    private String title;

    private String content;

    protected NoteDto() {}

    public NoteDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters and setters:
    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent() {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format(
                "Note {\n" +
                    " title: '" + this.title + "', \n" +
                    " content: '" + this.content + "', \n" +
                    "}"
        );
    }
}
