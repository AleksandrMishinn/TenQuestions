package com.tenquestions.dao;

import com.tenquestions.models.Answer;
import com.tenquestions.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.Iterator;


public class AnswerDAOImpl implements AnswerDAO{

    public String getAnswersByQuestionsId(int id){

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        String query = "SELECT answers.* FROM questions LEFT JOIN answers ON questions.id = answers.question WHERE questions.id = " + id;
        Collection <Answer> answers = null;

        try {
            answers = session.createSQLQuery(query).addEntity(Answer.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tx1.commit();
        session.close();

        String result = "[";
        Iterator iterator = answers.iterator();

        while (iterator.hasNext()){
            Answer answer = (Answer) iterator.next();
            result = result + answer.toString() + ",";
        }

        result = result.substring(0,result.length() - 1) + "]";

        return result;
    }

    public Answer getById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Answer answer = session.get(Answer.class, id);
        tx1.commit();
        session.close();

        return answer;
    }

}


