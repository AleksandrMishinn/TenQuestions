package com.tenquestions.rest;

import com.tenquestions.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController() {
        answerService = new AnswerService();
    }

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping(value = "/answers/get_answers_by_question/{id}")
    public ResponseEntity getAnswersByQuestionsId(@PathVariable(name = "id") int id) {

        String answersJSON = answerService.getAnswersByQuestionsId(id);

        if (answersJSON == null && answersJSON.isEmpty()) {
            return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<String>(answersJSON, HttpStatus.OK);
        }
    }

}
