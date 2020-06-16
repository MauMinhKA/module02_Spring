package com.example.customermanager.repository.impl;

import com.example.customermanager.models.Product;
import com.example.customermanager.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = em.createQuery("select c from Product c", Product.class);
        return query.getResultList();
    }

    @Override
    public Product getById(Long id) {
        TypedQuery<Product> query = em.createQuery("select c from Product c where  c.id=:id", Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void DeleteById(Long id) {
        Product product = getById(id);
        if(product != null){
            em.remove(product);
        }
    }


    @Override
    public void save(Product product) {
        if(product.getId()!= null){
            em.merge(product);
        } else {
            em.persist(product);
        }
    }

    @Override
    public void update(Long id, Product product) {
        em.merge(product);
    }
}
