package com.model;

import javax.persistence.*;

@Entity(name = "comment_picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "rating_picture")
    private Integer ratingPicture;
    @Column(name = "author_picture")
    private String authorPicture;
    @Column(name = "feedback_picture")
    private String feedbackPicture;
    @Column(name = "like_picture")
    private String likePicture;

    public Picture() {
    }

    public Picture(Integer id, Integer ratingPicture, String authorPicture, String feedbackPicture, String likePicture) {
        this.id = id;
        this.ratingPicture = ratingPicture;
        this.authorPicture = authorPicture;
        this.feedbackPicture = feedbackPicture;
        this.likePicture = likePicture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRatingPicture() {
        return ratingPicture;
    }

    public void setRatingPicture(Integer ratingPicture) {
        this.ratingPicture = ratingPicture;
    }

    public String getAuthorPicture() {
        return authorPicture;
    }

    public void setAuthorPicture(String authorPicture) {
        this.authorPicture = authorPicture;
    }

    public String getFeedbackPicture() {
        return feedbackPicture;
    }

    public void setFeedbackPicture(String feedbackPicture) {
        this.feedbackPicture = feedbackPicture;
    }

    public String getLikePicture() {
        return likePicture;
    }

    public void setLikePicture(String likePicture) {
        this.likePicture = likePicture;
    }
}
