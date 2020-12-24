package com.thien.ourproject.services;

import com.thien.ourproject.pojo.Reader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class ReaderServices {
    private final static SessionFactory factory = HibernateUtils.getFACTORY();

    public List<Reader> getAll(String kw) {
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery();
            Root<Reader> root = query.from(Reader.class);

            query = query.select(root);

            if (kw != null && !kw.isEmpty()) {
                String p = String.format("%%%s%%", kw);
                Predicate p1 = builder.like(root.get("people").get("lastname").as(String.class), p);
                Predicate p2 = builder.like(root.get("people").get("firstname").as(String.class), p);
                Predicate p3 = builder.like(root.get("people").get("gender").as(String.class), p);
                Predicate p4 = builder.like(root.get("people").get("contact").as(String.class), p);
                Predicate p5 = builder.like(root.get("people").get("address").as(String.class), p);

                query = query.where(builder.or(p1, p2, p3, p4, p5));
            }

            return session.createQuery(query).getResultList();
        }
    }

    public Reader getById(int id) {
        try ( Session session = factory.openSession()) {
            return session.get(Reader.class, id);
        }
    }

    public boolean addOrSave(Reader reader) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.saveOrUpdate(reader);
                session.getTransaction().commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
                return false;
            }
        }

        return true;
    }

    public boolean delete(Reader reader) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.delete(reader);
                session.getTransaction().commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
                return false;
            }
        }

        return true;
    }
}
