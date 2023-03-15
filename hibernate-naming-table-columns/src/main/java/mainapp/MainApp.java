package mainapp;

import HibernateConfiguration.HibernateConfiguration;
import com.github.javafaker.Faker;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = bootStrapUserObject();
        session.save(user);
        transaction.commit();
    }

    public static User bootStrapUserObject() {
        User user = new User();
        Faker faker = new Faker();
        user.setUserid(faker.number().numberBetween(1111, 9999));
        user.setName(faker.name().fullName());
        user.setPhoneNumber(faker.phoneNumber().phoneNumber());
        user.setUserEmail(user.getName() + "@gmail.com");
        return user;
    }
}
