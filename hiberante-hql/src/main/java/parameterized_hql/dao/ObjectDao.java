package parameterized_hql.dao;

import hql.HibernateConfiguration.HibernateConfiguration;
import hql.model.User;
import jakarta.persistence.Query;
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
