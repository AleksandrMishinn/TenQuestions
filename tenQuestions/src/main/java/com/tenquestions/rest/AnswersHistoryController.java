package com.tenquestions.rest;

import com.tenquestions.models.AnswersHistory;
import com.tenquestions.models.Question;
import com.tenquestions.models.User;
import com.tenquestions.service.AnswersHistoryService;
import com.tenquestions.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AnswersHistoryController {

    private final AnswersHistoryService answersHistoryService;

    @Autowired
    public AnswersHistoryController() {
        answersHistoryService = new AnswersHistoryService();
    }

//    @GetMapping(value = "/questions/get/{id}")
//    public ResponseEntity getById(@PathVariable(name = "id") int id) {
//
//        Question question = answersHistoryService.getById(id);
//
//        if (question == null) {
//            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<String>(question.toString(), HttpStatus.OK);
//        }
//    }

    @PostMapping(value = "/answers_history/create")
    public ResponseEntity<?> create(@RequestBody Map dataMap) {

        AnswersHistory answersHistory = answersHistoryService.create(dataMap);

        if (answersHistory == null) {
            return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<String>("user id = " + answersHistory.getId(), HttpStatus.CREATED);
        }
    }


}
