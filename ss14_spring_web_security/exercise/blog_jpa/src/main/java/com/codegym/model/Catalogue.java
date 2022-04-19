package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "catalogues")
public class Catalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameCatalogue;

    @OneToMany(mappedBy = "catalogue")
    private List<Blog> blogs;

    public Catalogue() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCatalogue() {
        return nameCatalogue;
    }

    public void setNameCatalogue(String nameCatalogue) {
        this.nameCatalogue = nameCatalogue;
    }
}
