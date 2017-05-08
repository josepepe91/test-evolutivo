package com.jose.prueba.controllers;
/**
 * Created by optimus-desarrollo on 07/05/17.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.jose.prueba.entities.User;

public class TestUser {
    public void testUser() {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = new User();
        user.setLogin("user2");
        user.setPassword("pass2");
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}
