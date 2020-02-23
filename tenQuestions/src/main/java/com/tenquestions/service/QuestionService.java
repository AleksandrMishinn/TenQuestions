package com.tenquestions.service;

import com.tenquestions.dao.QuestionDAOImpl;
import com.tenquestions.models.Question;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private QuestionDAOImpl questionDAOImpl = new QuestionDAOImpl();

    public QuestionService() {}

    public Question getById(int id) {
        return questionDAOImpl.getById(id);
    }

    public Question getById(String id) {
        return getById(Integer.parseInt(id));
    }

    public String getRandomN(int n){
        return questionDAOImpl.getRandomN(n);
    }

}
