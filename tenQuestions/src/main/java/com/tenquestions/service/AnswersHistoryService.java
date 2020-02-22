package com.tenquestions.service;

import com.tenquestions.dao.AnswersHistoryDAOImpl;
import com.tenquestions.models.AnswersHistory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AnswersHistoryService {

    private AnswersHistoryDAOImpl answersHistoryDAOImpl= new AnswersHistoryDAOImpl();

    public AnswersHistoryService() {
    }

    public AnswersHistory create(Map data) {
        return answersHistoryDAOImpl.create(data);
    }

//    public AnswersHistory getById(int id) {
//        return answersHistoryDAOImpl.getById(id);
//    }

//    public AnswersHistory getById(String id) {
//        return getById(Integer.parseInt(id));
//    }

}
