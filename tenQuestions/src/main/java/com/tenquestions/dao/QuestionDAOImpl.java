package com.tenquestions.dao;

import com.tenquestions.models.Question;
import com.tenquestions.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.Iterator;


public class QuestionDAOImpl implements QuestionDAO{

    public Question getById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Question question = session.get(Question.class, id);
        tx1.commit();
        session.close();

        return question;
    }

    @Override
    public String getRandomN(int n) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        String query = "SELECT * FROM `questions` LIMIT " + n;
        Collection<Question> questions = null;

        try {
            questions = session.createSQLQuery(query).addEntity(Question.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tx1.commit();
        session.close();

        String result = "[";
        Iterator iterator = questions.iterator();

        while (iterator.hasNext()){
            Question question = (Question) iterator.next();
            result = result + question.toString() + ",";
        }

            result = result.substring(0,result.length() - 1) + "]";

        return result;
    }

}


