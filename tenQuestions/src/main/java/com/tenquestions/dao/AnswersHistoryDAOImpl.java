package com.tenquestions.dao;

import com.tenquestions.models.Answer;
import com.tenquestions.models.AnswersHistory;
import com.tenquestions.models.Question;
import com.tenquestions.models.User;
import com.tenquestions.service.AnswerService;
import com.tenquestions.service.QuestionService;
import com.tenquestions.service.UserService;
import com.tenquestions.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Map;

public class AnswersHistoryDAOImpl implements AnswersHistoryDAO {

    public AnswersHistory create(Map data) {

        if (data.isEmpty()) {return null;}

        UserService userService = new UserService();
        QuestionService questionService = new QuestionService();
        AnswerService answerService = new AnswerService();

        User user = userService.getById(String.valueOf(data.get("user")));
        Question question = questionService.getById(String.valueOf(data.get("question")));
        Answer answer = answerService.getById(String.valueOf(data.get("answer")));

        AnswersHistory answersHistory = new AnswersHistory(user, question, answer);

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        try {
            session.save(answersHistory);
        }catch (Exception e){
            e.printStackTrace();
        }

        tx1.commit();
        session.close();

        return answersHistory;
    }

    @Override
    public Object getById(int id) {
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
