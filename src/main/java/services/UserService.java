package services;

import dao.UserDao;
import models.User;

import java.util.List;

public class UserService {

    private final UserDao userDao = new UserDao();

    public UserService() {}

    public void findUser(int id) {
        userDao.findById(id);
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void updateUser(int id, String lastName, String firstName, int age, int salary) {
        userDao.update(id, lastName, firstName, age, salary);
    }

    public void deleteUser(int id) {
        userDao.delete(id);
    }

    public void findAllUsers() {
        userDao.findAll();
    }
}
