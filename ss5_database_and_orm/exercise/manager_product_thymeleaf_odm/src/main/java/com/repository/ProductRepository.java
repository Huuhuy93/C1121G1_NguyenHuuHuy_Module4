package com.repository;

import com.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> tyleQuery = BaseRepository.entityManager.createQuery("select p " +
                                                                                        "from product p ", Product.class);
        return tyleQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if (product.getId() == null) {
            BaseRepository.entityManager.persist(product);
        }
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> tyleQuery = BaseRepository.entityManager.createQuery("select p " +
                                                                                        "from product p " +
                                                                                        "where p.id= ?1", Product.class);
        tyleQuery.setParameter(1, id);
        return tyleQuery.getSingleResult();
    }

    @Override
    public void update(int id, Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();

    }

    @Override
    public void remove(int id) {
        Product product = this.findById(id);
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> searchByName(String name) {

        TypedQuery<Product> tyleQuery = BaseRepository.entityManager.createQuery("select p " +
                "from product p " +
                "where p.nameProduct= ?1", Product.class);
        tyleQuery.setParameter(1, name);
        return tyleQuery.getResultList();
    }

}
