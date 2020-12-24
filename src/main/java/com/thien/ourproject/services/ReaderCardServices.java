package com.thien.ourproject.services;

import com.thien.ourproject.pojo.People;
import com.thien.ourproject.pojo.Reader;
import com.thien.ourproject.pojo.ReaderCard;
import com.thien.ourproject.pojo.StaffType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ReaderCardServices {
    private final static SessionFactory factory = HibernateUtils.getFACTORY();

    public List<ReaderCard> getAll() {
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery();
            Root<StaffType> root = query.from(ReaderCard.class);

            query = query.select(root);

            Query q = session.createQuery(query);
            return q.getResultList();
        }
    }

    public ReaderCard getById(int id) {
        try ( Session session = factory.openSession()) {
            return session.get(ReaderCard.class, id);
        }
    }

    public ReaderCard getById(String id) {
        return this.getById(Integer.parseInt(id));
    }

    public boolean addOrSave(ReaderCard card) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.saveOrUpdate(card);
                session.getTransaction().commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
                return false;
            }
        }

        return true;
    }
    public boolean delete(ReaderCard card) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.delete(card);
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
