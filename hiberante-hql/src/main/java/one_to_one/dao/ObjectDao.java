package one_to_one.dao;

import jakarta.persistence.Query;
import one_to_one.HibernateConfiguration.HibernateConfiguration;
import one_to_one.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class ObjectDao {
    private SessionFactory sessionFactory = null;

    public static void saveObject(Object o) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(o);
        transaction.commit();
    }

    static String fetchAll = "from User";

    public static void fetchAll() {
        Session session = HibernateConfiguration.getSession();
        Query query = session.createQuery(fetchAll);
        List<User> users = query.getResultList();
        users.forEach(System.out::println);
    }

    public static String fetchSingle = "from User where userId=1";

    public static void fetchSingle() {
        Session session = HibernateConfiguration.getSession();
        Query query = session.createQuery(fetchSingle);
        User user = (User) query.getSingleResult();
        System.out.println(user);
    }

    public static String deleteQuery = "delete from User where userId=1000";

    public static void deleteUsingHQL() {
        Session session = HibernateConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(deleteQuery);
        query.executeUpdate();
        transaction.commit();
    }
}
