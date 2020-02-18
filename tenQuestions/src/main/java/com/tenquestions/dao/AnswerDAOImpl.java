package com.tenquestions.dao;

import com.tenquestions.models.Answer;
import com.tenquestions.models.Question;
import com.tenquestions.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

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

    public Question getById(int id) {
       return null;
    }

    @Override
    public Object create(Map data) {
        return null;
    }

    @Override
    public boolean update(int id, Map data) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}


