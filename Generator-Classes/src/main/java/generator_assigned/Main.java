package generator_assigned;

import HibernateConfiguration.HibernateConfiguration;
import com.github.javafaker.Faker;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        User user = bootStrapUser();
        session.save(user);
        transaction.commit();
    }

    public static User bootStrapUser() {
        User user = new User();
        Faker faker = new Faker();
        user.setName(faker.name().fullName());
        user.setUserid(faker.number().numberBetween(1111, 9999));
        user.setPhoneNumber(faker.phoneNumber().phoneNumber());
        user.setUserEmail(user.getName() + "@gmail.com");
        return user;
    }
}
