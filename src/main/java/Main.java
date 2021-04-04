import models.User;
import services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        UserService userService = new UserService();

        userService.updateUser(5, "User5", "User5", 35, 800);
        //serService.deleteUser(6);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;

        do {
            System.out.println(
                    "1   Показать всех пользователей\n" +
                    "2   Показать пользователя по его уникальному номеру\n" +
                    "3   Добавить нового пользователя\n" +
                    "4   Изменить пользователя\n" +
                    "5   Удалить пользователя\n" +
                    "0   Выход\n" +
                    "Пожалуйста, выберите нужный пункт меню:"
            );

            int numberMenu = 0;

            try {
                numberMenu = Integer.parseInt(reader.readLine());

            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();

                System.out.println("Введите корректный пункт меню");
                numberMenu = Integer.parseInt(reader.readLine());
            }

            switch (numberMenu) {
                case 1:
                    userService.findAllUsers();
                    System.out.print("\n");
                    break;
                case 2:
                    System.out.println("Укажите уникальный номер пользователя ");

                    int numberUser = 0;

                    try {
                        numberUser = Integer.parseInt(reader.readLine());
                    } catch (IOException | NumberFormatException e) {
                        e.printStackTrace();

                        System.out.println("Введите корректный номер пользователя");
                        numberUser = Integer.parseInt(reader.readLine());
                    }

                    userService.findUser(numberUser);

                    System.out.print("\n");
                    break;
                case 3:
                    User user = new User();

                    System.out.println("Введите его Фамилию");
                    user.setLastName(reader.readLine());
                    System.out.println("Введите его Имя");
                    user.setFirstName(reader.readLine());
                    System.out.println("Введите его Возраст");
                    user.setAge(Integer.parseInt(reader.readLine()));
                    System.out.println("Введите его Зарплату");
                    user.setSalary(Integer.parseInt(reader.readLine()));

                    userService.saveUser(user);

                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("Введите номер пользователя, которого хотите изменить");
                    int id = Integer.parseInt(reader.readLine());

                    System.out.println("Пользователь - " + id);
                    userService.findUser(id);

                    System.out.println("Введите новую Фамилию");
                    String lastName = reader.readLine();
                    System.out.println("Введите новое Имя");
                    String firstname = reader.readLine();
                    System.out.println("Введите новый Возраст");
                    int age = Integer.parseInt(reader.readLine());
                    System.out.println("Введите новую Зарплату");
                    int salary = Integer.parseInt(reader.readLine());

                    userService.updateUser(id, lastName, firstname, age, salary);

                    System.out.println();
                    System.out.println("Отредактированный пользователь - " + id);
                    userService.findUser(id);

                    System.out.println("\n");
                    break;
                case 0:
                    exit = true;
                default:
                    System.out.println("Такого пункта нет!\n");
                    break;
            }
        } while (!exit);

        reader.close();
    }
}
