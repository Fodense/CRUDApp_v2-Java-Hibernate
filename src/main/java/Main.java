import models.User;
import services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        UserService userService = new UserService();

        //User user = new User("User6", "User6", 27, 700);
        //userService.saveUser(user);
        //userService.updateUser(5, "User5", "User5", 35, 800);
        //serService.deleteUser(6);
        //userService.findUser(1);
        //userService.findAllUsers();

        System.out.println(
                "1   Показать всех пользователей\n" +
                "2   Показать пользователя по его уникальному номеру\n" +
                "3   Добавить нового пользователя\n" +
                "4   Изменить пользователя\n" +
                "5   Удалить пользователя\n" +
                "0   Выход\n" +
                "Пожалуйста, выберите нужный пункт меню:    "
        );

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberMenu = 0;

        try {
            numberMenu = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (numberMenu) {
            case 1:
                userService.findAllUsers();
                break;
            case 2:
                System.out.println("Укажите уникальный номер пользователя: ");
                int numberUser = 0;

                try {
                    numberUser = Integer.parseInt(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                userService.findUser(numberUser);
                break;
            case 0:
                break;
            default:
                System.out.println("Такого пункта нет!\n");
                break;
        }

    }
}
