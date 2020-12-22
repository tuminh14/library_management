package com.thien.ourproject.services;

import com.thien.ourproject.pojo.Book;
import com.thien.ourproject.pojo.Category;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author nguye
 */
public class CategoryServices {

    private final static SessionFactory factory = HibernateUtils.getFACTORY();

    public List<Category> getCates() {
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery();
            Root<Category> root = query.from(Category.class);
            
            query = query.select(root);
            
            Query q = session.createQuery(query);
            return q.getResultList();
        }
    }
    
    public Category getCateById(int id) {
          try ( Session session = factory.openSession()) {
              return session.get(Category.class, id);
          }
    }
    
    public Category getCateById(String id) {
        return this.getCateById(Integer.parseInt(id));
    }

    public List<Category> getTopCategories(int max) {
        try (Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery();
            Root<Category> root = query.from(Category.class);
            query = query.select(root);
            return session.createQuery(query)
                    .setMaxResults(max)
                    .getResultList();
        }
    }

}