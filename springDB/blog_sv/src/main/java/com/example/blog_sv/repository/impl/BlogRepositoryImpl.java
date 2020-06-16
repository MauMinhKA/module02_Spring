package com.example.blog_sv.repository.impl;

import com.example.blog_sv.model.BlogSV;
import com.example.blog_sv.repository.BlogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BlogRepositoryImpl implements BlogRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BlogSV> getAll() {
        TypedQuery<BlogSV> query = entityManager.createQuery("select c from BlogSV c", BlogSV.class);
        return query.getResultList();
    }

    @Override
    public BlogSV getById(Long id) {
        TypedQuery<BlogSV> query = entityManager.createQuery("select  c from BlogSV c where c.id=:id", BlogSV.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void DeleteById(Long id) {
        BlogSV blogSV = getById(id);
        if (blogSV != null) {
            entityManager.remove(blogSV);
        }
    }

    @Override
    public void Save(BlogSV blogSV) {
        if (blogSV.getId() != null) {
            entityManager.merge(blogSV);
        } else {
            entityManager.persist(blogSV);
        }
    }

    @Override
    public void update(Long id, BlogSV blogSV) {
        entityManager.merge(blogSV);
    }
}
