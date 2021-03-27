import models.User;
import services.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        User user = new User("User6", "User6", 27, 700);
        //userService.saveUser(user);
        //userService.updateUser(5, "User5", "User5", 35, 800);
        //serService.deleteUser(6);
        //userService.findUser(1);
        userService.findAllUsers();

    }
}
