import models.User;
import service.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        User user = userService.getById(1);
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
