package com.service.impl;

import com.model.Picture;
import com.repository.IPictureRepository;
import com.repository.impl.PictureRepositoryImpl;
import com.service.IPictureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService implements IPictureService {
    private IPictureRepository iPictureRepository = new PictureRepositoryImpl();
    @Override
    public void save(Picture picture) {
        iPictureRepository.save(picture);
    }

    @Override
    public List<Picture> findAll() {
        return iPictureRepository.findAll();
    }
}
