package services;

import dao.UserDao;
import models.User;

public class UserService {
    private final UserDao userDao = new UserDao();

    public UserService() {}

    public void findUser(int id) {
        userDao.findById(id);
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void updateUser(int id) {
        userDao.update(id);
    }

    public void deleteUser(int id) {
        userDao.delete(id);
    }

    public void findAllUsers() {
        userDao.findAll();
    }
}
