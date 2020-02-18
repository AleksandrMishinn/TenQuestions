package com.tenquestions.service;

import com.tenquestions.dao.AnswerDAOImpl;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private AnswerDAOImpl answerDAOImpl = new AnswerDAOImpl();

    public AnswerService() {
    }

    public String getAnswersByQuestionsId(int id){
        return answerDAOImpl.getAnswersByQuestionsId(id);
    }
}
