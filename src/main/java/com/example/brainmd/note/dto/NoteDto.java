package com.example.brainmd.note.dto;

import jakarta.validation.constraints.NotBlank;

public class NoteDto {

    @NotBlank(message = "Title can't be empty!")
    private String title;
    private String content;
    private String userEmail;

    protected NoteDto() {}

    public NoteDto(String title, String content, String userEmail) {
        this.title = title;
        this.content = content;
        this.userEmail = userEmail;
    }

    // Getters and setters:
    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getUserEmail() { return this.userEmail; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
