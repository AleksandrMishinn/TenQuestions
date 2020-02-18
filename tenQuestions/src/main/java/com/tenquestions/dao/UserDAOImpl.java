package com.tenquestions.dao;

import com.tenquestions.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tenquestions.utils.HibernateSessionFactoryUtil;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

public class UserDAOImpl implements UserDAO{

    public User create (Map data) { //todo Type for Map

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

    public boolean deleteById(int id) {

        User user = getById(id);

        if (user == null) return false;

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();

        return true;
    }

    public boolean update(int id, Map data) { //todo Type for Map

        User user = getById(id);

        if (user == null){ return false;}

        Method method = null;
        String methodName = "set";

        Iterator iterator = data.entrySet().iterator();

        while (iterator.hasNext()){  //todo Refactoring

            Map.Entry entry = (Map.Entry) iterator.next();

            //get setters for editable fields
            try {
                String key = (String) entry.getKey();
                key = key.substring(0,1).toUpperCase() + key.substring(1).toLowerCase();

                method = user.getClass().getMethod(methodName + key, String.class);

                String[] sArg = new String[1];
                sArg[0] = (String) entry.getValue();
                method.invoke(user, sArg);

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();

        return true;
    }



}
