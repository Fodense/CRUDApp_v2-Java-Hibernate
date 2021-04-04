import models.User;
import services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        UserService userService = new UserService();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        User user = new User();

        boolean exit = false;

        do {
            System.out.println(
                    "1   Показать всех пользователей\n" +
                    "2   Показать пользователя по его уникальному номеру\n" +
                    "3   Добавить нового пользователя\n" +
                    "4   Изменить пользователя\n" +
                    "5   Удалить пользователя\n" +
                    "0   Выход\n" +
                    "Пожалуйста, выберите нужный пункт меню от 0 до 5:"
            );

            int numberMenu = 0;

            try {
                numberMenu = Integer.parseInt(reader.readLine());

            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();

                System.out.println("Выберите пункт меню от 0 до 5!");
                numberMenu = Integer.parseInt(reader.readLine());
            }

            switch (numberMenu) {
                case 1:
                    userService.findAllUsers();

                    System.out.println();
                    break;
                case 2:
                    System.out.println("Укажите уникальный номер пользователя ");

                    try {
                        int numberUser = Integer.parseInt(reader.readLine().trim());
                            try {
                                userService.findUser(numberUser);
                            } catch (IllegalStateException e) {
                                e.printStackTrace();

                                System.out.println("Пользователь с таким id не найден в базе данных");
                            }
                    } catch (IOException | NumberFormatException e) {
                        e.printStackTrace();

                        System.out.println("Получен некорректный номер");
                    }

                    System.out.println();
                    break;
                case 3:
                    userService.saveUser(user);
                    break;
                case 4:
                    System.out.println("Введите номер пользователя, которого хотите изменить");
                    int id = Integer.parseInt(reader.readLine().trim());

                    System.out.println("Пользователь - " + id);
                    userService.findUser(id);

                    userService.updateUser(id);

                    System.out.println("Отредактированный пользователь - " + id);
                    userService.findUser(id);

                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("Введите номер пользователя, которого вы хотите удалить");

                    try {
                        int idDelete = Integer.parseInt(reader.readLine().trim());
                        System.out.println("Пользователь - " + idDelete);

                        userService.findUser(idDelete);

                        try {
                            userService.deleteUser(idDelete);
                            System.out.println("Удаление успешно выполнено!");
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Такого пункта нет!\n");
                    break;
            }
        } while (!exit);

        reader.close();
    }
}
