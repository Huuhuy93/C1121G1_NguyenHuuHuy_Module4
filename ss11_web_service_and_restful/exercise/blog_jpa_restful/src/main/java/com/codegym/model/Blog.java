package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
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
    @Column(name = "create_time", columnDefinition = "datetime")
    private String createTime;

    @ManyToOne
    @JoinColumn(name = "catalogue_id", referencedColumnName = "id")
    private Catalogue catalogue;

    public Blog() {
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }
}
