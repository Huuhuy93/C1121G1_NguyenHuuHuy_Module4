package com.repository;

import com.model.Picture;

import java.util.List;

public interface IPictureRepository {
    public void save(Picture picture);

    public List<Picture> findAll();
}
