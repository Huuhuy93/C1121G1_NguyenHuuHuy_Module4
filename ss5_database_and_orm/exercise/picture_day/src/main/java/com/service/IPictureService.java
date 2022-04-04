package com.service;

import com.model.Picture;

import java.util.List;

public interface IPictureService {
    public void save(Picture picture);

    public List<Picture> findAll();
}
