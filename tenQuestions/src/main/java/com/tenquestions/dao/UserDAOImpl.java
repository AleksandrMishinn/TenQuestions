package com.tenquestions.dao;

import com.tenquestions.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tenquestions.utils.HibernateSessionFactoryUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserDAOImpl implements UserDAO{

    public User create (Map data) {  //todo  <String, String>

        if (data.isEmpty()) {return null;}

        User newUser = new User(data);

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        try {
            session.save(newUser);
        }catch (Exception e){
            e.printStackTrace();
        }

        tx1.commit();
        session.close();

        return newUser;
    }

    public User getById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        User user = session.get(User.class, id);
        tx1.commit();
        session.close();
        return user;
    }


    public Set getAll() {
        return null;
    }

    public Map update(Object o, Map data) {
        return null;
    }

    public Map delete(int id) {
        return null;
    }
}
