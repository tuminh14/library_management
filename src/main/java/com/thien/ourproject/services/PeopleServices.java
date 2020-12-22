/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.services;

import com.thien.ourproject.pojo.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PeopleServices {

    private final static SessionFactory factory = HibernateUtils.getFACTORY();

    public List<People> getAll(String kw) {
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery();
            Root<People> root = query.from(People.class);

            query = query.select(root);

//            if (kw != null && !kw.isEmpty()) {
//                String p = String.format("%%%s%%", kw);
//                Predicate p1 = builder.like(root.get("bookTitle").as(String.class), p);
//                Predicate p2 = builder.like(root.get("author").as(String.class), p);
//
//                query = query.where(builder.or(p1, p2));
//                System.out.println("test");
//            }

            return session.createQuery(query).getResultList();
        }
    }

    public People getById(int id) {
        try ( Session session = factory.openSession()) {
            return session.get(People.class, id);
        }
    }

    public People addOrSave(People people) {
        People resultPeople = null;
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.saveOrUpdate(people);
                session.getTransaction().commit();
                resultPeople = people;
            } catch (Exception ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
            }
        }

        return resultPeople;
    }
    
    public boolean delete(People people) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.delete(people);
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
