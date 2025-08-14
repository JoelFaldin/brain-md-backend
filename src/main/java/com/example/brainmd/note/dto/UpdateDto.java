package com.example.brainmd.note.dto;

public class UpdateDto {

    private String title;
    private String content;

    protected UpdateDto() {}

    public UpdateDto(String title, String content) {
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

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format(
                "Note: {\n" +
                        " title: " + this.title + "\n" +
                        " content: " + this.content + "\n" +
                        "}"
        );
    }
}
