package com.butoosa.linkapp.models;

public class Links {
    private String title;
    private String link;
    private String description;
    private String id;

    public Links() {
    }

    public Links(String id, String title, String link, String description) {
        this.id = id;
        this.description = description;
        this.link = link;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
