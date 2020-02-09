package com.tenquestions;

import com.tenquestions.models.User;
import com.tenquestions.service.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        User user = userService.getById(3);
        System.out.println(user);
//        userService.saveUser(user);
//        Auto ferrari = new Auto("Ferrari", "red");
//        user.addAuto(ferrari);
//        Auto ford = new Auto("Ford", "black");
//        ford.setUser(user);
//        user.addAuto(ford);
//        userService.updateUser(user);
//        user.setName("Sasha");
//        userService.updateUser(user);
    }
}
