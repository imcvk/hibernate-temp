package mainapp;

import com.github.javafaker.Faker;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        Faker faker = new Faker();
        user.setName(faker.name().fullName());
        user.setUserid(faker.number().numberBetween(1111, 9999));
        session.persist(user);
        transaction.commit();
    }
}
