package com.thien.ourproject.services;

import com.thien.ourproject.pojo.Category;
import com.thien.ourproject.pojo.StaffType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author nguye
 */
public class StaffTypeServices {

    private final static SessionFactory factory = HibernateUtils.getFACTORY();

    public List<StaffType> getAll() {
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery();
            Root<StaffType> root = query.from(StaffType.class);
            
            query = query.select(root);
            
            Query q = session.createQuery(query);
            return q.getResultList();
        }
    }
    
    public StaffType getById(int id) {
          try ( Session session = factory.openSession()) {
              return session.get(StaffType.class, id);
          }
    }
    
    public StaffType getById(String id) {
        return this.getById(Integer.parseInt(id));
    }
}