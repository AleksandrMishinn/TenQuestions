package com.tenquestions.dao;

import com.tenquestions.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tenquestions.utils.HibernateSessionFactoryUtil;

import java.util.Map;
import java.util.Set;

public class UserDAO implements DAO{

    public User create(Object user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
        return null;
    }


//    public User create(Object obj) {
//        return null;
//    }

    public User getById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public Set getAll() {
        return null;
    }

    public Map update(Object user, Map data) {
        return null;
    }

    public Map delete(int id) {
        return null;
    }
}
