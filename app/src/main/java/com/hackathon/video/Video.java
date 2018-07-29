package com.hackathon.video;

public class Video {
    private int id;
    private String link;

    public Video(int id, String link) {
        this.id = id;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
