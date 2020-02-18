package com.tenquestions.rest;

import com.tenquestions.models.Question;
import com.tenquestions.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController() {
        questionService = new QuestionService();
    }

    @GetMapping(value = "/questions/get/{id}")
    public ResponseEntity getById(@PathVariable(name = "id") int id) {

        Question question = questionService.getById(id);

        if (question == null) {
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<String>(question.toString(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/questions/get_random/{n}")
    public ResponseEntity getRandomN(@PathVariable(name = "n") int n) {

        String questionsJSON = questionService.getRandomN(n);

        if (questionsJSON == null && questionsJSON.isEmpty()) {
            return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<String>(questionsJSON, HttpStatus.OK);
        }
    }

}
