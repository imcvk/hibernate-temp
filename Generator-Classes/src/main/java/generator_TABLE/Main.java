package generator_TABLE;

import HibernateConfiguration.HibernateConfiguration;
import com.github.javafaker.Faker;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < 10; i++) {
            User_Table user = bootStrapUser();
            session.save(user);
        }
        transaction.commit();
    }

    public static User_Table bootStrapUser() {
        User_Table user = new User_Table();
        Faker faker = new Faker();
        user.setName(faker.name().fullName());
        //user.setUserid(faker.number().numberBetween(1111, 9999));
        user.setPhoneNumber(faker.phoneNumber().phoneNumber());
        user.setUserEmail(user.getName() + "@gmail.com");
        return user;
    }
}
