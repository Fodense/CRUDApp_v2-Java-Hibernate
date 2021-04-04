package models;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "crudv2", catalog = "")
public class User {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private int salary;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() != 0) {
            this.lastName = lastName;
        } else {
            System.out.println(
                  "Пустое поле\n" +
                  "Чтобы его изменить перейдите в 4-ый пункт меню."
            );
        }
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() != 0) {
            this.firstName = firstName;
        } else {
            System.out.println(
                    "Пустое поле\n" +
                    "Чтобы его изменить перейдите в 4-ый пункт меню."
            );
        }
    }

    @Basic
    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println(
                    "Введён отрицательный возраст - \"" + age + "\"\n" +
                    "Этому полю будет присвоено значение " + "\"0\"\n" +
                    "Чтобы его изменить перейдите в 4-ый пункт меню."
            );
        }
    }

    @Basic
    @Column(name = "salary", nullable = true)
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println(
                    "Введена отрицательная зароботная плата - \"" + salary + "\"\n" +
                    "Этому полю будет присвоено значение " + "\"0\"\n" +
                    "Чтобы его изменить перейдите в 4-ый пункт меню."
            );
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (id != that.id) return false;
        if (age != that.age) return false;
        if (salary != that.salary) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + salary;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
