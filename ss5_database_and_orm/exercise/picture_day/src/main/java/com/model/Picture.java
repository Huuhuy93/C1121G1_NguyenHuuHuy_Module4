package com.model;

import javax.persistence.*;

@Entity(name = "comment_picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer rating;
    private String author;
    private String feedback;
    private String like;

    public Picture() {
    }

    public Picture(Integer id, Integer rating, String author, String feedback, String like) {
        this.id = id;
        this.rating = rating;
        this.author = author;
        this.feedback = feedback;
        this.like = like;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

}
