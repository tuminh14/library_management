package com.thien.ourproject.services;

import com.thien.ourproject.pojo.BookBorrowed;
import com.thien.ourproject.pojo.Staff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookBorrowedServices {
    private final static SessionFactory factory = HibernateUtils.getFACTORY();

    public List<BookBorrowed> getAll(String kw) {
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery();
            Root<BookBorrowed> root = query.from(BookBorrowed.class);

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

    public BookBorrowed getById(int id) {
        try ( Session session = factory.openSession()) {
            return session.get(BookBorrowed.class, id);
        }
    }

    public boolean addOrSave(BookBorrowed bookBorrowed) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.saveOrUpdate(bookBorrowed);
                session.getTransaction().commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
                return false;
            }
        }

        return true;
    }

    public boolean delete(BookBorrowed bookBorrowed) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.delete(bookBorrowed);
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
