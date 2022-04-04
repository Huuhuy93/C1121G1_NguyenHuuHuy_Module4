package com.repository.impl;

import com.model.Picture;
import com.repository.BaseRepository;
import com.repository.IPictureRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PictureRepositoryImpl implements IPictureRepository {
    @Override
    public void save(Picture picture) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if (picture.getId() == null) {
            BaseRepository.entityManager.persist(picture);
        }
        entityTransaction.commit();
    }

    @Override
    public List<Picture> findAll() {

        TypedQuery<Picture> typedQuery = BaseRepository.entityManager.createQuery("select p " +
                                                                        "from comment_picture p", Picture.class);
        return typedQuery.getResultList();
    }
}
