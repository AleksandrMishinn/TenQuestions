package com.tenquestions.rest;

import com.tenquestions.service.UserService;
import com.tenquestions.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String read(@PathVariable(name = "id") int id){

        final User user = userService.getById(id);

        return user.toString();
    }


}
