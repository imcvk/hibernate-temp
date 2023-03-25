package named_query.dao;

import named_query.HibernateConfiguration.HibernateConfiguration;
import named_query.model.User;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class ObjectDaoNamedQuery {
    private final SessionFactory sessionFactory = null;

    public static void saveObject(Object o) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(o);
        transaction.commit();
    }

    public static void fetUsingNamedQuery() {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Query query = session.getNamedQuery("selectAllUsers");
        List<User> users = query.getResultList();
        users.forEach(System.out::println);
    }

    public static void fetchUsingNamedQueryWithId(int id) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();

        Query query = session.getNamedQuery("selectUsingId");
        query.setParameter("id", id);
        List<User> users = query.getResultList();
        users.forEach(System.out::println);
    }

    public static void updateUsingNamedQuery(int id) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getNamedQuery("updateUser");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
    }

    public static void deleteUsingNamedQuery(int id) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getNamedQuery("deleteUser");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
    }
}
