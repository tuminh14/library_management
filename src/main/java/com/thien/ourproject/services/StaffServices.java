/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.services;

import com.thien.ourproject.pojo.Staff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class StaffServices {

    private final static SessionFactory factory = HibernateUtils.getFACTORY();

    public List<Staff> getAll(String kw) {
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery();
            Root<Staff> root = query.from(Staff.class);

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

    public Staff getById(int id) {
        try ( Session session = factory.openSession()) {
            return session.get(Staff.class, id);
        }
    }

    public boolean addOrSave(Staff staff) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.saveOrUpdate(staff);
                session.getTransaction().commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
                return false;
            }
        }

        return true;
    }
    
    public boolean delete(Staff staff) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.delete(staff);
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
