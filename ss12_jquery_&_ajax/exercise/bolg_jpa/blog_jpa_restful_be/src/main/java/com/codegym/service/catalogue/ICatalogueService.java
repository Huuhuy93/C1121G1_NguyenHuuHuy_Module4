package com.codegym.service.catalogue;

import com.codegym.model.Blog;
import com.codegym.model.Catalogue;

import java.util.List;
import java.util.Optional;

public interface ICatalogueService {
    public Iterable<Catalogue> findAll();

    public Optional<Catalogue> findById(Integer id);

    public void save(Catalogue catalogue);

    public void remove(Integer id);
}
