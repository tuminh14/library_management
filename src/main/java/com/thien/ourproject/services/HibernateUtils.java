/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.services;

import com.thien.ourproject.pojo.Category;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
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

        conf.addAnnotatedClass(Category.class);
        
        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost/library_management");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "root");
        props.put(Environment.SHOW_SQL, true);

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
