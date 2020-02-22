package com.tenquestions.service;

import com.tenquestions.dao.AnswerDAOImpl;
import com.tenquestions.models.Answer;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private AnswerDAOImpl answerDAOImpl = new AnswerDAOImpl();

    public AnswerService() {
    }

    public String getAnswersByQuestionsId(int id){
        return answerDAOImpl.getAnswersByQuestionsId(id);
    }

    public Answer getById(int id) {
        return answerDAOImpl.getById(id);
    }

    public Answer getById(String id) {
        return getById(Integer.parseInt(id));
    }

}
