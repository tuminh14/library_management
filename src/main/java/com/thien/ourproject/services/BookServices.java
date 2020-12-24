/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.services;

import com.thien.ourproject.model.AuthorBook;
import com.thien.ourproject.pojo.Book;
import java.io.Console;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import com.thien.ourproject.pojo.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BookServices {

    private final static SessionFactory factory = HibernateUtils.getFACTORY();

    public List<Book> getBooks(String kw) {
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery();
            Root<Book> root = query.from(Book.class);

            query = query.select(root);

            if (kw != null && !kw.isEmpty()) {
                String p = String.format("%%%s%%", kw);
                Predicate p1 = builder.like(root.get("bookTitle").as(String.class), p);
                Predicate p2 = builder.like(root.get("author").as(String.class), p);

                query = query.where(builder.or(p1, p2));
            }

            return session.createQuery(query).getResultList();
        }
    }
    public ArrayList<AuthorBook> getAuthors(){
        try ( Session session = factory.openSession()) {
            ArrayList<AuthorBook> bookList = new ArrayList<>();
            TypedQuery<Object[]> query = session.createQuery("select distinct b.author from Book as b", Object[].class);
            List<Object[]> results = query.getResultList();
            for(Object result : results){
                List<Book> listOfBook = new ArrayList<Book>(session.createNamedQuery("Book.findByAuthor",Book.class).setParameter("author", result).getResultList());
                bookList.add(new AuthorBook(result.toString(), listOfBook.size()));
            }
            Collections.sort(bookList);
            return new ArrayList<AuthorBook>(bookList.subList(0,10));
        }
    }
    public Book getBookById(int id) {
        try ( Session session = factory.openSession()) {
            return session.get(Book.class, id);
        }
    }

    public boolean addOrSaveBook(Book book) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.saveOrUpdate(book);
                session.getTransaction().commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
                return false;
            }
        }

        return true;
    }
    
    public boolean deleteBook(Book book) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.delete(book);
                session.getTransaction().commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
                return false;
            }
        }

        return true;
    }
    public List<Book> getTopBook(int max){
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery();
            Root<Book> root = query.from(Book.class);
            query = query.select(root);
            return session.createQuery(query)
                    .setMaxResults(max)
                    .getResultList();
        }
    }

}
