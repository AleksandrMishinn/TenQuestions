package com.tenquestions;

import com.tenquestions.models.AnswersHistory;
import com.tenquestions.models.User;
import com.tenquestions.service.AnswerService;
import com.tenquestions.service.AnswersHistoryService;
import com.tenquestions.service.QuestionService;
import com.tenquestions.service.UserService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {

//for tests
//        UserService userService = new UserService();
//        User user = userService.getById(3);
//        System.out.println(user);
//
//        QuestionService questionService = new QuestionService();
//        String result = questionService.getRandomN(3);
//        System.out.println(result);
//
//        AnswerService answerService = new AnswerService();
//        String result = answerService.getAnswersByQuestionsId(2);
//        System.out.println(result);

        AnswersHistoryService answersHistoryService = new AnswersHistoryService();

        Map data = new HashMap<>();
        data.put("user", 1);
        data.put("question", 3);
        data.put("answer", 15);
        AnswersHistory result = answersHistoryService.create(data);
        System.out.println(result.toString());
    }
}
