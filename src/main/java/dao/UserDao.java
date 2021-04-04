package dao;

import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class UserDao {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void findById(int id) {
        Transaction transaction = null;
        User user = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            user = session.get(User.class, id);

            System.out.println(String.format("%s | %s | %s | %s | %s ",
                    user.getId(),
                    user.getLastName(),
                    user.getFirstName(),
                    user.getAge(),
                    user.getSalary()
            ));

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    public void save(User user) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            setUserFieldsToSave(user);

            session.save(user);

            transaction.commit();
            System.out.println("Пользователь успешно добавлен!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    private void setUserFieldsToSave(User user) {
        try {
            System.out.println("Введите его Фамилию");
            user.setLastName(reader.readLine().trim());
            System.out.println("Введите его Имя");
            user.setFirstName(reader.readLine().trim());
            System.out.println("Введите его Возраст");
            user.setAge(Integer.parseInt(reader.readLine().trim()));
            System.out.println("Введите его Зарплату");
            user.setSalary(Integer.parseInt(reader.readLine().trim()));
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void update(int id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            User user = session.get(User.class, id);
            if (user != null) {
                setUserFieldsToUpdate(user);
                session.update(user);
            }

            transaction.commit();
            System.out.println("Пользователь успешно изменён!");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    private void setUserFieldsToUpdate (User user) {
        try {
            System.out.println("Введите новую Фамилию");
            user.setLastName(reader.readLine().trim());
            System.out.println("Введите новое Имя");
            user.setFirstName(reader.readLine().trim());
            System.out.println("Введите новый Возраст");
            user.setAge(Integer.parseInt(reader.readLine().trim()));
            System.out.println("Введите новую Зарплату");
            user.setSalary(Integer.parseInt(reader.readLine().trim()));

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    public void findAll() {
        Transaction transaction = null;
        List<User> listOfUser;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            listOfUser = session.createQuery("from User").getResultList();

            listOfUser.forEach(user1 -> {
                System.out.println(String.format("%s | %s | %s | %s | %s",
                        user1.getId(),
                        user1.getLastName(),
                        user1.getFirstName(),
                        user1.getAge(),
                        user1.getSalary()
                ));
            });

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}
