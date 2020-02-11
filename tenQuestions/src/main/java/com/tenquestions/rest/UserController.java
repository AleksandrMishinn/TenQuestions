package com.tenquestions.rest;

import com.tenquestions.service.UserService;
import com.tenquestions.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    public UserController() {
        userService = new UserService(); //todo
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity read(@PathVariable(name = "id") int id) {

        User user = userService.getById(id);

        if (user == null) {
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<String>(user.toString(), HttpStatus.OK);
        }

    }

    @PostMapping(value = "/users/create")
    public ResponseEntity<?> create(@RequestBody Map dataMap) {

        User user = userService.create(dataMap);

        if (user == null) {
            return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<String>("user id = " + user.getId(), HttpStatus.CREATED);
        }
    }


}
