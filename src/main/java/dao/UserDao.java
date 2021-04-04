package dao;

import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class UserDao {

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
            session.close();
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

            session.save(user);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    public void update(int id, String lastName, String firstName, int age, int salary) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            User user = session.get(User.class, id);
            if (user != null) {
                user.setLastName(lastName);
                user.setFirstName(firstName);
                user.setAge(age);
                user.setSalary(salary);
                session.update(user);
            }

            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

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
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    public void findAll() {
        Transaction transaction = null;
        List<User> listOfUser = null;

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
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}
