package com.codegym.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "author_blog")
    private String authorBlog;
    @Column(name = "title_blog")
    private String titleBlog;
    @Column(name = "content_blog")
    private String contentBlog;

    public Blog() {
    }

    public Blog(Integer id, String authorBlog, String titleBlog, String contentBlog) {
        this.id = id;
        this.authorBlog = authorBlog;
        this.titleBlog = titleBlog;
        this.contentBlog = contentBlog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorBlog() {
        return authorBlog;
    }

    public void setAuthorBlog(String authorBlog) {
        this.authorBlog = authorBlog;
    }

    public String getTitleBlog() {
        return titleBlog;
    }

    public void setTitleBlog(String titleBlog) {
        this.titleBlog = titleBlog;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String contentBlog) {
        this.contentBlog = contentBlog;
    }
}
