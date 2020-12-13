/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.services;

import com.thien.ourproject.pojo.Book;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BookServices {
    private final static SessionFactory factory = HibernateUtils.getFACTORY();
    
    public List<Book> getBooks(String kw){
        try (Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery();
            Root<Book> root = query.from(Book.class);
            
            query = query.select(root);
            
            if (kw != null && !kw.isEmpty()){
                String p = String.format("%%%s%%", kw);
                Predicate p1 = builder.like(root.get("name").as(String.class), p);
                Predicate p2 = builder.like(root.get("description").as(String.class), p);
                
                query = query.where(builder.or(p1, p2));
            }
            
            return session.createQuery(query).getResultList();
        }
    }
    
    public Book getBookById(int id) {
        try (Session session = factory.openSession()){
            return session.get(Book.class, id);
        }
    }
    
    public boolean addOrSaveBook(Book book) {
        try (Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.saveOrUpdate(book);
                session.getTransaction().commit();
            } catch (Exception ex) {
                session.getTransaction().rollback();
                return false;
            }
            }
            
        
        return true;
    }
}
