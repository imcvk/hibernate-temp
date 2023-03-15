package custom_generator;

import HibernateConfiguration.HibernateConfiguration;
import com.github.javafaker.Faker;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        UserCustomGenerator user = bootStrapUser();
        session.save(user);
        System.out.println(user);
        transaction.commit();
    }

    public static UserCustomGenerator bootStrapUser() {
        UserCustomGenerator user = new UserCustomGenerator();
        Faker faker = new Faker();
        user.setName(faker.name().fullName());
        user.setPhoneNumber(faker.phoneNumber().phoneNumber());
        user.setUserEmail(user.getName() + "@gmail.com");
        return user;
    }
}
