/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.services;

import com.thien.ourproject.pojo.Book;
import com.thien.ourproject.pojo.Users;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author nguye
 */
public class UserServices {

    private final static SessionFactory factory = HibernateUtils.getFACTORY();

    public boolean addUser(Users users) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();

                users.setPassword(DigestUtils.md5Hex(users.getPassword()));
                session.save(users);

                session.getTransaction().commit();
                return true;
            } catch (Exception ex) {
                session.getTransaction().rollback();
            }

        }
        return false;
    }

    public Users login(String username, String password) {
        password = DigestUtils.md5Hex(password);

        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Users> query = builder.createQuery(Users.class);
            Root<Users> root = query.from(Users.class);
            query.select(root);
            
            Predicate p1 = builder.equal(root.get("username").as(String.class), username);
            Predicate p2 = builder.equal(root.get("password").as(String.class), password);
            
            query = query.where(builder.and(p1, p2));

            return session.createQuery(query).getSingleResult();
        }
    }
}
