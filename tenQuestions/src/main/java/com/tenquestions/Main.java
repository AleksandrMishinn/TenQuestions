package com.tenquestions;

import com.tenquestions.models.Question;
import com.tenquestions.models.User;
import com.tenquestions.service.AnswerService;
import com.tenquestions.service.QuestionService;
import com.tenquestions.service.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

//        UserService userService = new UserService();
//        User user = userService.getById(3);
//        System.out.println(user);

//        QuestionService questionService = new QuestionService();
//        String result = questionService.getRandomN(3);
//        System.out.println(result);

        AnswerService answerService = new AnswerService();
        String result = answerService.getAnswersByQuestionsId(2);
        System.out.println(result);

    }
}
