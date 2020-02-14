package com.tenquestions.dao;

import com.google.protobuf.MapEntry;
import com.tenquestions.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tenquestions.utils.HibernateSessionFactoryUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    public boolean update(int id, Map<String, String> data) {
        
        User user = getById(id);

        if (user == null){ return false;}

        Method method = null;
        String methodName = "set";

        for (Map.Entry<String, String> currentPair : data.entrySet()) {

            //get setters for editable fields
            try {
                String key = currentPair.getKey();
                key = key.substring(0,1).toUpperCase() + key.substring(1).toLowerCase();

                method = user.getClass().getMethod(methodName + key, String.class);

                String[] sArg = new String[1];
                sArg[0] = currentPair.getValue();
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
