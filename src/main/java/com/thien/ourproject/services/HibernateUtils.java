/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.services;

import com.thien.ourproject.pojo.Book;
import com.thien.ourproject.pojo.BookBorrowed;
import com.thien.ourproject.pojo.Category;
import com.thien.ourproject.pojo.LostBookTracking;
import com.thien.ourproject.pojo.People;
import com.thien.ourproject.pojo.Reader;
import com.thien.ourproject.pojo.ReaderCard;
import com.thien.ourproject.pojo.Staff;
import com.thien.ourproject.pojo.StaffType;
import com.thien.ourproject.pojo.Users;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author nguye
 */
public class HibernateUtils {

    private final static SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        
        conf.addAnnotatedClass(Book.class);
        conf.addAnnotatedClass(BookBorrowed.class);
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(LostBookTracking.class);
        conf.addAnnotatedClass(People.class);
        conf.addAnnotatedClass(Reader.class);
        conf.addAnnotatedClass(ReaderCard.class);
        conf.addAnnotatedClass(Staff.class);
        conf.addAnnotatedClass(StaffType.class);
        conf.addAnnotatedClass(Users.class);

        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost/library_management?createDatabaseIfNotExist=true&useSSL=true");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "root");
        props.put(Environment.SHOW_SQL, true);
        props.put(Environment.HBM2DDL_AUTO, "update");
        conf.setProperties(props);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties())
                .build();

        FACTORY = conf.buildSessionFactory(registry);
    }

    /**
     * @return the FACTORY
     */
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}
